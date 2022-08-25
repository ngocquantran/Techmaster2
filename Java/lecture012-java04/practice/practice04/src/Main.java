import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){


        String email="quan3@179ggmailcom";
        String regexEmail="^(.+)@(\\S+)$";
        if (email.matches(regexEmail)){
            System.out.println("Email hợp lệ");
        }
        else {
            System.out.println("Email không hợp lệ");
        }


//**************************************************************************************************
//       String mobile="09623671333323";
//       String regexMobile="\\d{10,11}";
//
//       if (mobile.matches(regexMobile)){
//           System.out.println("Số điện thoại hợp lệ");
//       }
//       else {
//           System.out.println("Số điện thoại không hợp lệ");
//       }



//**************************************************************************************************
//        int[] number=ArrayExample.inputArray();
//        System.out.println("Mảng vừa tạo là");
//        ArrayExample.printArray(number);

//**************************************************************************************************




//        Scanner scanner=new Scanner(System.in);

//
//        System.out.println("Nhập số phần tử của mảng");
//        int number= scanner.nextInt();
//
//        int[] inputArray=new int[number];
//        for (int i=0;i<number;i++){
//            System.out.println("Nhập giá trị phần tử "+"["+i+"]");
//            inputArray[i]= scanner.nextInt();
//        }
//**********************************************************************************
//        String name="Trần     Ngọc Quân";
//        name=name.replaceAll("\s+"," ");
//        String[] strArray=name.split("\s");
//        for (int i=0;i<strArray.length;i++){
//            System.out.println(strArray[i]);
//        }




        //**********************************************************************************
//        int[] arr=ArrayExample.createArray();
//        ArrayExample.printArray(arr);
//        System.out.println();
//
//        ArrayExample.getMin(arr);


//        int[] mang;
//        mang=new int[5];
//        mang[0]=5;
//        mang[1]=2;
//        mang[2]=6;
//        mang[3]=9;
//        mang[4]=8;
//        for (int i=0;i< mang.length;i++){
//             System.out.print(mang[i]+"\t");
//        }
//
//        //***********************************************************************************************
//
//        for (int i=0; i<mang.length;i++){
//            for (int j=i;j<=mang.length-1;j++){
//                int temp;
//                if(mang[i]>mang[j]){
//                    temp=mang[i];
//                    mang[i]=mang[j];
//                    mang[j]=temp;
//                }
//            }
//        }
//        System.out.println("\nMảng sau khi sắp xếp tăng dần");
//        for (int i=0;i< mang.length;i++){
//            System.out.print(mang[i]+"\t");
//        }
//
//        //***********************************************************************************************
//
//        for (int i=0; i<mang.length;i++){
//            for (int j=i;j<=mang.length-1;j++){
//                int temp;
//                if(mang[i]<mang[j]){
//                    temp=mang[i];
//                    mang[i]=mang[j];
//                    mang[j]=temp;
//                }
//            }
//        }
//        System.out.println("\nMảng sau khi sắp xếp giảm dần");
//        for (int i=0;i< mang.length;i++){
//            System.out.print(mang[i]+"\t");
//        }
//
//        //***************************************************************
//        System.out.println("\nPhần tử có giá trị chẵn");
//        for (int i=0;i< mang.length;i++){
//            if (mang[i]%2==0){ System.out.print(mang[i]+"\t");}
//
//        }
//        System.out.println("\nPhần tử nhỏ nhất là ");
//        int nhonhat=mang[0];
//        for (int i=1;i<mang.length;i++){
//            if (nhonhat> mang[i]){
//                nhonhat=mang[i];
//            }
//        }
//        System.out.println(nhonhat);
//
//        System.out.println("\nPhần tử lớn nhất là ");
//        int lonnhat=mang[0];
//        for (int i=1;i<mang.length;i++){
//            if (lonnhat< mang[i]){
//                lonnhat=mang[i];
//            }
//        }
//        System.out.println(lonnhat);
//
//
//        System.out.println();
//        String[] strArray=new String[4];
//        strArray[0]="Tên";
//        strArray[1]="tôi";
//        strArray[2]="là";
//        strArray[3]="Quân";
//        for(int i=0;i< strArray.length;i++){
//
//                System.out.print(strArray[i]+" ");
//        }
//
//        strArray[1]="bạn";
//        System.out.println("\nMảng sau khi sửa");
//        for(int i=0;i< strArray.length;i++){
//            System.out.print(strArray[i]+" ");
//        }
//




    }
}
