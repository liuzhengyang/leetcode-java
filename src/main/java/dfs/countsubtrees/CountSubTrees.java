package dfs.countsubtrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 先序遍历，遍历到每个节点时，记录当前这个字母的值并加1，遍历完子节点返回时，用这时的计数值减去之前的计数值即为当前值
 * @author liuzhengyang
 */
public class CountSubTrees {
    public static void main(String[] args) {
        CountSubTrees countSubTrees = new CountSubTrees();
        System.out.println(
                Arrays.toString(countSubTrees.countSubTrees(5, new int[][] {{0, 1}, {0, 2}, {1, 3}, {0, 4}}, "aabab")));
        System.out.println(Arrays.toString(
                countSubTrees.countSubTrees(6, new int[][] {{0, 1}, {0, 2}, {1, 3}, {3, 4}, {4, 5}}, "cbabaa")));
        System.out.println(Arrays.toString(
                countSubTrees.countSubTrees(4, new int[][] {{0, 2}, {0, 3}, {1, 2}}, "aeed")));
    }

    private static final int MAX_LABEL_SIZE = 26;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        if (edges == null || edges.length == 0) {
            return new int[] {};
        }
        int[][] cache = new int[n][];
        for (int i = 0; i < n; i++) {
            cache[i] = new int[MAX_LABEL_SIZE];
            for (int j = 0; j < MAX_LABEL_SIZE; j++) {
                cache[i][j] = -1;
            }
        }
        Map<Integer, Set<Integer>> tree = buildTree(edges);
        int[] result = new int[n];
        char[] labelChars = labels.toCharArray();
        int[] countTable = new int[MAX_LABEL_SIZE];
        for (int i = 0; i < n; i++) {
            if (result[i] == 0) {
                result[i] = dfs(i, tree, labelChars, countTable, result);
            }
        }
        return result;
    }

    private int dfs(int index, Map<Integer, Set<Integer>> tree, char[] labels, int[] countTable, int[] result) {
        if (result[index] > 0) {
            return result[index];
        }
        char label = labels[index];
        int previousCount = countTable[label - 'a'];
        countTable[label - 'a'] += 1;
        Set<Integer> children = tree.get(index);
        if (children != null) {
            for (int child : children) {
                dfs(child, tree, labels, countTable, result);
            }
        }
        int finalCount = countTable[label - 'a'];
        int count = finalCount - previousCount;
        result[index] = count;
        return count;
    }

    // 无向边转有向
    private Map<Integer, Set<Integer>> buildTree(int[][] edges) {
        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
        Map<Integer, Set<Integer>> reverseEdgeMap = new HashMap<>();

        // bfs遍历，保证边的指向
        for (int[] edge : edges) {
            int first = edge[0];
            int second = edge[1];
            edgeMap.computeIfAbsent(first, integer -> new HashSet<>()).add(second);
            reverseEdgeMap.computeIfAbsent(second, integer -> new HashSet<>()).add(first);
        }

        Map<Integer, Set<Integer>> realEdge = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> level = new ArrayList<>();
        List<Integer> nextLevel = new ArrayList<>();
        level.add(0);
        visited.add(0);
        while (!level.isEmpty()) {
            for (int node : level) {
                visited.add(node);
                Set<Integer> children = edgeMap.get(node);
                Set<Integer> reverseChildren = reverseEdgeMap.get(node);
                if (children != null) {
                    for (int child : children) {
                        if (!visited.contains(child)) {
                            realEdge.computeIfAbsent(node, integer -> new HashSet<>()).add(child);
                            nextLevel.add(child);
                        }
                    }
                }
                if (reverseChildren != null) {
                    for (int child : reverseChildren) {
                        if (!visited.contains(child)) {
                            realEdge.computeIfAbsent(node, integer -> new HashSet<>()).add(child);
                            nextLevel.add(child);
                        }
                    }
                }
            }
            level = nextLevel;
            nextLevel = new ArrayList<>();
        }
        return realEdge;
    }
}
