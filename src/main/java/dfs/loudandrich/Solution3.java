package dfs.loudandrich;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3 {
    public static void main(String[] args) {
        int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
        int[] quiert = new int[]{3, 2, 5, 4, 6, 1, 7, 0};
        System.out.println(Arrays.toString(new Solution3().loudAndRich(richer, quiert)));
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, Node> indexToNodeMap = new HashMap<>();
        for (int i = 0; i < quiet.length; i++) {
            indexToNodeMap.put(i, new Node(i));
        }
        for (int[] pair : richer) {
            int first = pair[0];
            int second = pair[1];
            indexToNodeMap.get(second).adjacents.add(indexToNodeMap.get(first));
        }
        int[] result = new int[quiet.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < quiet.length; i++) {
            dfsFindQuiest(indexToNodeMap, i, quiet, result);
        }
        return result;
    }

    private int dfsFindQuiest(Map<Integer, Node> indexToNodeMap, int index, int[] quiet, int[] result) {
        if (result[index] > -1) {
            return result[index];
        }
        Node node = indexToNodeMap.get(index);
        result[index] = index;
        List<Node> adjacents = node.adjacents;
        for (Node n : adjacents) {
            int dfsFind = dfsFindQuiest(indexToNodeMap, n.index, quiet, result);
            if (quiet[dfsFind] < quiet[result[index]]) {
                result[index] = dfsFind;
            }
        }
        return result[index];
    }

    static class Node {
        int index;
        List<Node> adjacents = new ArrayList<>();

        public Node(int index) {
            this.index = index;
        }
    }
}
