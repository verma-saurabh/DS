package LinkedList;

import java.util.Stack;

/*
 * 1290. Convert Binary Number in a Linked List to Integer
 * */
public class BinaryNumberToInteger {
    public static int getDecimalValue(ListNode head) {
        int ans = 0, t = 0;
        Stack<Integer> stack = new Stack<>();

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            ans += Math.pow(2, t) * stack.pop().intValue();
            t++;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode head = list;
        list.next = new ListNode(0);
        list.next.next = new ListNode(1);
        System.out.println(getDecimalValue(head));
    }
}
