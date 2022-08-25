package service;

import control.Controller;
import model.*;
import util.Util;
import util.Validate;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerService {
    static Scanner scanner=new Scanner(System.in);

    public void showCurrentCart(Account account,ArrayList<ShoppingCart> shoppingCarts){
        for (ShoppingCart s:shoppingCarts){
            if (s.getCustomerId().equals(account.getId())){
                System.out.println(s);
            }
        }
    }

    public ArrayList<ShoppingCart> getCurrentCart(Account account,ArrayList<ShoppingCart> shoppingCarts){
        ArrayList<ShoppingCart> currentCart=new ArrayList<>();
        for (ShoppingCart s:shoppingCarts){
            if (s.getCustomerId().equals(account.getId())){
                currentCart.add(s);
            }
        }
        return currentCart;
    }

    public void getSumOfCart(ArrayList<ShoppingCart> currentCarts){
        long sum=0;
        for (ShoppingCart s:currentCarts){
            sum=sum+s.getPrice();
        }
        System.out.println("Tổng giá trị đơn hàng: "+ Util.moneyFormat(sum));
    }



    public String getCustomerIdFromEmail(String email,ArrayList<Customer> customers){
        String id="";
        for (Customer c:customers){
            if (c.getEmail().equals(email)){
                id=c.getId();
                break;
            }
        }
        return id;
    }

    public boolean isCustomerIdAvailable(ArrayList<Account> accounts,String id){
        int found=0;
        for (Account a:accounts){
            if (a.getRole()== AccountRole.Customer && a.getId().equals(id)){
                found++;
                break;
            }
        }
        return (found>0);
    }












}
