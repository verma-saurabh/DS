package LinkedList;

import java.util.*;

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
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.first();

        TreeMap<Integer, List<Integer>> map= new TreeMap<>();
        if (map.containsKey(1)) {
            map.get(1);
            map.firstEntry();
        }
        return dummy.next;
    }

    static int Solve(int N, int[] A){
        TreeMap<Integer, List<Integer>> map= new TreeMap<>();

        for(int a:A){
            int diff= Math.abs(a);
            if(map.containsKey(diff)){
                List list= new ArrayList<Integer>();
                list= map.get(a);
                map.put(diff,list);
            }
            else{
                List list= new ArrayList<Integer>();
                list.add(a);
                map.put(diff,list);
            }
        }
        return 1;
    }

}
