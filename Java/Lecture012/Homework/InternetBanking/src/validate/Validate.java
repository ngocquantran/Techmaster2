package validate;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static int inputNumber(){
        Scanner scanner=new Scanner(System.in);
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


    public static boolean isSpecialCharacter(String password){
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(password);
        boolean b = m.find();
        return b;
    }
}
