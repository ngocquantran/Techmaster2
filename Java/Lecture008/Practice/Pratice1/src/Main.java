import java.time.LocalDate;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {

//        Student student=new Student(12,"Quan", LocalDate.of(1994,07,31),"java-08",9.0);
//        System.out.println(student);
//
//        Teacher teacher=new Teacher(13,"Ba",LocalDate.of(1992,05,15),"HTML/CSS",8000000);
//        System.out.println(teacher);


        SchoolBook book=new SchoolBook(1,"Cuốn theo chiều gió","Kim Đồng",2000,200,540,"new",20);
        System.out.println(book);


        BookService remaining=new BookService();
        System.out.println("Số sách tồn kho là "+remaining.getRemaining(book));

        Caculator.sum(5,6);
        Caculator.sum(4.5,7.8);
        Caculator.sum(1,2,3);






    }
}
