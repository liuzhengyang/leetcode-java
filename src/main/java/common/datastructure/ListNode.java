package common.datastructure;

/**
 * @author liuzhengyang
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return print();
    }

    public String print() {
        String nextPrint = null;
        if (next != null) {
            nextPrint = next.print();
        }
        return val + " -> " + nextPrint;
    }

    public static ListNode makeList(int... vals) {
        if (vals == null || vals.length == 0) {
            return null;
        }
        ListNode head = null;
        ListNode prev = null;
        for (int val : vals) {
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
                prev = newNode;
            } else {
                prev.next = newNode;
                prev = newNode;
            }
        }
        return head;
    }
}
