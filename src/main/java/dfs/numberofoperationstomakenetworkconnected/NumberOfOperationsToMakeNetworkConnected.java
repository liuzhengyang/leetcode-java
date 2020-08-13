package dfs.numberofoperationstomakenetworkconnected;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 需要的操作数量 = (连通分量数量 - 1)，如果当前所有连接数量小于这个值，返回-1
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 *
 * @author liuzhengyang
 * 2020/8/14
 */
public class NumberOfOperationsToMakeNetworkConnected {
    public static void main(String[] args) {
        NumberOfOperationsToMakeNetworkConnected n = new NumberOfOperationsToMakeNetworkConnected();
        System.out.println(n.makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
        System.out.println(n.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}}));
        System.out.println(n.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}}));
        System.out.println(n.makeConnected(5, new int[][]{{0, 1}, {0, 2}, {3, 4}, {2, 3}}));
    }

    public int makeConnected(int n, int[][] connections) {
        if (n <= 0) {
            return 0;
        }
        if (connections == null || connections.length == 0) {
            return -1;
        }
        if (connections.length < (n - 1)) {
            return -1;
        }
        int componentNumber = 0;
        Map<Integer, Set<Integer>> graph = buildGraph(connections);
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                componentNumber++;
                dfs(i, graph, visited);
            }
        }
        int connectionCount = connections.length;
        return connectionCount > (componentNumber - 1) ? (componentNumber - 1) : -1;
    }

    private void dfs(int index, Map<Integer, Set<Integer>> graph, boolean[] visited) {
        visited[index] = true;
        Set<Integer> adjSet = graph.get(index);
        if (adjSet == null) {
            return;
        }
        for (int adj : adjSet) {
            if (!visited[adj]) {
                dfs(adj, graph, visited);
            }
        }
    }

    private Map<Integer, Set<Integer>> buildGraph(int[][] connections) {
        Map<Integer, Set<Integer>> result = new HashMap<>();
        for (int[] connection : connections) {
            int first = connection[0];
            int second = connection[1];
            result.computeIfAbsent(first, k -> new HashSet<>()).add(second);
            result.computeIfAbsent(second, k -> new HashSet<>()).add(first);
        }
        return result;
    }
}
