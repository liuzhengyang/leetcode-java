package tree.minimunabsolutedifferenceinbst;

import java.util.Stack;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 */
public class Solution {
    long min = Long.MAX_VALUE;
    private TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);
        return (int) min;
    }

    private void inorderTraversal(TreeNode node) {
        if (node.left != null) {
            inorderTraversal(node.left);
        }
        visit(node);
        if (node.right != null) {
            inorderTraversal(node.right);
        }
    }

    private void visit(TreeNode node) {
        if (prev != null) {
            min = Math.min(min, node.val - prev.val);
        }
        prev = node;
    }

}
