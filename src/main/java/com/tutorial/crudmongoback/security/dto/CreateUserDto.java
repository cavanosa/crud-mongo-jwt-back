package com.tutorial.crudmongoback.security.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class CreateUserDto {
    @NotBlank(message = "username is mandatory")
    private String username;
    @NotBlank(message = "email is mandatory")
    @Email(message = "invalid email")
    private String email;
    @NotBlank(message = "username is mandatory")
    private String password;
    // @NotEmpty(message = "roles are mandatory")
    List<String> roles = new ArrayList<>();

    public CreateUserDto() {
    }

    public CreateUserDto(String username, String email, String password, List<String> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
