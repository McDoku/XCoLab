package org.xcolab.portlets.proposals.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.Cookie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xcolab.commons.beans.SortFilterPage;
import org.xcolab.portlets.proposals.utils.ContestsColumn;
import org.xcolab.portlets.proposals.wrappers.ContestWrapper;
import org.xcolab.portlets.proposals.wrappers.ContestsSortFilterBean;
import org.xcolab.portlets.proposals.wrappers.FocusAreaWrapper;
import org.xcolab.portlets.proposals.wrappers.OntologySpaceWrapper;
import org.xcolab.portlets.proposals.wrappers.OntologyTermWrapper;

import com.ext.portlet.model.Contest;
import com.ext.portlet.model.FocusArea;
import com.ext.portlet.model.FocusAreaOntologyTerm;
import com.ext.portlet.model.OntologySpace;
import com.ext.portlet.model.OntologyTerm;
import com.ext.portlet.service.ContestLocalServiceUtil;
import com.ext.portlet.service.FocusAreaLocalServiceUtil;
import com.ext.portlet.service.FocusAreaOntologyTermLocalServiceUtil;
import com.ext.portlet.service.OntologySpaceLocalServiceUtil;
import com.ext.portlet.service.OntologyTermLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@Controller
@RequestMapping("view")
public class ContestsIndexController extends BaseProposalsController {

    private final static String COOKIE_VIEW_TYPE = "cc_contests_viewType";
    private final static String VIEW_TYPE_GRID = "GRID";
    private final static String VIEW_TYPE_LIST = "LIST";
    private final static String VIEW_TYPE_OUTLINE = "OUTLINE";
    private final static String VIEW_TYPE_DEFAULT = VIEW_TYPE_GRID;
    
    @RequestMapping
    public String showContestsIndex(PortletRequest request, PortletResponse response, Model model, 
            @RequestParam(required = false) String viewType, 
            @RequestParam(required = false, defaultValue="true") boolean showActiveContests,
            SortFilterPage sortFilterPage) 
                    throws PortalException, SystemException {
        if (viewType == null) {
            // view type wasn't set
            for (Cookie cookie: request.getCookies()) {
                if (cookie.getName().equals(COOKIE_VIEW_TYPE)) {
                    viewType = cookie.getValue();
                } 
            }
        }
        else {
            // we need to change the view type
            if (viewType.equals(VIEW_TYPE_GRID) || viewType.equals(VIEW_TYPE_LIST) || viewType.equals(VIEW_TYPE_OUTLINE)) {
                // we should set the cookie but it doesn't work currently https://issues.liferay.com/browse/LPS-25733
                // it should be handled in the view
                response.addProperty(new Cookie(COOKIE_VIEW_TYPE, viewType));
            }
        }
        if (viewType == null) {
            viewType = VIEW_TYPE_DEFAULT;
        }
        List<ContestWrapper> contests = new ArrayList<ContestWrapper>();
        for (Contest contest: ContestLocalServiceUtil.getContestsByActivePrivate(showActiveContests, false)) {
        	contests.add(new ContestWrapper(contest));
        }

        model.addAttribute("contests", contests);
        model.addAttribute("contestsSorted", new ContestsSortFilterBean(contests, sortFilterPage,
                showActiveContests ? null : ContestsColumn.REFERENCE_DATE));
        model.addAttribute("viewType", viewType);
        model.addAttribute("sortFilterPage", sortFilterPage);
        model.addAttribute("showActiveContests", showActiveContests);

        setSeoTexts(request, showActiveContests ? "Active contests" : "Prior contests", null, null);
        
        if (viewType.equals(VIEW_TYPE_OUTLINE)) {
        	List<OntologySpace> ontologySpacesRaw = OntologySpaceLocalServiceUtil.getOntologySpaces(0, Integer.MAX_VALUE);
        	List<OntologyTerm> ontologyTermsRaw = OntologyTermLocalServiceUtil.getOntologyTerms(0, Integer.MAX_VALUE);
        	List<FocusArea> focusAreasRaw = FocusAreaLocalServiceUtil.getFocusAreas(0, Integer.MAX_VALUE);
        	List<FocusAreaOntologyTerm> focusAreasOntologyTermsRaw = FocusAreaOntologyTermLocalServiceUtil.getFocusAreaOntologyTerms(0, Integer.MAX_VALUE);
        	
        	Map<Long, FocusAreaWrapper> focusAreas = new TreeMap<>();
        	Map<Long, OntologySpaceWrapper> ontologySpaces = new TreeMap<>();
        	Map<Long, OntologyTermWrapper> ontologyTerms = new TreeMap<>();
        	
        	for (FocusArea area: focusAreasRaw) {
        		focusAreas.put(area.getId(), new FocusAreaWrapper(area));
        	}
        	
        	for (OntologySpace space: ontologySpacesRaw) {
        		ontologySpaces.put(space.getId(), new OntologySpaceWrapper(space));
        	}
        	
        	for (OntologyTerm term: ontologyTermsRaw) {
        		OntologyTermWrapper termWrapped = new OntologyTermWrapper(term);
        		ontologySpaces.get(term.getOntologySpaceId()).addTerm(termWrapped);
        		ontologyTerms.put(term.getId(), termWrapped);
        	}

        	for (OntologyTerm term: ontologyTermsRaw) {
        		if (term.getParentId() > 0) {
        			ontologyTerms.get(term.getId()).setParent(ontologyTerms.get(term.getParentId()));
        		}
        	}
        	
        	for (FocusAreaOntologyTerm faTerm: focusAreasOntologyTermsRaw) {
        		focusAreas.get(faTerm.getFocusAreaId()).addOntologyTerm(ontologyTerms.get(faTerm.getOntologyTermId()));
        	}
        	
        	model.addAttribute("focusAreas", focusAreas.values());
        	model.addAttribute("ontologyTerms", ontologyTerms.values());
        	model.addAttribute("ontologySpaces", ontologySpaces.values());
        	
        }
        
        return "contestsIndex";
    }

}
