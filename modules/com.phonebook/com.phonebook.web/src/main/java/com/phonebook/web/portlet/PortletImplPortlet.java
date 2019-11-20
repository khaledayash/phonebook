package com.phonebook.web.portlet;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.phonebook.service.PhonebookAddressLocalService;
import com.phonebook.web.constants.PortletImplPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;

/**
 * @author kayash
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PortletImplPortletKeys.PortletImpl,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PortletImplPortlet extends MVCPortlet {


    private PhonebookAddressLocalService phonebookAddressLocalService;

    @Reference(unbind = "-")
    protected void setPhonebookAddressLocalService(PhonebookAddressLocalService
                                                           newPhonebookAddressLocalService) {
        this.phonebookAddressLocalService = newPhonebookAddressLocalService;
    }

    public void savePhonebookAddress(ActionRequest request, ActionResponse response)
            throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay)request. getAttribute(WebKeys.THEME_DISPLAY);
        long companyId = themeDisplay.getCompanyId();
        long groupId = themeDisplay.getScopeGroupId();
        User user = themeDisplay.getUser();

        long addressId = ParamUtil.getInteger(request,
                PortletImplPortletKeys.PARAMETER_NAME_ADDRESS_IDENTIFIER, -1);
        String firstName = ParamUtil.getString(request,
                PortletImplPortletKeys.PARAMETER_NAME_FIRSTNAME, StringPool.BLANK);
        String lastName = ParamUtil.getString(request,
                PortletImplPortletKeys.PARAMETER_NAME_LASTNAME, StringPool.BLANK);
        String emailAddress = ParamUtil.getString(request,
                PortletImplPortletKeys.PARAMETER_NAME_EMAIL_ADDRESS, StringPool.BLANK);
        String mobileNr = ParamUtil.getString(request,
                PortletImplPortletKeys.PARAMETER_NAME_MOBILE_NUMBER, StringPool.BLANK);
        Date now = new Date();

        this.phonebookAddressLocalService.savePhonebookAddress(addressId, user.getUserId(), user.getFullName(), groupId,
                companyId, now, now, firstName, lastName, emailAddress, mobileNr);
    }



}
