package balancedbinarytree;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int heightLeft = getHeight(treeNode.left);
        int heightRight = getHeight(treeNode.right);
        return Math.max(heightLeft, heightRight) + 1;
    }
}
