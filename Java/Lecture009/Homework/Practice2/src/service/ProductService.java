package service;

import model.Product;
import model.ProductType;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {

    public ArrayList<Product> getAllProduct(){
        ArrayList<Product> products=new ArrayList<>();
        products.add(new Product(1,"Tivi",10000000,100,ProductType.A,20));
        products.add(new Product(2,"Cá hồi",100000,200,ProductType.B,10));
        products.add(new Product(3,"Áo khoác da",700000,150,ProductType.C,50));
        products.add(new Product(4,"Tủ lạnh",4000000,100,ProductType.A,20));
        products.add(new Product(5,"Thịt gà",50000,200,ProductType.B,10));
        products.add(new Product(6,"Quần tây",200000,150,ProductType.C,50));

        return products;
    }

    public void show(ArrayList<Product> products){
        for (Product p:products){
            System.out.println(p);
        }
    }

    public void searchByName(ArrayList<Product> products, String searchedName){
        int isFound=0;
        for (Product p:products){
            if (p.getName().toLowerCase().contains(searchedName)){
                System.out.println(p);
                isFound++;
            }
        }
        if (isFound==0){
            System.out.println("Không có sản phẩm này");
        }
    }

    public static ProductType getInputType(){
        Scanner scanner=new Scanner(System.in);
        ProductType productType = ProductType.A;
        int type;
        do {
            System.out.println("Nhập loại sản phẩm (1-đồ gia dụng / 2-thực phẩm / 3-thời trang)");
            type=Integer.parseInt(scanner.nextLine());
        }
        while (type!=1&&type!=2&&type!=3);
        switch (type){
            case 1:
                productType= ProductType.A;
                break;
            case 2:
                productType=ProductType.B;
                break;
            case 3:
                productType=ProductType.C;
                break;

        }
        return productType;
    }

    public void sortByType(ArrayList<Product> products,ProductType productType){
        for (Product p:products){
            if (p.getProductType()==productType){
                System.out.println(p);
            }
        }
    }

    public Product searchById(ArrayList<Product> products,int id){
        for (Product p:products){
            if (p.getId()==id){
                return p;
            }
        }
        return null;
    }

    public void updateNameAndPrice(Product product, String newName, long newPrice){
        product.setName(newName);
        product.setPrice(newPrice);
        System.out.println(product);

    }

//    public void updatePrice(model.Product product,long newPrice){
//        product.setPrice(newPrice);
//        System.out.println(product);
//    }

    public void removeProduct(ArrayList<Product> products, Product product){
                products.remove(product);
    }

//    public void removeProduct2(ArrayList<model.Product> products,int id){
//        for (model.Product p:products){
//            if (p.getId()==id){
//                products.remove(p);
//            }
//        }
//    }

    public Product createProduct(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập ID sản phẩm:");
        int id=Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên sản phẩm: ");
        String name= scanner.nextLine();
        System.out.println("Nhập giá sản phẩm");
        long price= scanner.nextLong();
        scanner.nextLine();
        System.out.println("Nhập tổng số lượng sản phẩm");
        int quantity=Integer.parseInt(scanner.nextLine());

        ProductType productType = ProductType.A;
//        int type;
//        do {
//            System.out.println("Nhập loại sản phẩm (1-đồ gia dụng / 2-thực phẩm / 3-thời trang");
//            type=Integer.parseInt(scanner.nextLine());
//        }
//        while (type!=1&&type!=2&&type!=3);
//        switch (type){
//            case 1:
//                productType=model.ProductType.A;
//                break;
//            case 2:
//                productType=model.ProductType.B;
//                break;
//            case 3:
//                productType=model.ProductType.C;
//                break;
//            default:
//                System.out.println();
//
//        }
        getInputType();

        System.out.println("Nhập số lượng bán");
        int sellingQuantity=Integer.parseInt(scanner.nextLine());

        Product newProduct=new Product(id,name,price,quantity,productType,sellingQuantity);
        return newProduct;

    }

    public void addProduct(Product product,ArrayList<Product> products){
        products.add(product);
    }




}
