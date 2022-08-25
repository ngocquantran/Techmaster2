import java.util.Stack;

public class Bai1544 {

    public static void main(String[] args) {
        System.out.println('A' - 'a');
        System.out.println('Z' - 'z');

    }

    public String makeGood1(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else if (Math.abs(s.charAt(i) - stack.peek()) == 32) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }
        return sb.toString();

    }

    public String makeGood2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (sb.isEmpty()) {
                sb.append(s.charAt(i));
            } else if (Math.abs(s.charAt(i) - sb.charAt(sb.length() - 1)) == 32) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
