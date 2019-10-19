package Stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        Stack<Character> stack = new Stack<Character>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == map.get(c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }

            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
