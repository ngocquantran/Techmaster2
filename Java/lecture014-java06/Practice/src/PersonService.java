import java.util.Scanner;

public class PersonService {
//    public Person[] getAllPerson(){
//        Person[] persons=new Person[3];
//        persons[0]=new Person("Quân",27,Gender.MALE,"Nhân Hậu");
//        persons[1]=new Person("Phương",27,Gender.FEMALE,"Nhân Tiến");
//        persons[2]=new Person("Hùng",27,Gender.MALE,"Hòa Hậu");
//        return persons;
//    }
    public void show(Person[] persons){
        for (Person p:persons){
            System.out.println(p);
        }
    }

    public Person createPerson(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập tên: ");
        String name= scanner.nextLine();
        System.out.println("Nhập tuổi");
        int age=Integer.parseInt(scanner.nextLine());
        System.out.println("Lựa chọn giới tính:");
        System.out.println("1 - Nữ");
        System.out.println("0 - Nam");
        int choice= Integer.parseInt(scanner.nextLine());
        Gender gender=Gender.FEMALE;
        if (choice==1){
            gender=Gender.FEMALE;
        }
        else if(choice==0){
            gender=Gender.MALE;
        }
        else {
            System.out.println("Không có lựa chọn này");
        }
        System.out.println("Nhập địa chỉ");
        String address= scanner.nextLine();

        Person newPerson=new Person(name,age,gender,address);
        return newPerson;

    }

    public Person[] addPerson(int size){
        Person[] persons=new Person[size];
        for (int i=0;i<size;i++){
            System.out.println("Nhập thông tin người thứ "+i);
            persons[i]=createPerson();
        }
             return persons;
    }





}
