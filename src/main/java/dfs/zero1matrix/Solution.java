package dfs.zero1matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        //  [[0,0,0],
        // * ⁠[0,1,0],
        // * ⁠[1,1,1]]
        int[][] matrix = new int[5000][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[2];
            matrix[i][0] = 1;
            matrix[i][1] = 0;
        }
//        matrix[0] = new int[]{0, 0, 0};
//        matrix[1] = new int[]{0, 1, 0};
//        matrix[2] = new int[]{1, 1, 1};
        Solution solution = new Solution();
        long start = System.currentTimeMillis();
        System.out.println(Arrays.deepToString(solution.updateMatrix(matrix)));
        System.out.println("Cost " + (System.currentTimeMillis() - start));
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
                minDistance[i][j] = bfs(matrix, i, j);
            }
        }

        return minDistance;
    }

    private int bfs(int[][] matrix, int row, int col) {
        if (matrix[row][col] == 0) {
            return 0;
        }
        boolean visited[][] = new boolean[matrix.length][];
//        for (int i = 0; i < matrix.length; i++) {
//            visited[i] = new boolean[matrix[i].length];
//        }

        List<Point> previous = new ArrayList<>();
        List<Point> next = new ArrayList<>();
        previous.add(new Point(row, col));
        int length = 0;
        while (!previous.isEmpty()) {
            for (Point p : previous) {
                if (matrix[p.row][p.col] == 0) {
                    return length;
                }
                if (visited[p.row] == null) {
                    visited[p.row] = new boolean[matrix[p.row].length];
                }
                visited[p.row][p.col] = true;
                List<Point> nearBy = findNearby(matrix, p.row, p.col, visited);
                next.addAll(nearBy);
            }
            length ++;
            previous = next;
            next = new ArrayList<>();
        }

        // should not reach here
        return 0;
    }

    private List<Point> findNearby(int[][] matrix, int row, int col, boolean[][] visited) {
        List<Point> result = new ArrayList<>();
        if (row + 1 < visited.length && (visited[row + 1] == null || !visited[row + 1][col])) {
            result.add(new Point(row + 1, col));
        }
        if (row > 0 && (visited[row - 1] == null || !visited[row - 1][col])) {
            result.add(new Point(row - 1, col));
        }
        if (col + 1 < visited[row].length && (visited[row] == null || !visited[row][col + 1])) {
            result.add(new Point(row, col + 1));
        }
        if (col > 0 && (visited[row] == null || !visited[row][col - 1])) {
            result.add(new Point(row, col - 1));
        }
        return result;
    }

    private static class Point {
        private int row;
        private int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
