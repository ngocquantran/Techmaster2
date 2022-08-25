import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Validate {
    static Scanner scanner=new Scanner(System.in);

    public static boolean isIdCategoryAvailable(ArrayList<Post> posts,int id){
        int found=0;
        for (Post p:posts){
            if (id==p.getIdCategory()){
                found++;
                break;
            }
        }
        return (found>0);
    }

    public static boolean isIdAuthorAvailable(ArrayList<Post> posts,int id){
        int found=0;
        for (Post p:posts){
            if (id==p.getIdAuthor()){
                found++;
                break;
            }
        }
        return (found>0);
    }

    public static boolean isIdAPostAvailable(ArrayList<Post> posts, int id){
        int found=0;
        for (Post p:posts){
            if (id==p.getId()){
                found++;
                break;
            }
        }
        return (found>0);
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

    public static String FormatDate(LocalDate date){
        DateTimeFormatter myFormatDate=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(myFormatDate);
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
