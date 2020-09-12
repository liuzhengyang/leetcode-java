package bfs.averageoflevelsinbinarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 */
public class AverateOfLevelsInBinaryTree {
    public static void main(String[] args) {

    }

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Double> result = new ArrayList<>();
        List<TreeNode> prev = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        prev.add(root);
        while (!prev.isEmpty()) {
            long sum = 0;
            int count = 0;
            for (TreeNode node : prev) {
                sum += node.val;
                count++;
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            result.add(1.0D * sum / count);
            prev = next;
            next = new ArrayList<>();
        }
        return result;
    }
}
