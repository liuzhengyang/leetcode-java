package dfs.flattenbinarytreetolinkedlist;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(null, root);
    }

    private TreeNode dfs(TreeNode prev, TreeNode node) {
        if (prev != null) {
            prev.right = node;
            prev.left = null;
        }
        if (node.left == null && node.right == null) {
            return node;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;

        TreeNode rightMost = node;

        if (left != null) {
            rightMost = dfs(node, left);
        }
        if (right != null) {
            rightMost = dfs(rightMost, right);
        }
        return rightMost;
    }
}
