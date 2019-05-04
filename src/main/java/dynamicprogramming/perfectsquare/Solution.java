package dynamicprogramming.perfectsquare;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        int i = new Solution().numSquares(47);
        System.out.println(i);
    }

    private Map<Integer, Integer> cache;

    public int numSquares(int n) {
        cache = new HashMap<>();
        cache.put(0, 0);
        return doNumSquare(n);
    }

    private int doNumSquare(int n) {
        Integer value = cache.get(n);
        if (value != null) {
            return value;
        }
        if (n == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(doNumSquare(n - i * i) + 1, min);
        }
        cache.put(n, min);
        return min;
    }
}
