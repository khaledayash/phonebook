<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>

<%@page import="com.phonebook.model.PhonebookAddress"%>
<%@page import="com.phonebook.service.PhonebookAddressLocalServiceUtil"%>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />


