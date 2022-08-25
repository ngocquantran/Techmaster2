package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Util {

    public static String randomId( int numberOfCharacter){
        String chars="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random=new Random();
        StringBuilder sb=new StringBuilder(numberOfCharacter);
        for (int i=0;i<numberOfCharacter;i++){
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public static String formatDate(LocalDate date){
        DateTimeFormatter myFormat=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(myFormat);
    }


}
