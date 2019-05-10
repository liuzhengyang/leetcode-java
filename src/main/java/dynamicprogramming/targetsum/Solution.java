package dynamicprogramming.targetsum;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 981};
        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(nums, 1000000000));
    }

    private int[][] cache;
    private static final int MAX_SUM = 1000;
    private static final int MAX_CACHE_LENGTH = 2 * MAX_SUM + 2;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (S > MAX_SUM || S < -MAX_SUM) {
            return 0;
        }
        cache = new int[nums.length][];
        for (int i = 0; i < nums.length; i++) {
            cache[i] = new int[MAX_CACHE_LENGTH];
            Arrays.fill(cache[i], -1);
        }
        return doFindTarget(0, S, nums);
    }

    private int doFindTarget(int index, int s, int[] nums) {
        int indexOfSum = getSumCacheIndex(s);
        if (indexOfSum >= MAX_CACHE_LENGTH || indexOfSum < 0) {
            return 0;
        }
        if (cache[index][indexOfSum] > -1) {
            return cache[index][indexOfSum];
        }
        int result = 0;
        if (index == nums.length - 1) {
            int count = 0;
            if (nums[index] == s) {
                count++;
            }
            if (nums[index] == -s) {
                count++;
            }
            result = count;
        } else {
            // + nums[index]
            int thisResult = 0;
            int posResult = doFindTarget(index + 1, s - nums[index], nums);
            if (posResult != 0) {
                thisResult += posResult;
            }
            int negResult = doFindTarget(index + 1, s + nums[index], nums);
            if (negResult != 0) {
                thisResult += negResult;
            }
            result = thisResult;
        }
        cache[index][indexOfSum] = result;
        return result;
    }

    private int getSumCacheIndex(int s) {
        return 1000 + s;
    }
}
