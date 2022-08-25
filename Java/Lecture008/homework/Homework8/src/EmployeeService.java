public class EmployeeService {
    public static Employee[] createEmployee(){
        Employee[] employees=new Employee[3];

        employees[0]=new Waiter(1,"Nam",20,8000000,2000000);
        employees[1]=new Kitchen(2,"Nga",21,7000000,2500000);
        employees[2]=new Waiter(3,"Phong",25,8000000,1000000);

        return employees;
    }


    public static void show(Employee[] employees){
        for(Employee e:employees){
            System.out.println(e);
        }
    }

}
