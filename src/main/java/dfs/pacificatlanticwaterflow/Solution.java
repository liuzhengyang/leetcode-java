package dfs.pacificatlanticwaterflow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        int[][] array = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<int[]> ints = new Solution().pacificAtlantic(array);
        for (int[] i : ints) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
    }

    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;
    private static final int PACIFIC = 1;
    private static final int ATLANTIC = 2;
    private int[][] visitedByPacific;
    private int[][] visitedByAtlantic;

    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return Collections.emptyList();
        }

        visitedByPacific = new int[matrix.length][];
        visitedByAtlantic = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            visitedByPacific[i] = new int[matrix[i].length];
            visitedByAtlantic[i] = new int[matrix[i].length];
        }
        for (int i = 0; i < matrix.length; i++) {
            if (visitedByPacific[i][0] == WHITE) {
                dfs(matrix, i, 0, PACIFIC);
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (visitedByPacific[0][i] == WHITE) {
                dfs(matrix, 0, i, PACIFIC);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (visitedByAtlantic[i][matrix[i].length - 1] == WHITE) {
                dfs(matrix, i, matrix[i].length - 1, ATLANTIC);
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (visitedByAtlantic[matrix.length - 1][i] == WHITE) {
                dfs(matrix, matrix.length - 1, i, ATLANTIC);
            }
        }
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (visitedByAtlantic[i][j] > WHITE && visitedByPacific[i][j] > WHITE) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    private void dfs(int[][] matrix, int row, int col, int type) {
        int[][] colorArray;
        if (type == PACIFIC) {
            colorArray = visitedByPacific;
        } else {
            colorArray = visitedByAtlantic;
        }
        colorArray[row][col] = GRAY;
        if (row > 0 && matrix[row - 1][col] >= matrix[row][col] && colorArray[row - 1][col] == WHITE) {
            dfs(matrix, row - 1, col, type);
        }
        if (row < matrix.length - 1 && matrix[row + 1][col] >= matrix[row][col] && colorArray[row + 1][col] == WHITE) {
            dfs(matrix, row + 1, col, type);
        }
        if (col > 0 && matrix[row][col - 1] >= matrix[row][col] && colorArray[row][col - 1] == WHITE) {
            dfs(matrix, row, col - 1, type);
        }
        if (col < matrix[row].length - 1 && matrix[row][col + 1] >= matrix[row][col] && colorArray[row][col + 1] == WHITE) {
            dfs(matrix, row, col + 1, type);
        }
        colorArray[row][col] = BLACK;
    }
}
