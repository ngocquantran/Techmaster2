package model;

public class Account {
    private String phoneNumber;
    private String password;
    private long accountBalance;

    public Account(String phoneNumber, String password, long accountBalance) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.accountBalance = accountBalance;
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

    public long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(long accountBalance) {
        this.accountBalance = accountBalance;
    }
}
