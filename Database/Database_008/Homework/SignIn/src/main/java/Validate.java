import java.util.ArrayList;
import java.util.Scanner;

public class Validate {
    static Scanner scanner=new Scanner(System.in);
    public static int inputNumber(){
        int number=0;
        boolean isContinue=true;
        while (isContinue){
            try {
                number=Integer.parseInt(scanner.nextLine());
                isContinue=false;
            }catch (NumberFormatException e){
                System.out.println("Vui lòng nhập số");
            }
        }
        return number;
    }

    public static boolean isMobileAvailable(ArrayList<Users> users, String mobile){
        int found=0;
        for (Users u:users){
            if (u.getMobile().equals(mobile)) {
                found++;
                break;
            }
        }
        return (found>0);
    }

    public static boolean isUser(ArrayList<Users> users,String mobile,String password){
        int found=0;
        for (Users u:users){
            if (u.getMobile().equals(mobile)&&u.getPassword().equals(password)){
                found++;
                break;
            }
        }
        return (found>0);
    }


}
