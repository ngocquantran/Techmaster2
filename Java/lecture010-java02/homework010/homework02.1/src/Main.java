import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);
        System.out.println("Vui lòng nhập chuỗi thứ nhất:");
        String chuoiThuNhat = scanner.nextLine();


        System.out.println("Vui lòng nhập chuỗi thứ hai:");
        String chuoiThuHai = scanner.nextLine();



        System.out.println("\nKết quả so sánh:");
        System.out.println((chuoiThuNhat.equals(chuoiThuHai))?"Hai chuỗi bằng nhau":"Hai chuỗi không bằng nhau");
        System.out.println((chuoiThuNhat.length()==chuoiThuHai.length())?"Hai chuỗi có chiều dài bằng nhau":"Hai chuỗi có chiều dài khác nhau");
    }



}
