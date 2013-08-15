package com.ext.portlet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ext.portlet.PlanSectionDefinitionType;
import com.ext.portlet.model.Contest;
import com.ext.portlet.model.FocusArea;
import com.ext.portlet.model.PlanSectionDefinition;
import com.ext.portlet.model.PlanSectionDefinitionListItem;
import com.ext.portlet.service.ContestLocalServiceUtil;
import com.ext.portlet.service.FocusAreaLocalServiceUtil;
import com.ext.portlet.service.PlanSectionDefinitionLocalServiceUtil;
import com.ext.portlet.service.base.PlanSectionDefinitionLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the plan section definition local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ext.portlet.service.PlanSectionDefinitionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ext.portlet.service.base.PlanSectionDefinitionLocalServiceBaseImpl
 * @see com.ext.portlet.service.PlanSectionDefinitionLocalServiceUtil
 */
public class PlanSectionDefinitionLocalServiceImpl
    extends PlanSectionDefinitionLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ext.portlet.service.PlanSectionDefinitionLocalServiceUtil} to access the plan section definition local service.
     */

    public void store(PlanSectionDefinition psd) throws SystemException {
        if (psd.isNew()) {
            if (psd.getId() == 0L || psd.getId() <= 0) {
                psd.setId(CounterLocalServiceUtil.increment(PlanSectionDefinition.class.getName()));
            }
            
            PlanSectionDefinitionLocalServiceUtil.addPlanSectionDefinition(psd);
        }
        else {
            PlanSectionDefinitionLocalServiceUtil.updatePlanSectionDefinition(psd);
        }
    }
    
    public FocusArea getFocusArea(PlanSectionDefinition psd) throws PortalException, SystemException {
        if (psd.getFocusAreaId() > 0L) {
            return FocusAreaLocalServiceUtil.getFocusArea(psd.getFocusAreaId());
        }
        return null;
    }
    
    public PlanSectionDefinitionType getSectionType(PlanSectionDefinition definition) {
        if (StringUtils.isBlank(definition.getType())) 
            return PlanSectionDefinitionType.TEXT;
        return PlanSectionDefinitionType.valueOf(definition.getType());
    }
    
    
    public List<Contest> getContestsWithProposals(PlanSectionDefinition psd) throws SystemException, PortalException {
        if (! (getSectionType(psd) == PlanSectionDefinitionType.PROPOSAL_REFERENCE)) return new ArrayList<>();
        List<Contest> ret = new ArrayList<>();
        for (PlanSectionDefinitionListItem item: planSectionDefinitionListItemPersistence.findByPlanSectionDefinitionIdType(psd.getId(), PlanSectionDefinitionType.PROPOSAL_REFERENCE.name())) {
            ret.add(ContestLocalServiceUtil.getContest(item.getReferencedId()));
        }
        
        return ret;
    }
}
