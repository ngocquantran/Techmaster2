public class Person {
    public int id;
    public String name;
    public int age;
    public Gender gender;
    public String address;
    public static String school="Techmaster";

    public Person(String name, int age, Gender gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public void job(){

    }

    public void sleep(){

    }
    public void hobby(){

    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender.getValue() + '\'' +
                ", address='" + address + '\'' +
              ", school='"+school+ '\'';
    }

    public static void study(){
        school="CNTT";
    }


}
