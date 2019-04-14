package binarytreelevelordertraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    private static final TreeNode levelSplitter = new TreeNode(0);

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<TreeNode> previousLine = new ArrayList<>();
        previousLine.add(root);
        List<TreeNode> nextLine = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentLineVals = new ArrayList<>();
        while (!previousLine.isEmpty()) {
            for (TreeNode t : previousLine) {
                if (t.left != null) {
                    nextLine.add(t.left);
                }
                if (t.right != null) {
                    nextLine.add(t.right);
                }
                currentLineVals.add(t.val);
            }
            previousLine = nextLine;
            nextLine = new ArrayList<>();
            result.add(currentLineVals);
            currentLineVals = new ArrayList<>();
        }
        if (!currentLineVals.isEmpty()) {
            result.add(currentLineVals);
        }
        return result;
    }
}
