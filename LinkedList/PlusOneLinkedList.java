package LinkedList;

public class PlusOneLinkedList {
    public static ListNode plusOne(ListNode head) {
        // sentinel head
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode notNine = sentinel;

        // find the rightmost not-nine digit
        while (head != null) {
            if (head.val != 9) {
                notNine = head;
            }
            head = head.next;
        }

        // increase this rightmost not-nine digit by 1
        notNine.val++;
        notNine = notNine.next;

        // set all the following nines to zeros
        while (notNine != null) {
            notNine.val = 0;
            notNine = notNine.next;
        }

        return sentinel.val != 0 ? sentinel : sentinel.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(9);
        ListNode head = list;
        list.next = new ListNode(9);
        list.next.next = new ListNode(9);
        ListNode ans = plusOne(head);
        System.out.println(ans);
    }
}
