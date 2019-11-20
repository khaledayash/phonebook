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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.phonebook.service.http.PhonebookAddressServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.phonebook.service.http.PhonebookAddressServiceSoap
 * @generated
 */
@ProviderType
public class PhonebookAddressSoap implements Serializable {
	public static PhonebookAddressSoap toSoapModel(PhonebookAddress model) {
		PhonebookAddressSoap soapModel = new PhonebookAddressSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAddressId(model.getAddressId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setEmail(model.getEmail());
		soapModel.setMobileNr(model.getMobileNr());

		return soapModel;
	}

	public static PhonebookAddressSoap[] toSoapModels(PhonebookAddress[] models) {
		PhonebookAddressSoap[] soapModels = new PhonebookAddressSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PhonebookAddressSoap[][] toSoapModels(
		PhonebookAddress[][] models) {
		PhonebookAddressSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PhonebookAddressSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PhonebookAddressSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PhonebookAddressSoap[] toSoapModels(
		List<PhonebookAddress> models) {
		List<PhonebookAddressSoap> soapModels = new ArrayList<PhonebookAddressSoap>(models.size());

		for (PhonebookAddress model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PhonebookAddressSoap[soapModels.size()]);
	}

	public PhonebookAddressSoap() {
	}

	public long getPrimaryKey() {
		return _addressId;
	}

	public void setPrimaryKey(long pk) {
		setAddressId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAddressId() {
		return _addressId;
	}

	public void setAddressId(long addressId) {
		_addressId = addressId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getMobileNr() {
		return _mobileNr;
	}

	public void setMobileNr(String mobileNr) {
		_mobileNr = mobileNr;
	}

	private String _uuid;
	private long _addressId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _firstName;
	private String _lastName;
	private String _email;
	private String _mobileNr;
}