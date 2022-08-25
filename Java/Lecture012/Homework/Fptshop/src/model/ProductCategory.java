package model;

public enum ProductCategory {
    phone("Điện thoại",1), laptop("Laptop",2),apple("Apple",3),accessory("Phụ kiện",4);
    private String type;
    private int value;

    ProductCategory(String type, int value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return type;
    }
}
