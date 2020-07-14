package bfs.allnodesdistancekinbinarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import common.datastructure.TreeNode;

/**
 * 解析树构造出一个图，然后从起点开始bfs即可
 *
 * @author liuzhengyang
 * Created on 2020-07-14
 */
public class AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {

    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (root == null || target == null || K < 0) {
            return Collections.emptyList();
        }
        Map<Integer, GraphNode> valueToGraphNode = buildGraph(root);
        return bfsResult(valueToGraphNode, target, K);
    }

    private List<Integer> bfsResult(Map<Integer, GraphNode> graph, TreeNode target, int k) {
        Set<Integer> visitedValue = new HashSet<>();
        List<Integer> prev = new ArrayList<>();
        List<Integer> next = new ArrayList<>();
        prev.add(target.val);
        visitedValue.add(target.val);
        int levelCount = 0;
        while (levelCount < k && !prev.isEmpty()) {
            visitedValue.addAll(prev);
            for (int value : prev) {
                GraphNode graphNode = graph.get(value);
                Set<Integer> adjacent = graphNode.adjacent;
                for (int adj : adjacent) {
                    if (!visitedValue.contains(adj)) {
                        next.add(adj);
                    }
                }
            }
            prev = next;
            next = new ArrayList<>();
            levelCount++;
        }
        return prev;
    }

    private Map<Integer, GraphNode> buildGraph(TreeNode root) {
        Map<Integer, GraphNode> valueToGraphNode = new HashMap<>();
        List<TreeNode> prev = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        prev.add(root);
        valueToGraphNode.put(root.val, new GraphNode(root.val));
        while (!prev.isEmpty()) {
            for (TreeNode node : prev) {
                GraphNode currentGraphNode = valueToGraphNode.get(node.val);
                TreeNode left = node.left;
                if (left != null) {
                    GraphNode leftNode = new GraphNode(left.val);
                    leftNode.addAdjacent(node.val);
                    valueToGraphNode.put(left.val, leftNode);
                    currentGraphNode.addAdjacent(left.val);
                    next.add(left);
                }
                TreeNode right = node.right;
                if (right != null) {
                    GraphNode rightNode = new GraphNode(right.val);
                    rightNode.addAdjacent(node.val);
                    valueToGraphNode.put(right.val, rightNode);
                    currentGraphNode.addAdjacent(right.val);
                    next.add(right);
                }
            }
            prev = next;
            next = new ArrayList<>();
        }
        return valueToGraphNode;
    }

    private static class GraphNode {
        private int value;
        private Set<Integer> adjacent;

        public GraphNode(int value) {
            this.value = value;
            this.adjacent = new HashSet<>();
        }

        public void addAdjacent(int index) {
            this.adjacent.add(index);
        }
    }
}
