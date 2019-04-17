package dfs.longestincresepathinamatrics;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        // * ⁠ [3,4,5],
        // * ⁠ [3,2,6],
        // * ⁠ [2,2,1]
        int[][] input = new int[3][];
        input[0] = new int[]{3,4,5};
        input[1] = new int[]{3,2,6};
        input[2] = new int[]{2,2,1};
        Solution solution = new Solution();
        System.out.println(solution.longestIncreasingPath(input));
    }

    private int[][] maxIncrease;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        maxIncrease = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            maxIncrease[i] = new int[matrix[i].length];
        }
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (maxIncrease[i][j] == 0) {
                    int thisIncrease = dfs(matrix, i, j);
                    maxIncrease[i][j] = thisIncrease;
                    max = Math.max(max, thisIncrease);
                }
            }
        }

        return max;
    }

    private int dfs(int[][] matrix, int row, int col) {
        if (maxIncrease[row][col] > 0) {
            return maxIncrease[row][col];
        }

        int aroundMax = 0;

        if (row > 0 && matrix[row][col] < matrix[row - 1][col]) {
            aroundMax = Math.max(aroundMax, dfs(matrix, row - 1, col));
        }
        if (row < matrix.length - 1 && matrix[row][col] < matrix[row + 1][col]) {
            aroundMax = Math.max(aroundMax, dfs(matrix, row + 1, col));
        }
        if (col > 0 && matrix[row][col] < matrix[row][col - 1]) {
            aroundMax = Math.max(aroundMax, dfs(matrix, row, col - 1));
        }
        if (col < matrix[row].length - 1 && matrix[row][col] < matrix[row][col + 1]) {
            aroundMax = Math.max(aroundMax, dfs(matrix, row, col + 1));
        }

        maxIncrease[row][col] = aroundMax + 1;
        return aroundMax + 1;
    }
}
