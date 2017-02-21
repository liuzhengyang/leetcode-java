package common.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-16
 */
public class WordCount {
	private ConcurrentMap<String, AtomicInteger> countMap = new ConcurrentHashMap<>();

	public int count(String word) {
		AtomicInteger oldCount = countMap.get(word);
		if (oldCount == null) {
			AtomicInteger previousCount = countMap.putIfAbsent(word, new AtomicInteger(1));
			if (previousCount == null) {
				return 1;
			} else {
				return previousCount.incrementAndGet();
			}
		} else {
			return oldCount.incrementAndGet();
		}
	}
}
