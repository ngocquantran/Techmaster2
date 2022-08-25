import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Bai0205 {
    public static void main(String[] args) {
//        System.out.println(isIsomorphic("egg","add"));  //TRUE
        System.out.println(isIsomorphic("foo", "bar"));   //FALSE
//        System.out.println(isIsomorphic("badc","baba"));   //FALSE
        //System.out.println(isIsomorphic("egcd","adfd"));   //FALSE

    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                } else {
                    map.put(s.charAt(i), t.charAt(i));
                }
            } else if (t.charAt(i) != map.get(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
