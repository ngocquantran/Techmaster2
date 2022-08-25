package model;

import util.Util;

import java.time.LocalDate;

public class Product {
    private String id;
    private String name;
    private String brand;
    private ProductCategory productCategory;
    private LocalDate receiptDate;
    private LocalDate mfg;
    private int exp;
    private int quantity;
    private int soldQuantity;
    private String origin;
    private long price;
    private String status;

    public Product(String id, String name, String brand, ProductCategory productCategory, LocalDate receiptDate, LocalDate mfg, int exp, int quantity, int soldQuantity, String origin, long price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.productCategory = productCategory;
        this.receiptDate = receiptDate;
        this.mfg = mfg;
        this.exp = exp;
        this.quantity = quantity;
        this.soldQuantity = soldQuantity;
        this.origin = origin;
        this.price = price;
        this.status = Util.showStatus(quantity);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public LocalDate getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(LocalDate receiptDate) {
        this.receiptDate = receiptDate;
    }

    public LocalDate getMfg() {
        return mfg;
    }

    public void setMfg(LocalDate mfg) {
        this.mfg = mfg;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return id +
                " - " + name +
                " - " + brand  +
                " - " + productCategory +
                " - Ngày nhập: " + Util.FormatDate(receiptDate) +
                " - NSX: " + Util.FormatDate(mfg) +
                " - HSD: " + exp +
                " tháng - SL: " + quantity +
                " - SL bán: " + soldQuantity +
                " - " + origin +
                " - " + Util.moneyFormat(price)+" - "+status;
    }




}
