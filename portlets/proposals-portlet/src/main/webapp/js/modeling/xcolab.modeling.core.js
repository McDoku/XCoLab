if (typeof (console) == 'undefined') {
	window.console = {
			log: function() {},
			debug: function() {},
			error: function() {}
	};
}

if (typeof (XCoLab) == 'undefined') 
	XCoLab = {};

function initActTooltips(container) {
    container.on('mouseover', '.actInputDef', function() {
            var actInputDef = jQuery(this);
            var tooltip = actInputDef.find(".act_tooltip");
            tooltip.show();
    });
    container.on('mouseout', '.actInputDef', function() {
        var actInputDef = jQuery(this);
        var tooltip = actInputDef.find(".act_tooltip");
        tooltip.hide();
    });
}


/** 
 * Base object responsible for handling rendering of ROMA modeling widget.
 * 
 * It provides an API to be used to show the widget, two modes are supported (edit/view).
 * 
 */
function ModelingWidget(selector, options) {
	this.container = $(selector);
	if (typeof(options) == 'undefined') {
		throw "Options have to be defined for modeling widget";
	}
	if (!('renderers' in options) || options.renderers.length == 0) {
		throw "Missing renderers";
	}
	this.inEditMode = 'edit' in options ? options.edit : false;
	
	var that = this;
	this.renderers = [];
	jQuery(options.renderers).each(function(idx, renderer) {
		that.renderers.push(new renderer(that));
	});
	
	initActTooltips(this.container);
	

	jQuery(this).on('scenarioFetched', function(event) {
		that.modelId = event.scenario.modelId;
	});

	jQuery(this).on('modelFetched', function(event) {
		that.modelId = event.model.modelId;
	});
	
}

ModelingWidget.prototype.getScenarioUrl = '/plansProposalsFacade-portlet/api/jsonws/modelrunner/get-scenario';
ModelingWidget.prototype.getModelUrl = '/plansProposalsFacade-portlet/api/jsonws/modelrunner/get-model';
ModelingWidget.prototype.runModelUrl = '/plansProposalsFacade-portlet/api/jsonws/modelrunner/run-model';

/**
 * returns true if value is valid, false otherwise, 
 * @param input for which value is to be checked 
 * @param newVal new value that is to be used for given input
 * @return true if value is valid false otherwise
 */
ModelingWidget.prototype.isInputValueValid = function(input, newVal) {
	var min = parseFloat(input.metaData.min[0]);
	var max = parseFloat(input.metaData.max[0]);
	
	var newValParsed = jQuery.trim(this.parseInputValue(input, newVal));
	if (! /^\s*(\+|-)?((\d+(\.\d+)?)|(\.\d+))\s*$/.test(newValParsed)) {
		return false;
	}
	
	var newValFloat = parseFloat(newValParsed);
	if (newValFloat < min || newValFloat > max) {
		return false;
	}
	return true;
};

/**
 * Parses value according to unit (currently just removes % sign if unit is a percent)
 * @param input input for which value should be parsed
 * @param value value that should be parsed
 * @return parsed value
 */
ModelingWidget.prototype.parseInputValue = function(input, value) {
	var unit = input.metaData.units[0];
	if (unit.toLowerCase().indexOf("percent") >= 0 || unit.toLowerCase().indexOf("%") >= 0) {
		return value.replace("%", '');
    }
	return value;
};

/**
 * Checks if given data type is an integer type.
 * @param dataType string representation of a data type (java.lang.Integer for example)
 * @return true if dataType represents an integer false otherwise
 */
ModelingWidget.prototype.isInteger = function(dataType) {
	if (dataType.indexOf("java.lang.Integer") >= 0) return true;
	if (dataType.indexOf("java.lang.Long") >= 0) return true;
	return false;
};

/**
 * Checks if given data type is a double type.
 * @param dataType string representation of a data type (java.lang.Double for example)
 * @return true if dataType represents a double false otherwise
 */
ModelingWidget.prototype.isDouble = function(dataType) {
	if (dataType.indexOf("java.lang.Double") >= 0) return true;
	if (dataType.indexOf("java.lang.Float") >= 0) return true;
	return false;
};

/**
 * Formats input value in human readable way.
 * 
 * @param input input for which value is to be presented
 * @param value value that should be formatted
 * @return formatted value
 */
ModelingWidget.prototype.formatInputValue = function(input, value) {
	var unit = input.metaData.units[0];
	var dataType = input.metaData.profiles[0];
	
	if (unit.toLowerCase().indexOf("percent") >= 0 || unit.toLowerCase().indexOf("%") >= 0) {

		return (value * 1).toFixed(0) + "%";
	}
    else if (dataType != null) {
    	if (this.isInteger(dataType)) 
    		return (value *1).toFixed(0);
    	else 
    		return (value * 1).toFixed(2);
    }
	return value;
};

/**
 * Returns a renderer for given input, if concrete renderer can't be found
 * a default renderer is returned (default renderer doesn't present anything
 * to the user)
 * 
 * @param input input for which renderer should be returned
 * @return renderer for an input
 */		
ModelingWidget.prototype.getInputRenderer = function(input) {
	var renderer = null;
	jQuery(XCoLab.modeling.inputItemRenderers).each(function(idx, rendererCandidate) {
		if (rendererCandidate.canRender(input)) {
			renderer = rendererCandidate;
		}
	});
	return renderer != null ? renderer : { render: function(container, input) {console.log('no renderer found for input', input);}};
};

/**
 * Returns a renderer for given output, if concrete renderer can't be found
 * a default renderer is returned (default renderer doesn't present anything
 * to the user)
 * 
 * @param output output for which renderer should be returned
 * @return renderer for an output
 */		
ModelingWidget.prototype.getOutputRenderer = function(output) {
	var renderer = null;
	jQuery(XCoLab.modeling.outputItemRenderers).each(function(idx, rendererCandidate) {
		if (rendererCandidate.canRender(output)) {
			renderer = rendererCandidate;
		}
	});
	return renderer != null ? renderer : { getName : function() { return output.name; }, render: function(container, output) {console.log('no renderer found for output', output);}};
};

/**
 * Returns value for input. If no value is set for given input then default value is returned.
 * 
 * @param input input for which value should be returned.
 * @return value for given input
 */
ModelingWidget.prototype.getInputValue = function(input) {
	if ('value' in input) {
		return parseFloat(input.value.values[0][0]);
	}
	if ('default' in input.metaData && input.metaData['default'].length > 0) {
		return parseFloat(input.metaData['default'][0]);
	}
	
	return 0;
};

/**
 * Loads scenario with given id. When scenario is loaded "scenarioFetched" 
 * event is triggered, if there was an error "scenarioFetchingError" is triggered.
 * 
 * @param scenarioId id of a scenario
 * 
 */
ModelingWidget.prototype.loadScenario = function(scenarioId) {
	console.debug('loading scenario', scenarioId);
	var modelingWidget = this;

	jQuery(modelingWidget).trigger("fetchingScenario");
	jQuery.ajax({
		url: this.getScenarioUrl, 
		data: {scenarioId: scenarioId}, 
		dataType: 'jsonp',
	}).done(function(data, textStatus, jqXHR) {
		console.debug('scenario loaded', scenarioId, data, textStatus, jqXHR);
		
		var event = jQuery.Event( "scenarioFetched" );
		event.scenario = data;
		jQuery(modelingWidget).trigger(event);
		
	}).fail(function(data, textStatus, errorThrown) {
		console.debug("can't load scenario", scenarioId, data, textStatus, errorThrown);
		var event = jQuery.Event( "scenarioFetchingError" );
		event.scenario = data;
		jQuery(modelingWidget).trigger(event);
		
	});
};

/**
 * Runs the current model.
 */
ModelingWidget.prototype.runTheModel = function() {
	var modelingWidget = this;
	
	var values = {};
	this.container.find(".valueBinding").each(function() {
		values[jQuery(this).attr('data-id')] = jQuery(this).val();
	});
	
	jQuery(modelingWidget).trigger("fetchingScenario");
	
	
	console.debug(modelingWidget.runModelUrl, values, modelingWidget.modelId);
	jQuery.ajax({
		url: modelingWidget.runModelUrl, 
		data: {modelId: modelingWidget.modelId, inputs: JSON.stringify(values)}, 
		dataType: 'jsonp',
	}).done(function(data) {
		var event = jQuery.Event( "scenarioFetched" );
		event.scenario = data;
		jQuery(modelingWidget).trigger(event);
	}).fail(function(a, b, c) {
		console.log("model run failed :(", a, b, c);
	});
};

/**
 * Loads model with given id. When scenario is loaded "modelFetched" 
 * event is triggered.
 * 
 * @param modelId id of a model
 * 
 */
ModelingWidget.prototype.loadModel = function(modelId) {
	console.debug('loading scenario', modelId);
	var modelingWidget = this;

	jQuery(modelingWidget).trigger("fetchingModel");
	jQuery.ajax({
		url: this.getModelUrl, 
		data: {modelId: modelId}, 
		dataType: 'jsonp',
	}).done(function(data, textStatus, jqXHR) {
		console.debug('model loaded', modelId, data, textStatus, jqXHR);
		
		var event = jQuery.Event( "modelFetched" );
		event.model = data;
		jQuery(modelingWidget).trigger(event);
		
	}).fail(function(data, textStatus, errorThrown) {
		console.debug("can't load model", scenarioId, data, textStatus, errorThrown);
		var event = jQuery.Event( "modelFetchingError" );
		event.scenario = data;
		jQuery(modelingWidget).trigger(event);
		
	});
};


XCoLab.modeling = function(selector, options) {
	options.renderers = 'renderers' in options ? options.renderers : [];
	if (!('headerRenderer' in options)) { 
		options.renderers.push(XCoLab.modeling.headerRenderers[0]);
	}
	if (!('inputsRenderer' in options)) { 
		options.renderers.push(XCoLab.modeling.inputsRenderers[0]);
	}
	if (!('outputsRenderer' in options)) { 
		options.renderers.push(XCoLab.modeling.outputsRenderers[0]);
	}
	return new ModelingWidget(selector, options);
};

XCoLab.modeling.outputItemRenderers = [];
XCoLab.modeling.outputsRenderers = [];
XCoLab.modeling.inputItemRenderers = [];
XCoLab.modeling.inputsRenderers = [];
XCoLab.modeling.headerRenderers = [];

