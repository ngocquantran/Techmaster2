

public class Account {
    private String id; //id gồm 5 ký tự sinh ngẫu nhiên
    private String mobile;
    private String password;
    private long balance;

    public Account(String mobile, String password, long balance) {
//        this.id = Util.randomId(5);
        this.id = Util.showStatus(balance);
        this.mobile = mobile;
        this.password = password;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
