public class Dog {
    public String breed;
    public Size size;
    public String color;
    public int age;


    public Dog(String breed, Size size, String color, int age) {
        this.breed = breed;
        this.size = size;
        this.color = color;
        this.age = age;
    }

    public void eat(String food){
        System.out.println(breed+" eat "+food);

    }
    public void run(String speed){
        System.out.println(breed+ " run "+speed);
    }
    public void name(){

    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", size=" + size +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}
