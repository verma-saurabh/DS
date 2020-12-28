package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/
 **/
public class GenerateParentheses {
    HashMap<Character, Character> map = new HashMap<>();

    public static void main(String[] args) {
        GenerateParentheses obj = new GenerateParentheses();
        obj.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        loadMap();
        List<String> ans = new ArrayList<>();
        List<String> result = new ArrayList<>();
        //generateCombinations(ans, 2 * n, "");
        generateCombinations_backtrack(ans, n, "", 0, 0);
        for (String str : ans) {
            if (isWellFormed(str)) {
                result.add(str);
            }
        }
        return result;
    }

    public boolean isWellFormed(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
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

    public void loadMap() {
        map.put(')', '(');
    }

    public void generateCombinations(List<String> ans, int length, String str) {
        if (str.length() == length) {
            ans.add(str);
            return;
        }

        generateCombinations(ans, length, str + '(');
        generateCombinations(ans, length, str + ')');

    }

    public void generateCombinations_backtrack(List<String> ans, int n, String str, int open, int close) {
        if (str.length() == 2 * n) {
            ans.add(str);
            return;
        }

        if (open < n) {
            generateCombinations_backtrack(ans, n, str + '(', open + 1, close);
        }
        // At this step if you do close< n , then it would generate combinations where the number of brackets is equal
        // but also includes those results which are not valid
        if (close < open) {
            generateCombinations_backtrack(ans, n, str + ')', open, close + 1);
        }


    }
}
