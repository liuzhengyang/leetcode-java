package common.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-24
 */
public class StackNodeTest {

	@Test
	public void testStack() {
		LinkedStack<Integer> stack = new LinkedStack<>();
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(1);
		stack.push(0);
		stack.push(1);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.selfPrint();
	}

}