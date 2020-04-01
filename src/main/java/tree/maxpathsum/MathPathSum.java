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
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = getMaxPathSumContains(root);
        if (root.left != null) {
            max = Math.max(max, maxPathSum(root.left));
        }
        if (root.right != null) {
            max = Math.max(max, maxPathSum(root.right));
        }
        return max;
    }

    private int getMaxPathSumContains(TreeNode root) {
        int val = root.val;
        if (root.left != null) {
            int left = doGetMaxPathSumContainsThis(root.left);
            if (left > 0) {
                val += left;
            }
        }
        if (root.right != null) {
            int right = doGetMaxPathSumContainsThis(root.right);
            if (right > 0) {
                val += right;
            }
        }
        return val;
    }

    private int doGetMaxPathSumContainsThis(TreeNode root) {
        int max = root.val;
        int maxLeft = max;
        int maxRight = max;
        if (root.left != null) {
            maxLeft = root.val + doGetMaxPathSumContainsThis(root.left);
        }
        if (root.right != null) {
            maxRight = root.val + doGetMaxPathSumContainsThis(root.right);
        }
        return Math.max(max, Math.max(maxLeft, maxRight));
    }
}
