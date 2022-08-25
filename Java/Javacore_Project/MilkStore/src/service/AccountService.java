package service;

import control.Controller;
import model.Account;
import model.AccountRole;
import model.Customer;
import util.Util;
import util.Validate;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountService {
    static Scanner scanner=new Scanner(System.in);

    public String passwordInput(){
        String password="";
        boolean isContinue=false;
        while (!isContinue){
            password= scanner.nextLine();
            if(Validate.isLength(password.length()) && Validate.isContainUppercase(password) && Validate.isSpecialCharacter(password)){
                isContinue=true;
            }
            else {
                System.out.println("Password từ 7 đến 15 ký tự, chứa ký tự in hoa và đặc biệt");
            }
        }
        return password;
    }

    public Customer signupCustomer(ArrayList<Account> accounts, ArrayList<Customer> customers){
        String phoneNumber="";
        {
            System.out.println("Nhập số điện thoại");
            boolean isContinue = true;
            while (isContinue) {
                phoneNumber = Validate.isPhoneNumber();
                isContinue = Validate.duplicatePhoneNumber(accounts, phoneNumber);
            }
        }

        System.out.println("Nhập mật khẩu");
        String password=passwordInput();

        String email="";
        {
            System.out.println("Nhập email");
            boolean isContinue = true;
            while (isContinue ) {
                email = Validate.isEmail();
                isContinue  = Validate.duplicateEmail(customers, email);
            }
        }

        System.out.println("Nhập họ tên");
        String name= scanner.nextLine();


        System.out.println("Nhập địa chỉ");
        String address= scanner.nextLine();

        String id="";
        {
            boolean isContinue=true;
            while (isContinue){
                id=Util.randomCustomerId();
                if (!Validate.duplicateAccountId(accounts,id)){
                    isContinue=false;
                }
            }

        }
        Customer newCustomer=new Customer(id,phoneNumber,password, AccountRole.Customer,name,email,address);
        customers.add(newCustomer);
        accounts.add(newCustomer);

        return newCustomer;
    }

    public Customer getCustomerFromAccount(Account account,ArrayList<Customer> customers){
        int found=0;
        for (int i=0;i<customers.size();i++){
            if (customers.get(i).getId().equals(account.getId())){
                found=i;
                break;
            }
        }
        return customers.get(found);
    }

    public Account getAccountFromPhoneNumber(ArrayList<Account> accounts,String phoneNumber){
        Account account=null;
        for (Account a:accounts){
            if (a.getPhoneNumber().equals(phoneNumber)){
                account=a;
                break;
            }
        }
        return account;
    }




}
