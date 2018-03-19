package p687;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import p101.Solution;

/**
 * @author liuzhengyang
 */
public class Main {

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int thisLongestLeft = sameValWith(root, root.left) ? 1 + longestSameDepthPathOfThisNode(root.left) : 0;
        int thisLongestRight = sameValWith(root, root.right) ? 1 + longestSameDepthPathOfThisNode(root.right) : 0;
        int thisLongest = thisLongestLeft + thisLongestRight;
        return max(thisLongest, longestUnivaluePath(root.left), longestUnivaluePath(root.right));
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private int longestValuePath(TreeNode root, int value) {
        if (root == null || root.val != value) {
            return 0;
        }
        return 1 + Math.max(longestValuePath(root.left, value), longestValuePath(root.right, value));
    }

    public int longestValuePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = longestValuePath(root.left, root.val) + longestValuePath(root.right, root.val);
        int maxl = longestValuePath(root.left);
        int maxr = longestValuePath(root.right);
        return Math.max(max, Math.max(maxl, maxr));
    }

    int longestSameDepthPathOfThisNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        boolean sameWithLeft = sameValWith(node, node.left);
        boolean sameWithRight = sameValWith(node, node.right);
        if (sameWithLeft && sameWithRight) {
            return 1 + Math.max(longestSameDepthPathOfThisNode(node.left), longestSameDepthPathOfThisNode(node.right));
        } else if (sameWithLeft) {
            return 1 + longestSameDepthPathOfThisNode(node.left);
        } else if (sameWithRight){
            return 1 + longestSameDepthPathOfThisNode(node.right);
        } else {
            return 0;
        }
    }

    private boolean sameValWith(TreeNode from, TreeNode to) {
        if (from != null && to != null && from.val == to.val) {
            return true;
        } else {
            return false;
        }
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new Main().longestUnivaluePath(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
               "val=" + val +
               '}';
    }
}
