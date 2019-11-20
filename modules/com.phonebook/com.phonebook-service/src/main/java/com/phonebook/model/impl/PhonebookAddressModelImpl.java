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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.phonebook.model.PhonebookAddress;
import com.phonebook.model.PhonebookAddressModel;
import com.phonebook.model.PhonebookAddressSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the PhonebookAddress service. Represents a row in the &quot;PHONEBOOK_PhonebookAddress&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link PhonebookAddressModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PhonebookAddressImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhonebookAddressImpl
 * @see PhonebookAddress
 * @see PhonebookAddressModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class PhonebookAddressModelImpl extends BaseModelImpl<PhonebookAddress>
	implements PhonebookAddressModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a phonebook address model instance should use the {@link PhonebookAddress} interface instead.
	 */
	public static final String TABLE_NAME = "PHONEBOOK_PhonebookAddress";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "addressId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "firstName", Types.VARCHAR },
			{ "lastName", Types.VARCHAR },
			{ "email", Types.VARCHAR },
			{ "mobileNr", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("addressId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("firstName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mobileNr", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table PHONEBOOK_PhonebookAddress (uuid_ VARCHAR(75) null,addressId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,firstName VARCHAR(75) null,lastName VARCHAR(75) null,email VARCHAR(75) null,mobileNr VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table PHONEBOOK_PhonebookAddress";
	public static final String ORDER_BY_JPQL = " ORDER BY phonebookAddress.email DESC";
	public static final String ORDER_BY_SQL = " ORDER BY PHONEBOOK_PhonebookAddress.email DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.phonebook.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.phonebook.model.PhonebookAddress"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.phonebook.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.phonebook.model.PhonebookAddress"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.phonebook.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.phonebook.model.PhonebookAddress"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long USERID_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;
	public static final long EMAIL_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static PhonebookAddress toModel(PhonebookAddressSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		PhonebookAddress model = new PhonebookAddressImpl();

		model.setUuid(soapModel.getUuid());
		model.setAddressId(soapModel.getAddressId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setFirstName(soapModel.getFirstName());
		model.setLastName(soapModel.getLastName());
		model.setEmail(soapModel.getEmail());
		model.setMobileNr(soapModel.getMobileNr());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<PhonebookAddress> toModels(
		PhonebookAddressSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<PhonebookAddress> models = new ArrayList<PhonebookAddress>(soapModels.length);

		for (PhonebookAddressSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.phonebook.service.util.ServiceProps.get(
				"lock.expiration.time.com.phonebook.model.PhonebookAddress"));

	public PhonebookAddressModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _addressId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAddressId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _addressId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getAddressId() {
		return _addressId;
	}

	@Override
	public void setAddressId(long addressId) {
		_addressId = addressId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getFirstName() {
		if (_firstName == null) {
			return "";
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	@JSON
	@Override
	public String getLastName() {
		if (_lastName == null) {
			return "";
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_columnBitmask = -1L;

		_email = email;
	}

	@JSON
	@Override
	public String getMobileNr() {
		if (_mobileNr == null) {
			return "";
		}
		else {
			return _mobileNr;
		}
	}

	@Override
	public void setMobileNr(String mobileNr) {
		_mobileNr = mobileNr;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				PhonebookAddress.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			PhonebookAddress.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PhonebookAddress toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (PhonebookAddress)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PhonebookAddressImpl phonebookAddressImpl = new PhonebookAddressImpl();

		phonebookAddressImpl.setUuid(getUuid());
		phonebookAddressImpl.setAddressId(getAddressId());
		phonebookAddressImpl.setGroupId(getGroupId());
		phonebookAddressImpl.setCompanyId(getCompanyId());
		phonebookAddressImpl.setUserId(getUserId());
		phonebookAddressImpl.setUserName(getUserName());
		phonebookAddressImpl.setCreateDate(getCreateDate());
		phonebookAddressImpl.setModifiedDate(getModifiedDate());
		phonebookAddressImpl.setFirstName(getFirstName());
		phonebookAddressImpl.setLastName(getLastName());
		phonebookAddressImpl.setEmail(getEmail());
		phonebookAddressImpl.setMobileNr(getMobileNr());

		phonebookAddressImpl.resetOriginalValues();

		return phonebookAddressImpl;
	}

	@Override
	public int compareTo(PhonebookAddress phonebookAddress) {
		int value = 0;

		value = getEmail().compareTo(phonebookAddress.getEmail());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PhonebookAddress)) {
			return false;
		}

		PhonebookAddress phonebookAddress = (PhonebookAddress)obj;

		long primaryKey = phonebookAddress.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		PhonebookAddressModelImpl phonebookAddressModelImpl = this;

		phonebookAddressModelImpl._originalUuid = phonebookAddressModelImpl._uuid;

		phonebookAddressModelImpl._originalGroupId = phonebookAddressModelImpl._groupId;

		phonebookAddressModelImpl._setOriginalGroupId = false;

		phonebookAddressModelImpl._originalCompanyId = phonebookAddressModelImpl._companyId;

		phonebookAddressModelImpl._setOriginalCompanyId = false;

		phonebookAddressModelImpl._originalUserId = phonebookAddressModelImpl._userId;

		phonebookAddressModelImpl._setOriginalUserId = false;

		phonebookAddressModelImpl._setModifiedDate = false;

		phonebookAddressModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<PhonebookAddress> toCacheModel() {
		PhonebookAddressCacheModel phonebookAddressCacheModel = new PhonebookAddressCacheModel();

		phonebookAddressCacheModel.uuid = getUuid();

		String uuid = phonebookAddressCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			phonebookAddressCacheModel.uuid = null;
		}

		phonebookAddressCacheModel.addressId = getAddressId();

		phonebookAddressCacheModel.groupId = getGroupId();

		phonebookAddressCacheModel.companyId = getCompanyId();

		phonebookAddressCacheModel.userId = getUserId();

		phonebookAddressCacheModel.userName = getUserName();

		String userName = phonebookAddressCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			phonebookAddressCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			phonebookAddressCacheModel.createDate = createDate.getTime();
		}
		else {
			phonebookAddressCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			phonebookAddressCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			phonebookAddressCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		phonebookAddressCacheModel.firstName = getFirstName();

		String firstName = phonebookAddressCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			phonebookAddressCacheModel.firstName = null;
		}

		phonebookAddressCacheModel.lastName = getLastName();

		String lastName = phonebookAddressCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			phonebookAddressCacheModel.lastName = null;
		}

		phonebookAddressCacheModel.email = getEmail();

		String email = phonebookAddressCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			phonebookAddressCacheModel.email = null;
		}

		phonebookAddressCacheModel.mobileNr = getMobileNr();

		String mobileNr = phonebookAddressCacheModel.mobileNr;

		if ((mobileNr != null) && (mobileNr.length() == 0)) {
			phonebookAddressCacheModel.mobileNr = null;
		}

		return phonebookAddressCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", addressId=");
		sb.append(getAddressId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", mobileNr=");
		sb.append(getMobileNr());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.phonebook.model.PhonebookAddress");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addressId</column-name><column-value><![CDATA[");
		sb.append(getAddressId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mobileNr</column-name><column-value><![CDATA[");
		sb.append(getMobileNr());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = PhonebookAddress.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			PhonebookAddress.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _addressId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _firstName;
	private String _lastName;
	private String _email;
	private String _mobileNr;
	private long _columnBitmask;
	private PhonebookAddress _escapedModel;
}