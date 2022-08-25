import java.util.HashSet;
import java.util.Set;

public class Bai0217 {
    public static void main(String[] args) {

    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> mySet = new HashSet<>();
        for (int n : nums) {
            if (mySet.contains(n)) {
                return true;
            }
            mySet.add(n);
        }
        return false;
    }
}
