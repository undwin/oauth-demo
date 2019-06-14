package win.und.demo.entity;

/**
 * @author yuit
 * @date  2018/10/16  9:23
 *
 **/
public class Client  {

    private String id;
    private String clientId;
    private String resourceIds;
    private Boolean isSecretRequired;
    private String clientSecret;
    private Boolean isScoped;
    private String scope;
    private String authorizedGrantTypes;
    private String registeredRedirectUri;
    private String authorities;
    private Boolean isAutoApprove;
    private Integer accessTokenValiditySeconds;
    private Integer refreshTokenValiditySeconds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public Boolean getSecretRequired() {
        return isSecretRequired;
    }

    public void setSecretRequired(Boolean secretRequired) {
        isSecretRequired = secretRequired;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public Boolean getScoped() {
        return isScoped;
    }

    public void setScoped(Boolean scoped) {
        isScoped = scoped;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getRegisteredRedirectUri() {
        return registeredRedirectUri;
    }

    public void setRegisteredRedirectUri(String registeredRedirectUri) {
        this.registeredRedirectUri = registeredRedirectUri;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Boolean getAutoApprove() {
        return isAutoApprove;
    }

    public void setAutoApprove(Boolean autoApprove) {
        isAutoApprove = autoApprove;
    }

    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValiditySeconds;
    }

    public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    }
}
