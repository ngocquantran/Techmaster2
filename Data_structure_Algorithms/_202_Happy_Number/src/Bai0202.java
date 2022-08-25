import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Bai0202 {
    public static void main(String[] args) {
        System.out.println(isHappy1(7));

    }


    public static boolean isHappy1(int n) {
        if (n == 1) return true;
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (true) {
            int number = 0;
            while (n >0) {
                number += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = number;
            if (n == 1) return true;
            if (set.contains(n)) return false;
            set.add(n);
        }
    }

    public static boolean isHappy2(int n) {
        if (n == 1) return true;
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (true) {
            String str = String.valueOf(n);
            int number = 0;
            for (int i = 0; i < str.length(); i++) {
                number += Math.pow(str.charAt(i) - '0', 2);
            }
            n = number;
            if (n == 1) return true;
            if (set.contains(n)) return false;

            set.add(n);
        }

    }


}
