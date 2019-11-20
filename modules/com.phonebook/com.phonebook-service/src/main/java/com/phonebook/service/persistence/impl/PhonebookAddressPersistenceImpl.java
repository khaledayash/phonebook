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

package com.phonebook.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.phonebook.exception.NoSuchPhonebookAddressException;

import com.phonebook.model.PhonebookAddress;
import com.phonebook.model.impl.PhonebookAddressImpl;
import com.phonebook.model.impl.PhonebookAddressModelImpl;

import com.phonebook.service.persistence.PhonebookAddressPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the phonebook address service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhonebookAddressPersistence
 * @see com.phonebook.service.persistence.PhonebookAddressUtil
 * @generated
 */
@ProviderType
public class PhonebookAddressPersistenceImpl extends BasePersistenceImpl<PhonebookAddress>
	implements PhonebookAddressPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PhonebookAddressUtil} to access the phonebook address persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PhonebookAddressImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressModelImpl.FINDER_CACHE_ENABLED,
			PhonebookAddressImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressModelImpl.FINDER_CACHE_ENABLED,
			PhonebookAddressImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressModelImpl.FINDER_CACHE_ENABLED,
			PhonebookAddressImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressModelImpl.FINDER_CACHE_ENABLED,
			PhonebookAddressImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			PhonebookAddressModelImpl.UUID_COLUMN_BITMASK |
			PhonebookAddressModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the phonebook addresses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching phonebook addresses
	 */
	@Override
	public List<PhonebookAddress> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PhonebookAddress> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<PhonebookAddress> findByUuid(String uuid, int start, int end,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<PhonebookAddress> findByUuid(String uuid, int start, int end,
		OrderByComparator<PhonebookAddress> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<PhonebookAddress> list = null;

		if (retrieveFromCache) {
			list = (List<PhonebookAddress>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PhonebookAddress phonebookAddress : list) {
					if (!Objects.equals(uuid, phonebookAddress.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PHONEBOOKADDRESS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PhonebookAddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<PhonebookAddress>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PhonebookAddress>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first phonebook address in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phonebook address
	 * @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	 */
	@Override
	public PhonebookAddress findByUuid_First(String uuid,
		OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException {
		PhonebookAddress phonebookAddress = fetchByUuid_First(uuid,
				orderByComparator);

		if (phonebookAddress != null) {
			return phonebookAddress;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchPhonebookAddressException(msg.toString());
	}

	/**
	 * Returns the first phonebook address in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	 */
	@Override
	public PhonebookAddress fetchByUuid_First(String uuid,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		List<PhonebookAddress> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phonebook address in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phonebook address
	 * @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	 */
	@Override
	public PhonebookAddress findByUuid_Last(String uuid,
		OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException {
		PhonebookAddress phonebookAddress = fetchByUuid_Last(uuid,
				orderByComparator);

		if (phonebookAddress != null) {
			return phonebookAddress;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchPhonebookAddressException(msg.toString());
	}

	/**
	 * Returns the last phonebook address in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	 */
	@Override
	public PhonebookAddress fetchByUuid_Last(String uuid,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PhonebookAddress> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PhonebookAddress[] findByUuid_PrevAndNext(long addressId,
		String uuid, OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException {
		PhonebookAddress phonebookAddress = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			PhonebookAddress[] array = new PhonebookAddressImpl[3];

			array[0] = getByUuid_PrevAndNext(session, phonebookAddress, uuid,
					orderByComparator, true);

			array[1] = phonebookAddress;

			array[2] = getByUuid_PrevAndNext(session, phonebookAddress, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PhonebookAddress getByUuid_PrevAndNext(Session session,
		PhonebookAddress phonebookAddress, String uuid,
		OrderByComparator<PhonebookAddress> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PHONEBOOKADDRESS_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals("")) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PhonebookAddressModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(phonebookAddress);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PhonebookAddress> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phonebook addresses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PhonebookAddress phonebookAddress : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(phonebookAddress);
		}
	}

	/**
	 * Returns the number of phonebook addresses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching phonebook addresses
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PHONEBOOKADDRESS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "phonebookAddress.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "phonebookAddress.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(phonebookAddress.uuid IS NULL OR phonebookAddress.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressModelImpl.FINDER_CACHE_ENABLED,
			PhonebookAddressImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			PhonebookAddressModelImpl.UUID_COLUMN_BITMASK |
			PhonebookAddressModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the phonebook address where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchPhonebookAddressException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching phonebook address
	 * @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	 */
	@Override
	public PhonebookAddress findByUUID_G(String uuid, long groupId)
		throws NoSuchPhonebookAddressException {
		PhonebookAddress phonebookAddress = fetchByUUID_G(uuid, groupId);

		if (phonebookAddress == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchPhonebookAddressException(msg.toString());
		}

		return phonebookAddress;
	}

	/**
	 * Returns the phonebook address where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	 */
	@Override
	public PhonebookAddress fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the phonebook address where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	 */
	@Override
	public PhonebookAddress fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof PhonebookAddress) {
			PhonebookAddress phonebookAddress = (PhonebookAddress)result;

			if (!Objects.equals(uuid, phonebookAddress.getUuid()) ||
					(groupId != phonebookAddress.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PHONEBOOKADDRESS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<PhonebookAddress> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					PhonebookAddress phonebookAddress = list.get(0);

					result = phonebookAddress;

					cacheResult(phonebookAddress);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (PhonebookAddress)result;
		}
	}

	/**
	 * Removes the phonebook address where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the phonebook address that was removed
	 */
	@Override
	public PhonebookAddress removeByUUID_G(String uuid, long groupId)
		throws NoSuchPhonebookAddressException {
		PhonebookAddress phonebookAddress = findByUUID_G(uuid, groupId);

		return remove(phonebookAddress);
	}

	/**
	 * Returns the number of phonebook addresses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching phonebook addresses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PHONEBOOKADDRESS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "phonebookAddress.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "phonebookAddress.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(phonebookAddress.uuid IS NULL OR phonebookAddress.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "phonebookAddress.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressModelImpl.FINDER_CACHE_ENABLED,
			PhonebookAddressImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressModelImpl.FINDER_CACHE_ENABLED,
			PhonebookAddressImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			PhonebookAddressModelImpl.UUID_COLUMN_BITMASK |
			PhonebookAddressModelImpl.COMPANYID_COLUMN_BITMASK |
			PhonebookAddressModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the phonebook addresses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching phonebook addresses
	 */
	@Override
	public List<PhonebookAddress> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<PhonebookAddress> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<PhonebookAddress> findByUuid_C(String uuid, long companyId,
		int start, int end,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<PhonebookAddress> findByUuid_C(String uuid, long companyId,
		int start, int end,
		OrderByComparator<PhonebookAddress> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<PhonebookAddress> list = null;

		if (retrieveFromCache) {
			list = (List<PhonebookAddress>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PhonebookAddress phonebookAddress : list) {
					if (!Objects.equals(uuid, phonebookAddress.getUuid()) ||
							(companyId != phonebookAddress.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PHONEBOOKADDRESS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PhonebookAddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<PhonebookAddress>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PhonebookAddress>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public PhonebookAddress findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException {
		PhonebookAddress phonebookAddress = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (phonebookAddress != null) {
			return phonebookAddress;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchPhonebookAddressException(msg.toString());
	}

	/**
	 * Returns the first phonebook address in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	 */
	@Override
	public PhonebookAddress fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		List<PhonebookAddress> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PhonebookAddress findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException {
		PhonebookAddress phonebookAddress = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (phonebookAddress != null) {
			return phonebookAddress;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchPhonebookAddressException(msg.toString());
	}

	/**
	 * Returns the last phonebook address in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	 */
	@Override
	public PhonebookAddress fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PhonebookAddress> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PhonebookAddress[] findByUuid_C_PrevAndNext(long addressId,
		String uuid, long companyId,
		OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException {
		PhonebookAddress phonebookAddress = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			PhonebookAddress[] array = new PhonebookAddressImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, phonebookAddress, uuid,
					companyId, orderByComparator, true);

			array[1] = phonebookAddress;

			array[2] = getByUuid_C_PrevAndNext(session, phonebookAddress, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PhonebookAddress getByUuid_C_PrevAndNext(Session session,
		PhonebookAddress phonebookAddress, String uuid, long companyId,
		OrderByComparator<PhonebookAddress> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PHONEBOOKADDRESS_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals("")) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PhonebookAddressModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(phonebookAddress);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PhonebookAddress> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phonebook addresses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (PhonebookAddress phonebookAddress : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(phonebookAddress);
		}
	}

	/**
	 * Returns the number of phonebook addresses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching phonebook addresses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PHONEBOOKADDRESS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "phonebookAddress.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "phonebookAddress.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(phonebookAddress.uuid IS NULL OR phonebookAddress.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "phonebookAddress.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressModelImpl.FINDER_CACHE_ENABLED,
			PhonebookAddressImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressModelImpl.FINDER_CACHE_ENABLED,
			PhonebookAddressImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			PhonebookAddressModelImpl.GROUPID_COLUMN_BITMASK |
			PhonebookAddressModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the phonebook addresses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching phonebook addresses
	 */
	@Override
	public List<PhonebookAddress> findByGroup(long groupId) {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PhonebookAddress> findByGroup(long groupId, int start, int end) {
		return findByGroup(groupId, start, end, null);
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
	@Override
	public List<PhonebookAddress> findByGroup(long groupId, int start, int end,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		return findByGroup(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<PhonebookAddress> findByGroup(long groupId, int start, int end,
		OrderByComparator<PhonebookAddress> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<PhonebookAddress> list = null;

		if (retrieveFromCache) {
			list = (List<PhonebookAddress>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PhonebookAddress phonebookAddress : list) {
					if ((groupId != phonebookAddress.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PHONEBOOKADDRESS_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PhonebookAddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<PhonebookAddress>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PhonebookAddress>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first phonebook address in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phonebook address
	 * @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	 */
	@Override
	public PhonebookAddress findByGroup_First(long groupId,
		OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException {
		PhonebookAddress phonebookAddress = fetchByGroup_First(groupId,
				orderByComparator);

		if (phonebookAddress != null) {
			return phonebookAddress;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchPhonebookAddressException(msg.toString());
	}

	/**
	 * Returns the first phonebook address in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	 */
	@Override
	public PhonebookAddress fetchByGroup_First(long groupId,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		List<PhonebookAddress> list = findByGroup(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phonebook address in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phonebook address
	 * @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	 */
	@Override
	public PhonebookAddress findByGroup_Last(long groupId,
		OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException {
		PhonebookAddress phonebookAddress = fetchByGroup_Last(groupId,
				orderByComparator);

		if (phonebookAddress != null) {
			return phonebookAddress;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchPhonebookAddressException(msg.toString());
	}

	/**
	 * Returns the last phonebook address in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	 */
	@Override
	public PhonebookAddress fetchByGroup_Last(long groupId,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<PhonebookAddress> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PhonebookAddress[] findByGroup_PrevAndNext(long addressId,
		long groupId, OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException {
		PhonebookAddress phonebookAddress = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			PhonebookAddress[] array = new PhonebookAddressImpl[3];

			array[0] = getByGroup_PrevAndNext(session, phonebookAddress,
					groupId, orderByComparator, true);

			array[1] = phonebookAddress;

			array[2] = getByGroup_PrevAndNext(session, phonebookAddress,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PhonebookAddress getByGroup_PrevAndNext(Session session,
		PhonebookAddress phonebookAddress, long groupId,
		OrderByComparator<PhonebookAddress> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PHONEBOOKADDRESS_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PhonebookAddressModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(phonebookAddress);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PhonebookAddress> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phonebook addresses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroup(long groupId) {
		for (PhonebookAddress phonebookAddress : findByGroup(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(phonebookAddress);
		}
	}

	/**
	 * Returns the number of phonebook addresses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching phonebook addresses
	 */
	@Override
	public int countByGroup(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUP;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PHONEBOOKADDRESS_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "phonebookAddress.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressModelImpl.FINDER_CACHE_ENABLED,
			PhonebookAddressImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressModelImpl.FINDER_CACHE_ENABLED,
			PhonebookAddressImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] { Long.class.getName() },
			PhonebookAddressModelImpl.USERID_COLUMN_BITMASK |
			PhonebookAddressModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the phonebook addresses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching phonebook addresses
	 */
	@Override
	public List<PhonebookAddress> findByUser(long userId) {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PhonebookAddress> findByUser(long userId, int start, int end) {
		return findByUser(userId, start, end, null);
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
	@Override
	public List<PhonebookAddress> findByUser(long userId, int start, int end,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		return findByUser(userId, start, end, orderByComparator, true);
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
	@Override
	public List<PhonebookAddress> findByUser(long userId, int start, int end,
		OrderByComparator<PhonebookAddress> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<PhonebookAddress> list = null;

		if (retrieveFromCache) {
			list = (List<PhonebookAddress>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PhonebookAddress phonebookAddress : list) {
					if ((userId != phonebookAddress.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PHONEBOOKADDRESS_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PhonebookAddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<PhonebookAddress>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PhonebookAddress>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first phonebook address in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phonebook address
	 * @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	 */
	@Override
	public PhonebookAddress findByUser_First(long userId,
		OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException {
		PhonebookAddress phonebookAddress = fetchByUser_First(userId,
				orderByComparator);

		if (phonebookAddress != null) {
			return phonebookAddress;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchPhonebookAddressException(msg.toString());
	}

	/**
	 * Returns the first phonebook address in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	 */
	@Override
	public PhonebookAddress fetchByUser_First(long userId,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		List<PhonebookAddress> list = findByUser(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phonebook address in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phonebook address
	 * @throws NoSuchPhonebookAddressException if a matching phonebook address could not be found
	 */
	@Override
	public PhonebookAddress findByUser_Last(long userId,
		OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException {
		PhonebookAddress phonebookAddress = fetchByUser_Last(userId,
				orderByComparator);

		if (phonebookAddress != null) {
			return phonebookAddress;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchPhonebookAddressException(msg.toString());
	}

	/**
	 * Returns the last phonebook address in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	 */
	@Override
	public PhonebookAddress fetchByUser_Last(long userId,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		int count = countByUser(userId);

		if (count == 0) {
			return null;
		}

		List<PhonebookAddress> list = findByUser(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PhonebookAddress[] findByUser_PrevAndNext(long addressId,
		long userId, OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException {
		PhonebookAddress phonebookAddress = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			PhonebookAddress[] array = new PhonebookAddressImpl[3];

			array[0] = getByUser_PrevAndNext(session, phonebookAddress, userId,
					orderByComparator, true);

			array[1] = phonebookAddress;

			array[2] = getByUser_PrevAndNext(session, phonebookAddress, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PhonebookAddress getByUser_PrevAndNext(Session session,
		PhonebookAddress phonebookAddress, long userId,
		OrderByComparator<PhonebookAddress> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PHONEBOOKADDRESS_WHERE);

		query.append(_FINDER_COLUMN_USER_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PhonebookAddressModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(phonebookAddress);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PhonebookAddress> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phonebook addresses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUser(long userId) {
		for (PhonebookAddress phonebookAddress : findByUser(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(phonebookAddress);
		}
	}

	/**
	 * Returns the number of phonebook addresses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching phonebook addresses
	 */
	@Override
	public int countByUser(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PHONEBOOKADDRESS_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USER_USERID_2 = "phonebookAddress.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDUSER =
		new FinderPath(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressModelImpl.FINDER_CACHE_ENABLED,
			PhonebookAddressImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupAndUser",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDUSER =
		new FinderPath(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressModelImpl.FINDER_CACHE_ENABLED,
			PhonebookAddressImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndUser",
			new String[] { Long.class.getName(), Long.class.getName() },
			PhonebookAddressModelImpl.USERID_COLUMN_BITMASK |
			PhonebookAddressModelImpl.GROUPID_COLUMN_BITMASK |
			PhonebookAddressModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPANDUSER = new FinderPath(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupAndUser",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the phonebook addresses where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching phonebook addresses
	 */
	@Override
	public List<PhonebookAddress> findByGroupAndUser(long userId, long groupId) {
		return findByGroupAndUser(userId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<PhonebookAddress> findByGroupAndUser(long userId, long groupId,
		int start, int end) {
		return findByGroupAndUser(userId, groupId, start, end, null);
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
	@Override
	public List<PhonebookAddress> findByGroupAndUser(long userId, long groupId,
		int start, int end,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		return findByGroupAndUser(userId, groupId, start, end,
			orderByComparator, true);
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
	@Override
	public List<PhonebookAddress> findByGroupAndUser(long userId, long groupId,
		int start, int end,
		OrderByComparator<PhonebookAddress> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDUSER;
			finderArgs = new Object[] { userId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDUSER;
			finderArgs = new Object[] {
					userId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<PhonebookAddress> list = null;

		if (retrieveFromCache) {
			list = (List<PhonebookAddress>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PhonebookAddress phonebookAddress : list) {
					if ((userId != phonebookAddress.getUserId()) ||
							(groupId != phonebookAddress.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PHONEBOOKADDRESS_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDUSER_USERID_2);

			query.append(_FINDER_COLUMN_GROUPANDUSER_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PhonebookAddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<PhonebookAddress>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PhonebookAddress>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public PhonebookAddress findByGroupAndUser_First(long userId, long groupId,
		OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException {
		PhonebookAddress phonebookAddress = fetchByGroupAndUser_First(userId,
				groupId, orderByComparator);

		if (phonebookAddress != null) {
			return phonebookAddress;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchPhonebookAddressException(msg.toString());
	}

	/**
	 * Returns the first phonebook address in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	 */
	@Override
	public PhonebookAddress fetchByGroupAndUser_First(long userId,
		long groupId, OrderByComparator<PhonebookAddress> orderByComparator) {
		List<PhonebookAddress> list = findByGroupAndUser(userId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PhonebookAddress findByGroupAndUser_Last(long userId, long groupId,
		OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException {
		PhonebookAddress phonebookAddress = fetchByGroupAndUser_Last(userId,
				groupId, orderByComparator);

		if (phonebookAddress != null) {
			return phonebookAddress;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchPhonebookAddressException(msg.toString());
	}

	/**
	 * Returns the last phonebook address in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phonebook address, or <code>null</code> if a matching phonebook address could not be found
	 */
	@Override
	public PhonebookAddress fetchByGroupAndUser_Last(long userId, long groupId,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		int count = countByGroupAndUser(userId, groupId);

		if (count == 0) {
			return null;
		}

		List<PhonebookAddress> list = findByGroupAndUser(userId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PhonebookAddress[] findByGroupAndUser_PrevAndNext(long addressId,
		long userId, long groupId,
		OrderByComparator<PhonebookAddress> orderByComparator)
		throws NoSuchPhonebookAddressException {
		PhonebookAddress phonebookAddress = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			PhonebookAddress[] array = new PhonebookAddressImpl[3];

			array[0] = getByGroupAndUser_PrevAndNext(session, phonebookAddress,
					userId, groupId, orderByComparator, true);

			array[1] = phonebookAddress;

			array[2] = getByGroupAndUser_PrevAndNext(session, phonebookAddress,
					userId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PhonebookAddress getByGroupAndUser_PrevAndNext(Session session,
		PhonebookAddress phonebookAddress, long userId, long groupId,
		OrderByComparator<PhonebookAddress> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PHONEBOOKADDRESS_WHERE);

		query.append(_FINDER_COLUMN_GROUPANDUSER_USERID_2);

		query.append(_FINDER_COLUMN_GROUPANDUSER_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PhonebookAddressModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(phonebookAddress);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PhonebookAddress> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phonebook addresses where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupAndUser(long userId, long groupId) {
		for (PhonebookAddress phonebookAddress : findByGroupAndUser(userId,
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(phonebookAddress);
		}
	}

	/**
	 * Returns the number of phonebook addresses where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching phonebook addresses
	 */
	@Override
	public int countByGroupAndUser(long userId, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPANDUSER;

		Object[] finderArgs = new Object[] { userId, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PHONEBOOKADDRESS_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDUSER_USERID_2);

			query.append(_FINDER_COLUMN_GROUPANDUSER_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPANDUSER_USERID_2 = "phonebookAddress.userId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPANDUSER_GROUPID_2 = "phonebookAddress.groupId = ?";

	public PhonebookAddressPersistenceImpl() {
		setModelClass(PhonebookAddress.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the phonebook address in the entity cache if it is enabled.
	 *
	 * @param phonebookAddress the phonebook address
	 */
	@Override
	public void cacheResult(PhonebookAddress phonebookAddress) {
		entityCache.putResult(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressImpl.class, phonebookAddress.getPrimaryKey(),
			phonebookAddress);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				phonebookAddress.getUuid(), phonebookAddress.getGroupId()
			}, phonebookAddress);

		phonebookAddress.resetOriginalValues();
	}

	/**
	 * Caches the phonebook addresses in the entity cache if it is enabled.
	 *
	 * @param phonebookAddresses the phonebook addresses
	 */
	@Override
	public void cacheResult(List<PhonebookAddress> phonebookAddresses) {
		for (PhonebookAddress phonebookAddress : phonebookAddresses) {
			if (entityCache.getResult(
						PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
						PhonebookAddressImpl.class,
						phonebookAddress.getPrimaryKey()) == null) {
				cacheResult(phonebookAddress);
			}
			else {
				phonebookAddress.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all phonebook addresses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PhonebookAddressImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the phonebook address.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PhonebookAddress phonebookAddress) {
		entityCache.removeResult(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressImpl.class, phonebookAddress.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((PhonebookAddressModelImpl)phonebookAddress,
			true);
	}

	@Override
	public void clearCache(List<PhonebookAddress> phonebookAddresses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PhonebookAddress phonebookAddress : phonebookAddresses) {
			entityCache.removeResult(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
				PhonebookAddressImpl.class, phonebookAddress.getPrimaryKey());

			clearUniqueFindersCache((PhonebookAddressModelImpl)phonebookAddress,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		PhonebookAddressModelImpl phonebookAddressModelImpl) {
		Object[] args = new Object[] {
				phonebookAddressModelImpl.getUuid(),
				phonebookAddressModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			phonebookAddressModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		PhonebookAddressModelImpl phonebookAddressModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					phonebookAddressModelImpl.getUuid(),
					phonebookAddressModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((phonebookAddressModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					phonebookAddressModelImpl.getOriginalUuid(),
					phonebookAddressModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new phonebook address with the primary key. Does not add the phonebook address to the database.
	 *
	 * @param addressId the primary key for the new phonebook address
	 * @return the new phonebook address
	 */
	@Override
	public PhonebookAddress create(long addressId) {
		PhonebookAddress phonebookAddress = new PhonebookAddressImpl();

		phonebookAddress.setNew(true);
		phonebookAddress.setPrimaryKey(addressId);

		String uuid = PortalUUIDUtil.generate();

		phonebookAddress.setUuid(uuid);

		phonebookAddress.setCompanyId(companyProvider.getCompanyId());

		return phonebookAddress;
	}

	/**
	 * Removes the phonebook address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressId the primary key of the phonebook address
	 * @return the phonebook address that was removed
	 * @throws NoSuchPhonebookAddressException if a phonebook address with the primary key could not be found
	 */
	@Override
	public PhonebookAddress remove(long addressId)
		throws NoSuchPhonebookAddressException {
		return remove((Serializable)addressId);
	}

	/**
	 * Removes the phonebook address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the phonebook address
	 * @return the phonebook address that was removed
	 * @throws NoSuchPhonebookAddressException if a phonebook address with the primary key could not be found
	 */
	@Override
	public PhonebookAddress remove(Serializable primaryKey)
		throws NoSuchPhonebookAddressException {
		Session session = null;

		try {
			session = openSession();

			PhonebookAddress phonebookAddress = (PhonebookAddress)session.get(PhonebookAddressImpl.class,
					primaryKey);

			if (phonebookAddress == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPhonebookAddressException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(phonebookAddress);
		}
		catch (NoSuchPhonebookAddressException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PhonebookAddress removeImpl(PhonebookAddress phonebookAddress) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(phonebookAddress)) {
				phonebookAddress = (PhonebookAddress)session.get(PhonebookAddressImpl.class,
						phonebookAddress.getPrimaryKeyObj());
			}

			if (phonebookAddress != null) {
				session.delete(phonebookAddress);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (phonebookAddress != null) {
			clearCache(phonebookAddress);
		}

		return phonebookAddress;
	}

	@Override
	public PhonebookAddress updateImpl(PhonebookAddress phonebookAddress) {
		boolean isNew = phonebookAddress.isNew();

		if (!(phonebookAddress instanceof PhonebookAddressModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(phonebookAddress.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(phonebookAddress);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in phonebookAddress proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PhonebookAddress implementation " +
				phonebookAddress.getClass());
		}

		PhonebookAddressModelImpl phonebookAddressModelImpl = (PhonebookAddressModelImpl)phonebookAddress;

		if (Validator.isNull(phonebookAddress.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			phonebookAddress.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (phonebookAddress.getCreateDate() == null)) {
			if (serviceContext == null) {
				phonebookAddress.setCreateDate(now);
			}
			else {
				phonebookAddress.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!phonebookAddressModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				phonebookAddress.setModifiedDate(now);
			}
			else {
				phonebookAddress.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (phonebookAddress.isNew()) {
				session.save(phonebookAddress);

				phonebookAddress.setNew(false);
			}
			else {
				phonebookAddress = (PhonebookAddress)session.merge(phonebookAddress);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!PhonebookAddressModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { phonebookAddressModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					phonebookAddressModelImpl.getUuid(),
					phonebookAddressModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { phonebookAddressModelImpl.getGroupId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
				args);

			args = new Object[] { phonebookAddressModelImpl.getUserId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USER, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
				args);

			args = new Object[] {
					phonebookAddressModelImpl.getUserId(),
					phonebookAddressModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPANDUSER, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDUSER,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((phonebookAddressModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						phonebookAddressModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { phonebookAddressModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((phonebookAddressModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						phonebookAddressModelImpl.getOriginalUuid(),
						phonebookAddressModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						phonebookAddressModelImpl.getUuid(),
						phonebookAddressModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((phonebookAddressModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						phonebookAddressModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { phonebookAddressModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((phonebookAddressModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						phonebookAddressModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] { phonebookAddressModelImpl.getUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}

			if ((phonebookAddressModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDUSER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						phonebookAddressModelImpl.getOriginalUserId(),
						phonebookAddressModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPANDUSER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDUSER,
					args);

				args = new Object[] {
						phonebookAddressModelImpl.getUserId(),
						phonebookAddressModelImpl.getGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPANDUSER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDUSER,
					args);
			}
		}

		entityCache.putResult(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
			PhonebookAddressImpl.class, phonebookAddress.getPrimaryKey(),
			phonebookAddress, false);

		clearUniqueFindersCache(phonebookAddressModelImpl, false);
		cacheUniqueFindersCache(phonebookAddressModelImpl);

		phonebookAddress.resetOriginalValues();

		return phonebookAddress;
	}

	/**
	 * Returns the phonebook address with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the phonebook address
	 * @return the phonebook address
	 * @throws NoSuchPhonebookAddressException if a phonebook address with the primary key could not be found
	 */
	@Override
	public PhonebookAddress findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPhonebookAddressException {
		PhonebookAddress phonebookAddress = fetchByPrimaryKey(primaryKey);

		if (phonebookAddress == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPhonebookAddressException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return phonebookAddress;
	}

	/**
	 * Returns the phonebook address with the primary key or throws a {@link NoSuchPhonebookAddressException} if it could not be found.
	 *
	 * @param addressId the primary key of the phonebook address
	 * @return the phonebook address
	 * @throws NoSuchPhonebookAddressException if a phonebook address with the primary key could not be found
	 */
	@Override
	public PhonebookAddress findByPrimaryKey(long addressId)
		throws NoSuchPhonebookAddressException {
		return findByPrimaryKey((Serializable)addressId);
	}

	/**
	 * Returns the phonebook address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the phonebook address
	 * @return the phonebook address, or <code>null</code> if a phonebook address with the primary key could not be found
	 */
	@Override
	public PhonebookAddress fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
				PhonebookAddressImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		PhonebookAddress phonebookAddress = (PhonebookAddress)serializable;

		if (phonebookAddress == null) {
			Session session = null;

			try {
				session = openSession();

				phonebookAddress = (PhonebookAddress)session.get(PhonebookAddressImpl.class,
						primaryKey);

				if (phonebookAddress != null) {
					cacheResult(phonebookAddress);
				}
				else {
					entityCache.putResult(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
						PhonebookAddressImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
					PhonebookAddressImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return phonebookAddress;
	}

	/**
	 * Returns the phonebook address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressId the primary key of the phonebook address
	 * @return the phonebook address, or <code>null</code> if a phonebook address with the primary key could not be found
	 */
	@Override
	public PhonebookAddress fetchByPrimaryKey(long addressId) {
		return fetchByPrimaryKey((Serializable)addressId);
	}

	@Override
	public Map<Serializable, PhonebookAddress> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, PhonebookAddress> map = new HashMap<Serializable, PhonebookAddress>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			PhonebookAddress phonebookAddress = fetchByPrimaryKey(primaryKey);

			if (phonebookAddress != null) {
				map.put(primaryKey, phonebookAddress);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
					PhonebookAddressImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (PhonebookAddress)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PHONEBOOKADDRESS_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (PhonebookAddress phonebookAddress : (List<PhonebookAddress>)q.list()) {
				map.put(phonebookAddress.getPrimaryKeyObj(), phonebookAddress);

				cacheResult(phonebookAddress);

				uncachedPrimaryKeys.remove(phonebookAddress.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PhonebookAddressModelImpl.ENTITY_CACHE_ENABLED,
					PhonebookAddressImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the phonebook addresses.
	 *
	 * @return the phonebook addresses
	 */
	@Override
	public List<PhonebookAddress> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PhonebookAddress> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<PhonebookAddress> findAll(int start, int end,
		OrderByComparator<PhonebookAddress> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<PhonebookAddress> findAll(int start, int end,
		OrderByComparator<PhonebookAddress> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<PhonebookAddress> list = null;

		if (retrieveFromCache) {
			list = (List<PhonebookAddress>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PHONEBOOKADDRESS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PHONEBOOKADDRESS;

				if (pagination) {
					sql = sql.concat(PhonebookAddressModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PhonebookAddress>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PhonebookAddress>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the phonebook addresses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PhonebookAddress phonebookAddress : findAll()) {
			remove(phonebookAddress);
		}
	}

	/**
	 * Returns the number of phonebook addresses.
	 *
	 * @return the number of phonebook addresses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PHONEBOOKADDRESS);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PhonebookAddressModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the phonebook address persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PhonebookAddressImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PHONEBOOKADDRESS = "SELECT phonebookAddress FROM PhonebookAddress phonebookAddress";
	private static final String _SQL_SELECT_PHONEBOOKADDRESS_WHERE_PKS_IN = "SELECT phonebookAddress FROM PhonebookAddress phonebookAddress WHERE addressId IN (";
	private static final String _SQL_SELECT_PHONEBOOKADDRESS_WHERE = "SELECT phonebookAddress FROM PhonebookAddress phonebookAddress WHERE ";
	private static final String _SQL_COUNT_PHONEBOOKADDRESS = "SELECT COUNT(phonebookAddress) FROM PhonebookAddress phonebookAddress";
	private static final String _SQL_COUNT_PHONEBOOKADDRESS_WHERE = "SELECT COUNT(phonebookAddress) FROM PhonebookAddress phonebookAddress WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "phonebookAddress.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PhonebookAddress exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PhonebookAddress exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(PhonebookAddressPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}