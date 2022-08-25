package controller;

import model.Product;
import service.ProductService;
import validate.Validate;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    static ProductService service=new ProductService();
    static Scanner scanner=new Scanner(System.in);
    static ArrayList<Product> products=service.getAllProduct();

    public static void menu(){
        System.out.println("--------------------------------");
        System.out.println("1 - In thông tin toàn bộ sản phẩm");
        System.out.println("2 - In thông tin dựa theo danh mục");
        System.out.println("3 - In thông tin dựa theo hãng");
        System.out.println("4 - In thông tin dựa theo mức giá");
        System.out.println("5 - Tìm sản phẩm theo tên");
        System.out.println("6 - Xem số sản phẩm theo danh mục");
        System.out.println("0 - Thoát chương trình");
        System.out.println("Lựa chọn của bạn là");
    }

    public static void program(){
        boolean isContinue=true;
        while (isContinue){
            menu();
            int choice= Validate.inputNumber();
            switch (choice){
                case 1:
                    service.show(products);
                    break;
                case 2:
                    service.sortCategory(products);
                    break;
                case 3:
                    ArrayList<String> brands=service.getAllBrand(products);
                    service.showAllBrand(brands);
                    String brand=service.chooseBrand(brands);
                    service.sortBrand(products,brand);
                    break;
                case 4:
                    priceProgram();
                    break;
                case 5:
                    System.out.println("Nhập tên sản phẩm cần tìm kiếm");
                    String name= scanner.nextLine();
                    service.searchByName(products, name);
                    break;
                case 6:
                    service.countCategory(products);
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

    public static void priceProgram(){
        System.out.println("Lựa chọn mức giá");
        System.out.println("1 - Dưới 2 triệu");
        System.out.println("2 - Từ 2 - 4 triệu");
        System.out.println("3 - Từ 4 - 7 triệu");
        System.out.println("4 - Từ 7 - 13 triệu");
        System.out.println("5 - Trên 13 triệu");
        System.out.println("Lựa chọn của bạn là");
        boolean isContinue=true;
        while (isContinue){
            int choice= Validate.inputNumber();
            switch (choice){
                case 1:
                    service.sortPrice(0,2000000,products);
                    isContinue=false;
                    break;
                case 2:
                    service.sortPrice(2000000,4000000,products);
                    isContinue=false;
                    break;
                case 3:
                    service.sortPrice(4000000,7000000,products);
                    isContinue=false;
                    break;
                case 4:
                    service.sortPrice(7000000,13000000,products);
                    isContinue=false;
                    break;
                case 5:
                    service.sortPrice(13000000,1000000000,products);
                    isContinue=false;
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
            }
        }

    }

}
