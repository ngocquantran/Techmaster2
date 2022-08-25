package service;

import model.Product;
import model.ProductCategory;
import validate.Validate;

import java.util.ArrayList;
import java.util.Arrays;


public class ProductService {
    public ArrayList<Product> getAllProduct(){
        ArrayList<Product> products=new ArrayList<>();
        products.add(new Product(1,"iPhone 13 Pro Max","A15 Bionic, 6.7\", 6GB RAM",31990000,1000,500,"Apple",new ProductCategory[]{ProductCategory.phone,ProductCategory.apple}));
        products.add(new Product(2,"MacBook Pro 13\" 2020","Touch Bar M1 256GB",33499000,2000,50,"Apple",new ProductCategory[]{ProductCategory.laptop,ProductCategory.apple}));
        products.add(new Product(3,"Apple Watch Series 6","GPS 40mm viền nhôm dây cao su",8499000,1500,250,"Apple",new ProductCategory[]{ProductCategory.apple}));
        products.add(new Product(4,"Tai nghe AirPods Pro 2021","4.5h nghe nhạc",4999000,800,200,"Apple",new ProductCategory[]{ProductCategory.accessory,ProductCategory.apple}));
        products.add(new Product(5,"Samsung Galaxy S21 Ultra","128GB",22990000,2000,500,"Samsung",new ProductCategory[]{ProductCategory.phone}));
        products.add(new Product(6,"Samsung Galaxy A12","4GB-128GB",31990000,3000,800,"Samsung",new ProductCategory[]{ProductCategory.phone}));
        products.add(new Product(7,"Xiaomi 11 Lite 5G NE","8GB - 256GB",8990000,1000,500,"Xiaomi",new ProductCategory[]{ProductCategory.phone}));
        products.add(new Product(8,"Xiaomi Redmi 9A","2GB-32GB",2490000,800,150,"Xiaomi",new ProductCategory[]{ProductCategory.phone}));
        products.add(new Product(9,"Laptop Acer Nitro Gaming AN515-45-R6EV R5 5600H","8GB/512GB SSD/GTX1650 4GB/Win11",21999000,1000,500,"Acer",new ProductCategory[]{ProductCategory.laptop}));
        products.add(new Product(10,"Laptop Dell Inspiron N3510 Celeron N4020","4GB/128GB15.6\"HD/Intel HD/Win 10/NK",10499000,600,500,"Dell",new ProductCategory[]{ProductCategory.laptop}));
        products.add(new Product(11,"Laptop Lenovo 100e Gen 2 N4020","GB/64GB eMMC/Intel UHD Graphics 600/11.6\"HD/Win 10 Pro ",7999000,1000,500,"Lenovo",new ProductCategory[]{ProductCategory.laptop}));
        products.add(new Product(12,"Pin sạc dự phòng PowerGo Smart Ai","10000mAh Innostyle",299000,1000,500,"Innostyle",new ProductCategory[]{ProductCategory.accessory}));
        products.add(new Product(13,"Chuột Game có dây Logitech G502","HERO High Performance",1759000,1000,500,"Logitech",new ProductCategory[]{ProductCategory.accessory}));
        products.add(new Product(14,"Tai nghe Beats Studio Buds ","Pin lên đến 8h, sử dụng kèm hộp sạc lên đến 24h",3999000,1000,500,"Beats",new ProductCategory[]{ProductCategory.accessory}));
        return products;

    }

    public void show(ArrayList<Product> products){
        for (Product p:products){
            System.out.println(p);
        }
    }

    public void searchCategory(ArrayList<Product> products,ProductCategory category){
        for (Product p:products){
            if (Arrays.toString(p.getCategories()).contains(category.toString())){
                System.out.println(p);
            }
        }
    }

    public void showCategory(){
        int i=1;
        ProductCategory[] categories=ProductCategory.values();
        for (ProductCategory p:categories){
            System.out.println(i+" - "+p.getType());
            i++;
        }
    }

    public void sortCategory(ArrayList<Product> products){
        ProductCategory[] categories=ProductCategory.values();
        ProductCategory category=ProductCategory.phone;
        System.out.println("Chọn danh mục cần xem thông tin");
        showCategory();
        System.out.println("Lựa chọn của bạn là");
        int choice= Validate.inputNumber();


        for(ProductCategory p:categories){
            if (p.getValue()==choice){
                category=p;
            }
        }
        searchCategory(products,category);
    }

    public ArrayList<String> getAllBrand(ArrayList<Product> products){
        ArrayList<String> brands=new ArrayList<>();
        brands.add(products.get(0).getBrand());
        for (int i=1;i< products.size();i++){
            int difference=0;
            for (int j=0;j<i;j++){
                if (products.get(j).getBrand().equals(products.get(i).getBrand())){
                difference++;
                }
            }
            if (difference<1){
                brands.add(products.get(i).getBrand());
            }
        }
        return brands;
    }

    public void showAllBrand(ArrayList<String> brands){
        String[] countBrand=new String[brands.size()];
        for (int i=0;i< brands.size();i++){
            System.out.println((i+1)+" - "+brands.get(i));
        }
    }

    public String chooseBrand(ArrayList<String> brands){
        String brand="";
        boolean isContinue=true;
        while (isContinue){
            System.out.println("Lựa chọn của bạn là");
            int choice=Validate.inputNumber();
            for (int i=0;i< brands.size();i++){
                if (choice==(i+1)){
                    brand=brands.get(i);
                    isContinue=false;
                    break;
                }
            }
            if (isContinue){
                System.out.println("Không có lựa chọn này");
            }
        }

        return brand;
    }

    public void sortBrand(ArrayList<Product> products,String brand){
        for (Product p:products){
            if (p.getBrand().equals(brand)){
                System.out.println(p);
            }
        }
    }

    public void sortPrice(long minPrice, long maxPrice,ArrayList<Product> products){
        for (Product p:products){
            if (p.getPrice()<=maxPrice && p.getPrice()>=minPrice){
                System.out.println(p);
            }
        }
    }

    public void searchByName(ArrayList<Product> products, String name){
        for (Product p:products){
            if (p.getName().toLowerCase().contains(name.toLowerCase().trim())){
                System.out.println(p);
            }
        }
    }

    public void countCategory(ArrayList<Product> products){

        for(ProductCategory p:ProductCategory.values()){
            int count=0;
         for (int i=0;i< products.size();i++){
             if (Arrays.toString(products.get(i).getCategories()).contains(p.toString())){
                 count++;
          }
         }
            System.out.println("Danh mục "+p.getType()+" có "+count+" sản phẩm");
        }
    }
}
