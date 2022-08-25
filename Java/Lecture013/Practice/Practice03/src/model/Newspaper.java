package model;

import model.Document;
import util.Util;

import java.time.LocalDate;

public class Newspaper extends Document {
    private LocalDate publishingDate;
    private int quantity;
    private int page;

    public Newspaper(String id, String name, String category, String publisher, LocalDate publishingDate, int quantity, int page) {
        super(id, name, category, publisher);
        this.publishingDate = publishingDate;
        this.quantity = quantity;
        this.page = page;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return super.toString() +" - "+ Util.formatDate(publishingDate) +
                " - " + quantity +
                " - " + page;
    }
}
