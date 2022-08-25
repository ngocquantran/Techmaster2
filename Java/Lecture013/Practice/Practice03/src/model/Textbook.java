package model;

import model.Document;

public class Textbook extends Document {
    private int publishingYear;
    private int quantity;
    private int page;
    private String author;

    public Textbook(String id, String name, String category, String publisher, int publishingYear, int quantity, int page, String author) {
        super(id, name, category, publisher);
        this.publishingYear = publishingYear;
        this.quantity = quantity;
        this.page = page;
        this.author = author;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return super.toString() +" - "+ publishingYear +
                " - " + quantity +
                " - " + page +
                " - " + author ;
    }
}
