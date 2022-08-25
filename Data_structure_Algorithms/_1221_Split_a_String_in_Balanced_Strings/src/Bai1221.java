public class Bai1221 {
    public static void main(String[] args) {
        String s1 = "RLRRLLRLRL";
        String s2 = "RLLLLRRRLR";
        System.out.println(balancedStringSplit(s1));
        System.out.println(balancedStringSplit(s2));

    }

    public static int balancedStringSplit(String s) {
        int result = 0, countL = 0, countR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                countL++;
            } else {
                countR++;
            }
            if (countL == countR) {
                result++;
                countL = 0;
                countR = 0;
            }
        }
        return result;

    }
}
