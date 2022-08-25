import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập chuỗi cần chuẩn hóa");
        String myString= scanner.nextLine();

        StringEx.standardString(myString);



        System.out.println();


        System.out.println("Nhập chuỗi bất kì để kiểm tra tính đối xứng");
        String rdString= scanner.nextLine();
        StringEx.mirrorString(rdString);

    }
}
