package bfs.binarytreerightsideview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }
        List<List<TreeNode>> levelOrder = levelOrderTraversal(root);
        List<Integer> result = new ArrayList<>();

        for (List<TreeNode> level : levelOrder) {
            result.add(level.get(level.size() - 1).val);
        }

        return result;
    }

    private List<List<TreeNode>> levelOrderTraversal(TreeNode root) {
        List<List<TreeNode>> result = new ArrayList<>();
        List<TreeNode> previous = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        previous.add(root);
        while (!previous.isEmpty()) {
            for (TreeNode node : previous) {
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            result.add(previous);
            previous = next;
            next = new ArrayList<>();
        }
        return result;
    }
}
