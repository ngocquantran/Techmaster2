package model;

public enum Status {
    AVAILABLE("(còn hàng)"),OUTOFSTOCK("(hết hàng)");
    String value;

    Status(String value) {
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
        return value;
    }
}
