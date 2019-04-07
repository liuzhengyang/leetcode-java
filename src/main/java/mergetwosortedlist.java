import common.datastructure.ListNode;

/**
 * @author liuzhengyang
 */
public class mergetwosortedlist {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = null;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newNode;
        ListNode current = null;
        while(l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                newNode = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                newNode = new ListNode(l1.val);
                l1 = l1.next;
            }
            if (newHead == null) {
                newHead = current = newNode;
            } else {
                current.next = newNode;
                current = newNode;
            }
        }
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }
        return newHead;
    }


}
