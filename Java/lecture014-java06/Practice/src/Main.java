public class Main {
    public static void main(String[] args){
////        Animal cat=new Animal();
////        cat.name="kitty";
////        cat.age=3;
////        cat.leg=4;
////        cat.color="Trắng";
////
////        System.out.println(cat.name+" - "+cat.age+" - "+cat.leg+" - "+cat.color);
////        cat.eat("fish");
////        System.out.println(cat);
////
////        Animal dog=new Animal("Milu", 7, 4,"black");
////        System.out.println(dog);
//
//        Person person1=new Person("Jane",25,Gender.FEMALE,"HN");
//        Person.study();
//
//        System.out.println(person1);
////
//        Person person2=new Person("John",30,Gender.MALE,"HCM");
//
//        System.out.println(person2);
//
//
//
////        Dog dog1=new Dog("German Shepherds",Size.Large,"White & grey",6);
////        System.out.println(dog1);
////
////        Dog dog2=new Dog("Bulldog",Size.Large,"Light Grey",5);
////        System.out.println(dog2);

//        Person[] persons=new Person[3];
//        persons[0]=new Person("Quân",27,Gender.MALE,"Nhân Hậu");
//        persons[1]=new Person("Phương",27,Gender.FEMALE,"Nhân Tiến");
//        persons[2]=new Person("Hùng",27,Gender.MALE,"Hòa Hậu");
//
//        for (Person p:persons){
//            System.out.println(p);
//        }




        StudentService service=new StudentService();
        Student[] students= service.addStudent(3);;
        service.show(students);







    }
}
