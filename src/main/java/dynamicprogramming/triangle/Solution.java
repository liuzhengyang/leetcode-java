package dynamicprogramming.triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

        List<List<Integer>> input = new ArrayList<>();
        List<Integer> level0 = new ArrayList<>();
        level0.add(-1);
        List<Integer> level1 = new ArrayList<>();
        level1.add(-2);
        level1.add(-3);
        input.add(level0);
        input.add(level1);
        int i = new Solution().minimumTotal(input);
        System.out.println(i);
    }

    private int[][] cache;

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        cache = new int[triangle.size()][];
        for (int i = 0; i < triangle.size(); i++) {
            cache[i] = new int[triangle.size()];
            Arrays.fill(cache[i], Integer.MAX_VALUE);
        }

        return getMin(0, 0, triangle.size(), triangle);
    }

    private int getMin(int row, int col, int triangleSize, List<List<Integer>> triangle) {
        if (row == triangleSize - 1) {
            return triangle.get(row).get(col);
        }
        if (cache[row][col] != Integer.MAX_VALUE) {
            return cache[row][col];
        }
        int leftMin = getMin(row + 1, col, triangleSize, triangle);
        if (col < row + 1) {
            int rightMin = getMin(row + 1, col + 1, triangleSize, triangle);
            leftMin = Math.min(leftMin, rightMin);
        }
        leftMin = triangle.get(row).get(col) + leftMin;
        cache[row][col] = leftMin;
        return leftMin;
    }

}
