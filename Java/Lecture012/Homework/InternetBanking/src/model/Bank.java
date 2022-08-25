package model;

public enum Bank {
    BIDV(1), VIETCOMBANK(2), TECHCOMBANK(3);

    public int value;

    Bank(int value) {
        this.value = value;
    }
}