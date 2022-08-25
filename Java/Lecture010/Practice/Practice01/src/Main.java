import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

//        Person p1=new Person("Quân", 27,"Hà Nam");
//        System.out.println(p1);

        ArrayList<Person> list=new ArrayList<>();
        list.add(new Person("Quân",27,"Hà Nam"));
        list.add(new Person("Nam",26,"Hà Nội"));
        list.add(new Person("Kiên",25,"Nam Định"));
        list.add(new Person("Luân",24,"Hải Phòng"));
        list.add(new Person("Quang",23,"Hà Nam"));


        System.out.println("Danh sách ban đầu");
        show(list);

        Collections.sort(list);
        System.out.println("\nDanh sách sau khi sắp xếp");
        show(list);

        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("\nDanh sách sắp xếp theo tên");
        show(list);


        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        System.out.println("\nDanh sách sắp xếp theo tuổi");
        show(list);

    }

    public static void show(ArrayList<Person> list){
        for (Person p:list){
            System.out.println(p);
        }
    }
}
