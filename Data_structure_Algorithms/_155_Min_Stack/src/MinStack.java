import java.util.Stack;

public class MinStack {


    public Stack<Integer> stack=new Stack<>();
    public Stack<Integer> min=new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        if (min.isEmpty() || val<=min.peek()){
            min.push(val);
        }
    }

    public void pop() {
        int a=stack.peek();
        stack.pop();
        if (a==min.peek()){
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();

    }
}
