import com.sun.security.jgss.GSSUtil;
import jdk.swing.interop.SwingInterOpUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){


//    double x;
//    double y;
//    double z;
//
//        Scanner scanner=new Scanner(System.in);
//
//        System.out.println("Enter side x: ");
//        x=scanner.nextDouble();
//        System.out.println("Enter side y:");
//        y=scanner.nextDouble();
//
//        z = Math.sqrt((x*x)+(y*y));
//        System.out.println("The hypotenuse is: "+z);
//        scanner.close();



//        int sumEven=0;
//        for(int i=1; i<10; i++) {
//            if (i % 2 == 0) {
//                sumEven+=i;
//                System.out.println(i);
//            }
//
//        }
//
//        System.out.println(sumEven);



//        int soNguyenTo;
//        for (soNguyenTo=2; soNguyenTo<=10000; soNguyenTo++){
//            int count=0;
//            for (int i=2; i<soNguyenTo;i++){
//                if (soNguyenTo%i==0){
//                    count++;
//                    break;
//                }
//            }
//            if (count==0){
//                System.out.println(soNguyenTo);}
//
//        }
//
//
//        for (int number = 2; number <= 10000; number++) {
//            boolean isPrime = true; // Thay vì biến count, dùng biến này để kiểm tra số nguyên tố
//            for(int j = 2; j <= Math.sqrt(number); j++) {
//                if (number % j == 0) {
//                    // Chỉ cần một giá trị được tìm thấy trong khoảng này,
//                    // thì number không phải số nguyên tố
//                    isPrime = false;
//                    break; // Thoát ngay và luôn khỏi for (vòng for bên ngoài vẫn chạy)
//                }
//            }
//            if (isPrime) {
//                // Nếu isPrime còn giữ được sự "trong trắng" đến cùng thì đó là số nguyên tố
//                System.out.println(number);
//            }
//        }
//        int number;
//        for(number=2;number<100;number++){
//            int count=0;
//            for (int i=2; i<number;i++){
//                if (number%i==0){
//                    count++;
//                    break;
//                }
//
//            }
//            if (count>0){
//
//                System.out.println(number);
//            }
//        }

//        LocalDate currentDate= LocalDate.now();
//        System.out.println(currentDate);
//        LocalDate nextDay=LocalDate.of(2021,12,22);
//        System.out.println(nextDay);
//
//        LocalTime currentTime=LocalTime.now();
//        System.out.println(currentTime);
//
//        LocalTime haiTiengSau=currentTime+LocalTime.of(2);
//        System.out.println(haiTiengSau);



        //**************************************************************************************
        //**** KIỂM TRA NĂM NHUẬN

//        Scanner scanner=new Scanner(System.in);
//        boolean isContinue=true;
//        while (isContinue){
//            System.out.println("Nhập năm bạn muốn kiểm tra");
//            int year= scanner.nextInt();
//            if (year%4==0){
//                if (year%400==0){
//                    System.out.println("Năm bạn nhập là năm nhuận");
//                }
//                else if (year%100==0){
//                    System.out.println("Năm bạn nhập không phải năm nhuận");
//                }
//                else {
//                    System.out.println("Năm bạn nhập là năm nhuận");
//                }
//            }
//            else {
//                System.out.println("Năm bạn nhập không phải năm nhuận");
//            }
//            System.out.println("Bạn có muốn nhập lại không (có: nhập bất kì, không: nhập \"N\")");
//            String repeat= scanner.next();
//            if (repeat.equalsIgnoreCase("N")){
//                isContinue=false;
//            }
//
//        }

        //************************************************************************************************
        //          KIỂM TRA NGUYÊN ÂM PHỤ ÂM TRONG JAVA
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("Nhập âm cần kiểm tra");
//        String am= scanner.next();
//        if (am.equalsIgnoreCase("a")||am.equalsIgnoreCase("i")||am.equalsIgnoreCase("e")||am.equalsIgnoreCase("o")||am.equalsIgnoreCase("u")){
//            System.out.println(am+" là một nguyên âm");
//        }
//        else if ((am.charAt(0)>='a'&&am.charAt(0)<='z')||(am.charAt(0)>='A'&&am.charAt(0)<='Z')){
//            System.out.println(am+" là một phụ âm");
//        }
//        else {
//            System.out.println(am+" không phải một âm");
//        }


        //************************************************************************************************
        //          KIỂM TRA NGUYÊN ÂM PHỤ ÂM TRONG JAVA ( CÁCH 2)

//        Scanner scanner=new Scanner(System.in);
//        System.out.println("Nhập âm cần kiểm tra");
//        char am=scanner.next().charAt(0);
//        if (am=='a'||am=='A'||am=='i'||am=='I'||am=='e'||am=='E'||am=='o'||am=='O'||am=='u'||am=='U'){
//            System.out.println(am+" là một nguyên âm");
//        }
//        else if ((am>='a'&&am<='z')||(am>='A'&&am<='Z')){
//            System.out.println(am+" là một phụ âm");
//        }
//        else {
//            System.out.println(am+" không phải một âm");
//        }

           //*****************************************************************************************************
        //         TÍNH LÃI SUẤT ĐƠN GIẢN
//
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("Nhập số tiền gốc (VND)");
//        int p= scanner.nextInt();
//        System.out.println("Nhập lãi suất mỗi năm (%)");
//        double r= scanner.nextDouble();
//        System.out.println("Nhập thời gian tính lãi suất (năm)");
//        int t= scanner.nextInt();
//        int tienLai=(int) (p*r*t)/100;
//        System.out.println("\nTiền lãi của bạn sau "+t+" năm là "+tienLai+" VND");


        //*****************************************************************************************************
        //         XÓA KHOẢNG TRẮNG CHUỖI
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("Nhập vào chuỗi cần xóa khoảng trắng");
//        String chuoi= scanner.nextLine();
//        System.out.println(" Chuỗi sau khi xóa:\n");
//        chuoi=chuoi.replace(" ","");
//        System.out.println(chuoi);

        //*****************************************************************************************************
        //         THỰC HÀNH CHUỖI


//        String chuoi1="Đây là chuỗi 1";
//        String chuoi2="Đây là chuỗi 2";
//        String chuoi3="Đây là chuỗi 3";
//        String chuoi4=chuoi1+chuoi2;
//        System.out.println(chuoi4);
//        String chuoi5=chuoi1.concat(chuoi2);
//        System.out.println(chuoi5);




        //*****************************************************************************************************
        //         THỰC HÀNH MẢNG

//        int[] myArray={3 , 5, 7, 30, 10, 5, 8, 23 , 0, -5};
//        int[] yourArray=new int[10];
//        yourArray[0]=3;
//        yourArray[1]=5;
//        yourArray[2]=7;
//        yourArray[3]=30;
//        yourArray[4]=10;
//        yourArray[5]=5;
//        yourArray[6]=8;
//        yourArray[7]=23;
//        yourArray[8]=0;
//        yourArray[9]=-5;
//        int[] hisArray=new int[10];
//        for (int i=0; i<10;i++){
//            hisArray[i]=i;
//        }
//        int sum=0;
//        for (int i=0; i< myArray.length;i++){
//            sum+=myArray[i];
//        }
//        System.out.printf("Tổng giá trị các phần tử trong mảng là %d",sum);
//        System.out.println("\nTrung bình cộng của các giá trị phần tử trong mảng là "+(sum/myArray.length));
//        boolean isFound=false;
//        for (int i=0;i<myArray.length;i++){
//            if (myArray[i]<0){
//                System.out.println("Phần tử "+myArray[i]+" < 0 nằm ở vị trí thứ "+(i+1)+" trong mảng");
//                isFound=true;
//            }
//
//
//        }
//        if (!isFound){
//            System.out.println("Mảng không có phần tử nào nhỏ hơn 0");
//        }

//        for (int i=0;i< myArray.length;i++){
//            for (int j=i;j<= myArray.length-1;j++){
//                if (myArray[i]>myArray[j]){
//                    int temp;
//                    temp=myArray[i];
//                    myArray[i]=myArray[j];
//                    myArray[j]=temp;
//
//                }
//            }
//        }
//
//        for (int i=0;i<myArray.length;i++){
//            System.out.print(myArray[i]+", ");
//        }
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("Nhập chuỗi bạn muốn kiểm tra");
//        String chuoi= scanner.nextLine();
//        boolean isFound=false;
//        for (int i=0; i<chuoi.length();i++){
//            int count=0;
//            for (int j=i;j<=chuoi.length()-1;j++){
//
//                if (chuoi.charAt(i)==chuoi.charAt(j)){
//                    count++;
//                }
//
//            }
//            if (count>0){
//                System.out.println("Chuỗi có kí tự "+chuoi.charAt(i)+" xuất hiện "+count+" lần");
//                isFound=true;
//            }
//        }
//        if (!isFound){
//            System.out.println("Chuỗi không có ký tự trùng lặp");
//        }


        //*****************************************************************************************************
        //         KIỂM TRA CHUỖI ĐỐI XỨNG
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("Nhập chuỗi cần kiểm tra");
//        String chuoi= scanner.nextLine();
//        String chuoinguoc="";
//        for (int i=chuoi.length()-1;i>=0;i--){
//            chuoinguoc=chuoinguoc+chuoi.charAt(i);
//        }
////        System.out.println(chuoinguoc);
//        HinhTron hinhTron=new HinhTron();
//        hinhTron.nhapBanKinh();
//        hinhTron.tinhChuVi();
//        hinhTron.tinhDienTich();
//        hinhTron.inChuVi();
//        hinhTron.inDienTich();


        //*****************************************************************************************************
        //        ĐẢO NGƯỢC CÁC TỪ TRONG CHUỖI
//        String chuoi="Xin chao cac ban !!";
//        String[] words=chuoi.split(" ");
//
//
//        String reversedString="";
//        for (int i=0; i< words.length;i++){
//            String word=words[i];
//            String reversedWord="";
//            for (int j=word.length()-1;j>=0;j--){
//                reversedWord=reversedWord+word.charAt(j);
//            }
//            reversedString=reversedString+reversedWord+" ";
//        }
//        System.out.println(chuoi);
//        System.out.println(reversedString);

//*****************************************************************************************************
        //        ĐẢO NGƯỢC CÁC PHẦN TỬ TRONG MẢNG
//          Scanner scanner=new Scanner(System.in);
//          System.out.println("Nhập số phần tử của mảng");
//          int n= scanner.nextInt();
//          int[] myArray=new int[n];
//          for (int i=0; i<n;i++){
//              System.out.println("Nhập phần tử tương ứng chỉ số "+i);
//              myArray[i]= scanner.nextInt();
//          }
//        System.out.println("Mảng vừa nhập là ");
//          for (int i=0;i<n;i++){
//              System.out.print(myArray[i]+"\t");
//          }
//
//          int[] mirrorArray=new int[n];
//          for (int i=0;i<n;i++){
//              mirrorArray[i]=myArray[(n-i-1)];
//          }
//        System.out.println();
//        System.out.println("Mảng đảo ngược là ");
//        for (int i=0;i<n;i++){
//            System.out.print(mirrorArray[i]+"\t");
//        }

//*****************************************************************************************************
        //        ĐẢO NGƯỢC CÁC PHẦN TỬ TRONG MẢNG

//        String s1 = "hello world";
//        String[] mang = s1.split(" ");
//        for (int i = 0; i < mang.length; i++) {
//            System.out.println(mang[i]);
//        }
//*****************************************************************************************************
        //        ĐẢO NGƯỢC 1 SỐ
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("Nhập vào số bạn muốn đảo ngược");
//        int number= scanner.nextInt();
//        scanner.close();
//        int reservedNumber=0;
//        while (number>0){
//            int n=number%10;
//            reservedNumber=reservedNumber*10+n;
//            number=(number-n)/10;
//        }
//        System.out.println("Số sau khi đảo ngược là "+reservedNumber);


//*****************************************************************************************************
        //        TÁCH 1 SÓ NGUYÊN
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập vào số bạn muốn tách");
        int number= scanner.nextInt();
        scanner.close();
        int temp=number;
        int count=0;
        while (number>=1){
            number=number/10;
            count++;
        }
        while (temp>0){
            int n=temp%10;
            System.out.println("Số vị trí "+count+" là "+n);
            temp=(temp-n)/10;
            count--;

        }




    }



}


