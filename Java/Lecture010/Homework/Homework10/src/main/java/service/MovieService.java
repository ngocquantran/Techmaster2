package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Movie;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MovieService {

    public ArrayList<Movie> getAllMovie(){
        ArrayList<Movie> movies=new ArrayList<>();
        Gson gson=new Gson();

        try{
            FileReader reader=new FileReader("movie.json");
            Type type=new TypeToken<ArrayList<Movie>>(){}.getType();

            movies=gson.fromJson(reader,type);
        }catch (FileNotFoundException e){
            System.out.println("Không tìm thấy file");
        }
        return movies;
    }

    public void show(ArrayList<Movie> movies){
        for (Movie m:movies){
            System.out.println(m);
        }
    }

    public ArrayList<Movie> sortYear(ArrayList<Movie> movies){
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getYear()-o2.getYear();
            }
        });
        return movies;
    }

    public ArrayList<Movie> sortTitle(ArrayList<Movie> movies){
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return movies;
    }

    public void searchTitle(ArrayList<Movie> movies, String title){
        int found=0;
        for (Movie m:movies){
            if (m.getTitle().toLowerCase().contains(title)){
                System.out.println(m);
                found++;
            }
        }
        if (found==0){
            System.out.println("Không có phim cần tìm");
        }
    }

    public ArrayList<Movie> sortViewDown(ArrayList<Movie> movies){
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o2.getView()-o1.getView();
            }
        });
        return movies;
    }

    public void searchCategory(ArrayList<Movie> movies, String category){
        int found=0;
        for (Movie m:movies){
            if (Arrays.toString(m.getCategory()).toLowerCase().contains(category)){
                System.out.println(m);
                found++;
            }
        }
        if (found==0){
            System.out.println("Không có thể loại cần tìm");
        }
    }



}
