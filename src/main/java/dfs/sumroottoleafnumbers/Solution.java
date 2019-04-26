package dfs.sumroottoleafnumbers;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode treeNode, int inputValue) {
        if (treeNode.left == null && treeNode.right == null) {
            sum += inputValue * 10 + treeNode.val;
            return;
        }
        if (treeNode.left != null) {
            dfs(treeNode.left, inputValue * 10 + treeNode.val);
        }
        if (treeNode.right != null) {
            dfs(treeNode.right, inputValue * 10 + treeNode.val);
        }
    }
}
