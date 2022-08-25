package service;
import model.Account;
import java.security.PublicKey;
import java.sql.SQLOutput;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Service {

    Scanner scanner=new Scanner(System.in);

    // Kiểm tra email hợp lệ
    public boolean isEmail(String email){
        String EMAIL_PATTERN =
                "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        return Pattern.matches(EMAIL_PATTERN,email);
    }

//    Kiểm tra chiều dài username
    public boolean isLength(int length){
        return  (length<=15&&length>7);
    }

//    Kiểm tra mật khẩu bao gồm ký tự in hoa
    public boolean isContainUppercase(String password){
        boolean isFound=false;
        for (int i=0;i<password.length();i++){
            if (Character.isUpperCase(password.charAt(i))){
                isFound=true;
                break;
            }
        }
        return isFound;
    }

//    Kiểm tra mật khẩu bao gồm kí tự đặc biệt
    public boolean isSpecialCharacter(String password){
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(password);
        boolean b = m.find();
        return b;
    }

//    Nhập email (khi đăng kí và quên mật khẩu)
    public String emailInput(){
        String email="";
        boolean isContinue=false;
        while (!isContinue){
            System.out.println("Nhập email");
            email= scanner.nextLine();
            if (!isEmail(email)){
                System.out.println("Email không hợp lệ");
            }
            isContinue=isEmail(email);
        }
        return email;
    }

//    Kiểm tra email đã được sử dụng chưa
    public boolean checkEmailUsed(ArrayList<Account> accounts, String email){
        boolean isFound=false;
        for (Account a:accounts){
            if (a.getEmail().equals(email)){
                System.out.println("Email này đã được sử dụng");
                isFound=true;
                break;
            }
            else{
                isFound= false;
            }
        }
        return isFound;
    }

//    Nhập mật khẩu
    public String passwordInput(){
        String password="";
        boolean isContinue=false;
        while (!isContinue){
            System.out.println("Nhập password");
            password= scanner.nextLine();
            if(isLength(password.length()) && isContainUppercase(password) && isSpecialCharacter(password)){

                isContinue=true;
            }
            else {
                System.out.println("Password từ 7 đến 15 ký tự, chứa ký tự in hoa và đặc biệt");
            }
        }
        return password;
    }



//    Đăng kí tài khoản mới
    public Account signUp(ArrayList<Account> accounts){
        String username;
        String email="";
        String password="";



        System.out.println("Nhập username");
        username=scanner.nextLine();

        boolean isContinue=true;
        while (isContinue){
            email=emailInput();
            isContinue=checkEmailUsed(accounts,email);
        }

        password=passwordInput();

        Account account=new Account(username,email,password);

        accounts.add(account);

        return account;
    }



    public Account updateUsername(Account account, String newUsername){
        account.setUsername(newUsername);
        return account;
    }

    public Account updateEmail(Account account, String newEmail){
        account.setEmail(newEmail);
        return account;
    }

    public Account updatePassword(Account account, String newPassword){
        account.setPassword(newPassword);
        return account;
    }




}
