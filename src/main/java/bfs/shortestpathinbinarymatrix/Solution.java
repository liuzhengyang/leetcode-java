package bfs.shortestpathinbinarymatrix;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int rowCount = grid.length;
        int colCount = grid[0].length;
        if (grid[0][0] == 1 || grid[rowCount - 1][colCount - 1] == 1) {
            return -1;
        }
        int[][] visited = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            visited[i] = new int[grid[i].length];
        }
        Queue<P> pointQueue = new ArrayDeque<>();
        pointQueue.offer(new P(0, 0, 0, 1));
        visited[0][0] = 1;
        while (!pointQueue.isEmpty()) {
            P poll = pointQueue.poll();
            if (poll.row == grid.length - 1 && poll.col == grid[0].length - 1) {
                return poll.dist;
            }
            int row = poll.row;
            int col = poll.col;
            int[] dxArray = new int[]{-1, 0, 1};
            int[] dyArray = new int[]{-1, 0, 1};
            for (int dx : dxArray) {
                for (int dy : dyArray) {
                    if (dx == 0 && dy == 0) {
                        continue;
                    }
                    if (row + dx >= 0 && row + dx < grid.length
                            && col + dy >= 0 && col + dy < grid[0].length
                            && grid[row + dx][col + dy] == 0
                            && visited[row + dx][col + dy] == 0) {
                        pointQueue.offer(new P(row + dx, col + dy, grid[row + dx][col + dy], poll.dist + 1));
                        visited[row + dx][col + dy] = 1;
                    }
                }
            }
        }
        return -1;
    }

    static class P {
        int row;
        int col;
        int value;
        int dist;

        public P(int row, int col, int value, int dist) {
            this.row = row;
            this.col = col;
            this.value = value;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}}));
        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{0, 0, 1}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{0, 0, 1}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{0,0,0,0,1}, {1,0,0,0,0}, {0,1,0,1,0}, {0,0,0,1,1}, {0,0,0,1,0}}));
        // [[0,0,0,0,1],[1,0,0,0,0],[0,1,0,1,0],[0,0,0,1,1],[0,0,0,1,0]]
        // [[1,0,0],[1,1,0],[1,1,0]]

    }
}
