/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.phonebook.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.phonebook.model.PhonebookAddress;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 * Provides the local service interface for PhonebookAddress. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see PhonebookAddressLocalServiceUtil
 * @see com.phonebook.service.base.PhonebookAddressLocalServiceBaseImpl
 * @see com.phonebook.service.impl.PhonebookAddressLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface PhonebookAddressLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhonebookAddressLocalServiceUtil} to access the phonebook address local service. Add custom service methods to {@link com.phonebook.service.impl.PhonebookAddressLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the phonebook address to the database. Also notifies the appropriate model listeners.
	*
	* @param phonebookAddress the phonebook address
	* @return the phonebook address that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public PhonebookAddress addPhonebookAddress(
		PhonebookAddress phonebookAddress);

	/**
	* Creates a new phonebook address with the primary key. Does not add the phonebook address to the database.
	*
	* @param addressId the primary key for the new phonebook address
	* @return the new phonebook address
	*/
	@Transactional(enabled = false)
	public PhonebookAddress createPhonebookAddress(long addressId);

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	* Deletes the phonebook address with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressId the primary key of the phonebook address
	* @return the phonebook address that was removed
	* @throws PortalException if a phonebook address with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public PhonebookAddress deletePhonebookAddress(long addressId)
		throws PortalException;

	/**
	* Deletes the phonebook address from the database. Also notifies the appropriate model listeners.
	*
	* @param phonebookAddress the phonebook address
	* @return the phonebook address that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public PhonebookAddress deletePhonebookAddress(
		PhonebookAddress phonebookAddress);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.phonebook.model.impl.PhonebookAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.phonebook.model.impl.PhonebookAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PhonebookAddress fetchPhonebookAddress(long addressId);

	/**
	* Returns the phonebook address matching the UUID and group.
	*
	* @param uuid the phonebook address's UUID
	* @param groupId the primary key of the group
	* @return the matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PhonebookAddress fetchPhonebookAddressByUuidAndGroupId(String uuid,
		long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	* @param userId
	* @param start
	* @param end
	* @return List<PhonebookAddress>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PhonebookAddress> getAllPhonebookAddressesbyUserId(
		long userId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Returns the phonebook address with the primary key.
	*
	* @param addressId the primary key of the phonebook address
	* @return the phonebook address
	* @throws PortalException if a phonebook address with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PhonebookAddress getPhonebookAddress(long addressId)
		throws PortalException;

	/**
	* Returns the phonebook address matching the UUID and group.
	*
	* @param uuid the phonebook address's UUID
	* @param groupId the primary key of the group
	* @return the matching phonebook address
	* @throws PortalException if a matching phonebook address could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PhonebookAddress getPhonebookAddressByUuidAndGroupId(String uuid,
		long groupId) throws PortalException;

	/**
	* Returns a range of all the phonebook addresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.phonebook.model.impl.PhonebookAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of phonebook addresses
	* @param end the upper bound of the range of phonebook addresses (not inclusive)
	* @return the range of phonebook addresses
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PhonebookAddress> getPhonebookAddresses(int start, int end);

	/**
	* Returns all the phonebook addresses matching the UUID and company.
	*
	* @param uuid the UUID of the phonebook addresses
	* @param companyId the primary key of the company
	* @return the matching phonebook addresses, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PhonebookAddress> getPhonebookAddressesByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	* Returns a range of phonebook addresses matching the UUID and company.
	*
	* @param uuid the UUID of the phonebook addresses
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of phonebook addresses
	* @param end the upper bound of the range of phonebook addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching phonebook addresses, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PhonebookAddress> getPhonebookAddressesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PhonebookAddress> orderByComparator);

	/**
	* Returns the number of phonebook addresses.
	*
	* @return the number of phonebook addresses
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPhonebookAddressesCount();

	/**
	* @param id
	* @param userId
	* @param username
	* @param groupId
	* @param companyId
	* @param createdDate
	* @param modifiedDate
	* @param firstName
	* @param lastName
	* @param emailAddress
	* @param mobileNr
	* @return PhonebookAddress
	*/
	public PhonebookAddress savePhonebookAddress(long id, long userId,
		String username, long groupId, long companyId, Date createdDate,
		Date modifiedDate, String firstName, String lastName,
		String emailAddress, String mobileNr);

	/**
	* Updates the phonebook address in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param phonebookAddress the phonebook address
	* @return the phonebook address that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public PhonebookAddress updatePhonebookAddress(
		PhonebookAddress phonebookAddress);
}