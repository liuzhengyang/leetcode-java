package bfs.reorderroutestomakeallpathsleadtothecityzero;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 * n-1个connection并且题目保证一定能有对应的解，说明当前是一个树，只不过树路线的方向可能不对，通过树的遍历，不断纠正路上的方向
 * @author liuzhengyang
 * 2020/8/15
 */
public class ReorderRoutesToMakeAllPathsLeadToCityZero {
    public static void main(String[] args) {
        ReorderRoutesToMakeAllPathsLeadToCityZero r = new ReorderRoutesToMakeAllPathsLeadToCityZero();
        System.out.println(r.minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}));
        System.out.println(r.minReorder(5, new int[][]{{1, 0}, {1, 2}, {3, 2}, {3, 4}}));
        System.out.println(r.minReorder(3, new int[][]{{1, 0}, {2, 0}}));
    }

    public int minReorder(int n, int[][] connections) {
        Map<Integer, Set<Integer>> positive = new HashMap<>();
        Map<Integer, Set<Integer>> reverse = new HashMap<>();
        buildReverseConnection(connections, positive, reverse);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        int count = 0;
        visited[0] = true;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            Set<Integer> positiveAdjacent = positive.get(poll);
            Set<Integer> negativeAdjacent = reverse.get(poll);
            if (positiveAdjacent != null) {
                for (int positiveAdj : positiveAdjacent) {
                    if (!visited[positiveAdj]) {
                        visited[positiveAdj] = true;
                        queue.offer(positiveAdj);
                        count++;
                    }
                }
            }
            if (negativeAdjacent != null) {
                for (int negativeAdj : negativeAdjacent) {
                    if (!visited[negativeAdj]) {
                        visited[negativeAdj] = true;
                        queue.offer(negativeAdj);
                    }
                }
            }
        }
        return count;
    }

    private void buildReverseConnection(int[][] connections, Map<Integer, Set<Integer>> positive, Map<Integer, Set<Integer>> reverse) {
        for (int[] connection : connections) {
            int first = connection[0];
            int second = connection[1];
            positive.computeIfAbsent(first, k -> new HashSet<>()).add(second);
            reverse.computeIfAbsent(second, k -> new HashSet<>()).add(first);
        }
    }

}
