package bst;

/**
 * @author liuzhengyang
 */
public class BinarySearchTree {

    public Node minimal(Node root) {
        while (root.getLeft() != null) {
            root = root.getLeft();
        }
        return root;
    }

    public Node successor(Node root) {
        if (root.getRight() != null) {
            return minimal(root.getRight());
        }

        Node p = root.getParent();
        while(p != null && root.equals(p.getRight())) {
            root = p;
            p = root.getParent();
        }

        return p;
    }

    static class Node {
        private int value;
        private Node left;
        private Node right;
        private Node parent;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }
}
