import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MovieService {

    public ArrayList<Movie> createMovie(){
        ArrayList<Movie> list=new ArrayList<>();
        list.add(new Movie(1,"Tây Du Ký",90,"Thiếu nhi", 10000,1984));
        list.add(new Movie(2,"Friends",20,"Hài hước", 200000,1994));
        list.add(new Movie(3,"Trò chơi vương quyền",60,"Giả tưởng", 15000,2010));
        list.add(new Movie(4,"How I met your mother",70,"Hài hước", 1000,2006));
        list.add(new Movie(5,"Sex education",45,"Tình cảm", 60000,2018));

        return list;
    }

    public void show(ArrayList<Movie> list){
        for (Movie m:list){
            System.out.println(m);
        }
    }

    public ArrayList<Movie> nameSort(ArrayList<Movie> list){

        Collections.sort(list, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return list;
    }

    public ArrayList<Movie> lengthSort(ArrayList<Movie> list){
        Collections.sort(list, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getLength()-o2.getLength();
            }
        });
        return list;
    }

    public ArrayList<Movie> viewSort(ArrayList<Movie> list){
        Collections.sort(list, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getView()-o2.getView();
            }
        });
        return list;
    }

    public ArrayList<Movie> yearSort(ArrayList<Movie> list){
        Collections.sort(list, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getYear()-o2.getYear()>0?1:-1;
            }
        });
        return list;
    }

}
