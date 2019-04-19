package dfs.zero1matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuzhengyang
 */
public class Solution2 {
    public static void main(String[] args) {
        //  [[0,0,0],
        // * ⁠[0,1,0],
        // * ⁠[1,1,1]]
        int[][] matrix = new int[3][];
        matrix[0] = new int[]{0, 0, 0};
        matrix[1] = new int[]{0, 1, 0};
        matrix[2] = new int[]{1, 1, 1};
        Solution2 solution = new Solution2();
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
//                    dfs(matrix, i, j);
                }
            }
        }

        return minDistance;
    }

    private int bfs(int[][] matrix, int row, int col) {
        if (matrix[row][col] == 0) {
            return 0;
        }
        List<Point> previous = new ArrayList<>();
        previous.add(new Point(row, col));
        List<Point> next = new ArrayList<>();
        while (!previous.isEmpty()) {

        }
        return 0;
    }

    private class Point {
        private int row;
        private int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
