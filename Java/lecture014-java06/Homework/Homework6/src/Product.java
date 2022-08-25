public class Product {
    public int id;
    public String name;
    public int quantity;
    public ProductUnit unit;
    public int purchasePrice;
    public int sellingPrice;
    public int sellingQty;

    public Product(int id, String name, int quantity, ProductUnit unit, int purchasePrice, int sellingPrice, int sellingQty) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.sellingQty = sellingQty;
    }

    @Override
    public String toString() {
        return id+" - "+name+" - "+quantity+" - "+unit+" - "+purchasePrice +" - "+sellingPrice +" - " + sellingQty;

    }
}
