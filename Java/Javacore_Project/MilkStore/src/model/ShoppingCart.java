package model;

import util.Util;

import java.time.LocalDate;

public class ShoppingCart {
    private String customerId;
    private String itemName;
    private String itemId;
    private int quantity;
    private long price;

    public ShoppingCart(String customerId, String itemName, String itemId, int quantity, long price) {
        this.customerId = customerId;
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return itemId+" - "+itemName +
                " - " + "SL: "+quantity +
                " - " + Util.moneyFormat(price)+" VND";
    }
}
