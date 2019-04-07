//package kthmsmallestelementbst;
//
///**
// * @author liuzhengyang
// */
//
///* -----------------------------------
// *  WARNING:
// * -----------------------------------
// *  Your code may fail to compile
// *  because it contains public class
// *  declarations.
// *  To fix this, please remove the
// *  "public" keyword from your class
// *  declarations.
// */
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.concurrent.atomic.AtomicInteger;
//
//import common.datastructure.TreeNode;
//
///**
// * Definition for a binary tree node.
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode(int x) { val = x; }
// * }
// */
//class DebugSolution {
//    public int kthSmallest(TreeNode root, int k) {
//        return visit(new AtomicInteger(1), root, k);
//    }
//
//    /**
//     * order means smallest ith
//     * @return whether this is the k th
//     */
//    private boolean visitVal(AtomicInteger order, int k) {
//        if (order.getAndIncrement() == k) {
//            return true;
//        }
//        return false;
//    }
//
//    private Integer visit(AtomicInteger count, TreeNode root, int k) {
//        if (root == null) {
//            return null;
//        }
//        if (root.left != null) {
//            Integer result = visit(count, root.left, k);
//            if (result != null) {
//                return result;
//            }
//        }
//        boolean isKth = visitVal(count, k);
//        if (isKth) {
//            return root.val;
//        }
//        if (root.right != null) {
//            Integer result = visit(count, root.right, k);
//            if (result != null) {
//                return result;
//            }
//        }
//        return null;
//    }
//}
//
//class MainClass {
//    public static TreeNode stringToTreeNode(String input) {
//        input = input.trim();
//        input = input.substring(1, input.length() - 1);
//        if (input.length() == 0) {
//            return null;
//        }
//
//        String[] parts = input.split(",");
//        String item = parts[0];
//        TreeNode root = new TreeNode(Integer.parseInt(item));
//        Queue<TreeNode> nodeQueue = new LinkedList<>();
//        nodeQueue.add(root);
//
//        int index = 1;
//        while(!nodeQueue.isEmpty()) {
//            TreeNode node = nodeQueue.remove();
//
//            if (index == parts.length) {
//                break;
//            }
//
//            item = parts[index++];
//            item = item.trim();
//            if (!item.equals("null")) {
//                int leftNumber = Integer.parseInt(item);
//                node.left = new TreeNode(leftNumber);
//                nodeQueue.add(node.left);
//            }
//
//            if (index == parts.length) {
//                break;
//            }
//
//            item = parts[index++];
//            item = item.trim();
//            if (!item.equals("null")) {
//                int rightNumber = Integer.parseInt(item);
//                node.right = new TreeNode(rightNumber);
//                nodeQueue.add(node.right);
//            }
//        }
//        return root;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            TreeNode root = stringToTreeNode(line);
//            line = in.readLine();
//            int k = Integer.parseInt(line);
//
//            int ret = new DebugSolution().kthSmallest(root, k);
//
//            String out = String.valueOf(ret);
//
//            System.out.print(out);
//        }
//    }
//}