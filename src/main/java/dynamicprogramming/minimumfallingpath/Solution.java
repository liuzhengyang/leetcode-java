package dynamicprogramming.minimumfallingpath;

import java.util.Arrays;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        int[][] input = {{51, 24}, {-50, 82}};
        System.out.println(new Solution().minFallingPathSum(input));
    }

    private static final int DEFAULT_CACHE_VAL = Integer.MAX_VALUE;

    private int[][] cache;

    public int minFallingPathSum(int[][] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        cache = new int[A.length][];
        for (int i = 0; i < A.length; i++) {
            cache[i] = new int[A[i].length];
            Arrays.fill(cache[i], DEFAULT_CACHE_VAL);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A[0].length; i++) {
            min = Math.min(min, minSum(A, 0, i));
        }
        return min;
    }

    private int minSum(int[][] nums, int row, int col) {
        if (row == nums.length - 1) {
            return nums[row][col];
        }
        if (cache[row][col] != DEFAULT_CACHE_VAL) {
            return cache[row][col];
        }
        int min = Integer.MAX_VALUE;
        if (col > 0) {
            min = Math.min(min, minSum(nums, row + 1, col - 1));
        }
        min = Math.min(min, minSum(nums, row + 1, col));
        if (col < nums[row].length - 1) {
            min = Math.min(min, minSum(nums, row + 1, col + 1));
        }
        min += nums[row][col];
        cache[row][col] = min;
        return min;
    }
}
