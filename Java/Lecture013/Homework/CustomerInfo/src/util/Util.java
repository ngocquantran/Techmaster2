package util;

import model.Customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Util {

    static Scanner scanner=new Scanner(System.in);

    public static String formatDate(LocalDate date){
        DateTimeFormatter myFormat=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(myFormat);
    }

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

//    Kiểm tra tính hợp lệ của id "KH123456"
    public static String isId(){
        String ID_PATTERN =
                "^KH\\d{6}$";
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

//    Kiểm tra tính hợp lệ của số điện thoại: 10-11 số, số 0 đầu tiên
    public static String isPhoneNumber(){
        String PHONE_PATTERN =
                "^0+\\d{9,10}$";
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

//    Kiểm tra ID có bị trùng lặp
    public static boolean duplicateId(ArrayList<Customer> customers, String id){
        int found=0;
        for (Customer c:customers){
            if (c.getId().equals(id)){
                found++;
                break;
            }
        }
        return (found>0);
    }

    //    public static String createRandomId(ArrayList<String> idList){
//        String chars="0123456789";
//        Random random=new Random();
//        StringBuilder sb=new StringBuilder("CH");
//        boolean isContinue=true;
//        while (isContinue){
//            for (int i=1;i<=6;i++){
//                sb.append(chars.charAt(random.nextInt(chars.length())));
//            }
//            if (!idList.contains(sb.toString())){
//                isContinue=false;
//            }
//        }
//        idList.add(sb.toString());
//
//        return sb.toString();
//    }




}
