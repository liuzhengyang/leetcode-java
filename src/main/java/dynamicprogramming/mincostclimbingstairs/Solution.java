package dynamicprogramming.mincostclimbingstairs;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        int min = new Solution().minCostClimbingStairs(new int[]{10, 15, 20});
        System.out.println(min);
    }

    private int[] cache;

    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        cache = new int[cost.length];
        return Math.min(minCost(cost, 0), minCost(cost, 1));
    }


    private int minCost(int[] cost, int i) {
        if (cache[i] > 0) {
            return cache[i];
        }
        int result;
        if (i == cost.length - 1) {
            result = cost[i];
        } else if (i == cost.length - 2) {
            result = cost[i];
        } else {
            int step1 = cost[i] + minCost(cost, i + 1);
            int step2 = cost[i] + minCost(cost, i + 2);

            result = Math.min(step1, step2);
        }

        cache[i] = result;
        return result;
    }
}
