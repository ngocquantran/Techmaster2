public class BookService {
    SchoolBook book;

    public int getRemaining(SchoolBook book){

        return book.getQuantity()- book.getNumberOfBorrow();
    }

}
