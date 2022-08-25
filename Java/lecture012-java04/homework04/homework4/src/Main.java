import java.sql.Array;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        String[] myArray=StArray.inputArray();
        System.out.println();

        System.out.println("2. Mảng vừa nhập là");
        StArray.printArray(myArray);

        StArray.javaCount(myArray);

        StArray.randomStringCheck(myArray);






//        Scanner scanner=new Scanner(System.in);
//        System.out.println("1. Nhập vào số phần tử của chuỗi");
//        int n= Integer.parseInt(scanner.nextLine());
//
//        String[] strArray=new String[n];
//        for (int i=0; i<n;i++){
//            System.out.println("- Nhập giá trị phần tử tương ứng chỉ số "+i);
//            strArray[i]= scanner.nextLine();
//        }
//        System.out.println();
//        System.out.println("2. Mảng vừa nhập là:");
//        for (int i=0; i<n;i++){
//            System.out.println(strArray[i]);
//        }
//        int count=0;
//        for (int i=0;i< strArray.length;i++){
//            if (strArray[i].equalsIgnoreCase("Java")){
//                count++;
//            }
//        }
//        System.out.println();
//        System.out.println("3. Số lần \"Java\" xuất hiện trong mảng là: "+count);
//
//        System.out.println();
//        System.out.println("4. Nhập chuỗi bất kỳ muốn kiểm tra");
//        String chuoi= scanner.nextLine();
//        boolean isFound=false;
//        for (int i=0;i< strArray.length;i++){
//            if ((chuoi.trim()).equalsIgnoreCase(strArray[i].trim())){
//                System.out.println("Chuỗi bạn nhập xuất hiện ở vị trí thứ "+(i+1)+" trong mảng");
//                isFound=true;
//            }
//        }
//        if (!isFound){
//            System.out.println("Chuỗi bạn nhập không xuất hiện trong mảng");
//        }


    }
}
