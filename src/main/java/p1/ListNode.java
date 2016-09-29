package p1;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2016-09-29
 */
public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ListNode{");
		sb.append("val=").append(val);
		sb.append(", next=").append(next);
		sb.append('}');
		return sb.toString();
	}
}
