import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
//        System.out.println("Nhập chiều cao của bạn");
//        double chieuCao= scanner.nextDouble();
//        System.out.println("Nhập cân nặng của bạn");
//        double canNang= scanner.nextDouble();
//        double bmi=canNang/(chieuCao*chieuCao);
//        System.out.println("Chỉ số BMI của bạn là:"+ bmi);
//        if (bmi>24.9){
//            System.out.println("Bạn thừa cân rồi, ăn ít đi nha");
//        }
//        else if (bmi<=24.9&&bmi>=18.5){
//            System.out.println("Bạn khá cân đối đấy, stay healthy nha");
//        }
//        else {
//            System.out.println("Bạn thiếu cân rồi, ăn nhiều lên nha");
//        }
//        System.out.println("Nhập kích thước cạnh tam giác thứ nhất");
//        double canhMot= scanner.nextDouble();
//        System.out.println("Nhập kích thước cạnh tam giác thứ hai");
//        double canhHai= scanner.nextDouble();
//        System.out.println("Nhập kích thước cạnh tam giác thứ ba");
//        double canhBa= scanner.nextDouble();
//        if ((canhMot+canhHai)>canhBa && (canhMot+canhBa)>canhHai && (canhBa+canhHai)>canhMot){
//            System.out.println("Ba cạnh trên thỏa mãn điều kiện ba cạnh tam giác");
//            if(canhBa==canhHai || canhHai==canhMot || canhBa==canhMot){
//                System.out.println("Bạn có tam giác cân");
//            }
//            else {
//                System.out.println("Bạn có tam giác thường");
//            }
//        }
//        else {
//            System.out.println("Không thỏa mãn điều kiện ba cạnh tam giác");
//        }

//        System.out.println("Nhập số nguyên bất kỳ");
//        int number= scanner.nextInt();
//
//        switch (number){
//            case 2:
//                System.out.println("Thứ hai");
//                break;
//
//            case 3:
//                System.out.println("Thứ ba");
//                break;
//            case 4:
//                System.out.println("Thứ tư");
//                break;
//            case 5:
//                System.out.println("Thứ năm");
//                break;
//            case 6:
//                System.out.println("Thứ sáu");
//                break;
//            case 7:
//                System.out.println("Thứ bảy");
//                break;
//            case 8:
//                System.out.println("Chủ nhật");
//                break;
//            default:
//                System.out.println("Không có ngày này trong tuần");
//                break;
//        }


//        System.out.println("Nhập vào một tháng bất kì (từ 1 đến 12)");
//        int thang= scanner.nextInt();
//
//        switch (thang){
//            case 1,3,5,7,8,10,12:
//                System.out.println("Tháng "+thang+" có 31 ngày");
//                break;
//            case 2:
//                System.out.println("Tháng "+thang+" có 28 ngày");
//                break;
//            case 4,6,9,11:
//                System.out.println("Tháng "+thang+" có 30 ngày");
//                break;
//            default:
//                System.out.println("Không có tháng "+thang);
//
//        }

//        Random random= new Random();
//        int randomNumber= random.nextInt(3)+2;
//        System.out.println(randomNumber);

//        for (int i=1; i<=100;i++){
//            if (i%3==0 && i%5==0){
//                System.out.println("FizzBuzz");
//
//            }
//            else if(i%3==0){
//                System.out.println("Fizz");
//            }
//            else  if (i%5==0){
//                System.out.println("Buzz");
//            }
//            else {
//                System.out.println(i);
//            }
//        }


//        Random random= new Random();
//
//        int randomNumber=1;
//
//        while (randomNumber<=5){
//
//            randomNumber= random.nextInt(10)+1;
//            System.out.println(randomNumber);
//
//        }

//        int age;
//        do {
//            System.out.println("Nhập tuổi của bạn");
//            age= scanner.nextInt();
//        }while (age<=0);
//        System.out.println(age);



//        double weight;
//        double height;
//       double bmi;
//        do {
//            System.out.println("Nhập cân nặng của bạn");
//            weight= scanner.nextDouble();
//        }while (weight<1 || weight>100);
//        System.out.println("Cân nặng của bạn là:"+weight);
//
//        do {
//            System.out.println("Nhập chiều cao của bạn");
//            height= scanner.nextDouble();
//        }while (height<0.5||height>2.5);
//        System.out.println("Chiều cao của bạn là:"+height);
//
//        System.out.println("Chỉ số BMI của bạn là "+weight/(height*height));

        Random random=new Random();
        int randomNumber= random.nextInt(100)+0;
        boolean repeat=true;
       while(repeat){
           System.out.println("Vui lòng nhập số bạn đoán từ 1 đến 100");
           int number= scanner.nextInt();

           if (number==randomNumber){
               System.out.println("Bạn đoán đúng rồi");
               repeat=false;
           }

           else if (number>randomNumber){
               System.out.println("Bạn đoán lớn hơn rồi");

           }
           else {
               System.out.println("Bạn đoán nhỏ hơn rồi");

           }
       }




    }
}
