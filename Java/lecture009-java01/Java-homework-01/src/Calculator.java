import java.util.Scanner;
public class Calculator {
    public static void main(String[] args){
        double a;
        double b;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập giá trị số a: ");
        a=scanner.nextDouble();
        System.out.println("Nhập giá trị số b:");
        b=scanner.nextDouble();

        double tong=sum(a,b);
        double hieu=subtract(a,b);
        double chia=division(a,b);
        double nhan=multi(a,b);

        System.out.println("Phép cộng của hai số a và b bằng: "+tong);
        System.out.println("Phép trừ của hai số a và b bằng: "+hieu);
        System.out.println("Phép chia của số a và b bằng: "+chia);
        System.out.println("Phép nhân của số a và b bằng: "+nhan);

        scanner.close();



    }
    public static double sum( double a, double b) {
        return a+b;
    }
    public static double subtract( double a, double b) {
        return a-b;
    }
    public static double division( double a, double b) {
        return a/b;
    }
    public static double multi( double a, double b) {
        return a*b;
    }




}
