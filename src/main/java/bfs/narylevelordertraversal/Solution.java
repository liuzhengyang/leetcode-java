package bfs.narylevelordertraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        return levelOrderTraversal(root);
    }

    private List<List<Integer>> levelOrderTraversal(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Node> previous = new ArrayList<>();
        List<Node> next = new ArrayList<>();
        previous.add(root);
        while (!previous.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for (Node n : previous) {
                if (n.children != null) {
                    for (Node c : n.children) {
                        next.add(c);
                    }
                }
                level.add(n.val);
            }
            result.add(level);
            previous = next;
            next = new ArrayList<>();
        }
        return result;
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
