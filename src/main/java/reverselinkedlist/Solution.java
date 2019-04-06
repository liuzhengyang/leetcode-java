package reverselinkedlist;

import common.datastructure.ListNode;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode newNode = null;
        ListNode current = head;
        ListNode next ;
        while(current != null) {
            next = current.next;
            current.next = newNode;
            newNode = current;
            current = next;
        }
        return newNode;
    }
}
