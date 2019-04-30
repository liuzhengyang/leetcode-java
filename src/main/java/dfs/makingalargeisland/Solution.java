package dfs.makingalargeisland;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        // [[1,0,0,1,1],[1,0,0,1,0],[1,1,1,1,1],[1,1,1,0,1],[0,0,0,1,0]]
//        System.out.println(new Solution().largestIsland(new int[][]{{0,0,0,0,0,0,0},{0,1,1,1,1,0,0},{0,1,0,0,1,0,0},{1,0,1,0,1,0,0},{0,1,0,0,1,0,0},{0,1,0,0,1,0,0},{0,1,1,1,1,0,0}}));
        System.out.println(new Solution().largestIsland(new int[][]{{1,0,0,1,1},{1,0,0,1,0},{1,1,
                1,1,1},{1,1,1,0,1},{0,0,0,1,0}}));
    }

    private int[][] visited;

    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        visited = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            visited[i] = new int[grid[i].length];
        }
        Map<Integer, Integer> maxSizeOfIsland = new HashMap<>();
        int totalMax = 0;
        int islandIndex = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    int thisIslandSize = dfs(grid, i, j, islandIndex);
                    totalMax = Math.max(totalMax, thisIslandSize);
                    maxSizeOfIsland.put(islandIndex, thisIslandSize);
                    islandIndex++;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> surroundOneIsland = new HashSet<>();
                    if (i > 0 && grid[i - 1][j] == 1) {
                        surroundOneIsland.add(visited[i - 1][j]);
                    }
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        surroundOneIsland.add(visited[i + 1][j]);
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        surroundOneIsland.add(visited[i][j - 1]);
                    }
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
                        surroundOneIsland.add(visited[i][j + 1]);
                    }
                    int thisMax = 1;
                    for (Integer isLand : surroundOneIsland) {
                        thisMax += maxSizeOfIsland.get(isLand);
                    }
                    totalMax = Math.max(totalMax, thisMax);
                }
            }
        }

        return totalMax;
    }

    private int dfs(int[][] grid, int row, int col, int islandIndex) {
        visited[row][col] = -islandIndex;
        int count = 1;
        if (row > 0 && grid[row - 1][col] == 1 && visited[row - 1][col] == 0) {
            count += dfs(grid, row - 1, col, islandIndex);
        }
        if (row < grid.length - 1 && grid[row + 1][col] == 1 && visited[row + 1][col] == 0) {
            count += dfs(grid, row + 1, col, islandIndex);
        }
        if (col > 0 && grid[row][col - 1] == 1 && visited[row][col - 1] == 0) {
            count += dfs(grid, row, col - 1, islandIndex);
        }
        if (col < grid[row].length - 1 && grid[row][col + 1] == 1 && visited[row][col + 1] == 0) {
            count += dfs(grid, row, col + 1, islandIndex);
        }
        visited[row][col] = islandIndex;
        return count;
    }
}
