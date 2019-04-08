package common.intro;

/**
 * @author liuzhengyang
 */
public class RBTree {
    private static class RBTreeNode {
        public boolean isBlack;
        public int val;
        public RBTreeNode p;
        public RBTreeNode left;
        public RBTreeNode right;

        public RBTreeNode(boolean isBlack, int val) {
            this.isBlack = isBlack;
            this.val = val;
        }
    }



}
