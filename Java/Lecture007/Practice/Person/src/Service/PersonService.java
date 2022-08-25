package Service;

import Model.Person;

public class PersonService {
    public static void createPerson(){
        Person person=new Person("Quân",27,"Hà Nam");
        System.out.println(person);
//        person.name="Nam";
        person.setName("Nam");
        System.out.println(person);

        System.out.println(person.getName());

    }
}
