import java.util.Scanner;

public class ArrayExample {
    public static int[] createArray(){
        int[] mang;
        mang=new int[5];
        mang[0]=5;
        mang[1]=2;
        mang[2]=6;
        mang[3]=9;
        mang[4]=8;

        return mang;
    }

    public static void printArray(int[] arr){
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+"\t");
        }
    }

    public static int getMin(int[] arr){
        System.out.println("\nPhần tử nhỏ nhất là ");
        int nhonhat=arr[0];
        for (int i=1;i<arr.length;i++){
            if (nhonhat> arr[i]){
                nhonhat=arr[i];
            }
        }
        System.out.println(nhonhat);

        return nhonhat;
    }

    public static int[] inputArray(){
Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập số phần tử của mảng");
        int number= scanner.nextInt();

        int[] arr=new int[number];
        for (int i=0;i<number;i++){
            System.out.println("Nhập giá trị phần tử "+"["+i+"]");
            arr[i]= scanner.nextInt();
        }
        return arr;
    }



}
