package LinkedList;

import java.util.Stack;

public class AddTwoNumbersLinkedListWithRecurssion {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = null;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int sum = s1.pop() + s2.pop() + carry;
            carry = sum / 10;
            sum = sum % 10;

            ListNode node = new ListNode(sum);
            if (head == null) {
                head = node;
            } else {
                node.next = head;
                head = node;
            }

        }
        if (!s1.isEmpty()) {
            while (!s1.isEmpty()) {
                int sum = s1.pop() + carry;
                carry = sum / 10;
                sum = sum % 10;
                ListNode node = new ListNode(sum);
                node.next = head;
                head = node;
            }

        }
        if (!s2.isEmpty()) {
            while (!s2.isEmpty()) {
                int sum = s2.pop() + carry;
                carry = sum / 10;
                sum = sum % 10;
                ListNode node = new ListNode(sum);
                node.next = head;
                head = node;
            }
        }

        if(carry!=0){
            ListNode node = new ListNode(carry);
            node.next = head;
            head = node;
        }

        return head;

    }

}
