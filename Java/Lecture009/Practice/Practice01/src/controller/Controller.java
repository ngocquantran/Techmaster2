package controller;

import Model.Book;
import service.BookService;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Controller {

    static Scanner scanner=new Scanner(System.in);
    static BookService service=new BookService();

    static ArrayList<Book> books=new ArrayList<>();

    public static void menu(){

        System.out.println("--------------------------------------");
        System.out.println("1 - Xem danh sách toàn bộ sách");
        System.out.println("2 - Thêm 1 quyển vào danh sách");
        System.out.println("3 - Tìm sách theo tên");
        System.out.println("4 - Tìm sách theo id");
        System.out.println("0 - Thoát chương trình");

        System.out.println("Lựa chọn của bạn là");


    }

    public static void mainMenu(){
        boolean isContinue=true;
        while (isContinue){
            menu();
            int choice=Integer.parseInt(scanner.nextLine());
            switch ((choice)){
                case 1:
                    System.out.println("Danh sách:");
                    service.show(books);
                    break;
                case 2:
                    System.out.println("Thêm quyển sách");
                    Book newBook=service.createNewBook();
                    service.addNewBook(newBook,books);
                    break;
                case 3:
                    System.out.println("Nhập tên quyển sách bạn muốn tìm");
                    String title= scanner.nextLine();
                    service.searchByName(books,title);
                    break;
                case 4:
            }
        }
    }
}
