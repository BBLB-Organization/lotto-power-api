package com.example.lottopower.models;

import javax.persistence.*;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String username;
    String emailAddress;
    String password;
    String roles;

    public Users(){}

    public Users(Integer id, String username, String emailAddress, String password, String roles) {
        this.id = id;
        this.username = username;
        this.emailAddress = emailAddress;
        this.password = password;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password; }

    public String getRoles() { return roles; }

    public void setRoles(String roles) {this.roles = roles;}
}
