public class Main {
    public static void main(String[] args) {
        String s1="abcabcbb";
        String s2="bbbbb";
        String s3="pwwkew";
        String s4="aab";
        String s5="dvdf";

        System.out.println(lengthOfLongestSubstring(s4));



    }
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        int result=0;
        int count=1;
        int index=1;
        while (index<s.length()){
                System.out.println("s: "+s);
                if (!s.substring(0,index).contains(""+s.charAt(index)+"")){
                    count++;
                    index++;
                }else {
                    result=Math.max(result,count);
                    count=1;
                    s=s.substring(s.indexOf(s.charAt(index))+1);
                    index=1;
                }
        }

        return Math.max(result,count);


    }
}
