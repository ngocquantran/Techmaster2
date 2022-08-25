package model;

public enum AccountRole {
    Visitor(0,"Người lạ"),Customer(1,"Khách hàng"),Staff(2,"Nhân viên"),Admin(3,"Quản trị viên");

    int value;
    String role;

    AccountRole(int value, String role) {
        this.value = value;
        this.role = role;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return role ;
    }
}
