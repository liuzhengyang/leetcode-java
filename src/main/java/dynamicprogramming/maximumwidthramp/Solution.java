package dynamicprogramming.maximumwidthramp;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5}));
        System.out.println(solution.maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
    }

    private int[] cache;

    public int maxWidthRamp(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        cache = new int[A.length];
        Arrays.fill(cache, -1);
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, findMaxRampFromIndex(A, i));
        }
        return max;
    }

    private int findMaxRampFromIndex(int[] nums, int index) {
        if (index == nums.length - 1) {
            return 0;
        }
        if (cache[index] != -1) {
            return cache[index];
        }

        int result = 0;
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] >= nums[index]) {
                result = (i - index);
                break;
            }
        }
        cache[index] = result;
        return result;
    }
}
