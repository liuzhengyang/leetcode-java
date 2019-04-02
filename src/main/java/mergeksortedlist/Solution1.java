package mergeksortedlist;

import common.datastructure.ListNode;

/**
 * @author liuzhengyang
 */
public class Solution1 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);


        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);


        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);

        ListNode[] listNodes = new ListNode[]{listNode1, listNode2, listNode3};
        ListNode listNode = new Solution1().mergeKLists(listNodes);
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode newNode = null;
        ListNode currentNewNode = null;
        while(true) {
            Integer index = findSmallestList(lists);
            if (index == null) {
                break;
            } else {
                if (currentNewNode == null) {
                    newNode = new ListNode(lists[index].val);
                    currentNewNode = newNode;
                } else {
                    currentNewNode.next = new ListNode(lists[index].val);
                    currentNewNode = currentNewNode.next;
                }
                lists[index] = lists[index].next;
            }
        }
        return newNode;
    }

    Integer findSmallestList(ListNode[] lists) {
        Integer min = null;
        Integer startIndex = null;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                min = lists[i].val;
                startIndex = i;
                break;
            }
        }
        // if all null
        if (min == null) {
            return null;
        }
        // find smallest node index
        for (int i = startIndex; i < lists.length; i++) {
            if (lists[i] != null && min > lists[i].val) {
                min = lists[i].val;
                startIndex = i;
            }
        }
        return startIndex;
    }
}
