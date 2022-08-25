package model;

public class Document {
    private  String id;
    private String name;
    private String category;
    private String publisher;

    public Document(String id, String name, String category, String publisher) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.publisher = publisher;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return id+" - "+name+" - "+category+" - "+publisher;
    }
}
