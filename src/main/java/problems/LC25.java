package problems;

import common.datastructure.ListNode;

/**
 * @author liuzhengyang <liuzhengyang@kuaishou.com>
 * Created on 2024-02-19
 */
public class LC25 {
    public static void main(String[] args) {
        System.out.println(new LC25().reverseKGroup(
                ListNode.makeList(1,2,3,4,5), 2
        ));
        System.out.println(new LC25().reverseKGroup(
                ListNode.makeList(1,2,3,4,5,6), 2
        ));
        System.out.println(new LC25().reverseKGroup(
                ListNode.makeList(1,2,3,4,5), 1
        ));
        System.out.println(new LC25().reverseKGroup(
                ListNode.makeList(1,2,3,4,5), 3
        ));
        System.out.println(new LC25().reverseKGroup(
                ListNode.makeList(1,2,3,4,5), 4
        ));;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        for (int i = 1; i < k; i++) {
            tail = tail.next;
            if (tail == null) {
                return head;
            }
        }
        ListNode nextHead = tail.next;
        tail.next = null;
        ListNode[] listNodes = doReverse(head);
        ListNode newHead = listNodes[0];
        ListNode newTail = listNodes[1];
        newTail.next = reverseKGroup(nextHead, k);
        return newHead;
    }

    // [head,tail]
    private ListNode[] doReverse(ListNode head) {
        // null check
        ListNode newHead = null;
        ListNode newTail = head;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return new ListNode[] {newHead, newTail};
    }
}
