import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] words1 = {"leetcode", "is", "amazing", "as", "is"};
        String[] words2 = {"amazing", "amazing", "leetcode", "is"};
        countWords(words1, words2);
    }

    public static int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < words1.length; i++) {
            if (map1.containsKey(words1[i])){
                map1.put(words1[i],map1.get(words1[i])+1 );
            }else {
                map1.put(words1[i],1);
            }
        }
        System.out.println(map1);
        for (int i = 0; i < words2.length; i++) {
            if (map2.containsKey(words2[i])){
                map2.put(words2[i],map2.get(words2[i])+1 );
            }else {
                map2.put(words2[i],1 );
            }
        }
        System.out.println(map2);
        int count = 0;
        for (String w : map1.keySet()) {
            if (map1.get(w) == 1 && map2.containsKey(w) && map2.get(w) == 1) {
                count++;
                System.out.println(w);
            }
        }
        return count;

    }
}
