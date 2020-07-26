package bfs.countpairs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 */
public class CountPairs {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root.left = node2;
        root.right = node3;
        node2.right = node4;
        CountPairs countPairs = new CountPairs();
        int i = countPairs.countPairs(root, 3);
        System.out.println(i);
    }
    public int countPairs(TreeNode root, int distance) {
        if (root == null) {
            return 0;
        }
        Map<TreeNode, GraphNode> graph = new HashMap<>();
        buildGraph(root, graph);
        Set<TreeNode> aLlLeafSet = findALlLeafSet(root);
        Set<TreeNode> visitedNode = new HashSet<>();
        int totalCount = 0;
        // bfs
        for (TreeNode leaf : aLlLeafSet) {
            visitedNode.add(leaf);
            totalCount += bfsCount(graph, leaf, distance, visitedNode, aLlLeafSet);
        }
        return totalCount;
    }

    private int bfsCount(Map<TreeNode, GraphNode> graph, TreeNode startNode, int distance, Set<TreeNode> traveledNode,
            Set<TreeNode> aLlLeafSet) {
        GraphNode graphNode = graph.get(startNode);
        Set<GraphNode> prev = new HashSet<>();
        Set<GraphNode> next = new HashSet<>();
        Set<GraphNode> visited = new HashSet<>();
        prev.add(graphNode);
        visited.add(graphNode);
        int totalCount = 0;
        int currentDistance = 0;
        while (!prev.isEmpty()) {
            currentDistance++;
            visited.addAll(prev);
            for (GraphNode g : prev) {
                Set<GraphNode> adj = g.adj;
                for (GraphNode adjNode : adj) {
                    if (!visited.contains(adjNode)) {
                        next.add(adjNode);
                    }
                }
            }
            if (currentDistance <= distance) {
                for (GraphNode g : next) {
                    if (aLlLeafSet.contains(g.treeNode) && !traveledNode.contains(g.treeNode)) {
                        totalCount++;
                    }
                }
            }
            if (currentDistance > distance) {
                break;
            } else {
                prev = next;
                next = new HashSet<>();
            }
        }
        return totalCount;
    }

    private Set<TreeNode> findALlLeafSet(TreeNode root) {
        Set<TreeNode> result = new HashSet<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left == null && treeNode.right == null) {
                result.add(treeNode);
            }
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        return result;
    }

    private GraphNode buildGraph(TreeNode root, Map<TreeNode, GraphNode> graph) {
        GraphNode graphNode = new GraphNode(root);
        graph.put(root, graphNode);
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            GraphNode leftNode = buildGraph(left, graph);
            graphNode.addAdj(leftNode);
            leftNode.addAdj(graphNode);
        }
        if (right != null) {
            GraphNode rightNode = buildGraph(right, graph);
            graphNode.addAdj(rightNode);
            rightNode.addAdj(graphNode);
        }
        return graphNode;
    }

    private static class GraphNode {
        private TreeNode treeNode;
        private Set<GraphNode> adj = new HashSet<>();

        public GraphNode(TreeNode treeNode) {
            this.treeNode = treeNode;
        }

        public void addAdj(GraphNode adj) {
            this.adj.add(adj);
        }
    }
}
