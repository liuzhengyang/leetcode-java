package dynamicprogramming.houserobber2;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{2}));
        System.out.println(solution.rob(new int[]{2,3,2}));
        System.out.println(solution.rob(new int[]{1,2,3,1}));
        System.out.println(solution.rob(new int[]{2,1,2,6,1,8,10,10}));

    }

    private int[] firstRobbedCache;
    private int[] firstNotRobbedCache;

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        firstNotRobbedCache = new int[nums.length];
        firstRobbedCache = new int[nums.length];
        Arrays.fill(firstRobbedCache, -1);
        Arrays.fill(firstNotRobbedCache, -1);
        return rob(nums, 0, false);
    }

    private int rob(int[] nums, int i, boolean firstRobbed) {
        if (firstRobbed) {
            if (firstRobbedCache[i] > -1) {
                return firstRobbedCache[i];
            }
        } else {
            if (firstNotRobbedCache[i] > -1) {
                return firstNotRobbedCache[i];
            }
        }
        boolean thisRobbed = false;
        int result;
        if (i == nums.length - 1) {
            result = firstRobbed ? 0 : nums[i];
        } else if (i == nums.length - 2) {
            result = firstRobbed ? nums[i] : Math.max(nums[i], nums[i + 1]);
        } else {
            int robMax = nums[i] + rob(nums, i + 2, i == 0 || firstRobbed);
            int notRobMax = rob(nums, i + 1, i == 0 ? false : firstRobbed);
            if (robMax >= notRobMax) {
                thisRobbed = true;
                result = robMax;
            } else {
                result = notRobMax;
            }
        }
        if (firstRobbed || (thisRobbed && i == 0)) {
            firstRobbedCache[i] = result;
        } else {
            firstNotRobbedCache[i] = result;
        }
        return result;
    }
}
