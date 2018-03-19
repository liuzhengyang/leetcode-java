package p687;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

    @Test
    public void testLognestSameValPath() throws Exception {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(3);
        System.out.println(new Main().longestSameDepthPathOfThisNode(treeNode.left));
    }

    @Test
    public void testMain() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(4);
        System.out.println(new Main().longestUnivaluePath(treeNode));
    }
}