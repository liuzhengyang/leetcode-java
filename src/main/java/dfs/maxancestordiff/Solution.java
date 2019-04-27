package dfs.maxancestordiff;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return recursiveRun(root).maxDiff;
    }

    private Result recursiveRun(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new Result(root.val, root.val, 0);
        }
        int min = root.val;
        int max = root.val;
        int leftMaxDiff = 0;
        int rightMaxDiff = 0;
        if (root.left != null) {
            Result left = recursiveRun(root.left);
            min = Math.min(min, left.min);
            max = Math.max(max, left.max);
            int thisDiff = Math.max(Math.abs(root.val - min), Math.abs(root.val - max));
            leftMaxDiff = Math.max(thisDiff, left.maxDiff);
        }
        if (root.right != null) {
            Result right = recursiveRun(root.right);
            min = Math.min(min, right.min);
            max = Math.max(max, right.max);
            int thisDiff = Math.max(Math.abs(root.val - min), Math.abs(root.val - max));
            rightMaxDiff = Math.max(thisDiff, right.maxDiff);
        }
        return new Result(min, max, Math.max(leftMaxDiff, rightMaxDiff));
    }

    private static class Result {
        private int min;
        private int max;
        private int maxDiff;

        public Result(int min, int max, int maxDiff) {
            this.min = min;
            this.max = max;
            this.maxDiff = maxDiff;
        }
    }
}
