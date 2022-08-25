package validate;

import java.util.Scanner;

public class Validate {
    public static int inputNumber(){
        Scanner scanner=new Scanner(System.in);
        int number=0;
        boolean isContinue=true;
        while (isContinue){
            try{
                number=Integer.parseInt(scanner.nextLine());
                isContinue=false;
            }catch (NumberFormatException e){
                System.out.println("Vui lòng nhập số");
            }
        }
        return number;
    }
}
