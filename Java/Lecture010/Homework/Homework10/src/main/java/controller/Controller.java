package controller;


import model.Movie;
import service.MovieService;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    static Scanner scanner=new Scanner(System.in);
    static MovieService service=new MovieService();
    static ArrayList<Movie> movies=service.getAllMovie();

    public static void menu(){
        System.out.println("------------------------------------------------------");
        System.out.println("1 - Xem toàn bộ danh sách phim ");
        System.out.println("2 - Sắp xếp phim theo năm xuất bản ");
        System.out.println("3 - Sắp xếp phim theo tên ");
        System.out.println("4 - Tìm phim theo tên ");
        System.out.println("5 - Lấy ra 3 phim có lượt xem cao nhất ");
        System.out.println("6 - Tìm phim theo thể loại ");
        System.out.println("0 - Thoát chương trình ");
        System.out.println("Lựa chọn của bạn là");
    }
    public static void mainMenu(){
        boolean isContinue=true;
        while (isContinue){
            menu();
            int choice=Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    service.getAllMovie();
                    service.show(movies);
                    break;
                case 2:
                    service.sortYear(movies);
                    System.out.println("Danh sách phim sắp xếp theo năm xuất bản");
                    service.show(movies);
                    break;
                case 3:
                    service.sortTitle(movies);
                    System.out.println("Danh sách phim sắp xếp theo tên");
                    service.show(movies);
                    break;
                case 4:
                    System.out.println("Nhập tên phim cần tìm");
                    String title= scanner.nextLine();
                    service.searchTitle(movies,title);
                    break;
                case 5:
                    service.sortViewDown(movies);
                    System.out.println("Ba phim có lượt xem cao nhất là");
                    for (int i=0;i<=2;i++){
                        System.out.println(movies.get(i));
                    }
                    break;
                case 6:
                    System.out.println("Nhập thể loại phim cần tìm");
                    String category= scanner.nextLine();
                    service.searchCategory(movies,category);
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
}
