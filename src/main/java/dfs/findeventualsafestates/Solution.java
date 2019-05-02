package dfs.findeventualsafestates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liuzhengyang
 */
public class Solution {
    private int[] visited;
    private boolean[] hasCircle;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return Collections.emptyList();
        }
        visited = new int[graph.length];
        hasCircle = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {
                List<Integer> paths = new ArrayList<>();
                dfs(i, graph, paths);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (!hasCircle[i]) {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * hasCircle or not
     * @return
     */
    private boolean dfs(int index, int[][] graph, List<Integer> path) {
        boolean result = false;
        visited[index] = 1;
        int[] adjacent = graph[index];
        List<Integer> newPath = new ArrayList<>(path);
        newPath.add(index);
        for (int adjIndex : adjacent) {
            if (visited[adjIndex] == 1) {
                markHasCircle(newPath);
                result = true;
            }
            if (visited[adjIndex] == 0) {
                if (dfs(adjIndex, graph, newPath)) {
                    markHasCircle(newPath);
                    result = true;
                }
            }
            if (visited[adjIndex] == 2) {
                if (hasCircle[adjIndex]) {
                    markHasCircle(newPath);
                }
            }
        }
        visited[index] = 2;
        return result;
    }

    private void markHasCircle(List<Integer> paths) {
        for (int i : paths) {
            hasCircle[i] = true;
        }
    }
}
