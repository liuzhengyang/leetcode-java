package tree.deepestleavessum;

import java.util.ArrayList;
import java.util.List;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 * Make something people want.
 * 2020/3/26
 */
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> prev = new ArrayList<>();
        List<TreeNode> finalList = new ArrayList<>();
        prev.add(root);
        while (!prev.isEmpty()) {
            finalList = prev;
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode treeNode : prev) {
                if (treeNode.left != null) {
                    next.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    next.add(treeNode.right);
                }
            }
            prev = next;
        }
        int sum = 0;
        for (TreeNode treeNode : finalList) {
            sum += treeNode.val;
        }
        return sum;
    }
}
