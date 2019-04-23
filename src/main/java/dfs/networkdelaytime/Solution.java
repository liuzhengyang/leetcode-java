package dfs.networkdelaytime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author liuzhengyang
 */
public class Solution {
    /**
     * [[2,1,1],[2,3,1],[3,4,1]]
     * 4
     * 2
     * @param args
     */
    public static void main(String[] args) {
        int[][] times = new int[3][];
        times[0] = new int[]{2, 1, 1};
        times[1] = new int[]{2, 3, 1};
        times[2] = new int[]{3, 4, 1};
        System.out.println(new Solution().networkDelayTime(times, 4, 2));
    }

    private int[][] weightMap;
    private int[][] distanceMap;

    public int networkDelayTime(int[][] times, int N, int K) {
        initWeightMap(times, N, K);
        int max = 0;
        for (int delay : distanceMap[K - 1]) {
            if (delay == -1) {
                return -1;
            }
            max = Math.max(delay, max);
        }
        return max;
    }

    // times 每行3个数值，分别表示 u,v,w
    private void initWeightMap(int[][] times, int N, int K) {
        weightMap = new int[N][];
        distanceMap = new int[N][];
        for (int i = 0; i < N; i++) {
            weightMap[i] = new int[N];
            distanceMap[i] = new int[N];
            for (int j = 0; j < weightMap[i].length; j++) {
                weightMap[i][j] = -1;
                distanceMap[i][j] = -1;
            }
            distanceMap[i][i] = 0;
            weightMap[i][i] = 0;
        }
        for (int[] each : times) {
            int u = each[0];
            int v = each[1];
            int w = each[2];
            weightMap[u - 1][v - 1] = w;
        }

        boolean[] visited = new boolean[N];
        for (int j = 0; j < N; j++) {
            int minIndex = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    continue;
                }
                if (min > distanceMap[K - 1][i] && distanceMap[K-1][i] != -1) {
                    min = distanceMap[K - 1][i];
                    minIndex = i;
                }
            }
            if (minIndex >= 0) {
                visited[minIndex] = true;
                for (int i = 0; i < N; i++) {
                    if (weightMap[minIndex][i] > -1) {
                        relax(K - 1, minIndex, i);
                    }
                }
            }
        }
    }

    private void relax(int source, int oldNode, int newNode) {
        if (distanceMap[source][oldNode] == -1 || weightMap[oldNode][newNode] == -1) {
            return;
        }
        if (distanceMap[source][newNode] == -1 ||
                distanceMap[source][newNode] > distanceMap[source][oldNode] + weightMap[oldNode][newNode]) {
            distanceMap[source][newNode] = distanceMap[source][oldNode] + weightMap[oldNode][newNode];
        }
    }

}
