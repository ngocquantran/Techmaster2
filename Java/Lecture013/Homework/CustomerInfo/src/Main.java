import controll.Controller;
import model.Customer;
import service.Service;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//       Controller.program();
//    }

        Service service = new Service();
        ArrayList<Customer> customers = service.getAllCustomer();
        service.countByGender(customers);
    }
}
