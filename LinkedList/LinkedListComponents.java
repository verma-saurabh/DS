package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {


    public int numComponents(ListNode head, int[] G) {
        int ans = 0;

        Set<Integer> set = new HashSet<Integer>();
        for (int a : G) set.add(a);

        ListNode cur = head;

        while (cur != null) {
            if (set.contains(cur.val) && (cur.next == null || set.contains(cur.next.val))) {
                ans++;
            }
            cur = cur.next;
        }
        return ans;
    }
}
