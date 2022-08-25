package control;

import model.*;
import service.CustomerService;
import service.ProductService;
import util.Util;
import util.Validate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formattable;
import java.util.Scanner;

public class CustomerController {
    static Scanner scanner=new Scanner(System.in);
    static CustomerService customerService=new CustomerService();
    static ProductService productService=new ProductService();
    public static void customerMenu(){
        System.out.println("--------------------------------");
        System.out.println("1 - Tham quan cửa hàng");
        System.out.println("2 - Xem giỏ hàng");
        System.out.println("3 - Xem lịch sử mua hàng");
        System.out.println("4 - Xem thông tin cá nhân");
        System.out.println("0 - Đăng xuất");
        System.out.println("Lựa chọn của bạn là");
    }

    public static void customerProgram(){
        boolean isContinue=true;
        while (isContinue){
            customerMenu();
            int choice= Validate.inputNumber();
            switch (choice){
                case 1:
                    Controller.productTypeProgram();
                    break;
                case 2:
                    System.out.println("Giỏ hàng của bạn");
                    ArrayList<ShoppingCart> currentCart=customerService.getCurrentCart(Controller.activeAccount,Controller.shoppingCarts);
                    if (currentCart.size()==0){
                        System.out.println("Chưa có sản phẩm trong giỏ hàng");
                    }
                    else {
                        productService.showArraylist(currentCart);
                        customerService.getSumOfCart(currentCart);
                        cartProgram();
                    }
                    break;

                case 3:

                    System.out.println("Lịch sử mua hàng:");

                    Controller.purchaseHistories.stream().filter(p -> p.getCustomerId().equals(Controller.activeAccount.getId()))
                            .forEach(p -> System.out.println(
                                    Util.FormatDate(p.getDate()) +
                                    " - " + p.getItemName()  +
                                    " - " +"SL: "+ p.getQuantity() +
                                    " - " + Util.moneyFormat(p.getPrice())+" VND"));

                    break;
                case 4:
                    System.out.println("Thông tin cá nhân");
                    System.out.println(Controller.accountService.getCustomerFromAccount(Controller.activeAccount,Controller.customers));
                    personalInfoProgram();
                    break;

                case 0:
                    Controller.activeAccount=new Account("","","",AccountRole.Visitor,"");
                    Controller.program();
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;
            }
        }
    }

    public static void cartMenu(){
        System.out.println("--------------------------------");
        System.out.println("1 - Điều chỉnh giỏ hàng");
        System.out.println("2 - Đặt hàng");
        System.out.println("0 - Trở về");
        System.out.println("Lựa chọn của bạn là");
    }
    public static void cartProgram(){
        boolean isContinue=true;
        while (isContinue){
            cartMenu();
            int choice=Validate.inputNumber();
            switch (choice){
                case 1:
                    System.out.println("Nhập id sản phẩm trong giỏ hàng cần sửa");

                    String id=productService.searchProductIdInCart(Controller.shoppingCarts).trim();
                    Product product=productService.searchProductId(Controller.products,id);
                    System.out.println("Nhập số lượng mới");
                    int quantity=Validate.inputInLimit(0,product.getQuantity());
                    for (ShoppingCart s:Controller.shoppingCarts){
                        if (s.getCustomerId().equals(Controller.activeAccount.getId())  &&  s.getItemId().equals(id)){
                            s.setQuantity(quantity);
                            s.setPrice(quantity*product.getPrice());
                        }
                    }

                    for (int i=0;i<Controller.shoppingCarts.size();i++){
                        if (Controller.shoppingCarts.get(i).getQuantity()==0){
                            Controller.shoppingCarts.remove(i);
                        }
                    }

                    System.out.println("Giỏ hàng sau khi cập nhật");
                    productService.showArraylist(customerService.getCurrentCart(Controller.activeAccount,Controller.shoppingCarts));
                    customerService.getSumOfCart(customerService.getCurrentCart(Controller.activeAccount,Controller.shoppingCarts));
                    isContinue=false;
                    break;
                case 2:
                        boolean repeat=true;
                        String purchaseCode="";
                        while (repeat){
                            purchaseCode= Util.randomPurchaseCode();
                            int found=0;
                            for (PurchaseHistory p:Controller.purchaseHistories){
                                if (p.getPurchaseCode().equals(purchaseCode)){
                                    found++;
                                }
                            }
                            if (found<1){
                                repeat=false;
                            }
                        }

                        LocalDate date=LocalDate.now();
                        ArrayList<ShoppingCart> currentCarts=customerService.getCurrentCart(Controller.activeAccount,Controller.shoppingCarts);
                        for (int i=0;i<(Controller.shoppingCarts.size());i++){
                            if (currentCarts.contains(Controller.shoppingCarts.get(i))){
                                Controller.purchaseHistories.add(new PurchaseHistory(purchaseCode,Controller.activeAccount.getId(),Controller.activeAccount.getName(),Controller.activeAccount.getPhoneNumber(),date,Controller.shoppingCarts.get(i).getItemName(),Controller.shoppingCarts.get(i).getItemId(),Controller.shoppingCarts.get(i).getQuantity(),Controller.shoppingCarts.get(i).getPrice()));
                            }
                        }

                    for (ShoppingCart p:currentCarts){
                        for (Product c:Controller.products){
                            if (p.getItemId().equals(c.getId())){
                                c.setQuantity(c.getQuantity()-p.getQuantity());
                                c.setSoldQuantity(c.getSoldQuantity()+p.getQuantity());
                                c.setStatus(Util.showStatus(c.getQuantity()));

                            }
                        }
                    }
                        Controller.shoppingCarts.removeAll(currentCarts);

                        System.out.println("Đặt hàng thành công");


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

    public static void personalInfoMenu(){
        System.out.println("--------------------------------");
        System.out.println("1 - Thay đổi thông tin cá nhân");
        System.out.println("0 - Trở về");
        System.out.println("Lựa chọn của bạn là");
    }

    public static void personalInfoProgram(){
        boolean isContinue=true;
        while (isContinue){
            personalInfoMenu();
            int choice=Validate.inputNumber();
            switch (choice){
                case 1:
                    String email="";

                    System.out.println("Nhập email");
                    boolean repeat = true;
                    while (repeat ) {
                        email = Validate.isEmail();
                        repeat  = Validate.duplicateEmail(Controller.customers, email);
                    }

                    System.out.println("Nhập họ tên");
                    String name= scanner.nextLine();

                    System.out.println("Nhập địa chỉ");
                    String address= scanner.nextLine();

                    for (Customer c:Controller.customers){
                       if (c.getId().equals(Controller.activeAccount.getId())){
                           c.setEmail(email);
                           c.setName(name);
                           c.setAddress(address);
                       }
                    }
                    System.out.println("Cập nhật thành công");
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
}
