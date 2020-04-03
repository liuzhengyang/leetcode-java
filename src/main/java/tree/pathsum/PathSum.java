package tree.pathsum;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 * Make something people want.
 * 2020/4/3
 */
public class PathSum {
    private static int totalCount = 0;

    public int pathSum(TreeNode root, int sum) {
        totalCount = 0;
        iterate(root, sum);
        return totalCount;
    }

    private void iterate(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        totalCount += pathSumFromThisNode(root, sum);
        iterate(root.left, sum);
        iterate(root.right, sum);
    }

    /**
     * 这个函数计算的是从当前这个root开始，向下的路径中和=sum的数量
     *
     * @param root
     * @param sum
     * @return
     */
    private int pathSumFromThisNode(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val == sum) {
            count += 1;
        }
        count += pathSumFromThisNode(root.left, sum - root.val);
        count += pathSumFromThisNode(root.right, sum - root.val);
        return count;
    }
}
