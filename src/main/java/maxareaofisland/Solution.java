package maxareaofisland;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        int[][] grid = new int[][]
                {{1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1},{0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1
                        ,0},{1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,0,1,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1},{0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1},{1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1},{1,0,1,1,1,1,1,0,1,1,1,0,1,1,1,1,0,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0},{1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,0},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
        Solution solution = new Solution();
        System.out.println(solution.maxAreaOfIsland(grid));
    }

    private int[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        visited = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            visited[i] = new int[grid[i].length];
        }
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (grid[row][col] == 0 || visited[row][col] == 1) {
             return 0;
        }
        int count = 1;
        visited[row][col] = 1;
        if (row > 0) {
            count += dfs(grid, row - 1, col);
        }
        if (row < grid.length - 1) {
            count += dfs(grid, row + 1, col);
        }
        if (col > 0) {
            count += dfs(grid, row, col - 1);
        }
        if (col < grid[row].length - 1) {
            count += dfs(grid, row, col + 1);
        }
        return count;
    }
}
