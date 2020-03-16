package tree.linkedlistinbinarytree;

import common.datastructure.ListNode;
import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 * Make something people want.
 * 2020/3/17
 */
public class LinkedListInBinaryTree {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean subPathOfNode = isSubPathOfNode(head, root);
        if (subPathOfNode) {
            return true;
        }
        if (root.left != null) {
            if (isSubPath(head, root.left)) {
                return true;
            }
        }
        if (root.right != null) {
            if (isSubPath(head, root.right)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSubPathOfNode(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (head.val != root.val) {
            return false;
        }
        return isSubPathOfNode(head.next, root.left) || isSubPathOfNode(head.next, root.right);
    }

}
