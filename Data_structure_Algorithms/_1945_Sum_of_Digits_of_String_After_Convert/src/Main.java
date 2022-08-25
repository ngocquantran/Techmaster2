public class Main {
    public static void main(String[] args) {
        String s="iiii";
        int k = 1;
        getLucky(s,k);

    }
    public static int getLucky(String s, int k) {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<s.length();i++){
            sb.append(s.charAt(i)-'a'+1);
        }
        String str=sb.toString();
        int result=0;
        while (k>0){
            result=0;
            for (int i=0;i<str.length();i++){
                result+=Character.getNumericValue(str.charAt(i));
            }
            str=String.valueOf(result);

            k--;
        }

        return result;

    }
}
