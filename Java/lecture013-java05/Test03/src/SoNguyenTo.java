public class SoNguyenTo {
    public static void isPrimeNumber(int n) {
        boolean isPrime=true;
        if (n < 2) {
            isPrime=false;
        }
        else {
            int squareRoot = (int) Math.sqrt(n);
            for (int i = 2; i <= squareRoot; i++) {
                if (n % i == 0) {
                    isPrime=false;
                    break;
                }
            }
        }
        if (isPrime){
            System.out.println("Số được cho là số nguyên tố");
        }
        else {
            System.out.println("Số được cho không phải số nguyên tố");
        }
    }

}
