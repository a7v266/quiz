package com.softaria.quiz.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "launch_request")
public class LaunchRequest extends BaseEntity {

    private static final String LTI_MESSAGE_TYPE = "ltiMessageType";
    private static final String LTI_VERSION = "ltiVersion";
    private static final String RESOURCE_LINK_ID = "resourceLinkId";
    private static final String RESOURCE_LINK_TITLE = "resourceLinkTitle";
    private static final String RESOURCE_LINK_DESCRIPTION = "resourceLinkDescription";
    private static final String USER_ID = "userId";
    private static final String USER_IMAGE = "userImage";
    private static final String ROLES = "roles";
    private static final String LIS_PERSON_NAME_GIVEN = "lisPersonNameGiven";
    private static final String LIS_PERSON_NAME_FAMILY = "lisPersonNameFamily";
    private static final String LIS_PERSON_NAME_FULL = "lisPersonNameFull";
    private static final String LIS_PERSON_CONTACT_EMAIL_PRIMARY = "lisPersonContactEmailPrimary";
    private static final String CONTEXT_ID = "contextId";
    private static final String CONTEXT_TYPE = "contextType";
    private static final String CONTEXT_TITLE = "contextTitle";
    private static final String CONTEXT_LABEL = "contextLabel";
    private static final String LAUNCH_PRESENTATION_LOCALE = "launchPresentationLocale";
    private static final String LAUNCH_PRESENTATION_DOCUMENT_TARGET = "launchPresentationDocumentTarget";
    private static final String LAUNCH_PRESENTATION_WIDTH = "launchPresentationWidth";
    private static final String LAUNCH_PRESENTATION_HEIGHT = "launchPresentationHeight";
    private static final String LAUNCH_PRESENTATION_RETURN_URL = "launchPresentationReturnUrl";
    private static final String TOOL_CONSUMER_INSTANCE_GUID = "toolConsumerInstanceGuid";
    private static final String TOOL_CONSUMER_INSTANCE_NAME = "toolConsumerInstanceName";
    private static final String TOOL_CONSUMER_INSTANCE_DESCRIPTION = "toolConsumerInstanceDescription";
    private static final String TOOL_CONSUMER_INSTANCE_URL = "toolConsumerInstanceUrl";
    private static final String TOOL_CONSUMER_INSTANCE_CONTACT_EMAIL = "toolConsumerInstanceContactEmail";
    private static final String CUSTOM_KEYNAME = "customKeyname";
    private static final String OAUTH_CONSUMER_KEY = "oauthConsumerKey";
    private static final String OAUTH_SIGNATURE_METHOD = "oauthSignatureMethod";
    private static final String OAUTH_TIMESTAMP = "oauthTimestamp";
    private static final String OAUTH_NONCE = "oauthNonce";
    private static final String OAUTH_VERSION = "oauthVersion";
    private static final String OAUTH_SIGNATURE = "oauthSignature";

    @Column(name = "lti_message_type")
    @JsonProperty
    private String ltiMessageType;

    @Column(name = "lti_version")
    @JsonProperty
    private String ltiVersion;

    @Column(name = "resource_link_id")
    @JsonProperty
    private String resourceLinkId;

    @Column(name = "resource_link_title")
    @JsonProperty
    private String resourceLinkTitle;

    @Column(name = "resource_link_description")
    @JsonProperty
    private String resourceLinkDescription;

    @Column(name = "user_id")
    @JsonProperty
    private String userId;

    @Column(name = "user_image")
    @JsonProperty
    private String userImage;

    @Column(name = "roles")
    @JsonProperty
    private String roles;

    @Column(name = "lis_person_name_given")
    @JsonProperty
    private String lisPersonNameGiven;

    @Column(name = "lis_person_name_family")
    @JsonProperty
    private String lisPersonNameFamily;

    @Column(name = "lis_person_name_full")
    @JsonProperty
    private String lisPersonNameFull;

    @Column(name = "lis_person_contact_email_primary")
    @JsonProperty
    private String lisPersonContactEmailPrimary;

    @Column(name = "context_id")
    @JsonProperty
    private String contextId;

    @Column(name = "context_type")
    @JsonProperty
    private String contextType;

    @Column(name = "context_title")
    @JsonProperty
    private String contextTitle;

    @Column(name = "context_label")
    @JsonProperty
    private String contextLabel;

    @Column(name = "launch_presentation_locale")
    @JsonProperty
    private String launchPresentationLocale;

    @Column(name = "launch_presentation_document_target")
    @JsonProperty
    private String launchPresentationDocumentTarget;

    @Column(name = "launch_presentation_width")
    @JsonProperty
    private String launchPresentationWidth;

    @Column(name = "launch_presentation_height")
    @JsonProperty
    private String launchPresentationHeight;

    @Column(name = "launch_presentation_return_url")
    @JsonProperty
    private String launchPresentationReturnUrl;

    @Column(name = "tool_consumer_instance_guid")
    @JsonProperty
    private String toolConsumerInstanceGuid;

    @Column(name = "tool_consumer_instance_name")
    @JsonProperty
    private String toolConsumerInstanceName;

    @Column(name = "tool_consumer_instance_description")
    @JsonProperty
    private String toolConsumerInstanceDescription;

    @Column(name = "tool_consumer_instance_url")
    @JsonProperty
    private String toolConsumerInstanceUrl;

    @Column(name = "tool_consumer_instance_contact_email")
    @JsonProperty
    private String toolConsumerInstanceContactEmail;

    @Column(name = "custom_keyname")
    @JsonProperty
    private String customKeyname;

    @Column(name = "oauth_consumer_key")
    @JsonProperty
    private String oauthConsumerKey;

    @Column(name = "oauth_signature_method")
    @JsonProperty
    private String oauthSignatureMethod;

    @Column(name = "oauth_timestamp")
    @JsonProperty
    private String oauthTimestamp;

    @Column(name = "oauth_nonce")
    @JsonProperty
    private String oauthNonce;

    @Column(name = "oauth_version")
    @JsonProperty
    private String oauthVersion;

    @Column(name = "oauth_signature")
    @JsonProperty
    private String oauthSignature;

    public Context createContext() {
        Context context = new Context();
        context.setContextId(contextId);
        return updateContext(context);
    }

    public Context updateContext(Context context) {
        context.setContextTitle(contextTitle);
        context.setContextLabel(contextLabel);
        context.setContextType(contextType);
        return context;
    }

    public ResourceLink createResourceLink() {
        ResourceLink resourceLink = new ResourceLink();
        resourceLink.setResourceLinkId(resourceLinkId);
        return updateResourceLink(resourceLink);
    }

    public ResourceLink updateResourceLink(ResourceLink resourceLink) {
        resourceLink.setResourceLinkTitle(resourceLinkTitle);
        resourceLink.setResourceLinkDescription(resourceLinkDescription);
        return resourceLink;
    }

    public String getLtiMessageType() {
        return ltiMessageType;
    }

    public void setLtiMessageType(String ltiMessageType) {
        this.ltiMessageType = ltiMessageType;
    }

    public String getLtiVersion() {
        return ltiVersion;
    }

    public void setLtiVersion(String ltiVersion) {
        this.ltiVersion = ltiVersion;
    }

    public String getResourceLinkId() {
        return resourceLinkId;
    }

    public void setResourceLinkId(String resourceLinkId) {
        this.resourceLinkId = resourceLinkId;
    }

    public String getResourceLinkTitle() {
        return resourceLinkTitle;
    }

    public void setResourceLinkTitle(String resourceLinkTitle) {
        this.resourceLinkTitle = resourceLinkTitle;
    }

    public String getResourceLinkDescription() {
        return resourceLinkDescription;
    }

    public void setResourceLinkDescription(String resourceLinkDescription) {
        this.resourceLinkDescription = resourceLinkDescription;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getLisPersonNameGiven() {
        return lisPersonNameGiven;
    }

    public void setLisPersonNameGiven(String lisPersonNameGiven) {
        this.lisPersonNameGiven = lisPersonNameGiven;
    }

    public String getLisPersonNameFamily() {
        return lisPersonNameFamily;
    }

    public void setLisPersonNameFamily(String lisPersonNameFamily) {
        this.lisPersonNameFamily = lisPersonNameFamily;
    }

    public String getLisPersonNameFull() {
        return lisPersonNameFull;
    }

    public void setLisPersonNameFull(String lisPersonNameFull) {
        this.lisPersonNameFull = lisPersonNameFull;
    }

    public String getLisPersonContactEmailPrimary() {
        return lisPersonContactEmailPrimary;
    }

    public void setLisPersonContactEmailPrimary(String lisPersonContactEmailPrimary) {
        this.lisPersonContactEmailPrimary = lisPersonContactEmailPrimary;
    }

    public String getContextId() {
        return contextId;
    }

    public void setContextId(String contextId) {
        this.contextId = contextId;
    }

    public String getContextType() {
        return contextType;
    }

    public void setContextType(String contextType) {
        this.contextType = contextType;
    }

    public String getContextTitle() {
        return contextTitle;
    }

    public void setContextTitle(String contextTitle) {
        this.contextTitle = contextTitle;
    }

    public String getContextLabel() {
        return contextLabel;
    }

    public void setContextLabel(String contextLabel) {
        this.contextLabel = contextLabel;
    }

    public String getLaunchPresentationLocale() {
        return launchPresentationLocale;
    }

    public void setLaunchPresentationLocale(String launchPresentationLocale) {
        this.launchPresentationLocale = launchPresentationLocale;
    }

    public String getLaunchPresentationDocumentTarget() {
        return launchPresentationDocumentTarget;
    }

    public void setLaunchPresentationDocumentTarget(String launchPresentationDocumentTarget) {
        this.launchPresentationDocumentTarget = launchPresentationDocumentTarget;
    }

    public String getLaunchPresentationWidth() {
        return launchPresentationWidth;
    }

    public void setLaunchPresentationWidth(String launchPresentationWidth) {
        this.launchPresentationWidth = launchPresentationWidth;
    }

    public String getLaunchPresentationHeight() {
        return launchPresentationHeight;
    }

    public void setLaunchPresentationHeight(String launchPresentationHeight) {
        this.launchPresentationHeight = launchPresentationHeight;
    }

    public String getLaunchPresentationReturnUrl() {
        return launchPresentationReturnUrl;
    }

    public void setLaunchPresentationReturnUrl(String launchPresentationReturnUrl) {
        this.launchPresentationReturnUrl = launchPresentationReturnUrl;
    }

    public String getToolConsumerInstanceGuid() {
        return toolConsumerInstanceGuid;
    }

    public void setToolConsumerInstanceGuid(String toolConsumerInstanceGuid) {
        this.toolConsumerInstanceGuid = toolConsumerInstanceGuid;
    }

    public String getToolConsumerInstanceName() {
        return toolConsumerInstanceName;
    }

    public void setToolConsumerInstanceName(String toolConsumerInstanceName) {
        this.toolConsumerInstanceName = toolConsumerInstanceName;
    }

    public String getToolConsumerInstanceDescription() {
        return toolConsumerInstanceDescription;
    }

    public void setToolConsumerInstanceDescription(String toolConsumerInstanceDescription) {
        this.toolConsumerInstanceDescription = toolConsumerInstanceDescription;
    }

    public String getToolConsumerInstanceUrl() {
        return toolConsumerInstanceUrl;
    }

    public void setToolConsumerInstanceUrl(String toolConsumerInstanceUrl) {
        this.toolConsumerInstanceUrl = toolConsumerInstanceUrl;
    }

    public String getToolConsumerInstanceContactEmail() {
        return toolConsumerInstanceContactEmail;
    }

    public void setToolConsumerInstanceContactEmail(String toolConsumerInstanceContactEmail) {
        this.toolConsumerInstanceContactEmail = toolConsumerInstanceContactEmail;
    }

    public String getCustomKeyname() {
        return customKeyname;
    }

    public void setCustomKeyname(String customKeyname) {
        this.customKeyname = customKeyname;
    }

    public String getOauthConsumerKey() {
        return oauthConsumerKey;
    }

    public void setOauthConsumerKey(String oauthConsumerKey) {
        this.oauthConsumerKey = oauthConsumerKey;
    }

    public String getOauthSignatureMethod() {
        return oauthSignatureMethod;
    }

    public void setOauthSignatureMethod(String oauthSignatureMethod) {
        this.oauthSignatureMethod = oauthSignatureMethod;
    }

    public String getOauthTimestamp() {
        return oauthTimestamp;
    }

    public void setOauthTimestamp(String oauthTimestamp) {
        this.oauthTimestamp = oauthTimestamp;
    }

    public String getOauthNonce() {
        return oauthNonce;
    }

    public void setOauthNonce(String oauthNonce) {
        this.oauthNonce = oauthNonce;
    }

    public String getOauthVersion() {
        return oauthVersion;
    }

    public void setOauthVersion(String oauthVersion) {
        this.oauthVersion = oauthVersion;
    }

    public String getOauthSignature() {
        return oauthSignature;
    }

    public void setOauthSignature(String oauthSignature) {
        this.oauthSignature = oauthSignature;
    }
}
