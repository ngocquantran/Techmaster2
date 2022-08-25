public class SchoolBook extends Library{
    private int numberOfPage;
    private String status;
    private int numberOfBorrow;

    public SchoolBook(int id, String name, String publisher, int publishingYear, int quantity, int numberOfPage, String status, int numberOfBorrow) {
        super(id, name, publisher, publishingYear, quantity);
        this.numberOfPage = numberOfPage;
        this.status = status;
        this.numberOfBorrow = numberOfBorrow;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumberOfBorrow() {
        return numberOfBorrow;
    }

    public void setNumberOfBorrow(int numberOfBorrow) {
        this.numberOfBorrow = numberOfBorrow;
    }

    @Override
    public String toString() {
        return super.toString()+numberOfPage+" - "+status+" - "+numberOfBorrow;
    }


}
