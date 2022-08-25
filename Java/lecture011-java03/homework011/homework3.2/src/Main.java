import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        System.out.println("\nGiải phương trình bậc nhất ax+b=0");

        double a;
        double b;

        boolean isContinue=true;
        while (isContinue){
            System.out.println("Nhập giá trị a");
            a= scanner.nextDouble();
            System.out.println("Nhập giá trị b");
            b= scanner.nextDouble();

            System.out.printf("Phương trình vừa nhập: %.2fx + %.2f = 0",a,b);
            if (a==0){
                if (b==0){
                    System.out.println("\nPhương trình có vô số nghiệm");
                }
                else {
                    System.out.println("\nPhương trình vô nghiệm");
                }
            }
            else {
                double x=(-1)*b/a;
                System.out.printf("\nNghiệm của phương trình là x = %.2f",x);
            }
            System.out.println("\nBạn có muốn nhập lại không (có: nhập bất kì, không: nhập \"N\")");
            String repeat=scanner.next();
            if (repeat.equalsIgnoreCase("N")){
                isContinue=false;
            }

        }





    }
}
