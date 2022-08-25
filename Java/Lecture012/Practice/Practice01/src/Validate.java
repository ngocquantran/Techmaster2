public class Validate {
    public static void validateAge(int age) throws MyException{
        if (age<=0){
            throw new MyException("Tuổi không được phép nhỏ hơn hoặc bằng 0");
        }
        else {
            System.out.println("Tuổi của bạn là: "+age);
        }

    }

    public static double validateMinWeight(double weight) throws MyException{
        if (weight<=0){
            throw new MyException("Cân nặng không được nhỏ hơn 0");
        }else {
            return weight;
        }
    }
    public static double validateMaxWeight(double weight) throws MyException{
        if (weight>=200){
            throw new MyException("Cân nặng không được lớn hơn 200");
        }else {
            return weight;
        }
    }
}
