package model;

import model.Document;

public class Ebook extends Document {
    private int publishingYear;
    private int size;
    private String picture;
    private int download;

    public Ebook(String id, String name, String category, String publisher, int publishingYear, int size, String picture, int download) {
        super(id, name, category, publisher);
        this.publishingYear = publishingYear;
        this.size = size;
        this.picture = picture;
        this.download = download;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getDownload() {
        return download;
    }

    public void setDownload(int download) {
        this.download = download;
    }

    @Override
    public String toString() {
        return super.toString() +" - "+ publishingYear +
                " - " + size +
                " - " + picture  +
                " - " + download ;
    }
}
