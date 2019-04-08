package common.intro;

/**
 * @author liuzhengyang
 */
public class BST {
    public static class BSTNode {
        public int val;
        public BSTNode p;
        public BSTNode left;
        public BSTNode right;

        public BSTNode(int val) {
            this.val = val;
        }
    }

    public BSTNode minmum(BSTNode root) {
        while (root != null) {
            root = root.left;
        }
        return root;
    }

    public BSTNode maxmum(BSTNode root) {
        while (root != null) {
            root = root.right;
        }
        return root;
    }

    public BSTNode successor(BSTNode root) {
        if (root == null) {
            return null;
        }
        if (root.right != null) {
            return minmum(root.right);
        }
        BSTNode p = root.p;
        while (p != null && p.right == root) {
            root = p;
            p = p.p;
        }
        return p;
    }

    public BSTNode predecessor(BSTNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            return maxmum(root.left);
        }
        BSTNode p = root.p;
        while (p != null && p.left == root) {
            root = p;
            p = p.p;
        }
        return p;
    }

    public BSTNode search(BSTNode root, int val) {
        while (root != null && root.val != val) {
            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }

    public void inorderWalk(BSTNode root) {
        if (root.left != null) {
            inorderWalk(root.left);
        }
        visit(root);
        if (root.right != null) {
            inorderWalk(root.right);
        }
    }

    private void visit(BSTNode root) {

    }

    public BSTNode insert(BSTNode root, int val) {
        if (root == null) {
            return new BSTNode(val);
        }
        BSTNode finalRoot = root;
        BSTNode p = null;
        while (root != null) {
            p = root;
            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        if (val < p.val) {
            p.left = new BSTNode(val);
        } else {
            p.right = new BSTNode(val);
        }
        return finalRoot;
    }

    public BSTNode delete(BSTNode root, int val) {
        return null;
    }
}
