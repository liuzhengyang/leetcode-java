package dfs.zero1matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        //  [[0,0,0],
        // * ⁠[0,1,0],
        // * ⁠[1,1,1]]
        int[][] matrix = new int[3][];
        matrix[0] = new int[]{0, 0, 0};
        matrix[1] = new int[]{0, 1, 0};
        matrix[2] = new int[]{1, 1, 1};
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.updateMatrix(matrix)));
    }

    private int[][] minDistance;

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[][]{};
        }
        minDistance = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            minDistance[i] = new int[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++) {
                // -2 not visited -1 visiting > -1 visited
                minDistance[i][j] = -2;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (minDistance[i][j] == -2) {
                    dfs(matrix, i, j);
                }
            }
        }

        return minDistance;
    }

    private int bfs(int[][] matrix, int row, int col) {
        boolean visited[][] = new boolean[matrix.length][];
        if (matrix[row][col] == 0) {
            return 0;
        }
        List<Point> previous = new ArrayList<>();
        List<Point> next = new ArrayList<>();
        previous.add(new Point(row, col));
        while (!previous.isEmpty()) {

        }

        return 0;
    }

    private static class Point {
        private int row;
        private int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private int dfs(int[][] matrix, int row, int col) {
        if (matrix[row][col] == 0) {
            minDistance[row][col] = 0;
            return 0;
        }
        if (minDistance[row][col] == -2) {
            return minDistance[row][col];
        }
        int min = Integer.MAX_VALUE;
        if (row > 0) {
            min = Math.min(min, dfs(matrix, row - 1, col));
        }
        if (row < matrix.length - 1) {
            min = Math.min(min, dfs(matrix, row + 1, col));
        }
        if (col > 0) {
            min = Math.min(min, dfs(matrix, row, col - 1));
        }
        if (col < matrix[row].length - 1) {
            min = Math.min(min, dfs(matrix, row, col + 1));
        }

        minDistance[row][col] = min + 1;
        return min + 1;
    }
}
