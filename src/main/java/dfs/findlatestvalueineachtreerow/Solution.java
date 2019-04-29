package dfs.findlatestvalueineachtreerow;

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

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        return levelOrderTraversal(root);
    }

    private List<Integer> levelOrderTraversal(TreeNode root) {
        List<TreeNode> previous = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        previous.add(root);
        while (!previous.isEmpty()) {
            int max = previous.get(0).val;
            for (TreeNode node : previous) {
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
                max = Math.max(max, node.val);
            }
            result.add(max);
            previous = next;
            next = new ArrayList<>();
        }
        return result;
    }
}
