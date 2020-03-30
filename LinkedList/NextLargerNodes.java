package LinkedList;

import java.util.Stack;

public class NextLargerNodes {
    int[] res;

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode head = list;
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);

        int[] ans = nextLargerNodes_1(head);
        System.out.println(ans);
    }

    public int[] nextLargerNodes(ListNode head) {

        recurssion(head, 0, new Stack<Integer>());
        return res;

    }

    public static int[] nextLargerNodes_1(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        if (head.next == null) {
            return new int[]{0};
        }

        int len = getLength(head);
        int[] res = new int[len];
        head = reverse(head);
        Stack<Integer> stk = new Stack<Integer>();

        for (int i = 0; i < len; i++) {
            while (!stk.isEmpty() && head.val >= stk.peek()) {
                stk.pop();
            }

            res[len - i - 1] = stk.isEmpty() ? 0 : stk.peek();
            stk.push(head.val);
            head = head.next;
        }

        return res;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = head;
        ListNode cur = head;
        ListNode pre;
        ListNode temp;
        while (tail.next != null) {
            pre = cur;
            cur = tail.next;
            temp = cur.next;
            cur.next = pre;
            tail.next = temp;
        }

        return cur;
    }

    private static int getLength(ListNode head) {
        int res = 0;
        while (head != null) {
            head = head.next;
            res++;
        }

        return res;
    }


    public void recurssion(ListNode node, int index, Stack<Integer> stack) {
        if (node == null) {
            res = new int[index];
            return;
        }

        recurssion(node.next, index + 1, stack);
        while (!stack.isEmpty() && stack.peek() <= node.val) {
            stack.pop();
        }
        res[index] = stack.isEmpty() ? 0 : stack.peek();
        stack.push(node.val);

    }
}

