import control.Controller;
import model.Account;
import model.Customer;
import model.Product;
import model.PurchaseHistory;
import service.AccountService;
import service.CustomerService;
import service.Data;
import service.ProductService;
import util.Util;
import util.Validate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        ProductService productService=new ProductService();
//         CustomerService customerService=new CustomerService();
//         AccountService accountService=new AccountService();
//         Data data=new Data();
//         ArrayList<Product> products=data.getAllProduct();
//
//         ArrayList<Customer> customers=data.getAllCustomer();
//         ArrayList<Account> accounts=data.getAllAccount();
////        service.showArraylist(products);

//        Scanner scanner=new Scanner(System.in);
//        System.out.println("Nhập tên cần tìm");
//        String name= scanner.nextLine();
//        ArrayList<model.Product> productsByName=service.searchByName(products,name);
//        service.showArraylist(productsByName);

//        ArrayList<String> brands=service.getBrands(products);
//        System.out.println("Các thương hiệu là: ");
//        service.showAllListWithNumber(brands);
//        System.out.println("Vui lòng nhập lựa chọn của bạn");
//        String brand=service.chooseFromList(brands);
//        ArrayList<model.Product> productsByBrand=service.searchByBrand(products, brand);
//        service.showArraylist(productsByBrand);

//        ArrayList<String> origins=service.getOrigins(products);
//        System.out.println("Các xuất xứ là: ");
//        service.showAllListWithNumber(origins);
//        System.out.println("Vui lòng nhập lựa chọn của bạn");
//        String origin=service.chooseFromList(origins);
//        ArrayList<model.Product> productsByOrigin=service.searchByOrigin(products, origin);
//        service.showArraylist(productsByOrigin);


//        service.sortDownPrice(products);
//        service.sortDownSellingRate(products);
//        service.showArraylist(products);

//        System.out.println("Danh mục loại sữa");
//        service.showCategory();
//        System.out.println("Lựa chọn của bạn là");
//        model.ProductCategory category=service.chooseCategory();
//        ArrayList<model.Product> productsByCategory= service.searchByCategory(products,category);
//        service.showArraylist(productsByCategory);
        Controller.program();

//        productService.showArraylist(customers);
//
//        Customer newCustomer=accountService.signupCustomer(accounts,customers);
//        System.out.println();
//        System.out.println("Helloooo");
//        System.out.println();
//
//        productService.showArraylist(accounts);










    }


}
