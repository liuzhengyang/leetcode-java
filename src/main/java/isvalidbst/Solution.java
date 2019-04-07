package isvalidbst;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        TreeNode left = root.left;
        TreeNode right = root.right;
        boolean thisValid =
                (left == null || maxVal(left) < val) && (right == null || minVal(right) > val);
        return thisValid && isValidBST(root.left) && isValidBST(root.right);
    }

    private Integer minVal(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.left == null && treeNode.right == null) {
            return treeNode.val;
        }
        if (treeNode.left == null && treeNode.right != null) {
            return Math.min(treeNode.val, minVal(treeNode.right));
        }
        if (treeNode.right == null && treeNode.left != null) {
            return Math.min(treeNode.val, minVal(treeNode.left));
        }
        return Math.min(Math.min(treeNode.val, minVal(treeNode.left)), minVal(treeNode.right));
    }

    private Integer maxVal(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.left == null && treeNode.right == null) {
            return treeNode.val;
        }
        if (treeNode.left == null && treeNode.right != null) {
            return Math.max(treeNode.val, maxVal(treeNode.right));
        }
        if (treeNode.right == null && treeNode.left != null) {
            return Math.max(treeNode.val, maxVal(treeNode.left));
        }
        return Math.max(Math.max(treeNode.val, maxVal(treeNode.left)), maxVal(treeNode.right));
    }
}
