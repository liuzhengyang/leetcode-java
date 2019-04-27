package dfs.increasingorderedsearchtree;

import java.util.ArrayList;
import java.util.List;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> inorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);
        TreeNode newRoot = null;
        TreeNode prev = null;
        for (int i = 0; i < inorderList.size(); i++) {
            if (newRoot == null) {
                newRoot = new TreeNode(inorderList.get(i));
                prev = newRoot;
            } else {
                TreeNode newNode = new TreeNode(inorderList.get(i));
                prev.right = newNode;
                prev = newNode;
            }
        }
        return newRoot;
    }

    private void inorderTraversal(TreeNode root, List<Integer> container) {
        if (root.left != null) {
            inorderTraversal(root.left, container);
        }
        container.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right, container);
        }
    }
}
