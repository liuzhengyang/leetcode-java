package common.datastructure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-06
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V>{


	private int cacheSize;
	public LRUCache(int size) {
		super(16, 0.75f, true);
		this.cacheSize = size;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry eldest) {
		return this.size() > cacheSize;
	}

	public static void main(String[] args) {
		LRUCache<String, Object> lruCache = new LRUCache<>(4);
		lruCache.put("1", "1");
		lruCache.put("2", "1");
		lruCache.put("3", "1");
		lruCache.put("4", "1");
		lruCache.put("5", "1");
		lruCache.get("3");
		System.out.println(lruCache);
	}
}
