import java.util.ArrayList;
import java.util.List;

public class Bai0387 {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar1(s));
        System.out.println(firstUniqChar2(s));


    }

    public static int firstUniqChar1(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar2(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!s.replaceFirst("" + s.charAt(i) + "", " ").contains("" + s.charAt(i) + "")) {
                return i;
            }
        }
        return -1;
    }

}
