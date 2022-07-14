package com.example.csistant;

import java.io.Serializable;

public class UserModel implements Serializable {

    private String email_id;
    private String name;
    private long phone_number;
    private String password;
    private String dob;

    public UserModel()
    {}

    public UserModel(String email_id, String name, long phone_number, String password, String dob) {
        this.email_id = email_id;
        this.name = name;
        this.phone_number = phone_number;
        this.password = password;
        this.dob = dob;
    }


    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "email_id='" + email_id + '\'' +
                ", name='" + name + '\'' +
                ", phone_number=" + phone_number +
                ", password='" + password + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
