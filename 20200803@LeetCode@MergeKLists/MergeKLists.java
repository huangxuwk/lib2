package src.com.jd.leetcode.textH;

import src.com.jd.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        for (ListNode n : lists) {
            if (n != null) {
                list.add(n);
            }
        }
        ListNode head = null;
        ListNode node = null;
        while (!list.isEmpty()) {
            int index = 0;
            ListNode min = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).val < min.val) {
                    index = i;
                    min = list.get(i);
                }
            }

            if (head == null) {
                head = min;
                node = head;
            } else {
                node.next = min;
                node = node.next;
            }
            list.remove(index);
            if (min.next != null) {
                list.add(min.next);
            }
        }
        return head;
    }

}
