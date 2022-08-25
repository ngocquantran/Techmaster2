package control;

import model.*;
import service.AccountService;
import service.CustomerService;
import service.Data;
import service.ProductService;
import util.Util;
import util.Validate;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    static Scanner scanner=new Scanner(System.in);
    static ProductService productService=new ProductService();
    static CustomerService customerService=new CustomerService();
    static AccountService accountService=new AccountService();
    static Data data=new Data();
    static ArrayList<Product> products=data.getAllProduct();
    static ArrayList<Customer> customers=data.getAllCustomer();
    static ArrayList<Account> accounts=data.getAllAccount();
    static Account activeAccount=new Account("","","",AccountRole.Visitor,"");
    static ArrayList<ShoppingCart> shoppingCarts=new ArrayList<>();
    static ArrayList<PurchaseHistory> purchaseHistories=new ArrayList<>();
    static ArrayList<ActionHistory> actionHistories=new ArrayList<>();




    public static void popup(){
        System.out.println("---------------------------------------");
        System.out.println("CHÀO MỪNG BẠN ĐẾN VỚI CỬA HÀNG THẾ GIỚI SỮA");
        System.out.println("1 - Tham quan cửa hàng");
        System.out.println("2 - Đăng nhập");
        System.out.println("3 - Đăng ký");
        System.out.println("0 - Thoát chương trình");
        System.out.println("Lựa chọn của bạn là");

    }

    public static void productTypeMenu(){
        System.out.println("---------------------------------------");
        System.out.println("Gian hàng sữa: ");
        System.out.println("1 - Sữa bột các loại");
        System.out.println("2 - Sữa nước các loại");
        System.out.println("3 - Sữa chua uống liền");
        System.out.println("4 - Tìm sản phẩm");
        if (activeAccount.getRole()==AccountRole.Visitor || activeAccount.getRole()==AccountRole.Customer){
            System.out.println("5 - Chọn sản phẩm");
        }
        System.out.println("0 - Trở về");
        System.out.println("Lựa chọn của bạn là");
    }

    public static void optinalViewMenu(){
        System.out.println("---------------------------------------");
        System.out.println("1 - Xem toàn bộ sản phẩm");
        System.out.println("2 - Xem theo thương hiệu");
        System.out.println("3 - Xem theo nơi sản xuất");
        System.out.println("4 - Sắp xếp theo giá tăng dần");
        System.out.println("5 - Sắp xếp theo giá giảm dần");
        System.out.println("6 - Sắp xếp theo mặt hàng bán chạy");
        if (activeAccount.getRole()==AccountRole.Visitor || activeAccount.getRole()==AccountRole.Customer){
            System.out.println("7 - Chọn sản phẩm");

        }
        System.out.println("0 - Trở về");
        System.out.println("Lựa chọn của bạn là");
    }

    public static void program(){
        boolean isContinue=true;
        while (isContinue){
            popup();
            int choice= Validate.inputNumber();
            switch (choice){
                case 1:
                    productTypeProgram();
                    break;
                case 2:
                    System.out.println("Nhập số điện thoại");
                    String phoneNumber= scanner.nextLine();
                    System.out.println("Nhập password");
                    String password= scanner.nextLine();
                    int found=0;
                    for (Account a:accounts){
                        if (a.getPhoneNumber().equals(phoneNumber) && a.getPassword().equals(password)) {
                            found++;
                        }
                    }
                    if (found>0){
                        isContinue=false;
                        activeAccount=accountService.getAccountFromPhoneNumber(accounts,phoneNumber);
                        userProgram();
                    }
                    else {
                        System.out.println("Số điện thoại hoặc mật khẩu không đúng");
                        forgetPasswordProgram();
                    }
                    break;
                case 3:
                    Customer newCustomer=accountService.signupCustomer(accounts,customers);
                    System.out.println("Đăng kí thành công");
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Hẹn gặp lại");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;
            }
        }
    }

    public static void userProgram(){
        System.out.println("Xin chào "+activeAccount.getRole()+" "+activeAccount.getName());
        if (activeAccount.getRole()==AccountRole.Customer){
            CustomerController.customerProgram();
        }else {
            StaffController.staffProgram();
        }

    }

    public static void productTypeProgram(){
        boolean isContinue=true;
        while (isContinue){
            productTypeMenu();
            ProductCategory category;
            ArrayList<Product> productsByCategory;
            int choice=Validate.inputNumber();
            switch (choice){
                case 1:
                    category=productService.chooseCategory(1);
                    productsByCategory= productService.searchByCategory(products,category);
                    optionalViewProgram(productsByCategory);
                    break;
                case 2:
                    category=productService.chooseCategory(2);
                    productsByCategory= productService.searchByCategory(products,category);
                    optionalViewProgram(productsByCategory);
                    break;
                case 3:
                    category=productService.chooseCategory(3);
                    productsByCategory= productService.searchByCategory(products,category);
                    optionalViewProgram(productsByCategory);
                    break;
                case 4:
                    searchProductProgram();
                    break;
                case 5:
                    if (activeAccount.getRole()==AccountRole.Visitor || activeAccount.getRole()==AccountRole.Customer){
                        selectProduct();
                    }else {
                        System.out.println("Không có lựa chọn này");
                    }
                    break;
                case 0:
                    if ( activeAccount.getRole()==AccountRole.Customer){
                        CustomerController.customerProgram();
                    }
                    else if((activeAccount.getRole()==AccountRole.Admin) || activeAccount.getRole()==AccountRole.Staff){
                        StaffController.staffProgram();
                    }
                    program();
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;
            }

        }
    }

    public static void optionalViewProgram(ArrayList<Product> productsByCategory){
        boolean isContinue=true;
        while (isContinue){
            optinalViewMenu();
            int choice=Validate.inputNumber();
            switch (choice){
                case 1:
                    if (activeAccount.getRole()==AccountRole.Staff || activeAccount.getRole()==AccountRole.Admin){
                        productService.showArraylist(productsByCategory);
                    }else {
                        productService.showProductForCustomer(productsByCategory);
                    }
                    break;
                case 2:
                    ArrayList<String> brands=productService.getBrands(productsByCategory);
                    productService.showAllListWithNumber(brands);
                    System.out.println("Vui lòng chọn thương hiệu cần xem");
                    String brand=productService.chooseFromList(brands);
                    ArrayList<Product> productsByBrand=productService.searchByBrand(productsByCategory, brand);

                    if (activeAccount.getRole()==AccountRole.Staff || activeAccount.getRole()==AccountRole.Admin){
                        productService.showArraylist(productsByBrand);
                    }else {
                        productService.showProductForCustomer(productsByBrand);
                    }

                    break;
                case 3:
                    ArrayList<String> origins=productService.getOrigins(productsByCategory);
                    productService.showAllListWithNumber(origins);
                    System.out.println("Vui lòng chọn xuất xứ cần xem");
                    String origin=productService.chooseFromList(origins);
                    ArrayList<Product> productsByOrigin=productService.searchByOrigin(productsByCategory, origin);

                    if (activeAccount.getRole()==AccountRole.Staff || activeAccount.getRole()==AccountRole.Admin){
                        productService.showArraylist(productsByOrigin);
                    }else {
                        productService.showProductForCustomer(productsByOrigin);
                    }
                    break;
                case 4:
                    productService.sortUpPrice(productsByCategory);

                    if (activeAccount.getRole()==AccountRole.Staff || activeAccount.getRole()==AccountRole.Admin){
                        productService.showArraylist(productsByCategory);
                    }else {
                        productService.showProductForCustomer(productsByCategory);
                    }
                    break;
                case 5:
                    productService.sortDownPrice(productsByCategory);
                    if (activeAccount.getRole()==AccountRole.Staff || activeAccount.getRole()==AccountRole.Admin){
                        productService.showArraylist(productsByCategory);
                    }else {
                        productService.showProductForCustomer(productsByCategory);
                    }
                    break;
                case 6:
                    productService.sortDownSellingRate(productsByCategory);
                    if (activeAccount.getRole()==AccountRole.Staff || activeAccount.getRole()==AccountRole.Admin){
                        productService.showArraylist(productsByCategory);
                    }else {
                        productService.showProductForCustomer(productsByCategory);
                    }
                    break;
                case 7:
                    if (activeAccount.getRole()==AccountRole.Visitor || activeAccount.getRole()==AccountRole.Customer){
                        selectProduct();
                    }else {
                        System.out.println("Không có lựa chọn này");
                    }
                    isContinue=false;
                    break;
                case 0:
                    productTypeProgram();
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;
            }
        }
    }

    public static void searchProductMenu(){
        System.out.println("---------------------------------------");
        System.out.println("1 - Tìm theo tên");
        System.out.println("2 - Tìm theo id sản phẩm");
        System.out.println("0 - Trở về");
        System.out.println("Lựa chọn của bạn là");
    }
    public static void searchProductProgram(){
        boolean isContinue=true;
        while (isContinue){
            searchProductMenu();
            int choice=Validate.inputNumber();
            switch (choice){
                case 1:
                    System.out.println("Nhập tên sản phầm cần tìm");
                    String name= scanner.nextLine();
                    int found=0;
                    for (Product p:products){
                        if (p.getName().toLowerCase().contains(name.toLowerCase().trim())){
                            if (activeAccount.getRole()==AccountRole.Visitor || activeAccount.getRole()==AccountRole.Customer){
                                productService.showOneProductForCustomer(p);
                            }
                            else {
                                System.out.println(p);
                            }
                            found++;
                        }
                    }
                    if (found<1){
                        System.out.println("Không có kết quả");
                    }
                    isContinue=false;
                    break;
                case 2:
                    System.out.println("Nhập id sản phẩm cần tìm");
                    String id= scanner.nextLine();
                    int found2=0;
                    for (Product p:products){
                        if (p.getId().equals(id)){
                            if (activeAccount.getRole()==AccountRole.Visitor || activeAccount.getRole()==AccountRole.Customer){
                                productService.showOneProductForCustomer(p);
                            }
                            else {
                                System.out.println(p);
                            }
                            found2++;
                        }
                    }
                    if (found2<1){
                        System.out.println("Không có kết quả");
                    }
                    isContinue=false;
                    break;
                case 0:
                    isContinue=false;
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;
            }
        }
    }





    public static void addToCart(Product product,ArrayList<ShoppingCart> carts){

        boolean isContinue=true;
        while (isContinue){
            System.out.println("---------------------------------------");
            System.out.println("1 - Thêm sản phẩm vào giỏ hàng");
            System.out.println("0 - Trở về");
            System.out.println("Lựa chọn của bạn là");
            int choice=Validate.inputNumber();
            switch (choice){
                case 1:
                    if (activeAccount.getId().equals("")){
                        System.out.println("Bạn cần đăng nhập để mua hàng");
                    }
                    else {
                        if (product.getQuantity()==0){
                            System.out.println("Sản phẩm đã hết hàng, vui lòng quay lại sau");
                        }
                        else {
                            if (productService.isProductInCart(product,Controller.activeAccount,carts)){
                                System.out.println("Sản phẩm đã có trong giỏ hàng");
                            }
                            else {
                                System.out.println("Nhập số lượng sản phẩm");
                                int quantity=Validate.inputInLimit(1,product.getQuantity());
                                ShoppingCart newCart=new ShoppingCart(activeAccount.getId(),product.getName(), product.getId(), quantity,product.getPrice()*quantity);
                                shoppingCarts.add(newCart);
                                ArrayList<ShoppingCart> currentCart=customerService.getCurrentCart(Controller.activeAccount,Controller.shoppingCarts);
                                System.out.println("Giỏ hàng của bạn:");
                                productService.showArraylist(currentCart);
                                customerService.getSumOfCart(currentCart);
//                        productService.showArraylist(customerService.getCurrentCart(activeAccount,shoppingCarts));
//                        customerService.getSumOfCart(customerService.getCurrentCart(activeAccount,shoppingCarts));
                            }
                        }
                    }
                    isContinue=false;
                    productTypeProgram();
                    break;
                case 0:
                    isContinue=false;
                    productTypeProgram();
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;

            }
        }

    }

    public static void selectProduct(){
        System.out.println("Nhập id sản phẩm");
        String id= scanner.nextLine().trim();
        if (!Validate.duplicateProductId(products,id)){
            System.out.println("Không có sản phẩm này");
            System.out.println("Vui lòng tham quan lại gian hàng");

        }else {
            Product product=productService.searchProductId(products,id);
            System.out.println(
                    product.getId()+" - "
                            + product.getProductCategory()+" - "
                            + product.getName()+" - "
                            + product.getBrand()+" - "
                            + product.getOrigin()+" - "
                            + Util.moneyFormat(product.getPrice())+" VND"
            );
            addToCart(product,Controller.shoppingCarts);
        }
    }

    public static void forgetPasswordMenu(){
        System.out.println("1 - Quên mật khẩu");
        System.out.println("2 - Đăng nhập lại");
        System.out.println("Lựa chọn của bạn là");
    }
    public static void forgetPasswordProgram(){
        boolean isContinue=true;
        while (isContinue){
            forgetPasswordMenu();
            int choice=Validate.inputNumber();
            switch (choice){
                case 1:
                    System.out.println("Nhập email của bạn");
                    String emailCheck= scanner.nextLine();
                    int found=0;
                    for (Customer c:Controller.customers){
                        if (c.getEmail().equals(emailCheck)){
                            found++;
                            break;
                        }
                    }
                    if (found>0){
                        System.out.println("Nhập mật khẩu mới");
                        String newPassword=accountService.passwordInput();
                        String customerId=customerService.getCustomerIdFromEmail(emailCheck,Controller.customers);
                        for (Account a:Controller.accounts){
                            if (a.getId().equals(customerId)){
                                a.setPassword(newPassword);
                            }
                        }
                        System.out.println("Cập nhật mật khẩu thành công");
                    }
                    else {
                        System.out.println("Email không đúng");
                    }
                    isContinue=false;
                    break;
                case 2:
                    isContinue=false;
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;
            }
        }
    }

//    public static void viewExpMenu(){
//        System.out.println("1 - Sản phẩm đã hết hạn");
//        System.out.println("2 - Sản phẩm sẽ hết hạn trong 30 ngày");
//        System.out.println("3 - Sản phẩm sẽ hết hạn trong 60 ngày");
//        System.out.println("Lựa chọn của bạn là");
//
//    }
//
//    public static void viewExpProgram(){
//        boolean isContinue=true;
//        while (isContinue){
//            viewExpMenu();
//            LocalDate today=LocalDate.now();
//            int choice=Validate.inputNumber();
//            switch (choice){
//                case 1:
//                    products.stream().filter(product -> product.getMfg()+product.getExp()*30-today<=0)
//
//            }
//        }
//    }
}



