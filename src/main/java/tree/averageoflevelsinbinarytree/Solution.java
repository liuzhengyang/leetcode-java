package tree.averageoflevelsinbinarytree;

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

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        return bfs(root);
    }

    private List<Double> bfs(TreeNode node) {
        List<TreeNode> previous = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        List<Double> result = new ArrayList<>();
        previous.add(node);
        while (!previous.isEmpty()) {
            long sum = 0;
            int count = 0;
            for (TreeNode n : previous) {
                sum += n.val;
                count ++;
                if (n.left != null) {
                    next.add(n.left);
                }
                if (n.right != null) {
                    next.add(n.right);
                }
            }
            previous = next;
            next = new ArrayList<>();
            result.add(sum * 1.0D / count);
        }
        return result;
    }
}
