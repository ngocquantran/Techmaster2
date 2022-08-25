package controll;

import model.Account;
import model.Transaction;
import service.Service;
import validate.Validate;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    static Service service=new Service();
    static Account account=service.getAccount();
    static Scanner scanner=new Scanner(System.in);
    static ArrayList<Transaction> transactions=new ArrayList<>();

    public static void firstPopUp(){
        System.out.println("1 - Đăng nhập");
        System.out.println("0 - Thoát chương trình");
        System.out.println("Lựa chọn của bạn là: ");
    }

    public static void menu(){
        System.out.println("------------------------------------------");
        System.out.println("1 - Truy vấn số dư tài khoản");
        System.out.println("2 - Chuyển tiền");
        System.out.println("3 - Xem lịch sử giao dịch");
        System.out.println("0 - Đăng xuất");
        System.out.println("Lựa chọn của bạn là");
    }

    public static void program(){
        boolean isContinue=true;
        while (isContinue){
            firstPopUp();
            int choice= Validate.inputNumber();
            switch (choice){
                case 1:
                    service.signIn(account);
                    System.out.println("******");
                    System.out.println("Xin chào");
                    mainProgram();
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

    public static void mainProgram(){

        int id=1;
        boolean isContinue=true;
        while (isContinue){
            menu();
            int choice= Validate.inputNumber();
            switch (choice){
                case 1:
                    service.showBalance(account);
                    break;
                case 2:
                    service.getTransaction(transactions,account,id);
                    id++;
                    break;
                case 3:
                    System.out.println("Lịch sử giao dịch: ");
                    service.showHistory(transactions);
                    break;
                case 0:
                    program();
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;

            }
        }

    }
}
