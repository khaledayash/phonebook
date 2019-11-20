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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.phonebook.exception.NoSuchPhonebookAddressException;

import com.phonebook.model.PhonebookAddress;

/**
 * The persistence interface for the phonebook address service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.phonebook.service.persistence.impl.PhonebookAddressPersistenceImpl
 * @see PhonebookAddressUtil
 * @generated
 */
@ProviderType
public interface PhonebookAddressPersistence extends BasePersistence<PhonebookAddress> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhonebookAddressUtil} to access the phonebook address persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the phonebook addresses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching phonebook addresses
	*/
	public java.util.List<PhonebookAddress> findByUuid(String uuid);

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
	public java.util.List<PhonebookAddress> findByUuid(String uuid, int start,
		int end);

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
	public java.util.List<PhonebookAddress> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator);

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
	public java.util.List<PhonebookAddress> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first phonebook address in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phonebook address
	* @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	*/
	public PhonebookAddress findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException;

	/**
	* Returns the first phonebook address in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public PhonebookAddress fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator);

	/**
	* Returns the last phonebook address in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phonebook address
	* @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	*/
	public PhonebookAddress findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException;

	/**
	* Returns the last phonebook address in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public PhonebookAddress fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator);

	/**
	* Returns the phonebook addresses before and after the current phonebook address in the ordered set where uuid = &#63;.
	*
	* @param addressId the primary key of the current phonebook address
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next phonebook address
	* @throws NoSuchPhonebookAddressException if a phonebook address with the primary key could not be found
	*/
	public PhonebookAddress[] findByUuid_PrevAndNext(long addressId,
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException;

	/**
	* Removes all the phonebook addresses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of phonebook addresses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching phonebook addresses
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the phonebook address where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchPhonebookAddressException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching phonebook address
	* @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	*/
	public PhonebookAddress findByUUID_G(String uuid, long groupId)
		throws NoSuchPhonebookAddressException;

	/**
	* Returns the phonebook address where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public PhonebookAddress fetchByUUID_G(String uuid, long groupId);

	/**
	* Returns the phonebook address where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public PhonebookAddress fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the phonebook address where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the phonebook address that was removed
	*/
	public PhonebookAddress removeByUUID_G(String uuid, long groupId)
		throws NoSuchPhonebookAddressException;

	/**
	* Returns the number of phonebook addresses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching phonebook addresses
	*/
	public int countByUUID_G(String uuid, long groupId);

	/**
	* Returns all the phonebook addresses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching phonebook addresses
	*/
	public java.util.List<PhonebookAddress> findByUuid_C(String uuid,
		long companyId);

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
	public java.util.List<PhonebookAddress> findByUuid_C(String uuid,
		long companyId, int start, int end);

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
	public java.util.List<PhonebookAddress> findByUuid_C(String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator);

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
	public java.util.List<PhonebookAddress> findByUuid_C(String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first phonebook address in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phonebook address
	* @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	*/
	public PhonebookAddress findByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException;

	/**
	* Returns the first phonebook address in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public PhonebookAddress fetchByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator);

	/**
	* Returns the last phonebook address in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phonebook address
	* @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	*/
	public PhonebookAddress findByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException;

	/**
	* Returns the last phonebook address in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public PhonebookAddress fetchByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator);

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
	public PhonebookAddress[] findByUuid_C_PrevAndNext(long addressId,
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException;

	/**
	* Removes all the phonebook addresses where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(String uuid, long companyId);

	/**
	* Returns the number of phonebook addresses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching phonebook addresses
	*/
	public int countByUuid_C(String uuid, long companyId);

	/**
	* Returns all the phonebook addresses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching phonebook addresses
	*/
	public java.util.List<PhonebookAddress> findByGroup(long groupId);

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
	public java.util.List<PhonebookAddress> findByGroup(long groupId,
		int start, int end);

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
	public java.util.List<PhonebookAddress> findByGroup(long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator);

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
	public java.util.List<PhonebookAddress> findByGroup(long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first phonebook address in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phonebook address
	* @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	*/
	public PhonebookAddress findByGroup_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException;

	/**
	* Returns the first phonebook address in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public PhonebookAddress fetchByGroup_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator);

	/**
	* Returns the last phonebook address in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phonebook address
	* @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	*/
	public PhonebookAddress findByGroup_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException;

	/**
	* Returns the last phonebook address in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public PhonebookAddress fetchByGroup_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator);

	/**
	* Returns the phonebook addresses before and after the current phonebook address in the ordered set where groupId = &#63;.
	*
	* @param addressId the primary key of the current phonebook address
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next phonebook address
	* @throws NoSuchPhonebookAddressException if a phonebook address with the primary key could not be found
	*/
	public PhonebookAddress[] findByGroup_PrevAndNext(long addressId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException;

	/**
	* Removes all the phonebook addresses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroup(long groupId);

	/**
	* Returns the number of phonebook addresses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching phonebook addresses
	*/
	public int countByGroup(long groupId);

	/**
	* Returns all the phonebook addresses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching phonebook addresses
	*/
	public java.util.List<PhonebookAddress> findByUser(long userId);

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
	public java.util.List<PhonebookAddress> findByUser(long userId, int start,
		int end);

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
	public java.util.List<PhonebookAddress> findByUser(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator);

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
	public java.util.List<PhonebookAddress> findByUser(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first phonebook address in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phonebook address
	* @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	*/
	public PhonebookAddress findByUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException;

	/**
	* Returns the first phonebook address in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public PhonebookAddress fetchByUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator);

	/**
	* Returns the last phonebook address in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phonebook address
	* @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	*/
	public PhonebookAddress findByUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException;

	/**
	* Returns the last phonebook address in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public PhonebookAddress fetchByUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator);

	/**
	* Returns the phonebook addresses before and after the current phonebook address in the ordered set where userId = &#63;.
	*
	* @param addressId the primary key of the current phonebook address
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next phonebook address
	* @throws NoSuchPhonebookAddressException if a phonebook address with the primary key could not be found
	*/
	public PhonebookAddress[] findByUser_PrevAndNext(long addressId,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException;

	/**
	* Removes all the phonebook addresses where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public void removeByUser(long userId);

	/**
	* Returns the number of phonebook addresses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching phonebook addresses
	*/
	public int countByUser(long userId);

	/**
	* Returns all the phonebook addresses where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching phonebook addresses
	*/
	public java.util.List<PhonebookAddress> findByGroupAndUser(long userId,
		long groupId);

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
	public java.util.List<PhonebookAddress> findByGroupAndUser(long userId,
		long groupId, int start, int end);

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
	public java.util.List<PhonebookAddress> findByGroupAndUser(long userId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator);

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
	public java.util.List<PhonebookAddress> findByGroupAndUser(long userId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first phonebook address in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phonebook address
	* @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	*/
	public PhonebookAddress findByGroupAndUser_First(long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException;

	/**
	* Returns the first phonebook address in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public PhonebookAddress fetchByGroupAndUser_First(long userId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator);

	/**
	* Returns the last phonebook address in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phonebook address
	* @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	*/
	public PhonebookAddress findByGroupAndUser_Last(long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException;

	/**
	* Returns the last phonebook address in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	*/
	public PhonebookAddress fetchByGroupAndUser_Last(long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator);

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
	public PhonebookAddress[] findByGroupAndUser_PrevAndNext(long addressId,
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException;

	/**
	* Removes all the phonebook addresses where userId = &#63; and groupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	*/
	public void removeByGroupAndUser(long userId, long groupId);

	/**
	* Returns the number of phonebook addresses where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching phonebook addresses
	*/
	public int countByGroupAndUser(long userId, long groupId);

	/**
	* Caches the phonebook address in the entity cache if it is enabled.
	*
	* @param phonebookAddress the phonebook address
	*/
	public void cacheResult(PhonebookAddress phonebookAddress);

	/**
	* Caches the phonebook addresses in the entity cache if it is enabled.
	*
	* @param phonebookAddresses the phonebook addresses
	*/
	public void cacheResult(java.util.List<PhonebookAddress> phonebookAddresses);

	/**
	* Creates a new phonebook address with the primary key. Does not add the phonebook address to the database.
	*
	* @param addressId the primary key for the new phonebook address
	* @return the new phonebook address
	*/
	public PhonebookAddress create(long addressId);

	/**
	* Removes the phonebook address with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressId the primary key of the phonebook address
	* @return the phonebook address that was removed
	* @throws NoSuchPhonebookAddressException if a phonebook address with the primary key could not be found
	*/
	public PhonebookAddress remove(long addressId)
		throws NoSuchPhonebookAddressException;

	public PhonebookAddress updateImpl(PhonebookAddress phonebookAddress);

	/**
	* Returns the phonebook address with the primary key or throws a {@link NoSuchPhonebookAddressException} if it could not be found.
	*
	* @param addressId the primary key of the phonebook address
	* @return the phonebook address
	* @throws NoSuchPhonebookAddressException if a phonebook address with the primary key could not be found
	*/
	public PhonebookAddress findByPrimaryKey(long addressId)
		throws NoSuchPhonebookAddressException;

	/**
	* Returns the phonebook address with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param addressId the primary key of the phonebook address
	* @return the phonebook address, or <code>null</code> if a phonebook address with the primary key could not be found
	*/
	public PhonebookAddress fetchByPrimaryKey(long addressId);

	@Override
	public java.util.Map<java.io.Serializable, PhonebookAddress> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the phonebook addresses.
	*
	* @return the phonebook addresses
	*/
	public java.util.List<PhonebookAddress> findAll();

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
	public java.util.List<PhonebookAddress> findAll(int start, int end);

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
	public java.util.List<PhonebookAddress> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator);

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
	public java.util.List<PhonebookAddress> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhonebookAddress> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the phonebook addresses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of phonebook addresses.
	*
	* @return the number of phonebook addresses
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}