package dfs.maxdepthofnarytree;

import java.util.List;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return dfs(root);
    }

    private int dfs(Node node) {
        if (node.children == null || node.children.isEmpty()) {
            return 1;
        }
        int maxOfChildre = 0;
        for (Node n : node.children) {
            maxOfChildre = Math.max(maxOfChildre, dfs(n));
        }
        return 1 + maxOfChildre;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};