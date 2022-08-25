import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Developer developer=new Developer(1,"Quân", LocalDate.of(1994,07,31),15000000, 20);
        System.out.println(developer);

        Tester tester=new Tester(2,"Nam", LocalDate.of(1994,10,15),14000000,50);
        System.out.println(tester);

    }
}
