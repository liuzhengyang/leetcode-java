package tree.countcompletetreenodes;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 */
public class Solution {
    public int countNodes(TreeNode root) {
        return count(root);
    }

    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
