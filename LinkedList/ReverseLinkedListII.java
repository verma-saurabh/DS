package LinkedList;

/*
 * 92. Reverse Linked List II
 * */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int len = getLength(head);
        ListNode current = head, prev = current;
        for (int i = 0; i < m; i++) {
            prev = current;
            current = current.next;
        }

        ListNode head1 = current;
        ListNode next= current;
        for (int i = m; i < n; i++) {

        }
        prev.next = head1;

        return head;
    }

    public int getLength(ListNode head) {
        int N = 0;
        while (head != null) {
            N++;
            head = head.next;
        }
        return N;
    }

}
