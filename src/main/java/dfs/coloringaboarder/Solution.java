package dfs.coloringaboarder;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    int[][] boarder;
    int[][] visited;

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if (grid == null || grid.length == 0) {
            return grid;
        }
        if (grid[r0][c0] == color) {
            return grid;
        }
        boarder = new int[grid.length][];
        visited = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            boarder[i] = new int[grid[i].length];
            visited[i] = new int[grid[i].length];
        }

        dfs(grid, r0, c0, grid[r0][c0]);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (boarder[i][j] == 1) {
                    grid[i][j] = color;
                }
            }
        }

        return grid;
    }

    private void dfs(int[][] grid, int row, int col, int color) {
        if (visited[row][col] != 0) {
            return;
        }
        visited[row][col] = 1;
        if (row > 0 && grid[row - 1][col] == color) {
            dfs(grid, row - 1, col, color);
        }
        if (row < grid.length - 1 && grid[row + 1][col] == color) {
            dfs(grid, row + 1, col, color);
        }
        if (col > 0 && grid[row][col - 1] == color) {
            dfs(grid, row, col - 1, color);
        }
        if (col < grid[row].length - 1 && grid[row][col + 1] == color) {
            dfs(grid, row, col + 1, color);
        }
        boolean isBoarder = false;
        if (row == 0 || row == grid.length - 1 || col == 0 || col == grid[row].length - 1) {
            isBoarder = true;
        }
        else if (row > 0 && grid[row - 1][col] != color) {
            isBoarder = true;
        } else if (row < grid.length - 1 && grid[row + 1][col] != color) {
            isBoarder = true;
        } else if (col > 0 && grid[row][col - 1] != color) {
            isBoarder = true;
        } else if (col < grid[row].length - 1 && grid[row][col + 1] != color) {
            isBoarder = true;
        }
        visited[row][col] = 1;
        boarder[row][col ] = isBoarder ? 1 : 0;
    }
}
