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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for PhonebookAddress. This utility wraps
 * {@link com.phonebook.service.impl.PhonebookAddressLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PhonebookAddressLocalService
 * @see com.phonebook.service.base.PhonebookAddressLocalServiceBaseImpl
 * @see com.phonebook.service.impl.PhonebookAddressLocalServiceImpl
 * @generated
 */
@ProviderType
public class PhonebookAddressLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.phonebook.service.impl.PhonebookAddressLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the phonebook address to the database. Also notifies the appropriate model listeners.
	*
	* @param phonebookAddress the phonebook address
	* @return the phonebook address that was added
	*/
	public static com.phonebook.model.PhonebookAddress addPhonebookAddress(
		com.phonebook.model.PhonebookAddress phonebookAddress) {
		return getService().addPhonebookAddress(phonebookAddress);
	}

	/**
	* Creates a new phonebook address with the primary key. Does not add the phonebook address to the database.
	*
	* @param addressId the primary key for the new phonebook address
	* @return the new phonebook address
	*/
	public static com.phonebook.model.PhonebookAddress createPhonebookAddress(
		long addressId) {
		return getService().createPhonebookAddress(addressId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the phonebook address with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressId the primary key of the phonebook address
	* @return the phonebook address that was removed
	* @throws PortalException if a phonebook address with the primary key could not be found
	*/
	public static com.phonebook.model.PhonebookAddress deletePhonebookAddress(
		long addressId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePhonebookAddress(addressId);
	}

	/**
	* Deletes the phonebook address from the database. Also notifies the appropriate model listeners.
	*
	* @param phonebookAddress the phonebook address
	* @return the phonebook address that was removed
	*/
	public static com.phonebook.model.PhonebookAddress deletePhonebookAddress(
		com.phonebook.model.PhonebookAddress phonebookAddress) {
		return getService().deletePhonebookAddress(phonebookAddress);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.phonebook.model.PhonebookAddress fetchPhonebookAddress(
		long addressId) {
		return getService().fetchPhonebookAddress(addressId);
	}

	/**
	* Returns the phonebook address matching the UUID and group.
	*
	* @param uuid the phonebook address's UUID
	* @param groupId the primary key of the group
	* @return the matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public static com.phonebook.model.PhonebookAddress fetchPhonebookAddressByUuidAndGroupId(
		String uuid, long groupId) {
		return getService().fetchPhonebookAddressByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* @param userId
	* @param start
	* @param end
	* @return List<PhonebookAddress>
	*/
	public static java.util.List<com.phonebook.model.PhonebookAddress> getAllPhonebookAddressesbyUserId(
		long userId, int start, int end) {
		return getService().getAllPhonebookAddressesbyUserId(userId, start, end);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the phonebook address with the primary key.
	*
	* @param addressId the primary key of the phonebook address
	* @return the phonebook address
	* @throws PortalException if a phonebook address with the primary key could not be found
	*/
	public static com.phonebook.model.PhonebookAddress getPhonebookAddress(
		long addressId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPhonebookAddress(addressId);
	}

	/**
	* Returns the phonebook address matching the UUID and group.
	*
	* @param uuid the phonebook address's UUID
	* @param groupId the primary key of the group
	* @return the matching phonebook address
	* @throws PortalException if a matching phonebook address could not be found
	*/
	public static com.phonebook.model.PhonebookAddress getPhonebookAddressByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPhonebookAddressByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<com.phonebook.model.PhonebookAddress> getPhonebookAddresses(
		int start, int end) {
		return getService().getPhonebookAddresses(start, end);
	}

	/**
	* Returns all the phonebook addresses matching the UUID and company.
	*
	* @param uuid the UUID of the phonebook addresses
	* @param companyId the primary key of the company
	* @return the matching phonebook addresses, or an empty list if no matches were found
	*/
	public static java.util.List<com.phonebook.model.PhonebookAddress> getPhonebookAddressesByUuidAndCompanyId(
		String uuid, long companyId) {
		return getService()
				   .getPhonebookAddressesByUuidAndCompanyId(uuid, companyId);
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
	public static java.util.List<com.phonebook.model.PhonebookAddress> getPhonebookAddressesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.phonebook.model.PhonebookAddress> orderByComparator) {
		return getService()
				   .getPhonebookAddressesByUuidAndCompanyId(uuid, companyId,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of phonebook addresses.
	*
	* @return the number of phonebook addresses
	*/
	public static int getPhonebookAddressesCount() {
		return getService().getPhonebookAddressesCount();
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
	public static com.phonebook.model.PhonebookAddress savePhonebookAddress(
		long id, long userId, String username, long groupId, long companyId,
		java.util.Date createdDate, java.util.Date modifiedDate,
		String firstName, String lastName, String emailAddress, String mobileNr) {
		return getService()
				   .savePhonebookAddress(id, userId, username, groupId,
			companyId, createdDate, modifiedDate, firstName, lastName,
			emailAddress, mobileNr);
	}

	/**
	* Updates the phonebook address in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param phonebookAddress the phonebook address
	* @return the phonebook address that was updated
	*/
	public static com.phonebook.model.PhonebookAddress updatePhonebookAddress(
		com.phonebook.model.PhonebookAddress phonebookAddress) {
		return getService().updatePhonebookAddress(phonebookAddress);
	}

	public static PhonebookAddressLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PhonebookAddressLocalService, PhonebookAddressLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PhonebookAddressLocalService.class);

		ServiceTracker<PhonebookAddressLocalService, PhonebookAddressLocalService> serviceTracker =
			new ServiceTracker<PhonebookAddressLocalService, PhonebookAddressLocalService>(bundle.getBundleContext(),
				PhonebookAddressLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}