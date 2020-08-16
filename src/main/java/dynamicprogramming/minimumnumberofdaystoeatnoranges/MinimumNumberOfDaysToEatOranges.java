package dynamicprogramming.minimumnumberofdaystoeatnoranges;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/
 * 解法1: 最少操作次数，bfs实现，注意queue的过程中判断是否访问过，减少重复计算
 * 解法2: 由于n可能非常大，每次尽量通过-n%2或-n%3去尝试除以或除以3，然后用dp缓存结果，并且n的值比较大，改成用map保存
 * @author liuzhengyang
 */
public class MinimumNumberOfDaysToEatOranges {
    public static void main(String[] args) {
        MinimumNumberOfDaysToEatOranges minimumNumberOfDaysToEatOranges = new MinimumNumberOfDaysToEatOranges();
        System.out.println(minimumNumberOfDaysToEatOranges.minDays(10));
        System.out.println(minimumNumberOfDaysToEatOranges.minDays(6));
        System.out.println(minimumNumberOfDaysToEatOranges.minDays(1));
        System.out.println(minimumNumberOfDaysToEatOranges.minDays(56));
        System.out.println(minimumNumberOfDaysToEatOranges.minDays(2 * 10000 * 10000));
    }

    public int minDays(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 2;
        }
        return dp(n);
    }

    private int dp(int n) {
        Map<Integer, Integer> cache =new HashMap<>();
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 2);
        return doDp(n, cache);
    }

    private int doDp(int n, Map<Integer, Integer> cache) {
        Integer cacheResult = cache.get(n);
        if (cacheResult != null) {
            return cacheResult;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 2;
        }
        int min = Math.min(doDp(n / 2, cache) + n % 2 + 1, doDp(n / 3, cache) + n % 3 + 1);
        cache.put(n, min);
        return min;
    }

    private int bfs(int n) {
        int count = 0;
        int batchSize = 1;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(n);
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            count++;
            int newBatchSize = 0;
            for (int i = 0; i < batchSize; i++) {
                int poll = queue.poll();
                if (poll == 1) {
                    return count;
                } else {
                    if (!visited.contains(poll - 1)) {
                        visited.add(poll - 1);
                        queue.offer(poll - 1);
                        newBatchSize++;
                    }
                    if (poll % 2 == 0 && !visited.contains(poll / 2)) {
                        queue.offer(poll / 2);
                        visited.add(poll / 2);
                        newBatchSize++;
                    }
                    if (poll % 3 == 0) {
                        queue.offer(poll / 3);
                        visited.add(poll / 3);
                        newBatchSize++;
                    }
                }
            }
            batchSize = newBatchSize;
        }
        return 0;
    }
}
