package Stack;

import java.util.Stack;
import java.util.stream.IntStream;

/*
Reverse a stack using recursion
 */
public class ReverseStack {
    private Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

        ReverseStack obj = new ReverseStack();
        obj.addElement();
        obj.display();
        obj.reverse();
        obj.display();
    }

    private void display() {
        for(int s:stack)
            System.out.println(s);
    }

    public void addElement() {
        IntStream.range(0, 5).forEach(i -> stack.push(i));
    }

    public void reverse() {

        if (!stack.isEmpty()) {
            int top = stack.pop();
            reverse();
            insertAtBottom(top);
        }
    }

    public void insertAtBottom(int top) {

        if (stack.isEmpty()) {
            stack.push(top);
            return;
        }

        int num = stack.pop();
        insertAtBottom(top);
        stack.push(num);
    }
}
