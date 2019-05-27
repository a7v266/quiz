package com.quiz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quiz.utils.Format;
import com.quiz.utils.Messages;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "local_user", indexes = {
        @Index(columnList = "username", unique = true),
        @Index(columnList = "token", unique = true),
        @Index(columnList = "consumer_key", unique = true),
        @Index(columnList = "shared_secret", unique = true)
})
public class LocalUser extends BaseEntity {

    public static final String USER_GROUP = "userGroup";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";
    public static final String TOKEN = "token";
    public static final String CONSUMER_KEY = "consumerKey";

    @Column(name = "first_name", nullable = false)
    @NotEmpty(message = Messages.ERROR_USER_FIRST_NAME_EMPTY)
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_USER_FIRST_NAME_MAX_LENGTH)
    @JsonProperty
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotEmpty(message = Messages.ERROR_USER_SECOND_NAME_EMPTY)
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_USER_SECOND_NAME_MAX_LENGTH)
    @JsonProperty
    private String lastName;

    @Column(name = "email")
    @Email(message = Messages.ERROR_USER_EMAIL_INVALID)
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_USER_EMAIL_MAX_LENGTH)
    @JsonProperty
    private String email;

    @Column(name = "username", nullable = false)
    @NotEmpty(message = Messages.ERROR_USERNAME_EMPTY)
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_USERNAME_MAX_LENGTH)
    @JsonProperty
    private String username;

    @Column(name = "password", nullable = false)
    @NotEmpty(message = Messages.ERROR_USER_PASSWORD_EMPTY)
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_USER_PASSWORD_MAX_LENGTH)
    private String password;

    @Transient
    private String rawPassword;

    @Column(name = "account_non_expired")
    @NotNull(message = Messages.ERROR_USER_ACCOUNT_NON_EXPIRED_EMPTY)
    @JsonProperty
    private Boolean accountNonExpired;

    @Column(name = "account_non_locked")
    @NotNull(message = Messages.ERROR_USER_ACCOUNT_NON_LOCKED_EMPTY)
    @JsonProperty
    private Boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    @NotNull(message = Messages.ERROR_USER_CREDENTIALS_NON_EXPIRED_EMPTY)
    @JsonProperty
    private Boolean credentialsNonExpired;

    @Column(name = "enabled")
    @NotNull(message = Messages.ERROR_USER_ENABLED_EMPTY)
    @JsonProperty
    private Boolean enabled;

    @Column(name = "token")
    @JsonProperty
    private String token;

    @Column(name = "token_time")
    @JsonProperty
    private LocalDateTime tokenTime;

    @Column(name = "consumer_key")
    @NotEmpty(message = Messages.ERROR_USER_CONSUMER_KEY_EMPTY)
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_USER_CONSUMER_KEY_EMPTY)
    @JsonProperty
    private String consumerKey;

    @Column(name = "shared_secret")
    @NotEmpty(message = Messages.ERROR_USER_SHARED_SECRET_EMPTY)
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_USER_SHARED_SECRET_MAX_LENGTH)
    @JsonProperty
    private String sharedSecret;

    public static LocalUser create(Long id) {
        LocalUser user = new LocalUser();
        user.setId(id);
        return user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRawPassword() {
        return rawPassword;
    }

    public void setRawPassword(String rawPassword) {
        this.rawPassword = rawPassword;
    }

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getTokenTime() {
        return tokenTime;
    }

    public void setTokenTime(LocalDateTime tokenTime) {
        this.tokenTime = tokenTime;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public String getSharedSecret() {
        return sharedSecret;
    }

    public void setSharedSecret(String sharedSecret) {
        this.sharedSecret = sharedSecret;
    }
}
