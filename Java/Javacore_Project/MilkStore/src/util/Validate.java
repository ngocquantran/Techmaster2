package util;

import model.Account;
import model.Customer;
import model.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    static Scanner scanner=new Scanner(System.in);

    //    Kiểm tra tính hợp lệ của email
    public static String isEmail(){
        String EMAIL_PATTERN =
                "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        String email="";
        boolean isContinue=true;
        while (isContinue){
            email= scanner.nextLine();
            if (!Pattern.matches(EMAIL_PATTERN,email)){
                System.out.println("Email không hợp lệ");
            }
            else {
                isContinue=false;
            }
        }
        return  email;
    }

    public static int inputNumber(){
        int number=0;
        boolean isContinue=true;
        while (isContinue){
            try {
                number=Integer.parseInt(scanner.nextLine());
                isContinue=false;
            }catch (NumberFormatException e){
                System.out.println("Vui lòng nhập số");
            }
        }
        return number;
    }

    public static long inputLongNumber(){
        long number=0;
        boolean isContinue=true;
        while (isContinue){
            try {
                number=Long.parseLong(scanner.nextLine());
                isContinue=false;
            }catch (NumberFormatException e){
                System.out.println("Vui lòng nhập số");
            }
        }
        return number;
    }

    public static int inputPositiveNumber(){
        int number=0;
        boolean isContinue=true;
        while (isContinue){
            try {
                number=Integer.parseInt(scanner.nextLine());
                if (number<0){
                    throw new MyException("Vui lòng nhập số lượng lớn hơn hoặc bằng không");
                }
                isContinue=false;
            }catch (NumberFormatException e){
                System.out.println("Vui lòng nhập số");
            }catch (MyException e){
                System.out.println(e.getMessage());
            }
        }
        return number;
    }

    public static String isPhoneNumber(){
        String PHONE_PATTERN =
                "^0+\\d{9}$";
        String phoneNumber="";
        boolean isContinue=true;
        while (isContinue){
            phoneNumber= scanner.nextLine();
            if (!Pattern.matches(PHONE_PATTERN,phoneNumber)){
                System.out.println("Số điện thoại không hợp lệ");
            }
            else {
                isContinue=false;
            }
        }
        return phoneNumber;
    }

    public static String isIdProduct(){
        String ID_PATTERN="^MI+\\d{6}$";
        String id="";
        boolean isContinue=true;
        while (isContinue){
            id= scanner.nextLine();
            if (!Pattern.matches(ID_PATTERN,id)){
                System.out.println("ID không hợp lệ");
            }
            else {
                isContinue=false;
            }
        }
        return id;
    }

    public static boolean duplicateProductId(ArrayList<Product> products,String id){
        int found=0;
        for (Product p:products){
            if (p.getId().equals(id)){
                found++;
                break;
            }
        }
        return (found>0);
    }
    public static boolean duplicateAccountId(ArrayList<Account> accounts,String id){
        int found=0;
        for (Account a:accounts){
            if (a.getId().equals(id)){
                found++;
                break;
            }
        }
        return (found>0);
    }

    public static boolean duplicatePhoneNumber(ArrayList<Account> accounts, String phoneNumber){
        int found=0;
        for (Account a:accounts){
            if(a.getPhoneNumber().equals(phoneNumber)){
                found++;
                break;
            }
        }
        if (found>0){
            System.out.println("Số điện thoại đã được sử dụng");
        }
        return (found>0);
    }

    public static boolean duplicateEmail(ArrayList<Customer> customers, String email){
        int found=0;
        for (Customer c:customers){
            if(c.getEmail().equals(email)){
                found++;
                break;
            }
        }
        if (found>0){
            System.out.println("Email này đã được sử dụng");
        }
        return (found>0);
    }

    public static boolean isContainUppercase(String password){
        boolean isFound=false;
        for (int i=0;i<password.length();i++){
            if (Character.isUpperCase(password.charAt(i))){
                isFound=true;
                break;
            }
        }
        return isFound;
    }

    public static boolean isSpecialCharacter(String password){
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(password);
        boolean b = m.find();
        return b;
    }

    public static boolean isLength(int length){
        return  (length<=15&&length>7);
    }

    public static int inputInLimit(int min, int max){
        int number=0;
        boolean isContinue=true;
        while (isContinue){
            number=Validate.inputNumber();
            if (number>max){
                System.out.println("Chỉ có "+max+" sản phẩm");
            }
            else if (number<min){
                System.out.println("Chọn số lượng lớn hơn bằng "+min);
            }
            else {
                isContinue=false;
            }
        }
        return number;
    }

    public static int inputNumberBiggerThanZero(){
        int number=0;
        boolean isContinue=true;
        while (isContinue){
            number=Validate.inputNumber();
            if (number<=0){
                System.out.println("Nhập số lượng lớn hơn 0");
            }
            else {
                isContinue=false;
            }
        }
        return number;
    }


    public static LocalDate inputDateFormat(){
        Scanner scanner=new Scanner(System.in);
        String inputDate="";
        SimpleDateFormat myFormat=new SimpleDateFormat("dd/MM/yyyy");
        Date date=new Date();
        myFormat.setLenient(false);
        boolean isContinue=true;
        while (isContinue){
            try{
                inputDate= scanner.nextLine();
                date=myFormat.parse(inputDate);
                isContinue=false;
            }catch (ParseException e){
                System.out.println("Không đúng định dạng ngày dd/MM/yyyy");
            }
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
