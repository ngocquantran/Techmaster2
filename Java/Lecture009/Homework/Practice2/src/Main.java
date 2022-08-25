import controller.Controller;
import model.Product;
import service.ProductService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//        ProductService service=new ProductService();
//        ArrayList<Product> products=service.getAllProduct();
//        service.show(products);

////        System.out.println("Kết quả tìm sản phẩm theo tên là");
////        service.searchByName(products,"cá");
////
////        System.out.println("Kết quả lọc theo mặt hành thời trang");
////        service.sortByType(products,model.ProductType.A);
////
////        System.out.println();
////        System.out.println("Kết quả lọc theo id");
//        Scanner scanner=new Scanner(System.in);
//
//        int id=1;
//        int found=0;
//        while (found==0){
//            System.out.println("Nhập id của sản phẩm");
//            id=Integer.parseInt(scanner.nextLine());
//            for (model.Product p:products){
//                if (p.getId()==id){
//                    found++;
//                }
//            }
//            if (found==0){
//                System.out.println("Không có sản phẩm này");
//
//            }
//        }
//
//
//
//////
//        model.Product updateNameProduct=service.searchById(products,id);
//        System.out.println(updateNameProduct);
//        System.out.println("Nhập tên sản phẩm mới");
//        String newName= scanner.nextLine();
//        System.out.println("Nhập giá sản phẩm mới");
//        long newPrice= scanner.nextLong();
//
//        service.updateNameAndPrice(updateNameProduct,newName,newPrice);
//
//        service.updatePrice(updateNameProduct,20000);
//
//        System.out.println("Danh sách sau khi xóa là:");
//        model.Product removedProduct=service.searchById(products,5);
//        service.removeProduct(products,removedProduct);
//        service.show(products);
//
//        model.ProductType productType=service.getInputType();
//        service.sortByType(products,productType);



//        model.Product newProduct=service.createProduct();
//        service.addProduct(newProduct,products);
//        System.out.println("Danh sách sau khi thêm là");
//        service.show(products);
        Controller.mainMenu();

    }

}
