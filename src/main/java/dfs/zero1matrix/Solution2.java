package dfs.zero1matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuzhengyang
 */
public class Solution2 {
    public static void main(String[] args) {
        // * [[0,0,0],
        // * ⁠[0,1,0],
        // * ⁠[1,1,1]]
        int[][] matrix = new int[3][];
        matrix[0] = new int[]{0, 0, 0};
        matrix[1] = new int[]{0, 1, 0};
        matrix[2] = new int[]{0, 0, 0};
//        matrix[2] = new int[]{1, 1, 1};
        Solution2 solution = new Solution2();
        System.out.println(Arrays.deepToString(solution.updateMatrix(matrix)));
    }

    private int[][] minDistance;

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[][]{};
        }
        int max = matrix.length + matrix[0].length;
        minDistance = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            minDistance[i] = new int[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++) {
                // -2 not visited -1 visiting > -1 visited
                if (matrix[i][j] == 0) {
                    minDistance[i][j] = 0;
                } else {
                    minDistance[i][j] = max;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
//                if (matrix[i][j] == 1) {
                    doRelaxAround(matrix, minDistance, i, j);
//                }
            }
        }

        return minDistance;
    }

    private void doRelaxAround(int[][] matrix, int[][] minDistance, int i, int j) {
        if (i > 0) {
            if (minDistance[i - 1][j] > minDistance[i][j] + 1) {
                minDistance[i - 1][j] = minDistance[i][j] + 1;
            }
        }
        if (i < matrix.length - 1) {
            if (minDistance[i + 1][j] > minDistance[i][j] + 1) {
                minDistance[i + 1][j] = minDistance[i][j] + 1;
            }
        }
        if (j > 0) {
            if (minDistance[i][j - 1] > minDistance[i][j] + 1) {
                minDistance[i][j - 1] = minDistance[i][j] + 1;
            }
        }
        if (j < matrix[i].length - 1) {
            if (minDistance[i][j + 1] > minDistance[i][j] + 1) {
                minDistance[i][j + 1] = minDistance[i][j] + 1;
            }
        }
    }
}
