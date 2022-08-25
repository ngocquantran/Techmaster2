import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {



        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");

        EmployeeService.createEmployee();
        EmployeeService.show(EmployeeService.createEmployee());


    }
}
