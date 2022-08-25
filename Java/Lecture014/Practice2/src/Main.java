import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Integer> list=new ArrayList<>();
//        list.add(1);
//        list.add(6);
//        list.add(2);
//        list.add(8);
//        list.add(5);
//        list.add(9);
//
//        for (Integer a:list){
//            System.out.print(a+"\t");
//        }
//        System.out.println();
//
//        list.forEach(number -> System.out.print(number+"\t"));
//
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        });
//        System.out.println();
//
//        list.forEach(number -> System.out.print(number+"\t"));
//
//        list.sort((number1,number2 ->number1-number2));

//        List<String> names= Arrays.asList("Java","HTML/CSS","PHP","Python","JS");
//        names.stream().forEach(name -> System.out.print(name+"\t"));
//
//        System.out.println();
//
//        names.stream().filter(name -> name.contains("J"))
//                .forEach(name -> System.out.print(name+"\t"));
//        System.out.println();
//
//        long count=names.stream().filter(name -> name.contains("J"))
//                .count();
//
//        System.out.println("Số phần tử có chữ J là: "+count);
//        System.out.println();
//
//        System.out.println("Sắp xếp thứ tự");
//        names.stream().sorted().forEach(name -> System.out.print(name+"\t"));
//
//        System.out.println("\nSắp xếp ngược lại");
//        names.stream().sorted((name1, name2) ->name2.compareTo(name1))
//                .limit(3)
//                .forEach(name -> System.out.print(name+"\t"));
//
//        System.out.println("\nSắp xếp ngược lại");
//        names.stream().sorted((name1, name2) ->name2.compareTo(name1))
//                .limit(3)
//                .skip(2)
//                .forEach(name -> System.out.print(name+"\t"));
//
//        System.out.println();
//
//        names.stream().map(name ->"Học "+name)
//                .forEach(name -> System.out.println(name));

        ArrayList<Employee> employees=new ArrayList<>();
        employees.add(new Employee("Quân",27,"Hà Nam"));
        employees.add(new Employee("Ngọc",25,"Nam Định"));
        employees.add(new Employee("Lan",23,"Hà Nội"));
        employees.add(new Employee("An",40,"Hà Nội"));

        System.out.println("In sử dụng lambda");
        employees.stream().forEach(employee -> System.out.println(employee));

//        System.out.println("Sắp xếp theo tên");
//        employees.sort(new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
//        show(employees);

        System.out.println("Sắp xếp theo tên bằng lambda");
        employees.sort((e1,e2) ->e1.getName().compareTo(e2.getName()));
        show(employees);

        System.out.println("Sắp xếp theo tên bằng lambda và in bằng stream");
        employees.stream().sorted((e1,e2)->e2.getName().compareTo(e1.getName()))
                .forEach(employee -> System.out.println(employee));

        System.out.println("Những người có tuổi lớn hơn 25");
        employees.stream().filter(employee -> employee.getAge()>25)
                .forEach(employee -> System.out.println(employee));











    }

    public static void show(ArrayList<Employee> employees){
        employees.stream().forEach(employee -> System.out.println(employee));
    }
}
