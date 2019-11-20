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

package com.phonebook.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.phonebook.model.PhonebookAddress;
import com.phonebook.service.base.PhonebookAddressLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the phonebook address local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.phonebook.service.PhonebookAddressLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhonebookAddressLocalServiceBaseImpl
 * @see com.phonebook.service.PhonebookAddressLocalServiceUtil
 */
public class PhonebookAddressLocalServiceImpl
	extends PhonebookAddressLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.phonebook.service.PhonebookAddressLocalServiceUtil} to access the phonebook address local service.
	 */
	private static final Log LOGGER = LogFactoryUtil.getLog(PhonebookAddressLocalServiceImpl.class);

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
	public PhonebookAddress savePhonebookAddress(long id, long userId, String username, long groupId, long companyId, Date createdDate, Date modifiedDate,
												 String firstName, String lastName, String emailAddress, String mobileNr){

		if (Validator.isNull(userId)) {
			LOGGER.warn("The provided userId doesn't belong to any user at the system. Null will be returned");
			return null;
		}
		if (Validator.isNull(lastName) || Validator.isBlank(lastName)){
			LOGGER.warn("the provided lastname of this PhonebookAddress can not be empty. Null will be returned");
			return null;
		}
		if (Validator.isNull(emailAddress) || Validator.isBlank(emailAddress)){
			LOGGER.warn("the provided Email address of this PhonebookAddress can not be empty. Null will be returned");
			return null;
		}
		if (Validator.isNull(mobileNr) || Validator.isBlank(mobileNr)){
			LOGGER.warn("the provided Mobile Number of this PhonebookAddress can not be empty. Null will be returned");
			return null;
		}
		PhonebookAddress phonebookAddress = null;
		boolean addressbookIsNotNew = id > 0;
		try {
			if (addressbookIsNotNew){
				phonebookAddress = this.getPhonebookAddress(id);
			}else{
				long newId = this.counterLocalService.increment(PhonebookAddress.class.getName());
				phonebookAddress = this.phonebookAddressPersistence.create(newId);
				phonebookAddress.setUserId(userId);
				phonebookAddress.setUserName(username);
				phonebookAddress.setGroupId(groupId);
				phonebookAddress.setCompanyId(companyId);
				phonebookAddress.setCreateDate(createdDate);
				phonebookAddress.setModifiedDate(modifiedDate);
				phonebookAddress.setFirstName(firstName);
				phonebookAddress.setLastName(lastName);
				phonebookAddress.setEmail(emailAddress);
				phonebookAddress.setMobileNr(mobileNr);
				phonebookAddress = this.phonebookAddressPersistence.update(phonebookAddress);
			}
		} catch (PortalException  | NullPointerException e ){
			LOGGER.warn(e);
		}
		return phonebookAddress;
	}

	/**
	 * @param userId
	 * @param start
	 * @param end
	 * @return List<PhonebookAddress>
	 */
	public List<PhonebookAddress> getAllPhonebookAddressesbyUserId(long userId, int start, int end){
		if (Validator.isNull(userId)){
			LOGGER.warn("The provided User is not exist. Null will be returned");
			return null;
		}
		List<PhonebookAddress> phonebookAddressList = new ArrayList<>();
		phonebookAddressList = this.phonebookAddressPersistence.findByUser(userId, start, end);
		if (Validator.isNull(phonebookAddressList)){
			LOGGER.warn("for this user there isn't any saved PhonebookAddress. Null will be returned");
			return null;
		}else return phonebookAddressList;
	}
}
