public class Bai1662 {
    public static void main(String[] args) {
        String[] word1 = {"a", "cb"};
        String[] word2 = {"ab", "c"};
        System.out.println(arrayStringsAreEqual(word1, word2));

    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String w : word1) {
            sb1.append(w);
        }
        for (String w : word2) {
            sb2.append(w);
        }
        return sb1.toString().equals(sb2.toString());
    }
}
