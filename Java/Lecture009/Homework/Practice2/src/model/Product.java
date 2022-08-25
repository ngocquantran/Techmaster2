package model;

public class Product {

    private int id;
    private String name;
    private long price;
    private int quantity;
    ProductType productType;
    private int sellingQuantity;

    public Product(int id, String name, long price, int quantity, ProductType productType, int sellingQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.productType = productType;
        this.sellingQuantity = sellingQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public int getSellingQuantity() {
        return sellingQuantity;
    }

    public void setSellingQuantity(int sellingQuantity) {
        this.sellingQuantity = sellingQuantity;
    }

    @Override
    public String toString() {
        return "   "+id+" - "+name+" - "+price+" - "+quantity+" - "+productType.getValue()+" - "+sellingQuantity;
    }
}
