package common.datastructure;

/**
 * Description: thread-not-safe stack implementation
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-21
 */
public class LinkedStack<T> {

	private class StackNode<T> {
		private T val;
		private StackNode<T> next;

		public T getVal() {
			return val;
		}

		public void setVal(T val) {
			this.val = val;
		}

		public StackNode<T> getNext() {
			return next;
		}

		public void setNext(StackNode<T> next) {
			this.next = next;
		}

		public void print() {
			System.out.println(" " + val + " =>");
			if (next != null) {
				next.print();
			}
		}
	}

	private StackNode<T> top;


	public T push(T element) {
		StackNode<T> newNode = new StackNode<>();
		newNode.setVal(element);
		if (top == null) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
		return element;
	}

	public T pop() {
		if (top == null) {
			return null;
		}
		T topValue = top.val;
		top = top.next;
		return topValue;
	}

	public void selfPrint() {
		if (top != null) {
			top.print();
		}
	}
}
