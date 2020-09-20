package weekly.contest.week207;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-non-negative-product-in-a-matrix/
 * @author liuzhengyang
 */
public class Problem3 {
    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        System.out.println(problem3.maxProductPath(new int[][]{{-1, -2, -3}, {-2, -3, -3}, {-3, -3, -2}}));
        System.out.println(problem3.maxProductPath(new int[][]{{1,-2,1}, {1,-2,1}, {3, -4, 1}}));
    }

    public int maxProductPath(int[][] grid) {
        long[][][] cache = new long[grid.length][][];
        for (int i = 0; i < grid.length; i++) {
            cache[i] = new long[grid[0].length][];
        }
        long[] result = maxProductPath(grid, 0, 0, cache);
        if (result[1] < 0) {
            return -1;
        }
        return (int)(result[1] % 1000000007);
    }

    private long[] maxProductPath(int[][] grid, int row, int col, long[][][] cache) {
        if (cache[row][col] != null) {
            return cache[row][col];
        }
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            long[] result = new long[]{grid[row][col], grid[row][col]};
            cache[row][col] = result;
            return result;
        }
        int thisValue = grid[row][col];

        if (row == grid.length - 1) {
            long[] rightResult = maxProductPath(grid, row, col + 1, cache);
            long newSmallest = Math.min(thisValue * rightResult[0], thisValue * rightResult[1]);
            long newLarge = Math.max(thisValue * rightResult[0], thisValue * rightResult[1]);
            long[] result = new long[]{newSmallest, newLarge};
            cache[row][col] = result;
            return result;
        }
        if (col == grid[0].length - 1) {
            long[] downResult = maxProductPath(grid, row + 1, col, cache);
            long newSmallest = Math.min(thisValue * downResult[0], thisValue * downResult[1]);
            long newLarge = Math.max(thisValue * downResult[0], thisValue * downResult[1]);
            long[] result = new long[]{newSmallest, newLarge};
            cache[row][col] = result;
            return result;
        }
        // right
        long[] rightResult = null;
        if (col + 1 < grid[0].length) {
            rightResult = maxProductPath(grid, row, col + 1, cache);
            long newSmallest = Math.min(thisValue * rightResult[0], thisValue * rightResult[1]);
            long newLarge = Math.max(thisValue * rightResult[0], thisValue * rightResult[1]);
            rightResult = new long[]{newSmallest, newLarge};
        }
        long[] downResult = null;
        if (row + 1 < grid.length) {
            downResult = maxProductPath(grid, row + 1, col, cache);
            long newSmallest = Math.min(thisValue * downResult[0], thisValue * downResult[1]);
            long newLarge = Math.max(thisValue * downResult[0], thisValue * downResult[1]);
            downResult = new long[]{newSmallest, newLarge};
        }
        long newSmallest = Long.MAX_VALUE;
        long newLargest = Long.MIN_VALUE;
        if (rightResult != null) {
            newSmallest = Math.min(newSmallest, rightResult[0]);
            newLargest = Math.max(newLargest, rightResult[1]);
        }
        if (downResult != null) {
            newSmallest = Math.min(newSmallest, downResult[0]);
            newLargest = Math.max(newLargest, downResult[1]);
        }
        long[] result = new long[] {newSmallest, newLargest};
        cache[row][col] = result;
        return result;
    }
}
