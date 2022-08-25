package controll;

import model.Customer;
import model.Gender;
import util.Validate;
import service.Service;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    static Scanner scanner=new Scanner(System.in);
    static Service service=new Service();
    static ArrayList<Customer> customers=service.getAllCustomer();

    public static void menu(){
        System.out.println("------------------------------------");
        System.out.println("1 - Xem thông tin toàn bộ khách hàng");
        System.out.println("2 - Xem thông tin khách hàng theo giới tính");
        System.out.println("3 - Thêm thông tin 1 khách hàng");
        System.out.println("4 - Tìm kiếm thông tin khách hàng");
        System.out.println("0 - Thoát chương trình");
        System.out.println("Lựa chọn của bạn là");
    }

    public static void submenu(){
        System.out.println("-------------------------------------");
        System.out.println("1 - Sửa thông tin khách hàng");
        System.out.println("2 - Xóa thông tin khách hàng");
        System.out.println("3 - Về màn hình chính");
    }

    public static void program(){
        boolean isContinue=true;
        while (isContinue){
            menu();
            int choice= Validate.inputNumber();
            switch (choice){
                case 1:
                    System.out.println("Thông tin toàn bộ khách hàng: ");
                    service.showArraylist(customers);
                    break;
                case 2:
                    Gender gender=service.chooseGender();
                    System.out.println("Thông tin khách hàng "+gender+" là:");
                    service.showByGender(gender,customers);
                    break;
                case 3:
                    service.addCustomer(customers);
                    break;
                case 4:
                    System.out.println("Nhập ID khách hàng cần tìm");
                    String id= scanner.nextLine();
                    int index= service.searchById(customers,id);
                    if(index>=0){
                        subProgram(index);
                    }
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

    public static void subProgram(int index){
        boolean isContinue=true;
        while (isContinue){
            submenu();
            int choice= Validate.inputNumber();
            switch (choice){
                case 1:
                    service.updateCustomer(customers,index);
                    break;
                case 2:
                    service.removeCustomer(customers,index);
                    break;
                case 3:
                    program();
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
            }
        }
    }

}
