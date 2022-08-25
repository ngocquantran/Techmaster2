import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
//        boolean isContinue=true;
//        while (isContinue){
//            try{System.out.println("Nhập a");
//                int a=Integer.parseInt(scanner.nextLine());
//                System.out.println("Nhập b");
//                int b= Integer.parseInt(scanner.nextLine());
//                int c=b/a;
//                System.out.println(c);
//                isContinue=false;
//            }catch (ArithmeticException e){
//                System.out.println(e.toString());
////                e.printStackTrace();
//                System.out.println("Bạn đang chia 1 số cho 0");
//            }catch (NumberFormatException e){
//                System.out.println(e.getMessage());
//                System.out.println("Bạn phải nhập số");
//            }finally {
//                System.out.println("Tạm biệt");
//            }
//        }

//        boolean isContinue=true;
//        while (isContinue){
//            System.out.println("Nhập tuổi");
//            try{
//                int age= Integer.parseInt(scanner.nextLine());
//                Validate.validateAge(age);
//                isContinue=false;
//            }catch (MyException e){
//                e.printStackTrace();
//            }catch (NumberFormatException e){
//                e.printStackTrace();
//            }
//        }
        Triangle triangle=new Triangle();
        triangle.checkTriangle();







    }
}
