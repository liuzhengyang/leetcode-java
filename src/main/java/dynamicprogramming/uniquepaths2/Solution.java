package dynamicprogramming.uniquepaths2;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    private int[][] memTable;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        memTable = new int[obstacleGrid.length][];
        for (int i = 0; i < obstacleGrid.length; i++) {
            memTable[i] = new int[obstacleGrid[i].length];
            for (int j = 0; j < memTable[i].length; j++) {
                memTable[i][j] = -1;
            }
        }

        return uniquePathStartWithSomePoint(obstacleGrid, 0, 0);
    }

    private int uniquePathStartWithSomePoint(int[][] obstacleGrid, int m, int n) {
        if (memTable[m][n] > -1) {
            return memTable[m][n];
        }
        if (obstacleGrid[m][n] == 1) {
            return 0;
        }
        if (m == obstacleGrid.length -1) {
            // 检查路径上是否有1
            for (int i = n; i < obstacleGrid[m].length; i++) {
                if (obstacleGrid[m][i] == 1) {
                    return 0;
                }
            }
            return 1;
        }
        if (n == obstacleGrid[m].length - 1) {
            for (int i = m; i < obstacleGrid.length; i++) {
                if (obstacleGrid[i][n] == 1) {
                    return 0;
                }
            }
            return 1;
        }
        int down = 0;
        if (m + 1 < obstacleGrid.length) {
            down = obstacleGrid[m + 1][n] == 0 ? uniquePathStartWithSomePoint(obstacleGrid, m + 1
                    , n) : 0;
        }

        int right = 0;
        if (n + 1 < obstacleGrid[m].length) {
            right = obstacleGrid[m][n + 1] == 0 ? uniquePathStartWithSomePoint(obstacleGrid, m,
                    n + 1) : 0;
        }

        int result = down + right;
        memTable[m][n] = result;
        return result;
    }
}
