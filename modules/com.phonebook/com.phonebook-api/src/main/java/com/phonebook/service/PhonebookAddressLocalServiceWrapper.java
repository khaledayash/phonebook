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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PhonebookAddressLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PhonebookAddressLocalService
 * @generated
 */
@ProviderType
public class PhonebookAddressLocalServiceWrapper
	implements PhonebookAddressLocalService,
		ServiceWrapper<PhonebookAddressLocalService> {
	public PhonebookAddressLocalServiceWrapper(
		PhonebookAddressLocalService phonebookAddressLocalService) {
		_phonebookAddressLocalService = phonebookAddressLocalService;
	}

	/**
	* Adds the phonebook address to the database. Also notifies the appropriate model listeners.
	*
	* @param phonebookAddress the phonebook address
	* @return the phonebook address that was added
	*/
	@Override
	public com.phonebook.model.PhonebookAddress addPhonebookAddress(
		com.phonebook.model.PhonebookAddress phonebookAddress) {
		return _phonebookAddressLocalService.addPhonebookAddress(phonebookAddress);
	}

	/**
	* Creates a new phonebook address with the primary key. Does not add the phonebook address to the database.
	*
	* @param addressId the primary key for the new phonebook address
	* @return the new phonebook address
	*/
	@Override
	public com.phonebook.model.PhonebookAddress createPhonebookAddress(
		long addressId) {
		return _phonebookAddressLocalService.createPhonebookAddress(addressId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _phonebookAddressLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the phonebook address with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressId the primary key of the phonebook address
	* @return the phonebook address that was removed
	* @throws PortalException if a phonebook address with the primary key could not be found
	*/
	@Override
	public com.phonebook.model.PhonebookAddress deletePhonebookAddress(
		long addressId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _phonebookAddressLocalService.deletePhonebookAddress(addressId);
	}

	/**
	* Deletes the phonebook address from the database. Also notifies the appropriate model listeners.
	*
	* @param phonebookAddress the phonebook address
	* @return the phonebook address that was removed
	*/
	@Override
	public com.phonebook.model.PhonebookAddress deletePhonebookAddress(
		com.phonebook.model.PhonebookAddress phonebookAddress) {
		return _phonebookAddressLocalService.deletePhonebookAddress(phonebookAddress);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _phonebookAddressLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _phonebookAddressLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _phonebookAddressLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _phonebookAddressLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _phonebookAddressLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _phonebookAddressLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.phonebook.model.PhonebookAddress fetchPhonebookAddress(
		long addressId) {
		return _phonebookAddressLocalService.fetchPhonebookAddress(addressId);
	}

	/**
	* Returns the phonebook address matching the UUID and group.
	*
	* @param uuid the phonebook address's UUID
	* @param groupId the primary key of the group
	* @return the matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	@Override
	public com.phonebook.model.PhonebookAddress fetchPhonebookAddressByUuidAndGroupId(
		String uuid, long groupId) {
		return _phonebookAddressLocalService.fetchPhonebookAddressByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _phonebookAddressLocalService.getActionableDynamicQuery();
	}

	/**
	* @param userId
	* @param start
	* @param end
	* @return List<PhonebookAddress>
	*/
	@Override
	public java.util.List<com.phonebook.model.PhonebookAddress> getAllPhonebookAddressesbyUserId(
		long userId, int start, int end) {
		return _phonebookAddressLocalService.getAllPhonebookAddressesbyUserId(userId,
			start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _phonebookAddressLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _phonebookAddressLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _phonebookAddressLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _phonebookAddressLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the phonebook address with the primary key.
	*
	* @param addressId the primary key of the phonebook address
	* @return the phonebook address
	* @throws PortalException if a phonebook address with the primary key could not be found
	*/
	@Override
	public com.phonebook.model.PhonebookAddress getPhonebookAddress(
		long addressId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _phonebookAddressLocalService.getPhonebookAddress(addressId);
	}

	/**
	* Returns the phonebook address matching the UUID and group.
	*
	* @param uuid the phonebook address's UUID
	* @param groupId the primary key of the group
	* @return the matching phonebook address
	* @throws PortalException if a matching phonebook address could not be found
	*/
	@Override
	public com.phonebook.model.PhonebookAddress getPhonebookAddressByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _phonebookAddressLocalService.getPhonebookAddressByUuidAndGroupId(uuid,
			groupId);
	}

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
	@Override
	public java.util.List<com.phonebook.model.PhonebookAddress> getPhonebookAddresses(
		int start, int end) {
		return _phonebookAddressLocalService.getPhonebookAddresses(start, end);
	}

	/**
	* Returns all the phonebook addresses matching the UUID and company.
	*
	* @param uuid the UUID of the phonebook addresses
	* @param companyId the primary key of the company
	* @return the matching phonebook addresses, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.phonebook.model.PhonebookAddress> getPhonebookAddressesByUuidAndCompanyId(
		String uuid, long companyId) {
		return _phonebookAddressLocalService.getPhonebookAddressesByUuidAndCompanyId(uuid,
			companyId);
	}

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
	@Override
	public java.util.List<com.phonebook.model.PhonebookAddress> getPhonebookAddressesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.phonebook.model.PhonebookAddress> orderByComparator) {
		return _phonebookAddressLocalService.getPhonebookAddressesByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of phonebook addresses.
	*
	* @return the number of phonebook addresses
	*/
	@Override
	public int getPhonebookAddressesCount() {
		return _phonebookAddressLocalService.getPhonebookAddressesCount();
	}

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
	@Override
	public com.phonebook.model.PhonebookAddress savePhonebookAddress(long id,
		long userId, String username, long groupId, long companyId,
		java.util.Date createdDate, java.util.Date modifiedDate,
		String firstName, String lastName, String emailAddress, String mobileNr) {
		return _phonebookAddressLocalService.savePhonebookAddress(id, userId,
			username, groupId, companyId, createdDate, modifiedDate, firstName,
			lastName, emailAddress, mobileNr);
	}

	/**
	* Updates the phonebook address in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param phonebookAddress the phonebook address
	* @return the phonebook address that was updated
	*/
	@Override
	public com.phonebook.model.PhonebookAddress updatePhonebookAddress(
		com.phonebook.model.PhonebookAddress phonebookAddress) {
		return _phonebookAddressLocalService.updatePhonebookAddress(phonebookAddress);
	}

	@Override
	public PhonebookAddressLocalService getWrappedService() {
		return _phonebookAddressLocalService;
	}

	@Override
	public void setWrappedService(
		PhonebookAddressLocalService phonebookAddressLocalService) {
		_phonebookAddressLocalService = phonebookAddressLocalService;
	}

	private PhonebookAddressLocalService _phonebookAddressLocalService;
}