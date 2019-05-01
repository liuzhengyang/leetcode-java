package tree.minimundistancebetweenbstnodes;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    private Integer minDiff = null;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return minDiff;
    }

    private Result dfs(TreeNode root) {
        Result result = new Result();
        result.min = result.max = root.val;

        if (root.left != null) {
            Result leftResult = dfs(root.left);
            result.min = Math.min(leftResult.min, result.min);
            result.max = Math.max(leftResult.max, result.max);

            if (minDiff == null || minDiff >= Math.min(Math.abs(root.val - leftResult.min),
                    Math.abs(root.val - leftResult.max))) {
                minDiff = Math.min(Math.abs(root.val - leftResult.min),
                        Math.abs(root.val - leftResult.max));
            }
        }
        if (root.right != null) {
            Result rightResult = dfs(root.right);
            result.min = Math.min(rightResult.min, result.min);
            result.max = Math.max(rightResult.max, result.max);

            if (minDiff == null || minDiff >= Math.min(Math.abs(root.val - rightResult.min),
                    Math.abs(root.val - rightResult.max))) {
                minDiff = Math.min(Math.abs(root.val - rightResult.min),
                        Math.abs(root.val - rightResult.max));
            }
        }
        if (root.left == null && root.right == null) {
            return result;
        }

        return result;
    }

    static class Result {
        private int min;
        private int max;

    }
}
