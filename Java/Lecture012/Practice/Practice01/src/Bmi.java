import java.util.Scanner;

public class Bmi {
    public void input(){
        Scanner scanner=new Scanner(System.in);
        double number=0;
        boolean isContinue=true;
        while (isContinue){
            try {
                number=Double.parseDouble(scanner.nextLine());
                if (number<0){
                    throw new MyException("Không hợp lệ");
                }
                isContinue=false;
            }catch (MyException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
