import java.util.Scanner;

public class StudentService {

//    public void show(Student[] students){
//        for (Student p:students){
//            System.out.println(p);
//        }
//
//    }

    public Student createStudent(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập id: ");
        int id= Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên: ");
        String name= scanner.nextLine();
        System.out.println("Nhập điểm lý thuyết: ");
        double diemLyThuyet= Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập điểm thực hành: ");
        double diemThucHanh= Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập trường: ");
        String truong= scanner.nextLine();

        Student newStudent=new Student(id,name,diemLyThuyet,diemThucHanh,truong);
        return newStudent;

    }

    public Student[] addStudent(int size){
        Student[] students=new Student[size];
        for (int i=0;i<size;i++){
            System.out.println("Nhập thông tin học sinh thứ "+(i+1));
            students[i]=createStudent();
        }
        return students;
    }

    public double diemTrungBinh(double diemLyThuyet, double diemThucHanh){
        return (diemLyThuyet+diemThucHanh)/2;

    }



    public void show(Student[] students){
        for (Student s:students){
            System.out.println(s+ " - "+diemTrungBinh(s.diemLyThuyet,s.diemThucHanh));
        }
    }


}
