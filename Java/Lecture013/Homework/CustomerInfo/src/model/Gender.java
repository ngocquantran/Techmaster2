package model;

public enum Gender {
    MALE("Nam"), FEMALE("Nữ");

    String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return  value;
    }
}
