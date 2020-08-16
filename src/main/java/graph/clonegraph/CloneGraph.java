package graph.clonegraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/clone-graph/
 * @author liuzhengyang
 */
public class CloneGraph {
    public static void main(String[] args) {

    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> cache = new HashMap<>();
        return cloneWithCache(node, cache);
    }

    private Node cloneWithCache(Node node, Map<Integer, Node> cache) {
        if (node == null) {
            return null;
        }
        int val = node.val;
        Node cacheNode = cache.get(val);
        if (cacheNode != null) {
            return cacheNode;
        }
        Node newNode = new Node(node.val);
        cache.put(val, newNode);
        List<Node> neighbors = node.neighbors;
        if (neighbors != null) {
            List<Node> thisNeighbors = new ArrayList<>();
            for (Node neighbor : neighbors) {
                thisNeighbors.add(cloneWithCache(neighbor, cache));
            }
            newNode.neighbors = thisNeighbors;
        }
        return newNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
