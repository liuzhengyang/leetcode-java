package linklist.removeduplicatesfromsortedlist;

import common.datastructure.ListNode;

/**
 * @author liuzhengyang
 */
public class RemoveDuplicatesFromSortedList2 {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode next = head.next;
        ListNode nextNext = head.next.next;
        while (next != null) {

        }

        return null;
    }

    private ListNode removeValue(ListNode root, Integer value) {
        if (value == null) {
            return root;
        }
        return null;
    }
}
