package util;

import model.Customer;
import model.PurchaseHistory;
import model.Status;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Random;

public class Util {

    public static String FormatDate(LocalDate date){
        DateTimeFormatter myFormatDate=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(myFormatDate);
    }

    public static String FormatTime(LocalTime time){
        DateTimeFormatter myFormatDate=DateTimeFormatter.ofPattern("hh:mm:ss");
        return time.format(myFormatDate);
    }

    public static String moneyFormat(long amount){
        DecimalFormat dcf=new DecimalFormat("###,###,###");
        return dcf.format(amount);
    }

    public static String randomPurchaseCode(){
        String str="0123456789";
        Random rd=new Random();
        StringBuilder sb=new StringBuilder("");

            for (int i=1;i<=6;i++){
                sb.append(str.charAt(rd.nextInt(str.length())));
            }

        return sb.toString();
    }

    public static String randomCustomerId(){
        String str="0123456789";
        Random rd=new Random();
        StringBuilder sb=new StringBuilder("CU");
        for (int i=1;i<=4;i++){
            sb.append(str.charAt(rd.nextInt(str.length())));
        }
        return sb.toString();
    }

    public static String randomStaffId(){
        String str="0123456789";
        Random rd=new Random();
        StringBuilder sb=new StringBuilder("ST");
        for (int i=1;i<=4;i++){
            sb.append(str.charAt(rd.nextInt(str.length())));
        }
        return sb.toString();
    }

    public static String randomProductId(){
        String str="0123456789";
        Random rd=new Random();
        StringBuilder sb=new StringBuilder("MI");
        for (int i=1;i<=6;i++){
            sb.append(str.charAt(rd.nextInt(str.length())));
        }
        return sb.toString();
    }

    public static String showStatus(int quantity){
        String status="";
        if(quantity>0){
            status= Status.AVAILABLE.getValue();
        }else {
            status=Status.OUTOFSTOCK.getValue();
        }
        return status;
    }





}
