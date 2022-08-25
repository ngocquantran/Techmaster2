import java.util.Arrays;

public class Bai0905 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        System.out.println(Arrays.toString(sortArrayByParity1(nums)));
        System.out.println(Arrays.toString(sortArrayByParity2(nums)));
    }

    public static int[] sortArrayByParity2(int[] nums) {
        int[] result = new int[nums.length];
        int indexL = 0;
        int indexR = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                result[indexL] = nums[i];
                indexL++;
            } else {
                result[indexR] = nums[i];
                indexR--;
            }
        }
        return result;
    }

    public static int[] sortArrayByParity1(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int t = nums[i];
                nums[i] = nums[index];
                nums[index] = t;
                index++;
            }
        }
        return nums;
    }



}
