public class SoNguyenTo {
    public static void primeNumberList() {
        int count = 0;
        for (int i = 3; i < 50; i++) {

            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;

                }
            }
            if (isPrime) {
                count++;
                if (count <= 10) {
                    System.out.print(i + " ");
                }

            }
        }


    }

    public static void primeNumber10() {

        for (int i = 3; i < 50; i++) {

            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;

                }
            }
            if (isPrime) {

                if (i<10) {
                    System.out.print(i + " ");
                }

            }
        }
    }

}