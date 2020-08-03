package src.com.jd.leetcode.textH;

import src.com.jd.leetcode.util.ListNode;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return null;
        }
        int count = 0;
        ListNode pre = null;
        ListNode cur = null;
        ListNode node = head;
        while (node != null) {
            if (pre != null) {
                pre = pre.next;
            }
            if (cur != null) {
                cur = cur.next;
            }
            if (count == n) {
                pre = head;
            }
            if (count == n - 1) {
                cur = head;
            }
            node = node.next;
            count++;
        }
        if (pre == null) {
            return cur.next;
        }
        if (n == 1) {
            pre.next = null;
        } else {
            pre.next = pre.next.next;
        }
        return head;
    }

}
