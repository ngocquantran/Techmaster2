package service;

import model.Account;
import model.Bank;
import model.Transaction;
import validate.MyException;
import validate.Validate;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Service {
    public Account getAccount(){
        Account account=new Account("0962367123","12345678",5000000);
        return account;
    }


    public void showBalance(Account account){
        DecimalFormat dcf=new DecimalFormat();
        System.out.println("Số dư hiện tại là: "+dcf.format(account.getAccountBalance())+" VNĐ");
    }


    public void signIn( Account account){
        Scanner scanner=new Scanner(System.in);
        boolean repeat=true;
        while (repeat){
            System.out.println("Nhập số điện thoại");
            String phoneNumber= scanner.nextLine();
            System.out.println("Nhập password");
            String password= scanner.nextLine();
            if (!phoneNumber.equals(account.getPhoneNumber()) || !password.equals(account.getPassword())){
                System.out.println("Số điện thoại hoặc mật khẩu không đúng");
            }else {
                repeat=false;
            }
        }
    }


    public Bank getReceivedBank(){
        Bank receiveBank=Bank.BIDV;
        System.out.println("Chọn ngân hàng nhận");
        for (Bank b:Bank.values()){
            System.out.println(b.value+" - "+b);
        }
        boolean isFound=true;
        while (isFound){
            System.out.println("Lựa chọn của bạn là");
            int choice= Validate.inputNumber();

            for (Bank b:Bank.values()){
                if (choice==b.value){
                    receiveBank=b;
                    isFound=false;
                    break;
                }
            }if (isFound){
                System.out.println("Không có lựa chọn này");}
        }
        return receiveBank;
    }


    public String getReceivedAccount(){
        System.out.println("Nhập số tài khoản nhận");

        Scanner scanner=new Scanner(System.in);
        String receiveAccount="";
        final String ACOUNT_PATTERN = "\\b\\d{8,16}\\b";
        boolean isContinue=true;
        while (isContinue){
            try {
                receiveAccount= scanner.nextLine();
                if (!Pattern.matches(ACOUNT_PATTERN,receiveAccount)){
                    throw new MyException("Không hợp lệ.\nSố tài khoản là các số và từ 8 đến 16 ký tự");
                }
                isContinue=false;
            }catch (MyException e){
                System.out.println(e.getMessage());
            }
        }
        return  receiveAccount;
    }


    public long getTransactionAmount(Account account){
        Scanner scanner=new Scanner(System.in);
        long transactionAmount=0;
        if (account.getAccountBalance()<=50000){
            System.out.println("Tài khoản của bạn không đủ để thực hiện giao dịch");
        }
        else {
            System.out.println("Nhập số tiền muốn chuyển");
            boolean isContinue=true;
            while (isContinue){
                try{
                    transactionAmount=Long.parseLong(scanner.nextLine());
                    if (transactionAmount<50000){
                        System.out.println("Số tiền chuyển tối thiểu 50,000 VNĐ");
                    }else if (transactionAmount>(account.getAccountBalance()-50000)){
                        System.out.println("Số dư tài khoản không đủ");
                    }else {
                        isContinue=false;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Vui lòng nhập số");
                }
            }
        }
        return transactionAmount;
    }


    public String getDescription(){
        String description="";
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập nội dung thông điệp");
        boolean isContinue=true;
        while (isContinue){
            description=scanner.nextLine();
            if (Validate.isSpecialCharacter(description)==true){
                System.out.println("Vui lòng không nhập ký tự đặc biệt");
            }
            isContinue= Validate.isSpecialCharacter(description);
        }
        return description;
    }


    public ArrayList<Transaction> getTransaction(ArrayList<Transaction> transactions, Account account, int id){
        Date date=new Date();
        Bank receiveBank=getReceivedBank();
        String receiveAccount=getReceivedAccount();
        Long transactionAmount=getTransactionAmount(account);
        String description=getDescription();
        Transaction transaction=new Transaction(id,date,receiveBank,description,transactionAmount,receiveAccount);
        transactions.add(transaction);
        account.setAccountBalance(account.getAccountBalance()-transactionAmount);
        return transactions;
    }


    public void showHistory(ArrayList<Transaction> transactions){
        for (Transaction t:transactions){
            System.out.println(t);
        }
    }



}
