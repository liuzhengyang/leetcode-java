package common.datastructure;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-24
 */
public class ConcurrentLinkedStackTest {
	@Test
	public void test() throws InterruptedException {
		final ConcurrentLinkedStack<Integer> stack = new ConcurrentLinkedStack<>();
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(3);
		stack.push(3);
		stack.push(3);
		stack.push(5);
		System.out.println(stack.pop());
		Runnable job = new Runnable() {
			@Override
			public void run() {
				stack.push(new Random().nextInt(10));
			}
		};
		Runnable popJob = new Runnable() {
			@Override
			public void run() {
				System.out.println(stack.pop());
			}
		};
		ExecutorService executorService = Executors.newFixedThreadPool(30);
		for (int i = 0; i < 100; i++) {
			executorService.submit(job);
		}
		for (int i = 0; i < 50; i++) {
			executorService.submit(popJob);
		}
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);
		stack.print();
	}

}