package dfs.sumofnodeswitheventvaluedgrandparent;

import common.datastructure.TreeNode;

/**
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 * @author liuzhengyang
 * 2020/8/16
 */
public class SumOfNodesWithEventValuedGrandParent {
    public static void main(String[] args) {

    }

    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, false, false);
    }

    private int dfs(TreeNode root, boolean parentIsEvent, boolean grandParentIsEvent) {
        int result = 0;
        if (grandParentIsEvent) {
            result += root.val;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        boolean thisIsEvent = root.val % 2 == 0;
        if (left != null) {
            result += dfs(left, thisIsEvent, parentIsEvent);
        }
        if (right != null) {
            result += dfs(right, thisIsEvent, parentIsEvent);
        }
        return result;
    }
}
