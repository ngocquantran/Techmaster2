public class Bai0414 {
    public static void main(String[] args) {
        int[] nums = {1, 2, -2147483648};
        System.out.println(thirdMax(nums));
    }

    public static int thirdMax(int[] nums) {
        long fistMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for (Integer n : nums) {
            if (n > fistMax) {
                thirdMax = secondMax;
                secondMax = fistMax;
                fistMax = n;
            }
            if (n > secondMax && n < fistMax) {
                thirdMax = secondMax;
                secondMax = n;
            }
            if (n > thirdMax && n < secondMax) {
                thirdMax = n;
            }
            System.out.println(fistMax + " - " + secondMax + " - " + thirdMax);
        }
        if (thirdMax == Long.MIN_VALUE) return (int) fistMax;
        else return (int) thirdMax;

    }
}
