public class Main {
    public static void main(String[] args) {

        PersonModel students=new PersonModel();
        students.add(new Student(1,"Quân",20));
        students.add(new Student(2,"Hoa",10));
        students.add(new Student(3,"Nga",15));

        System.out.println("Danh sách học sinh");
        students.show();

        PersonModel employers=new PersonModel();
        employers.add(new Employer(4,"Lan",6000000));
        employers.add(new Employer(5,"Hoàng",7000000));
        employers.add(new Employer(6,"Vân",8000000));
        System.out.println("Danh sách nhân viên");
        employers.show();



    }
}
