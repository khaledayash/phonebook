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

package com.phonebook.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link PhonebookAddress}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhonebookAddress
 * @generated
 */
@ProviderType
public class PhonebookAddressWrapper implements PhonebookAddress,
	ModelWrapper<PhonebookAddress> {
	public PhonebookAddressWrapper(PhonebookAddress phonebookAddress) {
		_phonebookAddress = phonebookAddress;
	}

	@Override
	public Class<?> getModelClass() {
		return PhonebookAddress.class;
	}

	@Override
	public String getModelClassName() {
		return PhonebookAddress.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("addressId", getAddressId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("email", getEmail());
		attributes.put("mobileNr", getMobileNr());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String mobileNr = (String)attributes.get("mobileNr");

		if (mobileNr != null) {
			setMobileNr(mobileNr);
		}
	}

	@Override
	public Object clone() {
		return new PhonebookAddressWrapper((PhonebookAddress)_phonebookAddress.clone());
	}

	@Override
	public int compareTo(PhonebookAddress phonebookAddress) {
		return _phonebookAddress.compareTo(phonebookAddress);
	}

	/**
	* Returns the address ID of this phonebook address.
	*
	* @return the address ID of this phonebook address
	*/
	@Override
	public long getAddressId() {
		return _phonebookAddress.getAddressId();
	}

	/**
	* Returns the company ID of this phonebook address.
	*
	* @return the company ID of this phonebook address
	*/
	@Override
	public long getCompanyId() {
		return _phonebookAddress.getCompanyId();
	}

	/**
	* Returns the create date of this phonebook address.
	*
	* @return the create date of this phonebook address
	*/
	@Override
	public Date getCreateDate() {
		return _phonebookAddress.getCreateDate();
	}

	/**
	* Returns the email of this phonebook address.
	*
	* @return the email of this phonebook address
	*/
	@Override
	public String getEmail() {
		return _phonebookAddress.getEmail();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _phonebookAddress.getExpandoBridge();
	}

	/**
	* Returns the first name of this phonebook address.
	*
	* @return the first name of this phonebook address
	*/
	@Override
	public String getFirstName() {
		return _phonebookAddress.getFirstName();
	}

	/**
	* Returns the group ID of this phonebook address.
	*
	* @return the group ID of this phonebook address
	*/
	@Override
	public long getGroupId() {
		return _phonebookAddress.getGroupId();
	}

	/**
	* Returns the last name of this phonebook address.
	*
	* @return the last name of this phonebook address
	*/
	@Override
	public String getLastName() {
		return _phonebookAddress.getLastName();
	}

	/**
	* Returns the mobile nr of this phonebook address.
	*
	* @return the mobile nr of this phonebook address
	*/
	@Override
	public String getMobileNr() {
		return _phonebookAddress.getMobileNr();
	}

	/**
	* Returns the modified date of this phonebook address.
	*
	* @return the modified date of this phonebook address
	*/
	@Override
	public Date getModifiedDate() {
		return _phonebookAddress.getModifiedDate();
	}

	/**
	* Returns the primary key of this phonebook address.
	*
	* @return the primary key of this phonebook address
	*/
	@Override
	public long getPrimaryKey() {
		return _phonebookAddress.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _phonebookAddress.getPrimaryKeyObj();
	}

	/**
	* Returns the user ID of this phonebook address.
	*
	* @return the user ID of this phonebook address
	*/
	@Override
	public long getUserId() {
		return _phonebookAddress.getUserId();
	}

	/**
	* Returns the user name of this phonebook address.
	*
	* @return the user name of this phonebook address
	*/
	@Override
	public String getUserName() {
		return _phonebookAddress.getUserName();
	}

	/**
	* Returns the user uuid of this phonebook address.
	*
	* @return the user uuid of this phonebook address
	*/
	@Override
	public String getUserUuid() {
		return _phonebookAddress.getUserUuid();
	}

	/**
	* Returns the uuid of this phonebook address.
	*
	* @return the uuid of this phonebook address
	*/
	@Override
	public String getUuid() {
		return _phonebookAddress.getUuid();
	}

	@Override
	public int hashCode() {
		return _phonebookAddress.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _phonebookAddress.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _phonebookAddress.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _phonebookAddress.isNew();
	}

	@Override
	public void persist() {
		_phonebookAddress.persist();
	}

	/**
	* Sets the address ID of this phonebook address.
	*
	* @param addressId the address ID of this phonebook address
	*/
	@Override
	public void setAddressId(long addressId) {
		_phonebookAddress.setAddressId(addressId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_phonebookAddress.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this phonebook address.
	*
	* @param companyId the company ID of this phonebook address
	*/
	@Override
	public void setCompanyId(long companyId) {
		_phonebookAddress.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this phonebook address.
	*
	* @param createDate the create date of this phonebook address
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_phonebookAddress.setCreateDate(createDate);
	}

	/**
	* Sets the email of this phonebook address.
	*
	* @param email the email of this phonebook address
	*/
	@Override
	public void setEmail(String email) {
		_phonebookAddress.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_phonebookAddress.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_phonebookAddress.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_phonebookAddress.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the first name of this phonebook address.
	*
	* @param firstName the first name of this phonebook address
	*/
	@Override
	public void setFirstName(String firstName) {
		_phonebookAddress.setFirstName(firstName);
	}

	/**
	* Sets the group ID of this phonebook address.
	*
	* @param groupId the group ID of this phonebook address
	*/
	@Override
	public void setGroupId(long groupId) {
		_phonebookAddress.setGroupId(groupId);
	}

	/**
	* Sets the last name of this phonebook address.
	*
	* @param lastName the last name of this phonebook address
	*/
	@Override
	public void setLastName(String lastName) {
		_phonebookAddress.setLastName(lastName);
	}

	/**
	* Sets the mobile nr of this phonebook address.
	*
	* @param mobileNr the mobile nr of this phonebook address
	*/
	@Override
	public void setMobileNr(String mobileNr) {
		_phonebookAddress.setMobileNr(mobileNr);
	}

	/**
	* Sets the modified date of this phonebook address.
	*
	* @param modifiedDate the modified date of this phonebook address
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_phonebookAddress.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_phonebookAddress.setNew(n);
	}

	/**
	* Sets the primary key of this phonebook address.
	*
	* @param primaryKey the primary key of this phonebook address
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_phonebookAddress.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_phonebookAddress.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this phonebook address.
	*
	* @param userId the user ID of this phonebook address
	*/
	@Override
	public void setUserId(long userId) {
		_phonebookAddress.setUserId(userId);
	}

	/**
	* Sets the user name of this phonebook address.
	*
	* @param userName the user name of this phonebook address
	*/
	@Override
	public void setUserName(String userName) {
		_phonebookAddress.setUserName(userName);
	}

	/**
	* Sets the user uuid of this phonebook address.
	*
	* @param userUuid the user uuid of this phonebook address
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_phonebookAddress.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this phonebook address.
	*
	* @param uuid the uuid of this phonebook address
	*/
	@Override
	public void setUuid(String uuid) {
		_phonebookAddress.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<PhonebookAddress> toCacheModel() {
		return _phonebookAddress.toCacheModel();
	}

	@Override
	public PhonebookAddress toEscapedModel() {
		return new PhonebookAddressWrapper(_phonebookAddress.toEscapedModel());
	}

	@Override
	public String toString() {
		return _phonebookAddress.toString();
	}

	@Override
	public PhonebookAddress toUnescapedModel() {
		return new PhonebookAddressWrapper(_phonebookAddress.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _phonebookAddress.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PhonebookAddressWrapper)) {
			return false;
		}

		PhonebookAddressWrapper phonebookAddressWrapper = (PhonebookAddressWrapper)obj;

		if (Objects.equals(_phonebookAddress,
					phonebookAddressWrapper._phonebookAddress)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _phonebookAddress.getStagedModelType();
	}

	@Override
	public PhonebookAddress getWrappedModel() {
		return _phonebookAddress;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _phonebookAddress.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _phonebookAddress.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_phonebookAddress.resetOriginalValues();
	}

	private final PhonebookAddress _phonebookAddress;
}