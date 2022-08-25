public class Main {
    public static void main(String[] args) {

    }
    public boolean detectCapitalUse(String word) {
        if(word.length()==1) return true;
        if (word.equals(word.toLowerCase())) return true;
        if (word.equals(word.toUpperCase())) return true;
        String s1=""+word.charAt(0)+"";
        String s2=word.substring(1);
        if (s1.equals(s1.toUpperCase()) && s2.equals(s2.toLowerCase())) return true;
        return false;
    }
}
