<%@ page import="com.phonebook.web.constants.PortletImplPortletKeys" %>
<%@ page import="com.liferay.portal.kernel.service.PhoneLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ include file="init.jsp" %>

<%


    long addressId = ParamUtil.getLong(request, PortletImplPortletKeys.PARAMETER_NAME_ADDRESS_IDENTIFIER);
    String firstName ="";
    String lastName = StringPool.BLANK;
    String emailAddress = StringPool.BLANK;
    String mobileNumber = StringPool.BLANK;
    PhonebookAddress existingAddress = null;
    if(addressId > 0) {
        try {
             existingAddress = PhonebookAddressLocalServiceUtil.getPhonebookAddress(addressId);
             firstName = existingAddress.getFirstName();
        } catch (PortalException | NullPointerException e) {
            e.printStackTrace();
        }

    }
    firstName = ParamUtil.getString(request, PortletImplPortletKeys.PARAMETER_NAME_FIRSTNAME, firstName);
    lastName = ParamUtil.getString(request, PortletImplPortletKeys.PARAMETER_NAME_LASTNAME, lastName);
    emailAddress= ParamUtil.getString(request, PortletImplPortletKeys.PARAMETER_NAME_EMAIL_ADDRESS, emailAddress);
    mobileNumber = ParamUtil.getString(request, PortletImplPortletKeys.PARAMETER_NAME_MOBILE_NUMBER, mobileNumber);

%>


<portlet:actionURL name="savePhonebookAddress" var="savePhonebookAddress" >
    <portlet:param name="jspPage" value="/view.jsp" />

    <portlet:param name="<%=PortletImplPortletKeys.PARAMETER_NAME_MVC_PATH%>"
                   value="/view.jsp" />
    </portlet:actionURL>

<aui:form action="<%= savePhonebookAddress %>" method="post" name="fm">

    <aui:input type="hidden" name="<%=PortletImplPortletKeys.PARAMETER_NAME_ADDRESS_IDENTIFIER%>"
               value="<%= addressId %>" />

    <aui:input name="<%=PortletImplPortletKeys.PARAMETER_NAME_FIRSTNAME%>"
               value="<%= firstName %>">
        <aui:validator name="text" />
    </aui:input>
    <aui:input name="<%=PortletImplPortletKeys.PARAMETER_NAME_LASTNAME%>"
               value="<%= lastName %>">
        <aui:validator name="required" />
        <aui:validator name="text" />
    </aui:input>
    <aui:input name="<%=PortletImplPortletKeys.PARAMETER_NAME_EMAIL_ADDRESS%>"
              type="text" value="<%= emailAddress %>">
        <aui:validator name="required" />
        <aui:validator name="email" />
    </aui:input>
    <aui:input name="<%=PortletImplPortletKeys.PARAMETER_NAME_MOBILE_NUMBER%>"
               value="<%= mobileNumber %>">
        <aui:validator name="required" />
        <aui:validator name="digits" />
    </aui:input>


    <portlet:renderURL var="cancel">
        <portlet:param name="<%=PortletImplPortletKeys.PARAMETER_NAME_MVC_PATH%>"
                       value="/view.jsp" />
    </portlet:renderURL>
    <aui:button-row>
        <aui:button cssClass="btn-lg" value="<%=PortletImplPortletKeys.SAVE_BUTTON%>"  type="submit" />
        <aui:button cssClass="btn-lg" type="cancel" value="<%=PortletImplPortletKeys.CANCEL_BUTTON%>" href="<%= cancel %>"/>
    </aui:button-row>
</aui:form>

