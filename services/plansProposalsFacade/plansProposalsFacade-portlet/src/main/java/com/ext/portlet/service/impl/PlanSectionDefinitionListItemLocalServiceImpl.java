package com.ext.portlet.service.impl;

import com.ext.portlet.model.PlanSectionDefinitionListItem;
import com.ext.portlet.service.base.PlanSectionDefinitionListItemLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.counter.service.persistence.CounterUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the plan section definition list item local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ext.portlet.service.PlanSectionDefinitionListItemLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ext.portlet.service.base.PlanSectionDefinitionListItemLocalServiceBaseImpl
 * @see com.ext.portlet.service.PlanSectionDefinitionListItemLocalServiceUtil
 */
public class PlanSectionDefinitionListItemLocalServiceImpl
    extends PlanSectionDefinitionListItemLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ext.portlet.service.PlanSectionDefinitionListItemLocalServiceUtil} to access the plan section definition list item local service.
     */
    
    public void store(PlanSectionDefinitionListItem psd) throws SystemException {
        if (psd.getId() <= 0) {
            psd.setId(CounterLocalServiceUtil.increment(PlanSectionDefinitionListItem.class.getName()));
        }
        
        if (psd.isNew()) {
            addPlanSectionDefinitionListItem(psd);
        }
        else {
            updatePlanSectionDefinitionListItem(psd);
        }
    }
}
