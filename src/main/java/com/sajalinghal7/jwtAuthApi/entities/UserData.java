package com.sajalinghal7.jwtAuthApi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserData {
    @Id
    String email;
    String password;
    String name;

    public UserData() {
    }

    public UserData(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
