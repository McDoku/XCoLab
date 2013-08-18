package com.ext.portlet.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ext.portlet.NoSuchPlanToPlanException;
import com.ext.portlet.model.PlanToPlan;
import com.ext.portlet.service.base.PlanToPlanLocalServiceBaseImpl;
import com.ext.portlet.service.persistence.PlanToPlanPK;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the plan to plan local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ext.portlet.service.PlanToPlanLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ext.portlet.service.base.PlanToPlanLocalServiceBaseImpl
 * @see com.ext.portlet.service.PlanToPlanLocalServiceUtil
 */
public class PlanToPlanLocalServiceImpl extends PlanToPlanLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ext.portlet.service.PlanToPlanLocalServiceUtil} to access the plan to plan local service.
     */
    
    /**
     * Update reference counter for given pair of proposals (we form directed graph with weights)
     * 
     * @param fromPlanId plan that references other plan
     * @param toPlanId referenced plan
     * @param value number of detected references, represents a change in references count, (can be either positive 
     *              - new references added or negative - references count decreased)
     * @throws SystemException 
     */
    public void updateReference(Long fromPlanId, Long toPlanId, int value) throws SystemException {
        if (value == 0) return;
        
        // check if there exists plan to plan entity
        PlanToPlan ptp = null;
        try {
            ptp = planToPlanPersistence.findByFromPlanIdToPlanId(fromPlanId, toPlanId);
        }
        catch (NoSuchPlanToPlanException e) {
            ptp = createPlanToPlan(new PlanToPlanPK(fromPlanId, toPlanId));
            ptp.setReferenceCount(0);
        }
        // update entity val
        int newVal = ptp.getReferenceCount() + value;
        if (newVal <= 0) {
            // if references will drop to 0 or bellow - remove mapping
            deletePlanToPlan(ptp);
        }
        else {
            ptp.setReferenceCount(newVal);
            store(ptp);
        }
    }
    
    /**
     * Returns list of plan ids referenced by a given plan
     * @param fromPlanId id of a plan for which references are to be returned
     * @return list of plan ids referenced by a given plan 
     * @throws SystemException 
     */
    public List<Long> getReferencedPlansList(Long fromPlanId) throws SystemException {
        List<Long> ret = new ArrayList<>();
        
        for (PlanToPlan ptp: planToPlanPersistence.findByFromPlanId(fromPlanId)) {
            ret.add(ptp.getPrimaryKey().getToPlanId());
        }
        return ret;
    }
    
    /**
     * Returns list of plan ids that are referencing a given plan
     * @param toPlanId id of a plan for which referencing plans should be found
     * @return list of plan ids referencing given plan 
     * @throws SystemException 
     */
    public List<Long> getReferencingPlansList(Long toPlanId) throws SystemException {
        List<Long> ret = new ArrayList<>();
        
        for (PlanToPlan ptp: planToPlanPersistence.findByToPlanId(toPlanId)) {
            ret.add(ptp.getPrimaryKey().getToPlanId());
        }
        return ret;
    }

    /**
     * Stores enitity. 
     * 
     * @param ptp
     * @throws SystemException
     */
    public void store(PlanToPlan ptp) throws SystemException {
        if (ptp.isNew()) {
            addPlanToPlan(ptp);
        }
        else {
            updatePlanToPlan(ptp);
        }
        
    }
    
    /**
     * Removes references made from given plan
     * 
     * @param fromPlanId plan from which references should be removed
     * @throws SystemException 
     */
    public void removeReferences(Long fromPlanId) throws SystemException {
        
        for (PlanToPlan ptp: planToPlanPersistence.findByFromPlanId(fromPlanId)) {
            deletePlanToPlan(ptp);
        }
    }
    
}
