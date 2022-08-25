import java.util.Scanner;

public class StArray {
    public static String[] inputArray(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("1. Nhập vào số phần tử của chuỗi");
        int n= Integer.parseInt(scanner.nextLine());

        String[] arr=new String[n];
        for (int i=0; i<n;i++){
            System.out.println("- Nhập giá trị phần tử tương ứng chỉ số "+i);
            arr[i]= scanner.nextLine();
        }
        return arr;
    }

    public static void printArray(String[] arr){
        for (int i=0;i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void javaCount(String[] arr){
        int count=0;
        for (int i=0;i< arr.length;i++){
            if (arr[i].equalsIgnoreCase("Java")){
                count++;
            }
        }
        System.out.println();
        System.out.println("3. Số lần \"Java\" xuất hiện trong mảng là: "+count);
    }

    public static void randomStringCheck(String[] arr){
        Scanner scanner=new Scanner(System.in);
        System.out.println();
        System.out.println("4. Nhập chuỗi bất kỳ muốn kiểm tra");
        String chuoi= scanner.nextLine();
        boolean isFound=false;
        for (int i=0;i< arr.length;i++){
            if ((chuoi.trim()).equalsIgnoreCase(arr[i].trim())){
                System.out.println("Chuỗi bạn nhập xuất hiện ở vị trí thứ "+(i+1)+" trong mảng");
                isFound=true;
            }
        }
        if (!isFound){
            System.out.println("Chuỗi bạn nhập không xuất hiện trong mảng");
        }
    }

}
