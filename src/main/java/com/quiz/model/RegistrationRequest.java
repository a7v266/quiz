package com.quiz.model;

import com.quiz.model.validation.RegistrationPasswordConstraint;
import com.quiz.model.validation.RegistrationPasswordValidated;
import com.quiz.utils.Format;
import com.quiz.utils.Messages;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@RegistrationPasswordConstraint
public class RegistrationRequest implements Serializable, RegistrationPasswordValidated {

    @NotEmpty(message = Messages.ERROR_REGISTRATION_FIRST_NAME_EMPTY)
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_REGISTRATION_FIRST_NAME_MAX_LENGTH)
    private String firstName;

    @NotEmpty(message = Messages.ERROR_REGISTRATION_LAST_NAME_EMPTY)
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_REGISTRATION_LAST_NAME_MAX_LENGTH)
    private String lastName;

    @NotEmpty(message = Messages.ERROR_REGISTRATION_USERNAME_EMPTY)
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_REGISTRATION_USERNAME_MAX_LENGTH)
    private String username;

    @Email(message = Messages.ERROR_REGISTRATION_EMAIL_INVALID)
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_REGISTRATION_EMAIL_MAX_LENGTH)
    private String email;

    @NotEmpty(message = Messages.ERROR_REGISTRATION_PASSWORD_EMPTY)
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_REGISTRATION_PASSWORD_MAX_LENGTH)
    private String password1;

    @NotEmpty(message = Messages.ERROR_REGISTRATION_PASSWORD_EMPTY)
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_REGISTRATION_PASSWORD_MAX_LENGTH)
    private String password2;


    public LocalUser createUser() {
        LocalUser user = new LocalUser();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setRawPassword(password1);
        user.setEmail(email);
        user.setAccountNonExpired(Boolean.TRUE);
        user.setAccountNonLocked(Boolean.TRUE);
        user.setCredentialsNonExpired(Boolean.TRUE);
        user.setEnabled(Boolean.TRUE);
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
