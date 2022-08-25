import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        ProductService service=new ProductService();
        Product[] products= service.addProduct();
        System.out.println("Thông tin sản phẩm:");
        System.out.println("id - tên sản phẩm - số lượng - đơn vị tính - giá mua - giá bán - số lượng bán - lãi");
        service.print(products);


    }
}
