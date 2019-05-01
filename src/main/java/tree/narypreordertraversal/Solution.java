package tree.narypreordertraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        visit(root);
        if (root.children != null) {
            for (Node n : root.children) {
                if (n != null) {
                    preorder(n);
                }
            }
        }
        return result;
    }

    private void visit(Node node) {
        result.add(node.val);
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
