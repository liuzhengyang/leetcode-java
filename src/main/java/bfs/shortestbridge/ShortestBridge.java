package bfs.shortestbridge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-bridge/
 * bfs, 先找到第一个island，然后开始bfs直到抵达另一个island
 * @author liuzhengyang
 * 2020/9/18
 */
public class ShortestBridge {
    public static void main(String[] args) {
        ShortestBridge shortestBridge = new ShortestBridge();
        System.out.println(shortestBridge.shortestBridge(new int[][]{{0, 1}, {1, 0}}));
        System.out.println(shortestBridge.shortestBridge(new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 1}}));
        System.out.println(shortestBridge.shortestBridge(new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 1}}));
        System.out.println(shortestBridge.shortestBridge(new int[][]{{1,1,1,1,1}, {1,0,0,0,1}, {1,0,1,0,1}, {1,0,0,0,1}, {1,1,1,1,1}}));
    }

    public int shortestBridge(int[][] A) {
        // 计算出两个岛的点集合
        // 从其中一个集合开始bfs
        // bfs使用queue做存储，初始化保存第一个岛的所有位置
        // 每次从queue中取出一个位置，判断周围是否有第二个岛的元素，如果有，说明抵达
        // 如果没有，并且没有访问过，加入到queue中，记录下一次queue要遍历的数量，每轮遍历step++
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        // find first island nodes
        List<Integer> firstIslandIndexes = new ArrayList<>();
        boolean found = false;
        for (int i = 0; i < A.length; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1) {
                    found = true;
                    boolean[] firstIslandVisited = new boolean[A.length * A[0].length];
                    Queue<Integer> firstIslandQueue = new ArrayDeque<>();
                    int index = getIndex(i, j, A);
                    firstIslandIndexes.add(index);
                    firstIslandQueue.add(index);
                    firstIslandVisited[index] = true;
                    while (!firstIslandQueue.isEmpty()) {
                        Integer nodeIndex = firstIslandQueue.poll();
                        int row = getRowByIndex(nodeIndex, A);
                        int col = getColByIndex(nodeIndex, A);
                        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                        for (int[] direction : directions) {
                            int newRow = row + direction[0];
                            int newCol = col + direction[1];
                            if (newRow >= 0 && newRow < A.length && newCol >= 0 && newCol < A[0].length) {
                                if (A[newRow][newCol] == 1 && !firstIslandVisited[getIndex(newRow, newCol, A)]) {
                                    firstIslandVisited[getIndex(newRow, newCol, A)] = true;
                                    firstIslandQueue.add(getIndex(newRow, newCol, A));
                                    firstIslandIndexes.add(getIndex(newRow, newCol, A));
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }

        // bfs from first island until find a adjacent value == 1 && !visited
        boolean[] visited = new boolean[A.length * A[0].length];
        for (int i : firstIslandIndexes) {
            visited[i] = true;
        }
        Queue<Integer> firstIslandBfsQueue = new ArrayDeque<>();
        firstIslandBfsQueue.addAll(firstIslandIndexes);
        int step = 0;
        int batchSize = firstIslandIndexes.size();
        while (!firstIslandBfsQueue.isEmpty()) {
            step++;
            int newBatchSize = 0;
            for (int i = 0; i < batchSize; i++) {
                Integer firstIslandNodeIndex = firstIslandBfsQueue.poll();
                int row = getRowByIndex(firstIslandNodeIndex, A);
                int col = getColByIndex(firstIslandNodeIndex, A);
                int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (newRow >= 0 && newRow < A.length && newCol >= 0 && newCol < A[0].length) {
                        if (A[newRow][newCol] == 1) {
                            if (!visited[getIndex(newRow, newCol, A)]) {
                                return step - 1;
                            } else {

                            }
                        } else {
                            if (!visited[getIndex(newRow, newCol, A)]) {
                                visited[getIndex(newRow, newCol, A)] = true;
                                firstIslandBfsQueue.add(getIndex(newRow, newCol, A));
                                newBatchSize++;
                            }
                        }
                    }
                }
            }
            batchSize = newBatchSize;
        }

        return 0;
    }

    private int getIndex(int row, int col, int[][] A) {
        return row * A[0].length + col;
    }

    private int getRowByIndex(int index, int[][] A) {
        return index / A[0].length;
    }

    private int getColByIndex(int index, int[][] A) {
        return index % A[0].length;
    }
}
