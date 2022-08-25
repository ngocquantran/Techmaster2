import java.util.Scanner;

public class PrimeNumber {

    public static void implement(){
        Scanner scanner=new Scanner(System.in);

        boolean isContinue=true;
        while (isContinue){
            System.out.println("Nhập số cần kiểm tra");
            String input= scanner.nextLine();
            exitPath(input);

            try {
                int number=Integer.parseInt(input);
                isPrimeNumber(number);
            }catch (NumberFormatException e){
                System.out.println("Bạn cần nhập số nguyên");
            }
        }
    }

    public static void isPrimeNumber(int number){
        if (number<=1){
            System.out.println(number+" không phải số nguyên tố");
        }
        else {
            int found=0;
            for (int i=2;i<number;i++){
                if (number%i==0){
                    System.out.println(number+" không phải số nguyên tố");
                    found++;
                    break;
                }
            }
            if (found<1){
                System.out.println(number+" là số nguyên tố");
            }
        }
    }


    public static void exitPath(String str){
            if (str.equalsIgnoreCase("q") || str.equalsIgnoreCase("x")){
                System.exit(0);
        }
    }

}
