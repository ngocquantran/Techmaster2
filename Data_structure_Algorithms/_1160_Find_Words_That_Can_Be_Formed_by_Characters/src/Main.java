import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


    }

    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            map.put(chars.charAt(i), map.getOrDefault(chars.charAt(i), 0) + 1);
        }
        int count = 0;
        for (String w : words) {
            Map<Character, Integer> mapCopy = new HashMap<>();
            mapCopy.putAll(map);
            boolean isCheck = true;
            for (int i = 0; i < w.length(); i++) {
                if (!mapCopy.containsKey(w.charAt(i)) || mapCopy.get(w.charAt(i)) == 0) {
                    isCheck = false;
                    break;
                }
                mapCopy.put(w.charAt(i), mapCopy.get(w.charAt(i)) - 1);
            }
            if (isCheck) {
                count += w.length();
            }
        }
        return count;
    }
}
