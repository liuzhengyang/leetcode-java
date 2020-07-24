package linklist.removeduplicatesfromsortedlist;

import common.datastructure.ListNode;

/**
 * @author liuzhengyang
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = head;
        ListNode next = head.next;
        while (next != null) {
            if (prev.val == next.val) {
                prev.next = next.next;
                next = next.next;
            } else {
                prev = next;
                next = next.next;
            }
        }
        return head;
    }
}
