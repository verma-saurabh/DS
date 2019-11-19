package LinkedList;

public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode head = list;
        RemoveLinkedListElements.insert(head, 2);
        RemoveLinkedListElements.insert(head, 6);
        RemoveLinkedListElements.insert(head, 3);
        RemoveLinkedListElements.insert(head, 4);
        RemoveLinkedListElements.insert(head, 5);
        RemoveLinkedListElements.insert(head, 6);


        list = RemoveLinkedListElements.removeElements(head, 6);

        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }


    }

    public static ListNode removeElements(ListNode head, int val) {

        if (head == null) return null;

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode node = fakeHead;
        while (node.next != null) {
            if (node.next.val == val) {

                node.next=node.next.next;
            } else {
                node = node.next;
            }
        }
        return fakeHead.next;
    }

    public static ListNode insert(ListNode head, int data) {
        ListNode new_node = new ListNode(data);
        new_node.next = null;

        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }

        // Insert the new_node at last node
        last.next = new_node;


        // Return the list by head
        return head;
    }
}

