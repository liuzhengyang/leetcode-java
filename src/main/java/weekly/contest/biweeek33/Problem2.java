package weekly.contest.biweeek33;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author liuzhengyang
 */
public class Problem2 {
    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        System.out.println(problem2.findSmallestSetOfVertices(6, Arrays.asList(Arrays.asList(0,1),
                Arrays.asList(0,2), Arrays.asList(2,5), Arrays.asList(3,4), Arrays.asList(4,2))));
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        if (n <= 0) {
            return Collections.emptyList();
        }
        boolean[] hasParent = new boolean[n];
        boolean[] visited = new boolean[n];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        if (edges != null) {
            edges.forEach(entry -> {
                Integer first = entry.get(0);
                Integer second = entry.get(1);
                graph.computeIfAbsent(first, k -> new HashSet<>()).add(second);
            });
        }
        for (int i = 0; i < n; i++) {
            topologySort(i, graph, visited, hasParent);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!hasParent[i]) {
                result.add(i);
            }
        }
        return result;
    }

    private void topologySort(int n, Map<Integer, Set<Integer>> graph, boolean[] visited,
            boolean[] hasParent) {
        visited[n] = true;
        Set<Integer> adjacent = graph.getOrDefault(n, Collections.emptySet());
        for (int adj : adjacent) {
            hasParent[adj] = true;
            if (!visited[adj]) {
                topologySort(adj, graph, visited, hasParent);
            }
        }
    }
}
