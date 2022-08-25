package model;

import control.Controller;
import service.ProductService;
import util.Util;

import java.time.LocalDate;

public class PurchaseHistory {
    private String purchaseCode;
    private String customerId;
    private String customerName;
    private String mobile;
    private LocalDate date;
    private String itemName;
    private String itemId;
    private int quantity;
    private long price;


    public PurchaseHistory(String purchaseCode, String customerId, String customerName, String mobile, LocalDate date, String itemName, String itemId, int quantity, long price) {
        this.purchaseCode = purchaseCode;
        this.customerId = customerId;
        this.customerName = customerName;
        this.mobile = mobile;
        this.date = date;
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;

    }

    public String getPurchaseCode() {
        return purchaseCode;
    }

    public void setPurchaseCode(String purchaseCode) {
        this.purchaseCode = purchaseCode;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
        return  "Đơn: "+purchaseCode  +
                " - Khách hàng: " + customerId +" - "+customerName+
                " - " + Util.FormatDate(date) +
                " - " + itemName +
                " - " + itemId  +
                " - SL: " + quantity +
                " - " + Util.moneyFormat(price) +
                "VND";
    }
}
