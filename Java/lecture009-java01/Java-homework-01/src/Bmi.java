
public class Bmi {
    public static void main(String[] args) {

        method1();

        //Trả kết quả phương thức 2
        double bmi2=method2();
        System.out.println("Cách 2: Kiểu trả về double");
        System.out.println("Chỉ số bmi của bạn: "+bmi2+"\n");

       // Trả kết quả phương thức 3
        double chieucao=1.68;
        double cannang=60.5;
        double bmi3=method3(chieucao,cannang);
        System.out.println("Cách 3: Kiểu trả về double và tham số");
        System.out.println("Chỉ số bmi của bạn: "+bmi3+"\n");


        System.out.println("So sánh: Cách trả dữ liệu sử dụng truyền tham số là tối ưu nhất do có thể linh hoạt nhập dữ liệu từ bên ngoài phương thức");
    }
    //Phương thức BMI có kiểu trả về là void
    public static void method1(){
        double chieucao=1.68;
        double cannang=60.5;
        double bmi1=cannang/(chieucao*chieucao);
        System.out.println("Cách 1: Kiểu trả về void");
        System.out.println("Chiều cao: "+chieucao);
        System.out.println("Cân nặng: "+cannang);
        System.out.println("Chỉ số bmi của bạn: "+bmi1+"\n");

    }

     //Phương thức BMI có kiểu trả về là double

     public static double method2(){
         double height=1.68;
         double weight=60.5;
         return weight/(height*height);



    }
    // Phương thức BMI có kiểu trả về là double và có truyền tham số
    public static double method3(double height, double weight){
        return weight/(height*height);

    }

}
