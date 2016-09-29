package p1;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2016-09-29
 */
public class Main {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int i = l1.val + l2.val;
		int add = 0;
		if (i >= 10) {
			add = i/10;
			i %= 10;
		}
		ListNode result = new ListNode(i);
		ListNode nodeOne = l1.next;
		ListNode nodeTwo = l2.next;
		ListNode tmpNode;
		ListNode lastNode = result;
		while(nodeOne != null && nodeTwo != null) {
			int sum = nodeOne.val + nodeTwo.val + add;
			add = 0;
			if (sum >= 10) {
				add = sum/10;
				sum %= 10;
			}
			tmpNode = new ListNode(sum);
			lastNode.next = tmpNode;
			lastNode = tmpNode;
			nodeOne = nodeOne.next;
			nodeTwo = nodeTwo.next;
		}
		if (nodeOne != null) {
			while(nodeOne != null) {
				int sum = nodeOne.val + add;
				add = 0;
				if (sum >= 10) {
					add = sum/10;
					sum %= 10;
				}
				tmpNode = new ListNode(sum);
				lastNode.next = tmpNode;
				lastNode = tmpNode;
				nodeOne = nodeOne.next;
			}
		} else if (nodeTwo != null) {
			while(nodeTwo != null) {
				int sum = nodeTwo.val + add;
				add = 0;
				if (sum >= 10) {
					add = sum/10;
					sum %= 10;
				}
				tmpNode = new ListNode(sum);
				lastNode.next = tmpNode;
				lastNode = tmpNode;
				nodeTwo = nodeTwo.next;
			}
		}
		if (add > 0) {
			tmpNode = new ListNode(add);
			lastNode.next = tmpNode;
		}

		return result;
	}
}
