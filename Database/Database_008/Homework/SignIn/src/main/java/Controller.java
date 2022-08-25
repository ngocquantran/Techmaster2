import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    static Scanner scanner=new Scanner(System.in);
    static Service service=new Service();
    static ArrayList<Users> users=service.getAllUsers();
    static Users activeUser=null;

    public static void menu(){
        System.out.println("-----------------------------");
        System.out.println("1 - Đăng nhập");
        System.out.println("0 - Thoát chương trình");
        System.out.println("Lựa chọn của bạn là");
    }

    public static void signInMenu(){
        System.out.println("-----------------------------");
        System.out.println("0 - Đăng xuất");
        System.out.println("Lựa chọn của bạn là");
    }

    public static void signInProgram(int id){
        activeUser=service.getUserFromId(users,id);
        System.out.println("Xin chào "+activeUser.getName());
        boolean isContinue=true;
        while (isContinue){
            signInMenu();
            int choice=Validate.inputNumber();
            switch (choice){
                case 0:
                    activeUser=null;
                    isContinue=false;
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;
            }
        }

    }

    public static void program(){
        boolean isContinue=true;
        while (isContinue){
            menu();
            int choice=Validate.inputNumber();
            switch (choice){
                case 1:
                    System.out.println("Nhập số điện thoại");
                    String mobile= scanner.nextLine();
                    System.out.println("Nhập mật khẩu");
                    String password= scanner.nextLine();
                    if (Validate.isUser(users,mobile,password)){
                        int id= service.getIdFromMoblie(users,mobile);
                        signInProgram(id);

                    }else {
                        System.out.println("Số điện thoại hoặc mật khẩu không đúng");
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


}
