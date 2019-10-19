package Stack;

import java.util.HashMap;
import java.util.Stack;

public class MinimumAddForValidParenthesis {

    public static void main(String[] args) {
        String S = "())";
        System.out.println(minAddToMakeValid(S));
    }

    public static int minAddToMakeValid(String S) {

        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        Stack<Character> stack = new Stack<Character>();

        for (char c : S.toCharArray()) {
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


        return stack.size();

    }
}
