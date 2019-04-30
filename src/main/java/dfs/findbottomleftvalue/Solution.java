package dfs.findbottomleftvalue;

import java.util.ArrayList;
import java.util.List;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }


        return levelOrderFind(root);
    }

    private int levelOrderFind(TreeNode root) {
        List<TreeNode> previous = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        previous.add(root);
        int bottomLeft = 0;
        while (!previous.isEmpty()) {
            bottomLeft = previous.get(0).val;
            for (TreeNode n : previous) {
                if (n.left != null) {
                    next.add(n.left);
                }
                if (n.right != null) {
                    next.add(n.right);
                }
            }
            previous = next;
            next = new ArrayList<>();
        }
        return bottomLeft;
    }
}
