package LinkedList;

/*
 * 92. Reverse Linked List II
 * */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0), prevTail = dummy, prev = head, curr = head.next;
        dummy.next = head;

        // Move to the m position
        int i = 1;
        for (; i < m; i++) {
            curr = curr.next;
            prev = prev.next;
            prevTail = prevTail.next;
        }

        // Start reversing
        for (; i < n; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // Connect the reversed part with the original list
        prevTail.next.next = curr;
        prevTail.next = prev;

        return dummy.next;
    }

}
