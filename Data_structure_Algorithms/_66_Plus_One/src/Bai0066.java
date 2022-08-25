import java.util.Arrays;

public class Bai0066 {
    public static void main(String[] args) {
        int[] digit1 = {1, 2, 3};
        int[] digit2 = {1, 9, 9, 9, 9};
        int[] digit3 = {9, 9, 9, 9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digit1)));
        System.out.println(Arrays.toString(plusOne(digit2)));
        System.out.println(Arrays.toString(plusOne(digit3)));

    }

    public static int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
            return digits;
        }
        digits[digits.length - 1] = 0;
        for (int i = digits.length - 2; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 0; i < digits.length; i++) {
            result[i + 1] = digits[i];
        }
        return result;
    }
}
