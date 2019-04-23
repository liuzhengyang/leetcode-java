package dynamicprogramming.minimunpathsum;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        int[][] grid = new int[3][];
        grid[0] = new int[]{1, 3, 1};
        grid[1] = new int[]{1, 5, 1};
        grid[2] = new int[]{4, 2, 1};
        int i = new Solution().minPathSum(grid);
        System.out.println(i);
    }

    public int minPathSum(int[][] grid) {
        resultTable = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            resultTable[i] = new int[grid[i].length];
            for (int j = 0; j < grid[i].length; j++) {
                resultTable[i][j] = -1;
            }
        }
        return minPathSum(grid, 0, 0);
    }

    private int[][] resultTable;

    private int minPathSum(int[][] grid, int startRow, int startCol) {
        if (resultTable[startRow][startCol] > -1) {
            return resultTable[startRow][startCol];
        }
        if (startCol == grid[0].length - 1) {
            int sum = 0;
            for (int i = startRow; i < grid.length; i++) {
                sum += grid[i][startCol];
            }
            return sum;
        }
        if (startRow == grid.length - 1) {
            int sum = 0;
            for (int i = startCol; i < grid[0].length; i++) {
                sum += grid[startRow][i];
            }
            return sum;
        }
        int minPath = grid[startRow][startCol] + Math.min(minPathSum(grid, startRow + 1,
                startCol), minPathSum(grid, startRow, startCol + 1));
        resultTable[startRow][startCol] = minPath;
        return minPath;
    }
}
