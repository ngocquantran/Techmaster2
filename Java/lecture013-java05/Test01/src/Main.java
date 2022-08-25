import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n;
        System.out.println("1. In hình vuông");
        do {System.out.println("Nhập vào kích thước cạnh hình vuông (số nguyên>=2)");
            n= scanner.nextInt();
        }
        while (n<2);

        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                System.out.print("*  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("2.In hình tam giác vuông cân");

        System.out.println("Nhập vào kích thước cạnh góc vuông ");
        int canh1= scanner.nextInt();

        for (int i=1;i<=canh1;i++){
            for (int j=1;j<=i;j++){
                System.out.print("*  ");
            }
            System.out.println();
        }


//        System.out.println();
//        System.out.println("3. In hình tam giác đều");
//        System.out.println("Nhập kích thước cạnh tam giác đều");
//        int canhDeu= scanner.nextInt();
//        for (int i=1;i<=canhDeu;i++){
//            for (int space=1;space<=i-1;++space){
//                System.out.println("  ");
//            }
//            while ()
//            System.out.println();
//        }




    }
}
