import java.util.Scanner;

public class Triangle {

    public void checkTriangle(){
        boolean isContinue=true;
        while (isContinue){
            System.out.println("Nhập chiều dài cạnh a");
            double a=input();
            System.out.println("Nhập chiều dài cạnh b");
            double b=input();
            System.out.println("Nhập chiều dài cạnh c");
            double c=input();
            if ((a+b)>c&&(a+c)>b&&(b+c)>a){
                isContinue=false;
            }
            else {
                System.out.println("Ba cạnh chưa đủ điều kiện tạo thành tam giác");
            }
        }

    }

    public double input(){
        Scanner scanner=new Scanner(System.in);
        double edge=0;
        boolean isContinue=true;
        while (isContinue){
            try {
                edge=Double.parseDouble(scanner.nextLine());
                if (edge<=0){
                    throw new MyException("Kích thước cạnh phải lớn 0");

                }
                isContinue=false;
            }catch (MyException e){
                System.out.println(e.getMessage());
                System.out.println("Nhập lại");

            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
                System.out.println("Nhập lại");

            }
        }
        return edge;
    }
}
