import java.util.HashSet;
import java.util.Set;

public class Bai0268 {
    public static void main(String[] args) {

    }

    public int missingNumber1(int[] nums) {
        int sum = 0;
        int numsSum = 0;
        for (int i = 0; i <= nums.length; i++) {
            sum += i;
            if (i < nums.length) {
                numsSum += nums[i];
            }
        }
        return (sum - numsSum);
    }

    public int missingNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }
}
