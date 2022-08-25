import java.util.ArrayList;

public class PersonModel<T> {

    ArrayList<T> arr=new ArrayList<>();

    public void add( T object){
        arr.add(object);
    }

    public void show(){
        for (T object:arr){
            System.out.println(object);
        }
    }
}
