import java.util.Scanner;

public class HinhTron {
    final float PI = 3.14f;
    float r;
    float cv;
    float dt;

    // Dưới đây là các Phương thức
    void nhapBanKinh() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Hãy nhập vào Bán kính Hình tròn: ");

        r = scanner.nextFloat();
    }

    void tinhChuVi() {
        cv = 2 * PI * r;
    }

    void tinhDienTich() {
        dt = PI * r * r;
    }

    void inChuVi() {
        System.out.println("Chu vi Hình tròn: " + cv);
    }

    void inDienTich() {
        System.out.println("Diện tích Hình tròn: " + dt);
    }
}
