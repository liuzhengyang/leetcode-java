package problems;

import java.util.Comparator;
import java.util.PriorityQueue;

import common.datastructure.ListNode;

/**
 * @author liuzhengyang <liuzhengyang@kuaishou.com>
 * Created on 2024-02-19
 */
public class LC23 {
    public static void main(String[] args) {
        System.out.println(new LC23().mergeKLists(
                new ListNode[] {
                        ListNode.makeList(1,4,5),
                        ListNode.makeList(1,3,6),
                        ListNode.makeList(2,6)
                }
        ));
        System.out.println(new LC23().mergeKLists(new ListNode[] { ListNode.makeList(1)}));
    }
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            ListNode result = null;
            ListNode tail = null;
            PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(p -> p.val));
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    priorityQueue.add(lists[i]);
                }
            }
            while (!priorityQueue.isEmpty()) {
                ListNode poll = priorityQueue.poll();
                ListNode next = poll.next;
                poll.next = null;
                if (next != null) {
                    priorityQueue.add(next);
                }
                if (result == null) {
                    result = poll;
                    tail = poll;
                } else {
                    tail.next = poll;
                    tail = poll;
                }
            }
            return result;
        }
}
