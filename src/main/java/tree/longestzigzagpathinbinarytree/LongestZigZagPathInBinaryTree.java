package tree.longestzigzagpathinbinarytree;

import java.util.HashMap;
import java.util.Map;

import common.datastructure.TreeNode;
import tree.utils.TreeUtils;

/**
 * @author liuzhengyang
 * Make something people want.
 * 2020/4/12
 */
public class LongestZigZagPathInBinaryTree {
    public static void main(String[] args) {
        String treeStr = "[2,8,6,1,1,7,9,8,9,3,1,4,8,null,5,3,4,10,10,2,null,5,null,3,7,null,3,null,4,6,2,8,4,5,null,null,9,null,6,null,6,null,null,2,2,null,3,2,null,null,8,1,9,8,8,5,10,null,9,null,8,null,null,null,null,5,7,2,10,null,null,null,null,null,null,3,null,2,null,null,null,8,7,null,null,3,1,null,3,null,null,null,7,1,null,3,null,null,null,null,2,null,2,null,4,7,4,null,null,null,9,null,null,null,null,8,8,null,null,null,null,7,2,1,4,null,4,7,null,5,9,null,7,9,7,null,10,9,6,null,null,7,2,3,null,2,null,9,5,9,null,null,5,null,5,9,null,null,null,null,9,null,null,null,null,null,7,null,null,null,null,null,null,null,9,null,4,1,null,null,null,null,4,4,null,null,4,null,null,null,4]";
        TreeNode treeNode = TreeUtils.buildTreeFromArray(treeStr);
        LongestZigZagPathInBinaryTree longestZigZagPathInBinaryTree = new LongestZigZagPathInBinaryTree();
        System.out.println(longestZigZagPathInBinaryTree.longestZigZag(treeNode));
    }

    // 0 left 1 right
    // 提供一个函数，输入root和方向，返回从这个点和方向开始的zigzag最长长度。

    static int max = 0;

    private Map<TreeNode, Integer> longestZigZagLeftMap = new HashMap<>();
    private Map<TreeNode, Integer> longestZigZagRightMap = new HashMap<>();

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        max = 0;
        longestZigZagLeftMap = new HashMap<>();
        longestZigZagRightMap = new HashMap<>();
        traversal(root);
        return max - 1;
    }

    private void traversal(TreeNode root) {
        visit(root);
        if (root.left != null) {
            traversal(root.left);
        }
        if (root.right != null) {
            traversal(root.right);
        }
    }

    private void visit(TreeNode node) {
        int maxOfThisNode = Math.max(longestZigZag(node, true), longestZigZag(node, false));
        max = Math.max(max, maxOfThisNode);
    }

    private int longestZigZag(TreeNode root, boolean left) {
        if (left) {
            if (longestZigZagLeftMap.get(root) != null) {
                return longestZigZagLeftMap.get(root);
            }
            if (root.left != null) {
                int result =  1 + longestZigZag(root.left, false);
                longestZigZagLeftMap.put(root, result);
                return result;
            } else {
                longestZigZagLeftMap.put(root, 1);
                return 1;
            }
        } else {
            if (longestZigZagRightMap.get(root) != null) {
                return longestZigZagRightMap.get(root);
            }
            if (root.right != null) {
                int result = 1 + longestZigZag(root.right, true);
                longestZigZagRightMap.put(root, result);
                return result;
            } else {
                longestZigZagRightMap.put(root, 1);
                return 1;
            }
        }
    }
}
