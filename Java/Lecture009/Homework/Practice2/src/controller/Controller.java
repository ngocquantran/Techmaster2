package controller;

import model.Product;
import model.ProductType;
import service.ProductService;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    static Scanner scanner=new Scanner(System.in);
    static ProductService service=new ProductService();
    static ArrayList<Product> products=service.getAllProduct();

    public static void menu(){
        System.out.println("--------------------------------");
        System.out.println("1 - Xem toàn bộ danh sách");
        System.out.println("2 - Tìm sản phẩm theo tên");
        System.out.println("3 - Liệt kê sản phẩm theo loại mặt hàng");
        System.out.println("4 - Tìm sản phẩm theo id");
        System.out.println("5 - Thêm một sản phẩm");
        System.out.println("0 - Thoát chương trình");
        System.out.println("Lựa chọn của bạn là: ");
    }

    public static void submenu(){
        System.out.println("--------------------------------");
        System.out.println("1 - Cập nhật tên sản phẩm và giá sản phẩm");
        System.out.println("2 - Xóa sản phẩm");
        System.out.println("3 - Quay về màn hình chính");
        System.out.println("Lựa chọn của bạn là: ");

    }

    public static void mainMenu(){
        boolean isContinue=true;
        while (isContinue){
            menu();
            int choice=Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Danh sách toàn bộ sản phẩm: ");
                    service.show(products);
                    break;
                case 2:
                    System.out.println("Nhập tên sản phẩm bạn muốn tìm");
                    String searchName= scanner.nextLine();

                    service.searchByName(products,searchName);
                    break;
                case 3:
                    ProductType productType= ProductService.getInputType();
                    System.out.println("Danh sách lọc theo loại "+productType.getValue()+" là:");
                    service.sortByType(products,productType);
                    break;
                case 4:
                    searchById();
                    break;

                case 5:
                    Product product=service.createProduct();
                    service.addProduct(product,products);
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
    public static void searchById(){

        int id=1;
        int found=0;
        while (found==0){
            System.out.println("Nhập id của sản phẩm");
            id=Integer.parseInt(scanner.nextLine());
            for (Product p:products){
                if (p.getId()==id){
                    found++;
                }
            }
            if (found==0){
                System.out.println("Không có sản phẩm này");
                mainMenu();
            }
        }

        Product product=service.searchById(products,id);
        System.out.println(product);

        boolean isContinue=true;
        while (isContinue){
            submenu();
            int choice=Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Nhập tên sản phẩm mới");
                    String newName= scanner.nextLine();
                    System.out.println("Nhập giá sản phẩm mới");
                    long newPrice= scanner.nextLong();
                    service.updateNameAndPrice(product,newName,newPrice);
                    System.out.println("Danh sách sau khi cập nhật");
                    service.show(products);
                    isContinue=false;
                    break;
                case 2:
                    System.out.println("Danh sách sau khi xóa");
                    service.removeProduct(products,product);
                    service.show(products);
                    isContinue=false;
                    break;
                case 3:

                    isContinue=false;
                    break;
                default:
                    System.out.println("Không có lựa chọn này, vui lòng chọn lại");
                    break;
            }

        }



    }


}
