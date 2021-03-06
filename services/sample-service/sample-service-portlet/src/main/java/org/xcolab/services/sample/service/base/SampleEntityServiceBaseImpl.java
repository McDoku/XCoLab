package org.xcolab.services.sample.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import org.xcolab.services.sample.model.SampleEntity;
import org.xcolab.services.sample.service.SampleEntityLocalService;
import org.xcolab.services.sample.service.SampleEntityService;
import org.xcolab.services.sample.service.persistence.SampleEntityPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the sample entity remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.xcolab.services.sample.service.impl.SampleEntityServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see org.xcolab.services.sample.service.impl.SampleEntityServiceImpl
 * @see org.xcolab.services.sample.service.SampleEntityServiceUtil
 * @generated
 */
public abstract class SampleEntityServiceBaseImpl extends PrincipalBean
    implements SampleEntityService, IdentifiableBean {
    @BeanReference(type = SampleEntityLocalService.class)
    protected SampleEntityLocalService sampleEntityLocalService;
    @BeanReference(type = SampleEntityService.class)
    protected SampleEntityService sampleEntityService;
    @BeanReference(type = SampleEntityPersistence.class)
    protected SampleEntityPersistence sampleEntityPersistence;
    @BeanReference(type = CounterLocalService.class)
    protected CounterLocalService counterLocalService;
    @BeanReference(type = ResourceLocalService.class)
    protected ResourceLocalService resourceLocalService;
    @BeanReference(type = ResourceService.class)
    protected ResourceService resourceService;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserLocalService.class)
    protected UserLocalService userLocalService;
    @BeanReference(type = UserService.class)
    protected UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link org.xcolab.services.sample.service.SampleEntityServiceUtil} to access the sample entity remote service.
     */

    /**
     * Returns the sample entity local service.
     *
     * @return the sample entity local service
     */
    public SampleEntityLocalService getSampleEntityLocalService() {
        return sampleEntityLocalService;
    }

    /**
     * Sets the sample entity local service.
     *
     * @param sampleEntityLocalService the sample entity local service
     */
    public void setSampleEntityLocalService(
        SampleEntityLocalService sampleEntityLocalService) {
        this.sampleEntityLocalService = sampleEntityLocalService;
    }

    /**
     * Returns the sample entity remote service.
     *
     * @return the sample entity remote service
     */
    public SampleEntityService getSampleEntityService() {
        return sampleEntityService;
    }

    /**
     * Sets the sample entity remote service.
     *
     * @param sampleEntityService the sample entity remote service
     */
    public void setSampleEntityService(SampleEntityService sampleEntityService) {
        this.sampleEntityService = sampleEntityService;
    }

    /**
     * Returns the sample entity persistence.
     *
     * @return the sample entity persistence
     */
    public SampleEntityPersistence getSampleEntityPersistence() {
        return sampleEntityPersistence;
    }

    /**
     * Sets the sample entity persistence.
     *
     * @param sampleEntityPersistence the sample entity persistence
     */
    public void setSampleEntityPersistence(
        SampleEntityPersistence sampleEntityPersistence) {
        this.sampleEntityPersistence = sampleEntityPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the resource remote service.
     *
     * @return the resource remote service
     */
    public ResourceService getResourceService() {
        return resourceService;
    }

    /**
     * Sets the resource remote service.
     *
     * @param resourceService the resource remote service
     */
    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    /**
     * Returns the resource persistence.
     *
     * @return the resource persistence
     */
    public ResourcePersistence getResourcePersistence() {
        return resourcePersistence;
    }

    /**
     * Sets the resource persistence.
     *
     * @param resourcePersistence the resource persistence
     */
    public void setResourcePersistence(ResourcePersistence resourcePersistence) {
        this.resourcePersistence = resourcePersistence;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
    }

    public void destroy() {
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    protected Class<?> getModelClass() {
        return SampleEntity.class;
    }

    protected String getModelClassName() {
        return SampleEntity.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = sampleEntityPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
