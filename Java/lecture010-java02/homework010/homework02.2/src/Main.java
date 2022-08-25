import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);
        System.out.println("Vui lòng nhập điểm thực hành của bạn:");
        double diemThucHanh= scanner.nextDouble();
        System.out.println("Vui lòng nhập điểm lý thuyết của bạn:");
        double diemLyThuyet= scanner.nextDouble();

        double diemTrungBinh=(diemLyThuyet+diemThucHanh)/2;


        System.out.println("\nKết quả của bạn:");
        System.out.println("Điểm trung bình của bạn là: "+diemTrungBinh);
        System.out.println((diemTrungBinh>=6)?"Chúc mừng bạn đã qua môn":"Rất tiếc bạn đã trượt môn");
    }
}
