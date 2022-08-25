package model;

import control.Controller;
import model.Account;
import service.Data;
import util.Util;

import java.util.ArrayList;

public class Customer extends Account {
    private String email;
    private String address;

    public Customer(String id, String phoneNumber, String password, AccountRole role, String name, String email, String address) {
        super(id, phoneNumber, password, role, name);
        this.email = email;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() +
                " - " + email  +
                " - " + address ;
    }
}
