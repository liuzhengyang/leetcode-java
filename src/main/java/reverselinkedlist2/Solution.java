package reverselinkedlist2;

import common.datastructure.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head;
        head = ListNode.makeList(1, 2, 3, 4, 5);
        System.out.println(head.print());
        head = ListNode.makeList(1, 2, 3, 4, 5);
        System.out.println(new Solution().reverseBetween(head, 1, 2).print());
        head = ListNode.makeList(1, 2, 3, 4, 5);
        System.out.println(new Solution().reverseBetween(head, 1, 1).print());
        head = ListNode.makeList(1, 2, 3, 4, 5);
        System.out.println(new Solution().reverseBetween(head, 1, 5).print());
        head = ListNode.makeList(1, 2, 3, 4, 5);
        System.out.println(new Solution().reverseBetween(head, 5, 5).print());
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode firstPartTail = null;
        ListNode firstPartHead = null;
        ListNode midPartHead;
        ListNode midPartTail;
        ListNode current = head;
        if (m > 1) {
            firstPartHead = head;
        }
        for (int i = 1; i < m; i++) {
            firstPartTail = current;
            current = current.next;
        }

        midPartTail = current;
        midPartHead = null;
        ListNode next;

        for (int i = m; i <= n; i++) {
            next = current.next;
            current.next = midPartHead;
            midPartHead = current;
            current = next;
        }

        if (firstPartTail != null) {
            firstPartTail.next = midPartHead;
        }
        if (midPartTail != null) {
            midPartTail.next = current;
        }

        return firstPartHead != null ? firstPartHead : midPartHead;
    }
}
