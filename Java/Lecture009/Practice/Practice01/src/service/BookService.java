package service;

import Model.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookService {

    public ArrayList<Book> getAllBook(){
        ArrayList<Book> books=new ArrayList<>();
        books.add(new Book(1,"Nam Cao","Chí Phèo","Truyện ngắn"));
        books.add(new Book(2,"Tony","Cuốn theo chiều gió","tiểu thuyết"));
        books.add(new Book(3,"Nguyên Vũ","Quốc Gia Khởi Nghiệp","selfhelp"));
        return books;
    }

    public void show(ArrayList<Book> books){
        for (Book n:books){
            System.out.println(n);
        }
    }

    public void searchByName(ArrayList<Book> books,String SearchedTitle){

        for (Book b:books){
            if (b.getTitle().toLowerCase().contains(SearchedTitle)){
                System.out.println(b);
            }
        }
    }

//    public void switchName(ArrayList<Model.Book> books,String oldName,String newName){
//        for (Model.Book b:books){
//            if (b.getTitle().toLowerCase().contains(oldName)){
//
//                b.setTitle(newName);
//            }
//        }
//    }

    public Book searchById(ArrayList<Book> books, int id){
        for (Book b:books){
            if (b.getId()==id) {
                return b;
            }
        }
        return null;
    }

    public void updateBook(Book book,String newTitle){
        book.setTitle(newTitle);
        System.out.println(book);
    }

    public void removeBook(ArrayList<Book> books, int id){
        for (Book b:books){
            if (b.getId()==id){
                books.remove(b);
            }

        }
    }

    public Book createNewBook(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập id sách");
        int id=Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên tác giả");
        String author=scanner.nextLine();
        System.out.println("Nhập tên sách");
        String title=scanner.nextLine();
        System.out.println("Nhập thể loại sách");
        String gender= scanner.nextLine();

        Book newBook=new Book(id,author,title,gender);
        return newBook;
    }

    public void addNewBook(Book book,ArrayList<Book> books){
        books.add(book);
    }


}
