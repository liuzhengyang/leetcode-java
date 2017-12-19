package p21;

import common.datastructure.ListNode;

/**
 * @author liuzhengyang
 */
public class Main {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = l1.val < l2.val ? new ListNode(l1.val) : new ListNode(l2.val);
        ListNode nextL1 = l1.val < l2.val ? l1.next : l1;
        ListNode nextL2 = l1.val < l2.val ? l2 : l2.next;
        result.next = mergeTwoLists(nextL1, nextL2);
        return result;
    }
}
