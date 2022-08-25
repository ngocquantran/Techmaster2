import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        MovieService service=new MovieService();
        ArrayList<Movie> list=service.createMovie();
        System.out.println("Danh sách ban đầu là");
        service.show(list);

        service.nameSort(list);
        System.out.println("Danh sách sắp xếp theo tên là");
        service.show(list);

        service.lengthSort(list);
        System.out.println("Danh sách sắp xếp theo độ dài là");
        service.show(list);

        service.viewSort(list);
        System.out.println("Danh sách sắp xếp theo lượt xem là");
        service.show(list);

        service.yearSort(list);
        System.out.println("Danh sách sắp xếp theo năm xuất bản là");
        service.show(list);


    }



}
