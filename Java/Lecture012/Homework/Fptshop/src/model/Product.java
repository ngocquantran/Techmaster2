package model;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Product {
    private int id;
    private String name;
    private String description;
    private long price;
    private int quantity;
    private int sellingQuantity;
    private String brand;
    private ProductCategory[] categories;

    public Product(int id, String name, String description, long price, int quantity, int sellingQuantity, String brand, ProductCategory[] categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.sellingQuantity = sellingQuantity;
        this.brand = brand;
        this.categories = categories;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getSellingQuantity() {
        return sellingQuantity;
    }

    public void setSellingQuantity(int sellingQuantity) {
        this.sellingQuantity = sellingQuantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public ProductCategory[] getCategories() {
        return categories;
    }

    public void setCategories(ProductCategory[] categories) {
        this.categories = categories;
    }

    DecimalFormat dcf=new DecimalFormat("###,###,###");

    @Override
    public String toString() {
        return id + " - " + name + " - " + description + " - " + dcf.format(price) +
                " - " + quantity + " - " + sellingQuantity + " - " + brand  +
                " - " + Arrays.toString(categories);
    }
}
