public class Main {
    public static void main(String[] args) {
        BookService.getAllBook();

        System.out.println("Sách có thể loại phiêu lưu là");
        BookService.searchBook(BookService.getAllBook(),"Phiêu lưu");

    }
}
