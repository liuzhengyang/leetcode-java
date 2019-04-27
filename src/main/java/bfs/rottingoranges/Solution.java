package bfs.rottingoranges;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(new Solution().orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        while (!canFinish(grid)) {
            boolean anyChanged = false;
            List<Point> notFreshList = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 2) {
                        notFreshList.add(new Point(i,j));
                    }
                }
            }
            for (Point point : notFreshList) {
                boolean changed = bfs(grid, point.row, point.col);
                if (changed) {
                    anyChanged = true;
                }
            }
            if (anyChanged) {
                count ++;
            }
        }

        boolean totalNotFresh = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    totalNotFresh = false;
                    break;
                }
            }

        }
        return totalNotFresh ? count : -1;
    }

    private static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private boolean bfs(int[][] grid, int row, int col) {
        grid[row][col] += 1;
        boolean changed = false;
        if (row > 0 && grid[row - 1][col] == 1) {
            grid[row - 1][col] = 2;
            changed = true;
        }
        if (row < grid.length - 1 && grid[row + 1][col] == 1) {
            grid[row + 1][col] = 2;
            changed = true;
        }
        if (col > 0 && grid[row][col - 1] == 1) {
            grid[row][col - 1] = 2;
            changed = true;
        }
        if (col < grid[row].length - 1 && grid[row][col + 1] == 1) {
            grid[row][col + 1] = 2;
            changed = true;
        }
        return changed;
    }

    private boolean canFinish(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
