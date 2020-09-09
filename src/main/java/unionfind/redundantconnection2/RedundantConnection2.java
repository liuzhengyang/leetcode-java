package unionfind.redundantconnection2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import common.datastructure.UnionFind;

/**
 * https://leetcode.com/problems/redundant-connection-ii/
 * @author liuzhengyang
 * 2020/9/10
 */
public class RedundantConnection2 {
    public static void main(String[] args) {
        RedundantConnection2 redundantConnection2 = new RedundantConnection2();
        System.out.println(Arrays.toString(redundantConnection2.findRedundantDirectedConnection(new int[][]{{2, 1}, {3, 1}, {4, 2}, {1, 4}})));
        System.out.println(Arrays.toString(redundantConnection2.findRedundantDirectedConnection(new int[][]{{5, 2}, {5, 1}, {3, 1}, {3, 4}, {3, 5}})));
        System.out.println(Arrays.toString(redundantConnection2.findRedundantDirectedConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));
        System.out.println(Arrays.toString(redundantConnection2.findRedundantDirectedConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}})));
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return null;
        }
        int nodeCount = edges.length;
        int[] inDegree = new int[nodeCount];
        // 先找到入度为0的点，这个点为root；
        // 如果不存在，说明存在环，移除这个环，如果存在root，则从root开始遍历图，找到第一个重复遍历点的边
        UnionFind uf = new UnionFind(nodeCount);
        int[] lastCircleEdge = null;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0] - 1;
            int to = edge[1] - 1;
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            inDegree[to] ++;
            if (!uf.findAndUnion(from, to)) {
                lastCircleEdge = edge;
            }
        }
        int root = -1;
        for (int i = 0; i < nodeCount; i++) {
            if (inDegree[i] == 0) {
                root = i;
                break;
            }
        }
        if (root < 0) {
            return lastCircleEdge;
        }
        // 判断从root有几条路径抵达inDegree>1的点，如果1条，删除最后一个环，如果2条，删除到inDegree的边的靠后的边
        int[] lastEdgeToInDegreeGreaterThanOneNode;
        int[] visited = new int[nodeCount]; // 0 not 1 visiting visited
        AtomicReference<int[]> lastEdge = new AtomicReference<>();
        if (dfs(root, visited, graph, lastEdge)) {
            return lastEdge.get();
        }
        for (int i = edges.length - 1; i >= 0; i--) {
            int to = edges[i][1] - 1;
            if (inDegree[to] > 1) {
                return edges[i];
            }
        }
        return null;
    }

    // return has circle or not
    private boolean dfs(int node, int[] visited, Map<Integer, List<Integer>> graph, AtomicReference<int[]> lastEdge) {
        visited[node] = 1;
        List<Integer> adjacent = graph.getOrDefault(node, Collections.emptyList());
        boolean hasCircle = false;
        for (int adj : adjacent) {
            if (visited[adj] == 1) {
                lastEdge.set(new int[]{node + 1, adj + 1});
                return true;
            }
            if (visited[adj] == 0) {
                hasCircle |= dfs(adj, visited, graph, lastEdge);
            }
        }
        visited[node] = 2;
        return hasCircle;
    }
}
