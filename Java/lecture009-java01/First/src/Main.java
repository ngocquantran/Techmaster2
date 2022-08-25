import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class Main {
    public static double point;
    public static void main(String[] args) {
        String name="Quan";
        System.out.println(name);

        String address=new String("Hanoi");
        System.out.println(address);





        System.out.println("Hello world");
        int age;
        age=25;

        long salary=3000000L;

        float height=1.5f;
        double weight=48.5;

        char ch='a';
        point=10;
        myMethod();

        Person p=new Person();
        p.introduce();
        Person.introduce();


        System.out.println(Person.sum( 10, 10 ));

        int i=Person.sum(30, 15);
        System.out.println(i);

        System.out.println(Person.multi(3,9));

        int m=Person.multi(4,5);
        System.out.println(m);

        boolean isCheck=Person.compare(5,10);
        System.out.println((isCheck));

        String ten="Quan";
        int tuoi=27;
        String diachi="Hà Nam";
        introduce(ten,tuoi,diachi);

       double cannang=60;
       double chieucao=1.7;
       double bmi=bmi(60,1.7);
        System.out.println("Chỉ số BMI của bạn là: " + bmi);


        String noio ="    HN";
        System.out.println(noio.trim());

        Date thuhai=Date.MONDAY;
        System.out.println(thuhai);

    }
    public static void introduce(String name, int age, String address){
//        System.out.println("Tôi tên là " + name);
//        System.out.println("Năm nay tôi " + age + "tuổi");
        System.out.printf("Tôi tên là %s,năm nay tôi %d tuổi", name, age);
    }

    public static double bmi(double weight, double height){
        return weight/height/height;
    }



    public static void myMethod(){
        System.out.println("toi ten la quan");
    }
}
