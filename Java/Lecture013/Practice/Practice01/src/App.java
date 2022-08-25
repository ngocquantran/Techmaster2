import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Student> students=new ArrayList<>();
        students.add(new Student(1,"Hoa",9));
        students.add(new Student(2,"Nam",7));
        students.add(new Student(3,"Nga",8.5));

        ArrayList<Teacher> teachers=new ArrayList<>();
        teachers.add(new Teacher(4,"Thuấn",8000000));
        teachers.add(new Teacher(5,"Hòa",6500000));
        teachers.add(new Teacher(6,"Nga",9000000));

//        System.out.println("Danh sách học sinh là");
//        showStudent(students);
//        System.out.println("Danh sách giảng viên");
//        showTeacher(teachers);

        System.out.println("Danh sách học sinh là");
        show(students);
        System.out.println("Danh sách giảng viên");
        show(teachers);

        ArrayList<Animal> animals=new ArrayList<>();
        animals.add(new Animal("Cat",4,"yellow"));
        animals.add(new Animal("Dog",4,"black"));

        System.out.println("Danh sách động vật");
        show2(animals);
        show2(teachers);



    }

    public static void showStudent(ArrayList<Student> students){
        for (Student s:students){
            System.out.println(s);
        }
    }

    public static void showTeacher(ArrayList<Teacher> teachers){
        for (Teacher t:teachers){
            System.out.println(t);
        }
    }

    public static void show(ArrayList<Student> list){
        for (Object o:list){
            System.out.println(o);
        }
    }

    public static void show2(ArrayList<?> list){
        for (Object o:list){
            System.out.println(o);
        }
    }

    public static void show3(ArrayList<? super Teacher> list){
        for (Object o:list){
            System.out.println(o);
        }
    }
}
