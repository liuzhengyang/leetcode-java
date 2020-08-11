package bfs.maximumlevelsumofabinarytree;

import java.util.ArrayList;
import java.util.List;

import common.datastructure.TreeNode;

/**
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 * 解法1: 层次遍历
 * 解法2: bfs或dfs遍历，记录每一行的综合
 * @author liuzhengyang
 */
public class MaximumLevelSumOfAbinaryTree {
    public static void main(String[] args) {

    }

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> prev = new ArrayList<>();
        List<TreeNode> nextQueue = new ArrayList<>();
        prev.add(root);
        int maxSum = root.val;
        int maxLevel = 1;
        int levelCount = 0;
        while (!prev.isEmpty()) {
            levelCount++;
            int thisLevelSum = 0;
            for (TreeNode prevNode : prev) {
                thisLevelSum += prevNode.val;
                TreeNode left = prevNode.left;
                if (left != null) {
                    nextQueue.add(left);
                }
                TreeNode right = prevNode.right;
                if (right != null) {
                    nextQueue.add(right);
                }
            }
            if (thisLevelSum > maxSum) {
                maxLevel = levelCount;
                maxSum = thisLevelSum;
            }
            prev = nextQueue;
            nextQueue = new ArrayList<>();
        }
        return maxLevel;
    }
}
