package model;

public enum ProductType {

    A("Đồ gia dụng"),
    B("Thực Phẩm"),
    C("Thời trang");

    String value;

    ProductType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
