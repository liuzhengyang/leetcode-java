package tree.maxpathsum;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 * Make something people want.
 * 2020/4/2
 */
public class MathPathSum {
    /**
     * 5,4,8,11,null,13,4,7,2,null,null,null,1
     *
     * @param root
     * @return
     */
    static int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxDownPath(root);
        return max;
    }

    int maxDownPath(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int left = 0;
        if (root.left != null) {
            left = Math.max(maxDownPath(root.left), 0);
        }
        int right = 0;
        if (root.right != null) {
            right = Math.max(maxDownPath(root.right), 0);
        }
        max = Math.max(max, root.val + left + right);
        return root.val + Math.max(left, right);
    }

}
