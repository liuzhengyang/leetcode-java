package bfs.binarytreelevelordertraversal2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        return levelOrder(root);
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> previous = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        List<List<Integer>> result = new LinkedList<>();
        previous.add(root);
        while (!previous.isEmpty()) {
            for (TreeNode node : previous) {
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            List<Integer> values = new ArrayList<>();
            for (TreeNode node : previous) {
                values.add(node.val);
            }
            result.add(0, values);
            previous = next;
            next = new ArrayList<>();
        }
        return result;
    }
}
