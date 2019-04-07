package kthmsmallestelementbst;

import java.util.concurrent.atomic.AtomicInteger;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    public int kthSmallest(TreeNode root, int k) {
        return visit(new AtomicInteger(1), root, k);
    }

    /**
     * order means smallest ith
     * @return whether this is the k th
     */
    private boolean visitVal(AtomicInteger order, int k) {
        if (order.getAndIncrement() == k) {
            return true;
        }
        return false;
    }

    private Integer visit(AtomicInteger count, TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            Integer result = visit(count, root.left, k);
            if (result != null) {
                return result;
            }
        }
        boolean isKth = visitVal(count, k);
        if (isKth) {
            return root.val;
        }
        if (root.right != null) {
            Integer result = visit(count, root.right, k);
            if (result != null) {
                return result;
            }
        }
        return null;
    }
}
