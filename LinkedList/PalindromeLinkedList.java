package LinkedList;

import java.util.Stack;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode list = head;
        boolean isPalindrome = false;
        if (head == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();

        while (list != null) {
            stack.push(list.val);
            list = list.next;
        }

        while (head != null) {
            if (stack.peek() == head.val) {
                stack.pop();
            }
            head = head.next;
        }
        if (stack.isEmpty()) {
            isPalindrome = true;
        }
        return isPalindrome;
    }
}
