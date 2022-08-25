import java.util.Stack;

public class Bai0844 {
    public static void main(String[] args) {

    }

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!sStack.isEmpty()) {
                    sStack.pop();
                }
            } else {
                sStack.push(s.charAt(i));
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (!tStack.isEmpty()) {
                    tStack.pop();
                }
            } else {
                tStack.push(t.charAt(i));
            }
        }

        if (sStack.size() != tStack.size()) {
            return false;
        }
        for (int i = 0; i < sStack.size(); i++) {
            if (sStack.get(i) != tStack.get(i)) {
                return false;
            }
        }
        return true;

    }
}
