package kthmsmallestelementbst;

import java.util.concurrent.atomic.AtomicInteger;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 */
public class Solution2 {
    public static void main(String[] args) {

    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return inOrderTraversal(root).val;
    }

    private int k;

    private TreeNode inOrderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode result = inOrderTraversal(root.left);
        if (result != null) {
            return result;
        }
        if (visit(root)) {
            return root;
        }
        result = inOrderTraversal(root.right);
        if (result != null) {
            return result;
        }
        return null;
    }

    private boolean visit(TreeNode root) {
        if (--k == 0) {
            return true;
        }
        System.out.println("Visit " + root.val);
        return false;
    }
}
