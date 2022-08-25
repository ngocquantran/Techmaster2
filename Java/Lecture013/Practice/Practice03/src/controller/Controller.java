package controller;

import model.Document;
import model.Ebook;
import model.Newspaper;
import model.Textbook;
import service.DocumentService;
import util.Validate;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    static Scanner scanner=new Scanner(System.in);
    static DocumentService service=new DocumentService();
    static ArrayList<Textbook> textbooks=service.getAllTextbook();
    static ArrayList<Newspaper> newspapers=service.getAllNewspaper();
    static ArrayList<Ebook> ebooks=service.getAllEbook();
    static ArrayList<Document> documents=service.getAllDocument();

    public static void menu(){
        System.out.println("---------------------------------");
        System.out.println("1 - Xem danh sách tài liệu");
        System.out.println("2 - Tìm tài liệu theo tên");
        System.out.println("3 - Tìm tài liệu theo thể loại");
        System.out.println("4 - Xem model.Ebook có lượt tải nhiều nhất");
        System.out.println("5 - Xem báo phát hành trong năm nay");
        System.out.println("0 - Thoát chương trình");
        System.out.println("Lựa chọn của bạn là");
    }
    public static void submenu(){
        System.out.println("---------------------------------");
        System.out.println("1 - Sách giáo khoa");
        System.out.println("2 - Báo");
        System.out.println("3 - model.Ebook");
        System.out.println("Lựa chọn của bạn là");
    }

    public static void program(){
        boolean isContinue=true;
        while (isContinue){
            menu();
            int choice= Validate.inputNumber();
            switch (choice){
                case 1:
                    subprogram();
                    break;
                case 2:
                    System.out.println("Nhập tên tài liệu cần tìm");
                    String name= scanner.nextLine();
                    service.searchByName(documents,name);
                    break;
                case 3:
                    System.out.println("Nhập thể loại cần tìm");
                    String category= scanner.nextLine();
                    service.searchByCategory(documents,category);
                    break;
                case 4:
                    System.out.println("model.Ebook có lượt tải nhiều nhất là");
                    service.getMaxDownloadEbook(ebooks);
                    break;
                case 5:
                    System.out.println("Các báo phát hành trong năm nay là");
                    service.getCurrentYearNewspaper(newspapers);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;
            }

        }
    }

    public static void subprogram(){
        submenu();
        int choice= Validate.inputNumber();
        switch (choice){
            case 1:
                service.show(textbooks);
                break;
            case 2:
                service.show(newspapers);
                break;
            case 3:
                service.show(ebooks);
                break;
            default:
                System.out.println("Không có lựa chọn này");
                break;
        }
    }
}
