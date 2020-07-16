package bfs.numberofclosedislands;

/**
 * @author liuzhengyang
 */
public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int islandNumber = 0;
        int notClosedNumber = 0;
        int[][] islandNumberMark = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            islandNumberMark[i] = new int[grid[i].length];
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // island and not visited
                if (grid[i][j] == 0 && islandNumberMark[i][j] == 0) {
                    boolean notClose = dfsMark(grid, islandNumberMark, i, j, ++islandNumber);
                    if (notClose) {
                        notClosedNumber++;
                    }
                }
            }
        }
        return islandNumber - notClosedNumber;
    }


    /**
     * true 不是close
     * false 还不确定
     */
    boolean dfsMark(int[][] grid, int[][] islandNumber, int row, int col, int number) {
        islandNumber[row][col] = number;
        boolean notClosed = 0 == row || row == grid.length - 1 || 0 == col || col == grid[row].length - 1;
        int[][] directions = new int[][] {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1},
        };
        for (int[] direction : directions) {
            int xDiff = direction[0];
            int yDiff = direction[1];
            int newRow = row + yDiff;
            int newCol = col + xDiff;
            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[row].length) {
                if (grid[newRow][newCol] == 0 && islandNumber[newRow][newCol] == 0) {
                    notClosed = dfsMark(grid, islandNumber, newRow, newCol, number) || notClosed;
                }
            }
        }

        return notClosed;
    }

}
