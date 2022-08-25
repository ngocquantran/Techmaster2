import java.util.Scanner;

public class HinhTron {
    final float PI=3.14f;
    float r;
    float cv;
    float dt;

    void nhapBanKinh(){
        System.out.println("Nhập vào bán kính Hình tròn:");
        Scanner scanner=new Scanner(System.in);
        r= scanner.nextFloat();
    }

    void tinhChuVi(){
        cv=2*PI*r;
    }

    void tinhDienTich(){
        dt=PI*r*r;
    }

    void inChuVi(){
        System.out.println("Chu vì Hình tròn là: "+cv);
    }

    void inDienTich(){
        System.out.println("Diện tích hình tròn là: "+dt);
    }
}
