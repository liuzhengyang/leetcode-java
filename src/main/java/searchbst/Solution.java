package searchbst;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null) {
            if (root.val == val) {
                break;
            } else if (root.val < val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return root;
    }
}
