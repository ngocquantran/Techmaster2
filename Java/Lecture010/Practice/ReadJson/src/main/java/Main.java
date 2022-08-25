import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Person p=new Person();
//        Person p1=new Person(1,"Quân","Trần","quan@31","Nam","0962");



//        PersonService service=new PersonService();
//        ArrayList<Person> persons=service.getAllPerson();
//        service.getAllPerson();
//        service.show(persons);

        MovieService service=new MovieService();
        ArrayList<Movie> movies=service.getAllMovie();
        service.getAllMovie();
        service.showMovie(movies);


    }
}
