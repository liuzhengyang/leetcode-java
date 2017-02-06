package p146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-06
 */
public class LRUCache {

	private int capacity;
	private LinkedHashMap<Integer, Integer> linkedHashMap = null;
	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.linkedHashMap = new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {
			@Override
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return this.size() > capacity;
			}
		};
	}

	public Integer get(Integer key) {
		Integer cache = linkedHashMap.get(key);
		if (cache == null) {
			return -1;
		}
		return cache;
	}

	public void put(Integer key, Integer value) {
		linkedHashMap.put(key, value);
	}
	public static void main(String[] args) {
		LRUCache cache = new LRUCache( 2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
	}
}
