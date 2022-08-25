package model;

import jdk.jshell.spi.SPIResolutionException;
import util.Util;

import java.time.LocalDate;
import java.time.LocalTime;

public class ActionHistory {
    private LocalDate date;
    private LocalTime time;
    private String staffId;
    private String staffName;
    private String productId;
    private String productName;
    private String action;
    private String description;

    public ActionHistory(LocalDate date, LocalTime time, String staffId, String staffName, String productId, String productName, String action, String description) {
        this.date = date;
        this.time = time;
        this.staffId = staffId;
        this.staffName = staffName;
        this.productId = productId;
        this.productName = productName;
        this.action = action;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return Util.FormatDate(date) +
                " - " + Util.FormatTime(time) +
                " - mã NV: " + staffId  +
                " - " + staffName  +
                " - mã SP: " + productId +
                " - " + productName +
                " - " + action +
                " - " + description ;
    }
}
