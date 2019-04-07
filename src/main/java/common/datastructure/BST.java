package common.datastructure;

/**
 * @author liuzhengyang
 */
public class BST {
    public static class TreeNode {
        public int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode minimum(TreeNode treeNode) {
        while (treeNode != null) {
            treeNode = treeNode.left;
        }
        return treeNode;
    }

    public TreeNode maxmun(TreeNode treeNode) {
        while (treeNode != null) {
            treeNode = treeNode.right;
        }
        return treeNode;
    }

    public TreeNode successor(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.right != null) {
            return minimum(treeNode.right);
        }
        return null;
    }

}
