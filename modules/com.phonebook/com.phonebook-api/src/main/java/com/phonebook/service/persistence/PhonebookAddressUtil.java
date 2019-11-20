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

package com.phonebook.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.phonebook.model.PhonebookAddress;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the phonebook address service. This utility wraps {@link com.phonebook.service.persistence.impl.PhonebookAddressPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhonebookAddressPersistence
 * @see com.phonebook.service.persistence.impl.PhonebookAddressPersistenceImpl
 * @generated
 */
@ProviderType
public class PhonebookAddressUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(PhonebookAddress phonebookAddress) {
		getPersistence().clearCache(phonebookAddress);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PhonebookAddress> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PhonebookAddress> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PhonebookAddress> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PhonebookAddress update(PhonebookAddress phonebookAddress) {
		return getPersistence().update(phonebookAddress);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PhonebookAddress update(PhonebookAddress phonebookAddress,
		ServiceContext serviceContext) {
		return getPersistence().update(phonebookAddress, serviceContext);
	}

	/**
	* Returns all the phonebook addresses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching phonebook addresses
	*/
	public static List<PhonebookAddress> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the phonebook addresses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhonebookAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of phonebook addresses
	* @param end the upper bound of the range of phonebook addresses (not inclusive)
	* @return the range of matching phonebook addresses
	*/
	public static List<PhonebookAddress> findByUuid(String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the phonebook addresses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhonebookAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of phonebook addresses
	* @param end the upper bound of the range of phonebook addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching phonebook addresses
	*/
	public static List<PhonebookAddress> findByUuid(String uuid, int start,
		int end, OrderByComparator<PhonebookAddress> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the phonebook addresses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhonebookAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of phonebook addresses
	* @param end the upper bound of the range of phonebook addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching phonebook addresses
	*/
	public static List<PhonebookAddress> findByUuid(String uuid, int start,
		int end, OrderByComparator<PhonebookAddress> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first phonebook address in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phonebook address
	* @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	*/
	public static PhonebookAddress findByUuid_First(String uuid,
		OrderByComparator<PhonebookAddress> orderByComparator)
		throws com.phonebook.exception.NoSuchPhonebookAddressException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first phonebook address in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public static PhonebookAddress fetchByUuid_First(String uuid,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last phonebook address in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phonebook address
	* @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	*/
	public static PhonebookAddress findByUuid_Last(String uuid,
		OrderByComparator<PhonebookAddress> orderByComparator)
		throws com.phonebook.exception.NoSuchPhonebookAddressException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last phonebook address in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public static PhonebookAddress fetchByUuid_Last(String uuid,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the phonebook addresses before and after the current phonebook address in the ordered set where uuid = &#63;.
	*
	* @param addressId the primary key of the current phonebook address
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next phonebook address
	* @throws NoSuchPhonebookAddressException if a phonebook address with the primary key could not be found
	*/
	public static PhonebookAddress[] findByUuid_PrevAndNext(long addressId,
		String uuid, OrderByComparator<PhonebookAddress> orderByComparator)
		throws com.phonebook.exception.NoSuchPhonebookAddressException {
		return getPersistence()
				   .findByUuid_PrevAndNext(addressId, uuid, orderByComparator);
	}

	/**
	* Removes all the phonebook addresses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of phonebook addresses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching phonebook addresses
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the phonebook address where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchPhonebookAddressException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching phonebook address
	* @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	*/
	public static PhonebookAddress findByUUID_G(String uuid, long groupId)
		throws com.phonebook.exception.NoSuchPhonebookAddressException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the phonebook address where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public static PhonebookAddress fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the phonebook address where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public static PhonebookAddress fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the phonebook address where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the phonebook address that was removed
	*/
	public static PhonebookAddress removeByUUID_G(String uuid, long groupId)
		throws com.phonebook.exception.NoSuchPhonebookAddressException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of phonebook addresses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching phonebook addresses
	*/
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the phonebook addresses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching phonebook addresses
	*/
	public static List<PhonebookAddress> findByUuid_C(String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the phonebook addresses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhonebookAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of phonebook addresses
	* @param end the upper bound of the range of phonebook addresses (not inclusive)
	* @return the range of matching phonebook addresses
	*/
	public static List<PhonebookAddress> findByUuid_C(String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the phonebook addresses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhonebookAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of phonebook addresses
	* @param end the upper bound of the range of phonebook addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching phonebook addresses
	*/
	public static List<PhonebookAddress> findByUuid_C(String uuid,
		long companyId, int start, int end,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the phonebook addresses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhonebookAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of phonebook addresses
	* @param end the upper bound of the range of phonebook addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching phonebook addresses
	*/
	public static List<PhonebookAddress> findByUuid_C(String uuid,
		long companyId, int start, int end,
		OrderByComparator<PhonebookAddress> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first phonebook address in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phonebook address
	* @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	*/
	public static PhonebookAddress findByUuid_C_First(String uuid,
		long companyId, OrderByComparator<PhonebookAddress> orderByComparator)
		throws com.phonebook.exception.NoSuchPhonebookAddressException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first phonebook address in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public static PhonebookAddress fetchByUuid_C_First(String uuid,
		long companyId, OrderByComparator<PhonebookAddress> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last phonebook address in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phonebook address
	* @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	*/
	public static PhonebookAddress findByUuid_C_Last(String uuid,
		long companyId, OrderByComparator<PhonebookAddress> orderByComparator)
		throws com.phonebook.exception.NoSuchPhonebookAddressException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last phonebook address in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public static PhonebookAddress fetchByUuid_C_Last(String uuid,
		long companyId, OrderByComparator<PhonebookAddress> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the phonebook addresses before and after the current phonebook address in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param addressId the primary key of the current phonebook address
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next phonebook address
	* @throws NoSuchPhonebookAddressException if a phonebook address with the primary key could not be found
	*/
	public static PhonebookAddress[] findByUuid_C_PrevAndNext(long addressId,
		String uuid, long companyId,
		OrderByComparator<PhonebookAddress> orderByComparator)
		throws com.phonebook.exception.NoSuchPhonebookAddressException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(addressId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the phonebook addresses where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of phonebook addresses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching phonebook addresses
	*/
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the phonebook addresses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching phonebook addresses
	*/
	public static List<PhonebookAddress> findByGroup(long groupId) {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the phonebook addresses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhonebookAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of phonebook addresses
	* @param end the upper bound of the range of phonebook addresses (not inclusive)
	* @return the range of matching phonebook addresses
	*/
	public static List<PhonebookAddress> findByGroup(long groupId, int start,
		int end) {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the phonebook addresses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhonebookAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of phonebook addresses
	* @param end the upper bound of the range of phonebook addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching phonebook addresses
	*/
	public static List<PhonebookAddress> findByGroup(long groupId, int start,
		int end, OrderByComparator<PhonebookAddress> orderByComparator) {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the phonebook addresses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhonebookAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of phonebook addresses
	* @param end the upper bound of the range of phonebook addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching phonebook addresses
	*/
	public static List<PhonebookAddress> findByGroup(long groupId, int start,
		int end, OrderByComparator<PhonebookAddress> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first phonebook address in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phonebook address
	* @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	*/
	public static PhonebookAddress findByGroup_First(long groupId,
		OrderByComparator<PhonebookAddress> orderByComparator)
		throws com.phonebook.exception.NoSuchPhonebookAddressException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first phonebook address in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public static PhonebookAddress fetchByGroup_First(long groupId,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last phonebook address in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phonebook address
	* @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	*/
	public static PhonebookAddress findByGroup_Last(long groupId,
		OrderByComparator<PhonebookAddress> orderByComparator)
		throws com.phonebook.exception.NoSuchPhonebookAddressException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last phonebook address in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public static PhonebookAddress fetchByGroup_Last(long groupId,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the phonebook addresses before and after the current phonebook address in the ordered set where groupId = &#63;.
	*
	* @param addressId the primary key of the current phonebook address
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next phonebook address
	* @throws NoSuchPhonebookAddressException if a phonebook address with the primary key could not be found
	*/
	public static PhonebookAddress[] findByGroup_PrevAndNext(long addressId,
		long groupId, OrderByComparator<PhonebookAddress> orderByComparator)
		throws com.phonebook.exception.NoSuchPhonebookAddressException {
		return getPersistence()
				   .findByGroup_PrevAndNext(addressId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the phonebook addresses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroup(long groupId) {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Returns the number of phonebook addresses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching phonebook addresses
	*/
	public static int countByGroup(long groupId) {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns all the phonebook addresses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching phonebook addresses
	*/
	public static List<PhonebookAddress> findByUser(long userId) {
		return getPersistence().findByUser(userId);
	}

	/**
	* Returns a range of all the phonebook addresses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhonebookAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of phonebook addresses
	* @param end the upper bound of the range of phonebook addresses (not inclusive)
	* @return the range of matching phonebook addresses
	*/
	public static List<PhonebookAddress> findByUser(long userId, int start,
		int end) {
		return getPersistence().findByUser(userId, start, end);
	}

	/**
	* Returns an ordered range of all the phonebook addresses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhonebookAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of phonebook addresses
	* @param end the upper bound of the range of phonebook addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching phonebook addresses
	*/
	public static List<PhonebookAddress> findByUser(long userId, int start,
		int end, OrderByComparator<PhonebookAddress> orderByComparator) {
		return getPersistence().findByUser(userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the phonebook addresses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhonebookAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of phonebook addresses
	* @param end the upper bound of the range of phonebook addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching phonebook addresses
	*/
	public static List<PhonebookAddress> findByUser(long userId, int start,
		int end, OrderByComparator<PhonebookAddress> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUser(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first phonebook address in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phonebook address
	* @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	*/
	public static PhonebookAddress findByUser_First(long userId,
		OrderByComparator<PhonebookAddress> orderByComparator)
		throws com.phonebook.exception.NoSuchPhonebookAddressException {
		return getPersistence().findByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the first phonebook address in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public static PhonebookAddress fetchByUser_First(long userId,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		return getPersistence().fetchByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the last phonebook address in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phonebook address
	* @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	*/
	public static PhonebookAddress findByUser_Last(long userId,
		OrderByComparator<PhonebookAddress> orderByComparator)
		throws com.phonebook.exception.NoSuchPhonebookAddressException {
		return getPersistence().findByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the last phonebook address in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public static PhonebookAddress fetchByUser_Last(long userId,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		return getPersistence().fetchByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the phonebook addresses before and after the current phonebook address in the ordered set where userId = &#63;.
	*
	* @param addressId the primary key of the current phonebook address
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next phonebook address
	* @throws NoSuchPhonebookAddressException if a phonebook address with the primary key could not be found
	*/
	public static PhonebookAddress[] findByUser_PrevAndNext(long addressId,
		long userId, OrderByComparator<PhonebookAddress> orderByComparator)
		throws com.phonebook.exception.NoSuchPhonebookAddressException {
		return getPersistence()
				   .findByUser_PrevAndNext(addressId, userId, orderByComparator);
	}

	/**
	* Removes all the phonebook addresses where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByUser(long userId) {
		getPersistence().removeByUser(userId);
	}

	/**
	* Returns the number of phonebook addresses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching phonebook addresses
	*/
	public static int countByUser(long userId) {
		return getPersistence().countByUser(userId);
	}

	/**
	* Returns all the phonebook addresses where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching phonebook addresses
	*/
	public static List<PhonebookAddress> findByGroupAndUser(long userId,
		long groupId) {
		return getPersistence().findByGroupAndUser(userId, groupId);
	}

	/**
	* Returns a range of all the phonebook addresses where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhonebookAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of phonebook addresses
	* @param end the upper bound of the range of phonebook addresses (not inclusive)
	* @return the range of matching phonebook addresses
	*/
	public static List<PhonebookAddress> findByGroupAndUser(long userId,
		long groupId, int start, int end) {
		return getPersistence().findByGroupAndUser(userId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the phonebook addresses where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhonebookAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of phonebook addresses
	* @param end the upper bound of the range of phonebook addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching phonebook addresses
	*/
	public static List<PhonebookAddress> findByGroupAndUser(long userId,
		long groupId, int start, int end,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		return getPersistence()
				   .findByGroupAndUser(userId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the phonebook addresses where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhonebookAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of phonebook addresses
	* @param end the upper bound of the range of phonebook addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching phonebook addresses
	*/
	public static List<PhonebookAddress> findByGroupAndUser(long userId,
		long groupId, int start, int end,
		OrderByComparator<PhonebookAddress> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupAndUser(userId, groupId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first phonebook address in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phonebook address
	* @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	*/
	public static PhonebookAddress findByGroupAndUser_First(long userId,
		long groupId, OrderByComparator<PhonebookAddress> orderByComparator)
		throws com.phonebook.exception.NoSuchPhonebookAddressException {
		return getPersistence()
				   .findByGroupAndUser_First(userId, groupId, orderByComparator);
	}

	/**
	* Returns the first phonebook address in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public static PhonebookAddress fetchByGroupAndUser_First(long userId,
		long groupId, OrderByComparator<PhonebookAddress> orderByComparator) {
		return getPersistence()
				   .fetchByGroupAndUser_First(userId, groupId, orderByComparator);
	}

	/**
	* Returns the last phonebook address in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phonebook address
	* @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	*/
	public static PhonebookAddress findByGroupAndUser_Last(long userId,
		long groupId, OrderByComparator<PhonebookAddress> orderByComparator)
		throws com.phonebook.exception.NoSuchPhonebookAddressException {
		return getPersistence()
				   .findByGroupAndUser_Last(userId, groupId, orderByComparator);
	}

	/**
	* Returns the last phonebook address in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public static PhonebookAddress fetchByGroupAndUser_Last(long userId,
		long groupId, OrderByComparator<PhonebookAddress> orderByComparator) {
		return getPersistence()
				   .fetchByGroupAndUser_Last(userId, groupId, orderByComparator);
	}

	/**
	* Returns the phonebook addresses before and after the current phonebook address in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param addressId the primary key of the current phonebook address
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next phonebook address
	* @throws NoSuchPhonebookAddressException if a phonebook address with the primary key could not be found
	*/
	public static PhonebookAddress[] findByGroupAndUser_PrevAndNext(
		long addressId, long userId, long groupId,
		OrderByComparator<PhonebookAddress> orderByComparator)
		throws com.phonebook.exception.NoSuchPhonebookAddressException {
		return getPersistence()
				   .findByGroupAndUser_PrevAndNext(addressId, userId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the phonebook addresses where userId = &#63; and groupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	*/
	public static void removeByGroupAndUser(long userId, long groupId) {
		getPersistence().removeByGroupAndUser(userId, groupId);
	}

	/**
	* Returns the number of phonebook addresses where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching phonebook addresses
	*/
	public static int countByGroupAndUser(long userId, long groupId) {
		return getPersistence().countByGroupAndUser(userId, groupId);
	}

	/**
	* Caches the phonebook address in the entity cache if it is enabled.
	*
	* @param phonebookAddress the phonebook address
	*/
	public static void cacheResult(PhonebookAddress phonebookAddress) {
		getPersistence().cacheResult(phonebookAddress);
	}

	/**
	* Caches the phonebook addresses in the entity cache if it is enabled.
	*
	* @param phonebookAddresses the phonebook addresses
	*/
	public static void cacheResult(List<PhonebookAddress> phonebookAddresses) {
		getPersistence().cacheResult(phonebookAddresses);
	}

	/**
	* Creates a new phonebook address with the primary key. Does not add the phonebook address to the database.
	*
	* @param addressId the primary key for the new phonebook address
	* @return the new phonebook address
	*/
	public static PhonebookAddress create(long addressId) {
		return getPersistence().create(addressId);
	}

	/**
	* Removes the phonebook address with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressId the primary key of the phonebook address
	* @return the phonebook address that was removed
	* @throws NoSuchPhonebookAddressException if a phonebook address with the primary key could not be found
	*/
	public static PhonebookAddress remove(long addressId)
		throws com.phonebook.exception.NoSuchPhonebookAddressException {
		return getPersistence().remove(addressId);
	}

	public static PhonebookAddress updateImpl(PhonebookAddress phonebookAddress) {
		return getPersistence().updateImpl(phonebookAddress);
	}

	/**
	* Returns the phonebook address with the primary key or throws a {@link NoSuchPhonebookAddressException} if it could not be found.
	*
	* @param addressId the primary key of the phonebook address
	* @return the phonebook address
	* @throws NoSuchPhonebookAddressException if a phonebook address with the primary key could not be found
	*/
	public static PhonebookAddress findByPrimaryKey(long addressId)
		throws com.phonebook.exception.NoSuchPhonebookAddressException {
		return getPersistence().findByPrimaryKey(addressId);
	}

	/**
	* Returns the phonebook address with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param addressId the primary key of the phonebook address
	* @return the phonebook address, or <code>null</code> if a phonebook address with the primary key could not be found
	*/
	public static PhonebookAddress fetchByPrimaryKey(long addressId) {
		return getPersistence().fetchByPrimaryKey(addressId);
	}

	public static java.util.Map<java.io.Serializable, PhonebookAddress> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the phonebook addresses.
	*
	* @return the phonebook addresses
	*/
	public static List<PhonebookAddress> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the phonebook addresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhonebookAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of phonebook addresses
	* @param end the upper bound of the range of phonebook addresses (not inclusive)
	* @return the range of phonebook addresses
	*/
	public static List<PhonebookAddress> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the phonebook addresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhonebookAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of phonebook addresses
	* @param end the upper bound of the range of phonebook addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of phonebook addresses
	*/
	public static List<PhonebookAddress> findAll(int start, int end,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the phonebook addresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhonebookAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of phonebook addresses
	* @param end the upper bound of the range of phonebook addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of phonebook addresses
	*/
	public static List<PhonebookAddress> findAll(int start, int end,
		OrderByComparator<PhonebookAddress> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the phonebook addresses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of phonebook addresses.
	*
	* @return the number of phonebook addresses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static PhonebookAddressPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PhonebookAddressPersistence, PhonebookAddressPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PhonebookAddressPersistence.class);

		ServiceTracker<PhonebookAddressPersistence, PhonebookAddressPersistence> serviceTracker =
			new ServiceTracker<PhonebookAddressPersistence, PhonebookAddressPersistence>(bundle.getBundleContext(),
				PhonebookAddressPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}