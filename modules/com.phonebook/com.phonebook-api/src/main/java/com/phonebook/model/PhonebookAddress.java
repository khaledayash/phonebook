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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the PhonebookAddress service. Represents a row in the &quot;PHONEBOOK_PhonebookAddress&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PhonebookAddressModel
 * @see com.phonebook.model.impl.PhonebookAddressImpl
 * @see com.phonebook.model.impl.PhonebookAddressModelImpl
 * @generated
 */
@ImplementationClassName("com.phonebook.model.impl.PhonebookAddressImpl")
@ProviderType
public interface PhonebookAddress extends PhonebookAddressModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.phonebook.model.impl.PhonebookAddressImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PhonebookAddress, Long> ADDRESS_ID_ACCESSOR = new Accessor<PhonebookAddress, Long>() {
			@Override
			public Long get(PhonebookAddress phonebookAddress) {
				return phonebookAddress.getAddressId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<PhonebookAddress> getTypeClass() {
				return PhonebookAddress.class;
			}
		};
}