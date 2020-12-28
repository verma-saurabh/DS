package LinkedList;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 23. Merge k Sorted Lists
 * */
public class MergeKList {
    public static void main(String[] args) {
        int[][] arr = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
        MergeKList obj = new MergeKList();
        obj.mergeKLists(obj.generateLinkedList(arr));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (pq.size() > 0) {
            ListNode node = pq.poll();
            pre.next = node;
            if (node.next != null) pq.offer(node.next);
            pre = pre.next;
        }

        return dummy.next;
    }

    public ListNode[] generateLinkedList(int[][] arr) {
        ListNode[] lists = new ListNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ListNode head = new ListNode(0);
            ListNode node = head;
            for (int j = 0; j < arr[i].length; j++) {
                node.next = new ListNode(arr[i][j]);
                node = node.next;
            }
            lists[i] = head.next;
        }
        return lists;
    }
}
