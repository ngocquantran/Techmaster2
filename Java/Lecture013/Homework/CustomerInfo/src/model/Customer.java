package model;

import util.Util;

import java.time.LocalDate;

public class Customer {
    private String id;
    private String name;
    private LocalDate birthday;
    private Gender gender;
    private String address;
    private String phone;
    private String email;

    public Customer(String id, String name, LocalDate birthday, Gender gender, String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id +
                " - " + name +
                " - " + Util.formatDate(birthday) +
                " - " + gender +
                " - " + address  +
                " - " + phone +
                " - " + email ;
    }
}
