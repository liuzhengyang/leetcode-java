package weekly.contest.biweeek33;

/**
 * @author liuzhengyang
 */
public class Problem4 {
    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        char[][] grid =
                new char[][] {{'a', 'a', 'a', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'a', 'a', 'a'}};
        System.out.println(problem4.containsCycle(grid));
        char[][] grid2 = new char[][] {{'a', 'b', 'b'}, {'b', 'z', 'b'}, {'b', 'b', 'a'}};
        System.out.println(problem4.containsCycle(grid2));
        char[][] grid3 = new char[][] {{'c','c','c','a'},{'c','d','c','c'},{'c','c','e','c'},{'f','c','c','c'}};
        System.out.println(problem4.containsCycle(grid3));
        System.out.println(problem4.containsCycle(new char[][]{{'b'}, {'b'}}));
    }

    public boolean containsCycle(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return false;
        }
        boolean[][] visited = new boolean[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            visited[i] = new boolean[grid[0].length];
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j]) {
                    if (dfs(visited, grid, i, j, -1, -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(boolean[][] visited, char[][] grid, int row, int col, int prevRow, int prevCol) {
        visited[row][col] = true;
        char c = grid[row][col];
        int[][] direction = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        boolean circle = false;
        for (int[] dir : direction) {
            int dx = dir[0];
            int dy = dir[1];
            int newRow = dy + row;
            int newCol = dx + col;
            if (newRow >= 0 && newRow < grid.length && newCol >= 0
                    && newCol < grid[0].length && grid[newRow][newCol] == c) {
                if (visited[newRow][newCol]) {
                    if (prevCol >= 0 && prevRow >= 0 & !(prevCol == newCol && prevRow == newRow)) {
                        return true;
                    } else {
                    }
                } else {
                    circle |= dfs(visited, grid, newRow, newCol, row, col);
                }
            }
        }
        return circle;
    }
}
