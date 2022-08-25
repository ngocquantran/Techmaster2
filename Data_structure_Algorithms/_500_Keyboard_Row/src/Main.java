import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
    public String[] findWords(String[] words) {
        List<String> list=new ArrayList<>();
        String row1="qwertyuiopQWERTYUIOP";
        String row2="asdfghjklASDFGHJKL";
        String row3="zxcvbnmZXCVBNM";
        for (String w:words){
            int count1=0,count2=0,count3=0;
            for (int i=0;i<w.length();i++){
                if (row1.contains(""+w.charAt(i)+"")){
                    count1++;
                }
                if (row2.contains(""+w.charAt(i)+"")){
                    count2++;
                }
                if (row3.contains(""+w.charAt(i)+"")){
                    count3++;
                }
            }
            if (count1==w.length()) {
                list.add(w);
            }
            if (count2==w.length()) {
                list.add(w);
            }
            if (count3==w.length()) {
                list.add(w);
            }
        }
        String[] result=new String[list.size()];
        for (int i=0;i< result.length;i++){
            result[i]= list.get(i);
        }
        return result;
    }
}
