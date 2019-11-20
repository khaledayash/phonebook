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

package com.phonebook.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.phonebook.model.PhonebookAddress;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PhonebookAddress in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see PhonebookAddress
 * @generated
 */
@ProviderType
public class PhonebookAddressCacheModel implements CacheModel<PhonebookAddress>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PhonebookAddressCacheModel)) {
			return false;
		}

		PhonebookAddressCacheModel phonebookAddressCacheModel = (PhonebookAddressCacheModel)obj;

		if (addressId == phonebookAddressCacheModel.addressId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, addressId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", addressId=");
		sb.append(addressId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", email=");
		sb.append(email);
		sb.append(", mobileNr=");
		sb.append(mobileNr);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PhonebookAddress toEntityModel() {
		PhonebookAddressImpl phonebookAddressImpl = new PhonebookAddressImpl();

		if (uuid == null) {
			phonebookAddressImpl.setUuid("");
		}
		else {
			phonebookAddressImpl.setUuid(uuid);
		}

		phonebookAddressImpl.setAddressId(addressId);
		phonebookAddressImpl.setGroupId(groupId);
		phonebookAddressImpl.setCompanyId(companyId);
		phonebookAddressImpl.setUserId(userId);

		if (userName == null) {
			phonebookAddressImpl.setUserName("");
		}
		else {
			phonebookAddressImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			phonebookAddressImpl.setCreateDate(null);
		}
		else {
			phonebookAddressImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			phonebookAddressImpl.setModifiedDate(null);
		}
		else {
			phonebookAddressImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (firstName == null) {
			phonebookAddressImpl.setFirstName("");
		}
		else {
			phonebookAddressImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			phonebookAddressImpl.setLastName("");
		}
		else {
			phonebookAddressImpl.setLastName(lastName);
		}

		if (email == null) {
			phonebookAddressImpl.setEmail("");
		}
		else {
			phonebookAddressImpl.setEmail(email);
		}

		if (mobileNr == null) {
			phonebookAddressImpl.setMobileNr("");
		}
		else {
			phonebookAddressImpl.setMobileNr(mobileNr);
		}

		phonebookAddressImpl.resetOriginalValues();

		return phonebookAddressImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		addressId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		email = objectInput.readUTF();
		mobileNr = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(addressId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (mobileNr == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobileNr);
		}
	}

	public String uuid;
	public long addressId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String firstName;
	public String lastName;
	public String email;
	public String mobileNr;
}