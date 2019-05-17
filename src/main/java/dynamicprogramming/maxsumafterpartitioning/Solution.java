package dynamicprogramming.maxsumafterpartitioning;

import java.awt.image.Kernel;
import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3));
    }

    private int[] cache;

    public int maxSumAfterPartitioning(int[] A, int K) {
        if (A == null || A.length == 0 || K <= 0) {
            return 0;
        }
        cache = new int[A.length];
        Arrays.fill(cache, -1);
        return maxSumAtIndex(A, 0, K);
    }

    private int maxSumAtIndex(int[] nums, int index, int k) {
        if (index == nums.length) {
            return 0;
        }
        if (cache[index] > -1) {
            return cache[index];
        }
        int thisMax = Integer.MIN_VALUE;
        int currentMaxNum = Integer.MIN_VALUE;
        for (int i = 0; i < k && index + i < nums.length; i++) {
            currentMaxNum = Math.max(currentMaxNum, nums[index + i]);
            thisMax = Math.max(thisMax, currentMaxNum * (i + 1) + maxSumAtIndex(nums,
                    index + i + 1, k));
        }
        cache[index] = thisMax;
        return thisMax;
    }
}
