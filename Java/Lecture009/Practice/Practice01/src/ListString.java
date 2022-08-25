import java.util.ArrayList;

public class ListString {

    public void createString() {
        ArrayList<String> names=new ArrayList<>();
        names.add("Quang");
        names.add("Nam");
        names.add("Nga");
        names.add("Kiên");
        names.add("Nam");

        System.out.println("\nDanh sách ban đầu");
        for (String n:names){
            System.out.print(n+"\t");
        }

        names.remove("Nam");
        System.out.println("\nDanh sách sau khi xóa");
        for (String n:names){
            System.out.print(n+"\t");
        }

    }
}
