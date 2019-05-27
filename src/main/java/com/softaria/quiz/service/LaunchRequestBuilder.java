package com.softaria.quiz.service;

import com.softaria.quiz.model.LaunchRequest;

import javax.servlet.http.HttpServletRequest;

public class LaunchRequestBuilder {

    private static final String LTI_MESSAGE_TYPE = "lti_message_type";
    private static final String LTI_VERSION = "lti_version";
    private static final String RESOURCE_LINK_ID = "resource_link_id";
    private static final String RESOURCE_LINK_TITLE = "resource_link_title";
    private static final String RESOURCE_LINK_DESCRIPTION = "resource_link_description";
    private static final String USER_ID = "user_id";
    private static final String USER_IMAGE = "user_image";
    private static final String ROLES = "roles";
    private static final String LIS_PERSON_NAME_GIVEN = "lis_person_name_given";
    private static final String LIS_PERSON_NAME_FAMILY = "lis_person_name_family";
    private static final String LIS_PERSON_NAME_FULL = "lis_person_name_full";
    private static final String LIS_PERSON_CONTACT_EMAIL_PRIMARY = "lis_person_contact_email_primary";
    private static final String CONTEXT_ID = "context_id";
    private static final String CONTEXT_TYPE = "context_type";
    private static final String CONTEXT_TITLE = "context_title";
    private static final String CONTEXT_LABEL = "context_label";
    private static final String LAUNCH_PRESENTATION_LOCALE = "launch_presentation_locale";
    private static final String LAUNCH_PRESENTATION_DOCUMENT_TARGET = "launch_presentation_document_target";
    private static final String LAUNCH_PRESENTATION_WIDTH = "launch_presentation_width";
    private static final String LAUNCH_PRESENTATION_HEIGHT = "launch_presentation_height";
    private static final String LAUNCH_PRESENTATION_RETURN_URL = "launch_presentation_return_url";
    private static final String TOOL_CONSUMER_INSTANCE_GUID = "tool_consumer_instance_guid";
    private static final String TOOL_CONSUMER_INSTANCE_NAME = "tool_consumer_instance_name";
    private static final String TOOL_CONSUMER_INSTANCE_DESCRIPTION = "tool_consumer_instance_description";
    private static final String TOOL_CONSUMER_INSTANCE_URL = "tool_consumer_instance_url";
    private static final String TOOL_CONSUMER_INSTANCE_CONTACT_EMAIL = "tool_consumer_instance_contact_email";
    private static final String CUSTOM_KEYNAME = "custom_keyname";
    private static final String OAUTH_CONSUMER_KEY = "oauth_consumer_key";
    private static final String OAUTH_SIGNATURE_METHOD = "oauth_signature_method";
    private static final String OAUTH_TIMESTAMP = "oauth_timestamp";
    private static final String OAUTH_NONCE = "oauth_nonce";
    private static final String OAUTH_VERSION = "oauth_version";
    private static final String OAUTH_SIGNATURE = "oauth_signature";

    public static LaunchRequest createLaunchRequest(HttpServletRequest httpRequest) {
        LaunchRequest launchRequest = new LaunchRequest();
        launchRequest.setLtiMessageType(httpRequest.getParameter(LTI_MESSAGE_TYPE));
        launchRequest.setLtiVersion(httpRequest.getParameter(LTI_VERSION));
        launchRequest.setResourceLinkId(httpRequest.getParameter(RESOURCE_LINK_ID));
        launchRequest.setResourceLinkTitle(httpRequest.getParameter(RESOURCE_LINK_TITLE));
        launchRequest.setResourceLinkDescription(httpRequest.getParameter(RESOURCE_LINK_DESCRIPTION));
        launchRequest.setUserId(httpRequest.getParameter(USER_ID));
        launchRequest.setUserImage(httpRequest.getParameter(USER_IMAGE));
        launchRequest.setRoles(httpRequest.getParameter(ROLES));
        launchRequest.setLisPersonNameGiven(httpRequest.getParameter(LIS_PERSON_NAME_GIVEN));
        launchRequest.setLisPersonNameFamily(httpRequest.getParameter(LIS_PERSON_NAME_FAMILY));
        launchRequest.setLisPersonNameFull(httpRequest.getParameter(LIS_PERSON_NAME_FULL));
        launchRequest.setLisPersonContactEmailPrimary(httpRequest.getParameter(LIS_PERSON_CONTACT_EMAIL_PRIMARY));
        launchRequest.setContextId(httpRequest.getParameter(CONTEXT_ID));
        launchRequest.setContextType(httpRequest.getParameter(CONTEXT_TYPE));
        launchRequest.setContextTitle(httpRequest.getParameter(CONTEXT_TITLE));
        launchRequest.setContextLabel(httpRequest.getParameter(CONTEXT_LABEL));
        launchRequest.setLaunchPresentationLocale(httpRequest.getParameter(LAUNCH_PRESENTATION_LOCALE));
        launchRequest.setLaunchPresentationDocumentTarget(httpRequest.getParameter(LAUNCH_PRESENTATION_DOCUMENT_TARGET));
        launchRequest.setLaunchPresentationWidth(httpRequest.getParameter(LAUNCH_PRESENTATION_WIDTH));
        launchRequest.setLaunchPresentationHeight(httpRequest.getParameter(LAUNCH_PRESENTATION_HEIGHT));
        launchRequest.setLaunchPresentationReturnUrl(httpRequest.getParameter(LAUNCH_PRESENTATION_RETURN_URL));
        launchRequest.setToolConsumerInstanceGuid(httpRequest.getParameter(TOOL_CONSUMER_INSTANCE_GUID));
        launchRequest.setToolConsumerInstanceName(httpRequest.getParameter(TOOL_CONSUMER_INSTANCE_NAME));
        launchRequest.setToolConsumerInstanceDescription(httpRequest.getParameter(TOOL_CONSUMER_INSTANCE_DESCRIPTION));
        launchRequest.setToolConsumerInstanceUrl(httpRequest.getParameter(TOOL_CONSUMER_INSTANCE_URL));
        launchRequest.setToolConsumerInstanceContactEmail(httpRequest.getParameter(TOOL_CONSUMER_INSTANCE_CONTACT_EMAIL));
        launchRequest.setCustomKeyname(httpRequest.getParameter(CUSTOM_KEYNAME));
        launchRequest.setOauthConsumerKey(httpRequest.getParameter(OAUTH_CONSUMER_KEY));
        launchRequest.setOauthSignatureMethod(httpRequest.getParameter(OAUTH_SIGNATURE_METHOD));
        launchRequest.setOauthTimestamp(httpRequest.getParameter(OAUTH_TIMESTAMP));
        launchRequest.setOauthNonce(httpRequest.getParameter(OAUTH_NONCE));
        launchRequest.setOauthVersion(httpRequest.getParameter(OAUTH_VERSION));
        launchRequest.setOauthSignature(httpRequest.getParameter(OAUTH_SIGNATURE));
        return launchRequest;
    }
}
