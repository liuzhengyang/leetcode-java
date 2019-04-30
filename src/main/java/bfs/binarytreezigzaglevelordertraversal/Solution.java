package bfs.binarytreezigzaglevelordertraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        return levelOrder(root);
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> previous = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        previous.add(root);
        boolean leftToRight = true;
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
            if (leftToRight) {
                for (TreeNode node : previous) {
                    values.add(node.val);
                }
            } else {
                for (int i = previous.size() - 1; i >= 0; i--) {
                    values.add(previous.get(i).val);
                }
            }
            leftToRight ^= true;
            result.add(values);
            previous = next;
            next = new ArrayList<>();
        }
        return result;
    }
}
