package dynamicprogramming.houserobber;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{1}));
        System.out.println(solution.rob(new int[]{1, 2}));
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(solution.rob(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
                ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }

    private int[] cache;

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return robAtIndex(nums, 0);
    }

    private int robAtIndex(int[] nums, int i) {
        if (cache[i] > -1) {
            return cache[i];
        }
        int result;
        if (i == nums.length - 1) {
            result = nums[i];
        } else if (i == nums.length - 2) {
            result = Math.max(nums[i], nums[i + 1]);
        } else {
            result = Math.max(nums[i] + robAtIndex(nums, i + 2), robAtIndex(nums, i + 1));
        }

        cache[i] = result;
        return result;
    }
}
