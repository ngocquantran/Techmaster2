import java.util.*;

public class Main {
    public static void main(String[] args) {
        String paragraph =
                "Bob. hIt, baLl";
        String[] banned = {
                "bob", "hit"};
        System.out.println(mostCommonWord(paragraph,banned));

    }
    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph=paragraph.replaceAll("[!?',;.]"," ").toLowerCase();
        String[] str=paragraph.split("[\\W]+");
        System.out.println(Arrays.toString(str));
        Set<String> banStr=new HashSet<>();
        for (String b:banned){
            banStr.add(b);
        }
        System.out.println(banStr);
        int max=0;
        String result="";
        Map<String,Integer> appearance=new HashMap<>();
        for (String s:str){
            if (!banStr.contains(s.trim())){
                appearance.put(s.trim(), appearance.getOrDefault(s.trim(),0)+1);
                if (appearance.get(s.trim())>max){
                    max=appearance.get(s.trim());
                    result=s.trim();
                }
            }
        }
        System.out.println(appearance);
        return result;
    }
}
