<%@ page import="com.phonebook.web.constants.PortletImplPortletKeys" %>
<%@ include file="init.jsp" %>

<%
	boolean isSignedIn = themeDisplay.isSignedIn();
%>

<c:if test="<%= !isSignedIn %>">
<h1>please sign in to show the phonebook!</h1>
</c:if>
<c:if test="<%= isSignedIn %>">


<portlet:actionURL name="saveAddress" var="savePhonebookAddressUrl" />
<portlet:renderURL var="savePhonebookAddressUrl">
	<portlet:param name="<%=PortletImplPortletKeys.PARAMETER_NAME_MVC_PATH%>"
				   value="/add_phonebook_address.jsp" />
</portlet:renderURL>

<aui:button-row>
	<aui:button href="<%= savePhonebookAddressUrl %>" icon="icon-plus" value="<%=PortletImplPortletKeys.ADD_NEW_ADDRESS%>" />
</aui:button-row>

<%


	Integer delta = ParamUtil.getInteger(renderRequest,PortletImplPortletKeys.PARAMETER_NAME_DELTA,
			SearchContainer.DEFAULT_DELTA);
	int cur = ParamUtil.getInteger(renderRequest,PortletImplPortletKeys.PARAMETER_NAME_CUR, 1);

	PortletURL iterateURL = renderResponse.createRenderURL();
	iterateURL.setParameter(PortletImplPortletKeys.PARAMETER_NAME_MVC_PATH, "/view.jsp");
	iterateURL.setParameter(PortletImplPortletKeys.PARAMETER_NAME_CUR, Integer.toString(cur));
	iterateURL.setParameter(PortletImplPortletKeys.PARAMETER_NAME_DELTA, Integer.toString(delta));

	List<PhonebookAddress> phonebookAddressList = PhonebookAddressLocalServiceUtil.
			getAllPhonebookAddressesbyUserId(user.getUserId(), (cur-1)*delta, (cur)*delta);
	DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT,
			themeDisplay.getLocale());

%>

	<table>
		<liferay-ui:search-container delta="<%=delta%>" emptyResultsMessage="No Addresses found"
									 iteratorURL="<%=iterateURL %>">
			<liferay-ui:search-container-results results="<%= phonebookAddressList %>"/>
			<liferay-ui:search-container-row className="com.phonebook.model.PhonebookAddress"
											 keyProperty="addressId" modelVar="phonebookAddress">
				<liferay-ui:search-container-column-text>

					<td><%= phonebookAddress.getFirstName() %></td>
					<td><%= phonebookAddress.getLastName() %></td>
					<td><%= phonebookAddress.getEmail() %></td>
					<td><%= phonebookAddress.getMobileNr() %></td>

				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

	<liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>
	</table>

</c:if>
