package model;

public enum ProductCategory {
    powdered("Sữa bột các loại",1),fresh("Sữa nước các loại",2),yogurt("Sữa chua uống liền",3);
     String value;
     int number;

    ProductCategory(String value, int number) {
        this.value = value;
        this.number = number;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return  value;
    }
}
