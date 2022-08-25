import Model.Book;
import service.BookService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        BookService service=new BookService();
        ArrayList<Book> books=service.getAllBook();
        service.show(books);

        System.out.println("Danh sách cần tìm");
        service.searchByName(books,"phèo");

//        System.out.println("Danh sách sau khi đổi chí phèo thành vợ nhặt");
//        service.switchName(books,"chí phèo","Vợ Nhặt");
//        service.show(books);

        Book updateBook=service.searchById(books,2);
        System.out.println("Sách sau khi dổi tên");
        service.updateBook(updateBook,"Vợ Nhặt");

        System.out.println("Danh sách sau khi cập nhật");
        service.show(books);


        System.out.println("Danh sách sau khi xóa");
        service.removeBook(books,2);
        service.show(books);

        System.out.println("Thêm sách mới");
        Book newBook=service.createNewBook();
        service.addNewBook(newBook,books);

        System.out.println("Danh sách sau khi thêm: ");
        service.show(books);






    }
}
