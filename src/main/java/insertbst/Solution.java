package insertbst;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode result = root;
        TreeNode p = null;
        while (root != null) {
            p = root;
            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        if (p == null) {
            return new TreeNode(val);
        } else {
            if (val < p.val) {
                p.left = new TreeNode(val);
            } else {
                p.right = new TreeNode(val);
            }
            return result;
        }
    }
}
