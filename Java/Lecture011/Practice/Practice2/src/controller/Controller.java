package controller;

import model.Account;
import service.Service;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    static Service service=new Service();
    static Account account=new Account("","","");
    static ArrayList<Account>accounts=new ArrayList<>();
    static Scanner scanner=new Scanner(System.in);

    public static void mainMenu(){
        System.out.println("------------------------------");
        System.out.println("1 - Đăng nhập");
        System.out.println("2 - Đăng ký");
        System.out.println("0 - Thoát chương trình");
        System.out.println("Lựa chọn của bạn là");
    }

    public static void submenu1(){
        System.out.println("------------------------------");
        System.out.println("1 - Thay đổi username");
        System.out.println("2 - Thay đổi email");
        System.out.println("3 - Thay đổi mật khẩu");
        System.out.println("4 - Đăng xuất");
        System.out.println("0 - Thoát chương trình");
        System.out.println("Lựa chọn của bạn là");
    }

    public static void submenu2(){
        System.out.println("------------------------------");
        System.out.println("1 - Đăng nhập lại");
        System.out.println("2 - Quên mật khẩu");
    }


//    Chương trình chính
    public static void program(){
        mainMenu();
            int choice=Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    boolean isContinue=true;
                    while (isContinue){System.out.println("Nhập username");
                        String username= scanner.nextLine();
                        if (username.equals(account.getUsername())){
                            isContinue=false;
                        }else {
                            System.out.println("Kiểm tra lại username");
                            program();
                        }
                    }
                    System.out.println("Nhập password");
                    String password= scanner.nextLine();
                    if (password.equals(account.getPassword())){
                        subprogram1();
                    }
                    else {
                        System.out.println("Mật khẩu không đúng");
                        subprogram2();
                    }
                    break;
                case 2:
                    account=service.signUp(accounts);
                    program();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;
            }



    }

//    Chương trình Khi đăng nhập thành công
    public static void subprogram1(){
        System.out.println("--------------------------------");
        System.out.println("Chào mừng "+account.getUsername());

        boolean isContinue=true;
        while (isContinue){
            submenu1();
            int choice1=Integer.parseInt(scanner.nextLine());
            switch (choice1){
                case 1:
                    System.out.println("Nhập username mới");
                    String newUsername= scanner.nextLine();
                    service.updateUsername(account,newUsername);
                    System.out.println("Cập nhật username thành công");
                    break;
                case 2:
                    System.out.println("Bắt đầu tạo email mới");
                    String newEmail= service.emailInput();
                    service.updateEmail(account,newEmail);
                    System.out.println("Cập nhật email thành công");
                    break;
                case 3:
                    System.out.println("Bắt đầu tạo mật khẩu mới");
                    String newPassword=service.passwordInput();
                    service.updatePassword(account,newPassword);
                    System.out.println("Cập nhật mật khẩu thành công");
                    break;
                case 4:
                    program();
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

//    Chương trình khi quên mật khẩu
    public static void subprogram2(){
        submenu2();
        int choice2=Integer.parseInt(scanner.nextLine());
        switch (choice2){
            case 1:
                program();
                break;
            case 2:
                String emailCheck=service.emailInput();
                if (emailCheck.equals(account.getEmail())){
                    System.out.println("Bắt đầu tạo mật khẩu mới");
                    String newPassword=service.passwordInput();
                    service.updatePassword(account,newPassword);
                    System.out.println("Cập nhật mật khẩu thành công \nĐăng nhập lại");

                }else {
                    System.out.println("Chưa tồn tại tài khoản");
                }
                program();
                break;

        }
    }
}
