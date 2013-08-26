package org.climatecollaboratorium.plans.wrappers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.climatecollaboratorium.plans.Helper;
import org.climatecollaboratorium.plans.utils.ContentFilteringHelper;

import com.ext.portlet.NoSuchContestPhaseException;
import com.ext.portlet.NoSuchPlanItemException;
import com.ext.portlet.PlanSectionDefinitionType;
import com.ext.portlet.model.Contest;
import com.ext.portlet.model.ContestPhase;
import com.ext.portlet.model.FocusArea;
import com.ext.portlet.model.PlanItem;
import com.ext.portlet.model.PlanSection;
import com.ext.portlet.model.PlanSectionDefinition;
import com.ext.portlet.service.ActivitySubscriptionLocalServiceUtil;
import com.ext.portlet.service.ContestLocalServiceUtil;
import com.ext.portlet.service.PlanItemLocalServiceUtil;
import com.ext.portlet.service.PlanSectionDefinitionLocalServiceUtil;
import com.ext.portlet.service.PlanSectionLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

public class PlanSectionWrapper implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PlanSection section;
	private boolean editing;
	private PlanItemWrapper piw;
	private List<Long> referencedPlans;
	private String oryginalContent;
	private Long oryginalReferencedId;
	private boolean last;
	private String proposalsFilter;
	private PlanSectionProposalFilterTabs proposalsFilterTab = PlanSectionProposalFilterTabs.MY_SUBSCRIPTIONS;
	private String proposalsFilterSortColumn = "PROPOSALS";
	private boolean proposalsFilterSortOrder = true;
	private boolean choosingProposal = false;
	private PlanItemWrapper referencedPlan;

	public PlanSectionWrapper(PlanSection section,
			PlanItemWrapper planItemWrapper, boolean last)
			throws NoSuchPlanItemException, SystemException {
		this.section = section;
		piw = planItemWrapper;
		oryginalContent = section.getContent();
		oryginalReferencedId = section.getReferencedId();

		this.setLast(last);

	}

	public PlanSection getSection() {
		return section;
	}

	public void setSection(PlanSection section) {
		this.section = section;
	}

	public boolean isEditing() {
		return editing;
	}

	public void toggleEditing(ActionEvent e) {
		editing = !editing;
	}

	public boolean save(ActionEvent e) throws NoSuchPlanItemException,
			PortalException, SystemException {
		boolean changed = false;
		if (Helper.isUserLoggedIn()
				&& !section.getContent().trim().equals(oryginalContent)) {
			PlanItemLocalServiceUtil.setSectionContent(PlanItemLocalServiceUtil
					.getPlan(section.getPlanId()), PlanSectionLocalServiceUtil
					.getDefinition(section), ContentFilteringHelper
					.removeStylingFromHTMLContent(section.getContent()),
					referencedPlans, Helper.getLiferayUser().getUserId());
			changed = true;
		}
		if (oryginalReferencedId != section.getReferencedId()) {
			PlanItemLocalServiceUtil.setSectionReferencedId(
					PlanItemLocalServiceUtil.getPlan(section.getPlanId()),
					PlanSectionLocalServiceUtil.getDefinition(section), section
							.getReferencedId(), referencedPlans, Helper
							.getLiferayUser().getUserId());

		}
		toggleEditing(e);

		return changed;

	}

	public List<SelectItem> getPlansForReference() throws PortalException,
			SystemException {
		List<SelectItem> ret = new ArrayList<SelectItem>();

		FocusArea fa = PlanSectionDefinitionLocalServiceUtil
				.getFocusArea(PlanSectionLocalServiceUtil
						.getDefinition(section));
		if (fa != null) {
			for (PlanItem plan : PlanItemLocalServiceUtil
					.findPlansForFocusArea(fa)) {
				ret.add(new SelectItem(plan.getPlanId(),
						PlanItemLocalServiceUtil.getName(plan)));
			}
		}

		return ret;
	}

	public List<Long> getReferencedPlanIds() throws NoSuchPlanItemException,
			SystemException {
		return referencedPlans;
	}

	public void setReferencedPlanIds(List<String> plans) {
		referencedPlans.clear();
		for (String planId : plans) {
			referencedPlans.add(Long.parseLong(planId));
		}

	}

	public void setOryginalContent(String oryginalContent) {
		this.oryginalContent = oryginalContent;
	}

	public String getOriginalContent() {
		return oryginalContent;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

	public boolean isLast() {
		return last;
	}

	private PlanSectionDefinition definition;

	public PlanSectionDefinition getDefinition() throws PortalException,
			SystemException {
		if (definition == null) {
			definition = PlanSectionDefinitionLocalServiceUtil
					.getPlanSectionDefinition(section
							.getPlanSectionDefinitionId());
		}
		return definition;
	}

	public PlanSectionDefinitionType getType() throws PortalException,
			SystemException {
		PlanSectionDefinition definition = getDefinition();
		if (StringUtils.isBlank(definition.getType()))
			return PlanSectionDefinitionType.TEXT;
		return PlanSectionDefinitionType.valueOf(definition.getType());
	}


	public PlanItemWrapper getReferencedPlan() throws NoSuchPlanItemException,
			SystemException {
		if (section.getReferencedId() <= 0) {
			return null;
		}
		if (referencedPlan == null) {
			referencedPlan = new PlanItemWrapper(PlanItemLocalServiceUtil.getPlan(section
					.getReferencedId()));
		}
		return referencedPlan;
	}

	public List<SelectItem> getProposalsToChooseFrom()
			throws NoSuchContestPhaseException, PortalException,
			SystemException {
		List<SelectItem> ret = new ArrayList<SelectItem>();

		Map<Object, Object> param = new HashMap<Object, Object>();
		for (Contest contest : PlanSectionDefinitionLocalServiceUtil
				.getContestsWithProposals(getDefinition())) {
			List<ContestPhase> phases = ContestLocalServiceUtil
					.getPhases(contest);

			for (PlanItem plan : PlanItemLocalServiceUtil.getPlans(param,
					param, 0,
					phases.get(phases.size() - 1).getContestPhasePK(), 0,
					Integer.MAX_VALUE, null, null)) {
				ret.add(new SelectItem(plan.getPlanId(),
						PlanItemLocalServiceUtil.getName(plan)));
			}
		}
		return ret;
	}

	public List<PlanItemWrapper> getProposalsInScope()
			throws NoSuchContestPhaseException, PortalException,
			SystemException {

		List<PlanItemWrapper> ret = null;//new ArrayList<PlanItemWrapper>();
		if (StringUtils.isBlank(proposalsFilter)) {
			ret = getProposalsInScopeForTab();
		}
		else {
			ret = new ArrayList<PlanItemWrapper>();
			String filter = proposalsFilter.toLowerCase(); 
			for (PlanItemWrapper plan: getProposalsInScopeForTab()) {
				if (plan.getName().toLowerCase().contains(filter)) {
					ret.add(plan);
				}
			}
		}
		
		if (StringUtils.isNotBlank(proposalsFilterSortColumn)) {
			// apply sort
			Collections.sort(ret, new Comparator<PlanItemWrapper>() {

				@Override
				public int compare(PlanItemWrapper o1, PlanItemWrapper o2) {
					int val = (int) (o1.getPlanId() - o2.getPlanId());
					try {
						if (proposalsFilterSortColumn.equals("CONTEST")) {
							val = o1.getContestName().compareTo(o2.getContestName());
						}
						else if (proposalsFilterSortColumn.equals("PROPOSAL")) {
							val = o1.getName().compareTo(o2.getName());
						}
					}
					catch (Exception e) {
						// ignore
					}
					
					return proposalsFilterSortOrder ? val : - val;
				}
			});
		}
		return ret;
	}

	private List<PlanItemWrapper> allProposals = new ArrayList<PlanItemWrapper>();
	private List<PlanItemWrapper> subscribedProposals = new ArrayList<PlanItemWrapper>();
	private List<PlanItemWrapper> supportingProposals = new ArrayList<PlanItemWrapper>();

	private List<PlanItemWrapper> getProposalsInScopeForTab()
			throws NoSuchContestPhaseException, PortalException,
			SystemException {
		if (allProposals.isEmpty()) {
			Map<Object, Object> param = new HashMap<Object, Object>();
			for (Contest contest : PlanSectionDefinitionLocalServiceUtil
					.getContestsWithProposals(getDefinition())) {
				List<ContestPhase> phases = ContestLocalServiceUtil
						.getPhases(contest);

				for (PlanItem plan : PlanItemLocalServiceUtil.getPlans(param,
						param, 0, phases.get(phases.size() - 1)
								.getContestPhasePK(), 0, Integer.MAX_VALUE,
						null, null)) {
					PlanItemWrapper planWrapped = new PlanItemWrapper(plan);
					switch (proposalsFilterTab) {
					case ALL_PROPOSALS:
						allProposals.add(planWrapped);
						break;
					case MY_SUBSCRIPTIONS:
						if (ActivitySubscriptionLocalServiceUtil.isSubscribed(
								Helper.getLiferayUser().getUserId(),
								PlanItem.class, plan.getPlanId(), 0, "")) {
							subscribedProposals.add(planWrapped);
						}
					case SUPPORTING:
						if (PlanItemLocalServiceUtil.isUserAFan(plan, Helper
								.getLiferayUser().getUserId())) {
							supportingProposals.add(planWrapped);
						}
					}
				}
			}
		}
		switch (proposalsFilterTab) {
		case MY_SUBSCRIPTIONS:
			return subscribedProposals;
		case SUPPORTING:
			return supportingProposals;
		default:
			return allProposals;
		}
	}

	public Long getReferencedId() {
		return section.getReferencedId();
	}

	public void setReferencedId(Long referencedId) {
		section.setReferencedId(referencedId);
	}

	public String getProposalsFilter() {
		return proposalsFilter;
	}

	public void setProposalsFilter(String proposalsFilter) {
		this.proposalsFilter = proposalsFilter;
	}

	public PlanSectionProposalFilterTabs getProposalsFilterTab() {
		return proposalsFilterTab;
	}

	public void setProposalsFilterTab(
			PlanSectionProposalFilterTabs proposalsFilterTab) {
		this.proposalsFilterTab = proposalsFilterTab;
	}

	public String getProposalsFilterSortColumn() {
		return proposalsFilterSortColumn;
	}

	public void setProposalsFilterSortColumn(String proposalsFilterSortColumn) {
		this.proposalsFilterSortColumn = proposalsFilterSortColumn;
	}

	public boolean getProposalsFilterSortOrder() {
		return proposalsFilterSortOrder;
	}

	public void setProposalsFilterSortOrder(boolean proposalsFilterSortOrder) {
		this.proposalsFilterSortOrder = proposalsFilterSortOrder;
	}

	public void changeProposalsFilterTab(ActionEvent e) {
		Object tab = e.getComponent().getAttributes().get("tab");

		proposalsFilterTab = PlanSectionProposalFilterTabs.valueOf(tab
				.toString());
	}
	
	public void selectProposal(ActionEvent e) {
		Long planId = (Long) e.getComponent().getAttributes().get("planId");
		choosingProposal = false;
		
		section.setReferencedId(planId);
		referencedPlan = null;
	}

	public boolean isChoosingProposal() {
		return choosingProposal;
	}

	public void setChoosingProposal(boolean choosingProposal) {
		this.choosingProposal = choosingProposal;
	}
	
	public void toggleChoosingProposal(ActionEvent e) {
		choosingProposal = !choosingProposal;
	}
}
