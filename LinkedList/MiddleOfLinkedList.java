package LinkedList;

public class MiddleOfLinkedList {


    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode head = list;
        list.next = new ListNode(2);
        list.next = new ListNode(3);
        list.next = new ListNode(4);
        list.next = new ListNode(5);
        System.out.println(middleNode(head).val);
    }

    public static ListNode middleNode(ListNode head) {

        ListNode fast = head, slow = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;

        }

        return slow;
    }

    public static void insert(ListNode list, int data) {
        ListNode node = new ListNode(data);



    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
