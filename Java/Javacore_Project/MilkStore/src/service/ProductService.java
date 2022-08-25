package service;

import model.Account;
import model.Product;
import model.ProductCategory;
import model.ShoppingCart;
import util.Util;
import util.Validate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProductService {
    static Scanner scanner=new Scanner(System.in);

    public void showArraylist(ArrayList<?> list){
        for (Object o:list){
            System.out.println(o);
        }
    }

    public void showProductForCustomer(ArrayList<Product> products){
        for (Product p:products){
            System.out.println(
                    p.getId()+" - "
                    + p.getProductCategory()+" - "
                    + p.getName()+" - "
                    + p.getBrand()+" - "
                    + p.getOrigin()+" - "
                    + Util.moneyFormat(p.getPrice())+" VND"+" - "+p.getStatus());
        }
    }
    public void showOneProductForCustomer(Product p){
        System.out.println(
                p.getId()+" - "
                        + p.getProductCategory()+" - "
                        + p.getName()+" - "
                        + p.getBrand()+" - "
                        + p.getOrigin()+" - "
                        + Util.moneyFormat(p.getPrice())+" VND"+" - "+p.getStatus());
    }

    public ArrayList<Product> searchByName(ArrayList<Product> products,String name){
        ArrayList<Product> productByName=new ArrayList<>();
        for (Product p:products){
            if (p.getName().toLowerCase().contains(name.toLowerCase().trim())){
                productByName.add(p);

            }
        }
        return productByName;
    }

    public ArrayList<String> getBrands(ArrayList<Product> products){
        ArrayList<String> brands=new ArrayList<>();
        brands.add(products.get(0).getBrand());
        for (int i=1;i< products.size();i++){
            int count=0;
            for (int j=0;j<i;j++){
                if (products.get(j).getBrand().equals(products.get(i).getBrand())){
                    count++;
                }
            }
            if (count<1){
                brands.add(products.get(i).getBrand());
            }
        }
        return brands;
    }

    public ArrayList<String> getOrigins(ArrayList<Product> products){
        ArrayList<String> origins=new ArrayList<>();
        origins.add(products.get(0).getOrigin());
        for (int i=1;i< products.size();i++){
            int count=0;
            for (int j=0;j<i;j++){
                if (products.get(j).getOrigin().equals(products.get(i).getOrigin())){
                    count++;
                }
            }
            if (count<1){
                origins.add(products.get(i).getOrigin());
            }
        }
        return origins;
    }

    public void showAllListWithNumber(ArrayList<String> list){
        for (int i=0;i< list.size();i++){
            System.out.println((i+1)+" - "+list.get(i));
        }
    }

    public String chooseFromList(ArrayList<String> list){
        String brand="";
        boolean isContinue=true;
        while (isContinue){
            int choice= Validate.inputNumber();
            if (choice<= list.size()){
                if (choice<=0){
                    System.out.println("Không có lựa chọn này");
                }else {
                    brand=list.get((choice-1));
                    isContinue=false;
                }

            }
            else {
                System.out.println("Không có lựa chọn này");
            }
        }
        return brand;
    }

    public ArrayList<Product> searchByBrand(ArrayList<Product> products,String brand){
        ArrayList<Product> productsByBrand=new ArrayList<>();
        for (Product p:products){
            if (p.getBrand().equals(brand)){
                productsByBrand.add(p);
            }
        }
        return productsByBrand;
    }


    public ArrayList<Product> searchByOrigin(ArrayList<Product> products,String Origin){
        ArrayList<Product> productsByOrigin=new ArrayList<>();
        for (Product p:products){
            if (p.getOrigin().equals(Origin)){
                productsByOrigin.add(p);
            }
        }
        return productsByOrigin;
    }

    public Product searchProductId(ArrayList<Product> products,String id){
        Product product=null;
        for (Product p:products){
            if (p.getId().equals(id)){
                product=p;
                break;
            }
        }
        return product;
    }

    public ArrayList<Product> sortUpPrice(ArrayList<Product> products){
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice()-o2.getPrice()>0?1:-1;
            }
        });
        return products;
    }

    public ArrayList<Product> sortDownPrice(ArrayList<Product> products){
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice()-o2.getPrice()<0?1:-1;
            }
        });
        return products;
    }

    public ArrayList<Product> sortDownSellingRate(ArrayList<Product> products){
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getSoldQuantity()-o2.getSoldQuantity()<0?1:-1;
            }
        });
        return products;
    }


    public ProductCategory chooseCategory(int choice){
        ProductCategory category= ProductCategory.fresh;

            for (ProductCategory p: ProductCategory.values()){
                if (p.getNumber()==choice){
                    category=p;
                    break;
                }
            }
        return category;
    }

    public ArrayList<Product> searchByCategory(ArrayList<Product> products, ProductCategory category){
        ArrayList<Product> productsByCategory=new ArrayList<>();
        for (Product p:products){
            if (p.getProductCategory()==category){
                productsByCategory.add(p);
            }
        }
        return productsByCategory;
    }

    public boolean isProductInCart(Product product, Account account, ArrayList<ShoppingCart> carts){
       int found=0;
        for (ShoppingCart c:carts){
            if (c.getCustomerId().equals(account.getId()) && c.getItemId().equals(product.getId())){
                found++;
            }
        }
        return (found>0);
    }

    public String searchProductIdInCart(ArrayList<ShoppingCart> carts){
        String id="";

        boolean isContinue=true;
        int found=0;
        while (isContinue){
            id= scanner.nextLine();
            for (int i=0;i<carts.size();i++){
                if (carts.get(i).getItemId().equals(id)){
                    found++;
                }
            }
            if (found>0){
                isContinue=false;
            }else {
                System.out.println("Không có mã sản phẩm này trong giỏ hàng");
            }
        }
        return id;
    }



    public ProductCategory chooseProductCategory(){
        ProductCategory newCategory=ProductCategory.fresh;
        boolean isContinue=true;
        while (isContinue){
            int choose=Validate.inputNumber();
            int found=0;
            for (ProductCategory p:ProductCategory.values()){
                if (choose==p.getNumber()){
                    newCategory=p;
                    found++;
                    break;
                }
            }
            if (found>0){
                isContinue=false;
            }
            else {
                System.out.println("Không có lựa chọn này");
            }
        }
        return newCategory;
    }


}
