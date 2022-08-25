import java.util.Scanner;

public class ScannerExample {
    public static void usingScanner(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Nhập tên bạn:");
        String name=sc.nextLine();
        System.out.println("Nhập tuổi của bạn");
        int age=Integer.parseInt(sc.nextLine());
        //sc.nextLine();
        System.out.println("Nhập địa chỉ của bạn");
        String address=sc.nextLine();

        System.out.println("Tên của bạn là "+name);
        System.out.println("Tuổi của bạn là "+age);
        System.out.println("Địa chỉ của bạn là "+address);
        System.out.printf("Tên của tôi là %s, năm nay tôi %d tuổi, tôi đến từ %s", name, age,address);

    }
}
