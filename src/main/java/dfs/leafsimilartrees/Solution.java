package dfs.leafsimilartrees;

import java.util.ArrayList;
import java.util.List;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        inorderTraversal(root1, result1);
        inorderTraversal(root2, result2);
        return result1.equals(result2);
    }

    private List<Integer> result1 = new ArrayList<>();
    private List<Integer> result2 = new ArrayList<>();
    private void inorderTraversal(TreeNode treeNode, List<Integer> result) {
        if (treeNode.left != null) {
            inorderTraversal(treeNode.left, result);
        }
        visit(result, treeNode);
        if (treeNode.right != null) {
            inorderTraversal(treeNode.right, result);
        }
    }

    private void visit(List<Integer> result, TreeNode treeNode) {
       if (treeNode.left == null && treeNode.right == null) {
           result.add(treeNode.val);
       }
    }
}
