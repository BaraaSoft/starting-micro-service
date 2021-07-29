package com.baraabytes.app.ws.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserRequest {
    @NotNull
    private String firstname;
    private String lastname;
    @Email
    private String email;

    public UserRequest() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
