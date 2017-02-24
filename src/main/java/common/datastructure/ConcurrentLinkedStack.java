package common.datastructure;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-24
 */
public class ConcurrentLinkedStack<T> {
	private AtomicReference<Node<T>> top = new AtomicReference<>();

	public void push(T t) {
		Node<T> newNode = new Node<>(t);
		Node<T> oldNode;
		do {
			oldNode = top.get();
			newNode.next = oldNode;
		} while (!top.compareAndSet(oldNode, newNode));
	}

	public T pop() {
		Node<T> oldTop = top.get();
		Node<T> newTop;
		if (oldTop == null) {
			return null;
		}
		do {
			newTop = oldTop.next;
		} while(!top.compareAndSet(oldTop, newTop));
		return oldTop.item;
	}

	private static class Node<T> {
		private T item;
		private Node<T> next;

		public Node(T item) {
			this.item = item;
		}

		public T getItem() {
			return item;
		}

		public void setItem(T item) {
			this.item = item;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public void print() {
			System.out.print(item + " =>");
			if (next != null) {
				next.print();
			}
		}
	}
	public void print() {
		top.get().print();
	}
}
