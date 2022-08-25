import java.util.HashMap;
import java.util.Map;

public class Bai0242 {
    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        if (sMap.size() != tMap.size()) {
            return false;
        }
        for (Character c : sMap.keySet()) {
            if (tMap.get(c) == null || !tMap.get(c).equals(sMap.get(c))) {
                return false;
            }
        }
        return true;
    }
}
