UPDATE `xcolab_OntologyTerm` SET parentId = 0 WHERE parentId is null;

delete from ClassName_ where value LIKE '%com.ext.portlet.model%';
update ClassName_ set value = REPLACE(value, 'com.ext.portlet.plans', 'com.ext.portlet') WHERE value LIKE '%com.ext.portlet.plans%';
update ClassName_ set value = REPLACE(value, 'com.ext.portlet.discussions', 'com.ext.portlet') WHERE value LIKE '%com.ext.portlet.discussions%';
update ClassName_ set value = REPLACE(value, 'com.ext.portlet.Activity', 'com.ext.portlet') WHERE value LIKE '%com.ext.portlet.Activity%';
update ClassName_ set value = REPLACE(value, 'com.ext.portlet.contests', 'com.ext.portlet') WHERE value LIKE '%com.ext.portlet.contests%';
update ClassName_ set value = REPLACE(value, 'com.ext.portlet.messaging', 'com.ext.portlet') WHERE value LIKE '%com.ext.portlet.messaging%';
update ClassName_ set value = REPLACE(value, 'com.ext.portlet.models', 'com.ext.portlet') WHERE value LIKE '%com.ext.portlet.models%';
update ClassName_ set value = REPLACE(value, 'com.ext.portlet.ontology', 'com.ext.portlet') WHERE value LIKE '%com.ext.portlet.ontology%';
update ClassName_ set value = REPLACE(value, 'com.ext.portlet.Activity', 'com.ext.portlet') WHERE value LIKE '%com.ext.portlet.Activity%';
update ClassName_ set value = REPLACE(value, 'com.ext.portlet.Activity', 'com.ext.portlet') WHERE value LIKE '%com.ext.portlet.Activity%';

