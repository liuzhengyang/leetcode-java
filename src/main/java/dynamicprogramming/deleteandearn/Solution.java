package dynamicprogramming.deleteandearn;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        int[] input = {2, 2, 3, 3, 3, 4};
        int result = new Solution().deleteAndEarn(input);
        System.out.println(result);
    }

    private int[] cache;

    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        cache = new int[nums.length];
        return deleteAt(nums, 0);
    }

    private int deleteAt(int[] nums, int i) {
        if (i == nums.length) {
            return 0;
        }
        if (cache[i] > 0) {
            return cache[i];
        }
        int notEarnThisSum = deleteAt(nums, findNextIndex(nums, i));
        int thisSum = 0;
        int currentValue = nums[i];
        int j;
        for (j = i; j < nums.length; j++) {
            if (nums[j] == currentValue) {
                thisSum += nums[j];
            } else {
                break;
            }
        }
        int earnThisSum = thisSum + deleteAt(nums, findNextBiggerThan1Index(nums, i));
        int thisResult = Math.max(earnThisSum, notEarnThisSum);
        cache[i] = thisResult;
        return thisResult;
    }

    private int findNextIndex(int[] nums, int currentIndex) {
        if (currentIndex >= nums.length - 1) {
            return nums.length;
        }
        int currentValue = nums[currentIndex];
        int i;
        for (i = currentIndex; i < nums.length; i++) {
            if (nums[i] > currentValue) {
                break;
            }
        }
        return i;
    }

    private int findNextBiggerThan1Index(int[] nums, int currentIndex) {
        if (currentIndex >= nums.length - 1) {
            return nums.length;
        }
        int currentValue = nums[currentIndex];
        int i;
        for (i = currentIndex; i < nums.length; i++) {
            if (nums[i] > currentValue + 1) {
                break;
            }
        }
        return i;
    }
}
