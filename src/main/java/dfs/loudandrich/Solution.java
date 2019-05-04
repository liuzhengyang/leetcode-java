package dfs.loudandrich;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

        int[][] richer = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quiert = new int[]{3,2,5,4,6,1,7,0};
        System.out.println(Arrays.toString(new Solution().loudAndRich(richer, quiert)));
    }

    private int[] visited;
    Map<Integer, Set<Integer>> indexToRicherSet = new HashMap<>();
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        if (quiet == null || quiet.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> quietOrderToIndex = new HashMap<>();
        for (int i = 0; i < quiet.length; i++) {
            quietOrderToIndex.put(quiet[i], i);
        }

        visited = new int[quiet.length];
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < quiet.length; i++) {
            nodes.add(new Node());
        }
        for (int[] pair : richer) {
            int first = pair[0];
            int second = pair[1];
            nodes.get(first).poorer.add(second);
        }

        for (int i = 0; i < quiet.length; i++) {
            if (visited[i] == 0) {
                richer(i, nodes);
            }
        }

        int[] result = new int[quiet.length];
        Arrays.fill(result, -1);

        for (int i = 0; i < quiet.length; i++) {
            Integer index = quietOrderToIndex.get(i);
            Set<Integer> poorer = indexToRicherSet.get(index);
            for (int each : poorer) {
                if (result[each] == -1) {
                    result[each] = index;
                }
            }
        }

        return result;
    }

    private Set<Integer> richer(int index, List<Node> nodes) {
        if (indexToRicherSet.get(index) != null) {
            return indexToRicherSet.get(index);
        }
        visited[index] = 1;
        Set<Integer> result = new HashSet<>();
        result.add(index);
        for (Integer adj : nodes.get(index).poorer) {
            result.addAll(richer(adj, nodes));
        }
        visited[index] = 2;
        indexToRicherSet.put(index, result);
        return result;
    }

    private static class Node {
        private List<Integer> poorer = new ArrayList<>();
    }
}
