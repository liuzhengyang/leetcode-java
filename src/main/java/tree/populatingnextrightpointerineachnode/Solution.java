package tree.populatingnextrightpointerineachnode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhengyang
 */
public class Solution {

    Map<Integer, Node> levelPrev = new HashMap<>();
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        doEach(root, 1);
        return root;
    }

    private void doEach(Node node, int level) {
        Node prevLevelNode = levelPrev.get(level);
        if (prevLevelNode != null) {
            prevLevelNode.next = node;
        }
        levelPrev.put(level, node);
        if (node.left != null) {
            doEach(node.left, level + 1);
        }
        if (node.right != null) {
            doEach(node.right, level + 1);
        }
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
