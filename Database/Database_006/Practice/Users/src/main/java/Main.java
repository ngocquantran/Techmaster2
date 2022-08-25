import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Service service=new Service();
//        service.getAllUsers();
//        List<Users> list=service.getUsers(1);
//        service.show(list);

        List<Users> list2=service.searchByName("Olive");
        service.show(list2);

    }
}
