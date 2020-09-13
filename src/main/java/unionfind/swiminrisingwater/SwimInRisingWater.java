package unionfind.swiminrisingwater;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author liuzhengyang
 */
public class SwimInRisingWater {
    public static void main(String[] args) {
        SwimInRisingWater swimInRisingWater = new SwimInRisingWater();
        System.out.println(swimInRisingWater.swimInWater(new int[][]{{0,2}, {1,3}}));
    }

    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        List<Integer> queue = new ArrayList<>();
        boolean[] visited = new boolean[grid.length * grid.length];
        queue.add(0);
        visited[0] = true;
        for (int i = grid[0][0]; i < grid.length * grid.length;) {
            List<Integer> nextQueue = new ArrayList<>(queue);
            Queue<Integer> bfsQueue = new ArrayDeque<>(queue);
            int[][] direction = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
            int smallestNeighbor = grid.length * grid.length;
            while (!bfsQueue.isEmpty()) {
                Integer index = bfsQueue.poll();
                int x = index / grid.length;
                int y = index % grid.length;
                if (x == grid.length - 1 && y == grid.length - 1) {
                    return i;
                }
                for (int[] d : direction) {
                    int newX = x + d[0];
                    int newY = y + d[1];
                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid.length) {
                        if (!visited[newX * grid.length + newY] && grid[newX][newY] <= i) {
                            if (x == grid.length - 1 && y == grid.length - 1) {
                                return i;
                            }
                            visited[newX * grid.length + newY] = true;
                            bfsQueue.add(newX * grid.length + newY);
                            nextQueue.add(newX * grid.length + newY);
                        }
                        if (grid[newX][newY] > i) {
                            smallestNeighbor = Math.min(smallestNeighbor, grid[newX][newY]);
                        }
                    }
                }
            }
            queue = nextQueue;
            i = smallestNeighbor;
        }
        return 0;
    }
}
