package dynamicprogramming.coinchange;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.coinChange(new int[]{1,2,5}, 11));
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null || amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        cache = new int[amount + 1];

        return doCoinChange(coins, amount);
    }

    private int[] cache;

    private int doCoinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (cache[amount] != 0) {
            return cache[amount];
        }
        boolean canChange = false;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length && coins[i] <= amount; i++) {
            int thisMin = doCoinChange(coins, amount - coins[i]);
            if (thisMin != -1) {
                min = Math.min(min, thisMin + 1);
                canChange = true;
            }
        }
        if (!canChange) {
            min = -1;
        }
        cache[amount] = min;
        return min;
    }
}
