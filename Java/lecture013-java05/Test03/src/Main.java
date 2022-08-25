import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random random=new Random();
        int rdNumber= random.nextInt(1000);
        System.out.println("Số ngẫu nhiên được cho là: "+rdNumber);


       SoNguyenTo.isPrimeNumber(rdNumber);

    }


}
