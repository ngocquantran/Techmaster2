package model;

public class Account {
    private String id;
    private String phoneNumber;
    private String password;
    private AccountRole role;
    private String name;


    public Account(String id, String phoneNumber, String password, AccountRole role, String name) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountRole getRole() {
        return role;
    }

    public void setRole(AccountRole role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  id +
                " - " + phoneNumber +" - "+name+" - "+role;
    }
}
