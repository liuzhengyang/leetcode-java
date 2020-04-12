package tree.utils;

import java.util.ArrayList;
import java.util.List;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 * Make something people want.
 * 2020/4/12
 */
public class TreeUtils {

    public static TreeNode buildTreeFromArray(String arrays) {
        if (arrays == null || arrays.length() <= 2) {
            return null;
        }
        List<Integer> numbers = parseIntegerListFromString(arrays);
        TreeNode root = new TreeNode(numbers.get(0));
        doBuild(root, 0, numbers);
        return root;
    }

    private static void doBuild(TreeNode node, int currentIndex, List<Integer> numbers) {
        int leftIndex = 2 * currentIndex + 1;
        int rightIndex = 2 * currentIndex + 2;
        if (leftIndex < numbers.size()) {
            Integer number = numbers.get(leftIndex);
            if (number != null) {
                TreeNode treeNode = new TreeNode(number);
                node.left = treeNode;
                doBuild(treeNode, leftIndex, numbers);
            }
        }
        if (rightIndex < numbers.size()) {
            Integer number = numbers.get(rightIndex);
            if (number != null) {
                TreeNode treeNode = new TreeNode(number);
                node.right = treeNode;
                doBuild(treeNode, rightIndex, numbers);
            }
        }
    }

    private static List<Integer> parseIntegerListFromString(String arrays) {
        String numbersSplitByComma = arrays.substring(1, arrays.length() - 1);
        String[] splits = numbersSplitByComma.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String split : splits) {
            if ("null".equals(split)) {
                numbers.add(null);
            } else {
                numbers.add(Integer.parseInt(split.trim()));
            }
        }
        return numbers;
    }

    public static String buildTreeToArray(TreeNode root) {
        if (root == null) {
            return null;
        }
        int heightOfBinaryTree = getHeightOfBinaryTree(root);
        int arrayLength = powOf2(heightOfBinaryTree) - 1;
        Integer[] numbers = new Integer[arrayLength];
        doBuildToArray(numbers, root, 0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < numbers.length - 1; i++) {
            stringBuilder.append(numbers[i]);
            stringBuilder.append(",");
        }
        stringBuilder.append(numbers[numbers.length - 1]);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static void doBuildToArray(Integer[] arrays, TreeNode root, int currentIndex) {
        if (root == null) {
            if (currentIndex < arrays.length) {
                arrays[currentIndex] = null;
            }
        } else {
            arrays[currentIndex] = root.val;
            doBuildToArray(arrays, root.left, currentIndex * 2 + 1);
            doBuildToArray(arrays, root.right, currentIndex * 2 + 2);
        }
    }

    public static void printTree(TreeNode root) {
        int height = getHeightOfBinaryTree(root) - 1;
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> next = new ArrayList<>();
            int blankBefore = getBlankBeforeThisNode(height);
            for (int i = 0; i < blankBefore; i++) {
                System.out.print(" ");
            }
            for (TreeNode treeNode : queue) {
                if (treeNode != null) {
                    System.out.print(treeNode.val);
                    if (treeNode.left != null) {
                        next.add(treeNode.left);
                    } else {
                        next.add(null);
                    }
                    if (treeNode.right != null) {
                        next.add(treeNode.right);
                    } else {
                        next.add(null);
                    }
                } else {
                    System.out.print(" ");
                }
                int blankInterval = powOf2(height + 1) - 1;
                for (int i = 0; i < blankInterval; i++) {
                    System.out.print(" ");
                }
            }
            boolean allNull = true;
            for (TreeNode node : next) {
                if (node != null) {
                    allNull = false;
                    break;
                }
            }
            if (allNull) {
                break;
            }
            queue = next;
            height--;
            System.out.println();
        }
    }

    private static int getBlankBeforeThisNode(int level) {
        return powOf2(level) - 1;
    }

    private static int powOf2(int n) {
        if (n == 0) {
            return 1;
        } else {
            return 2 * powOf2(n - 1);
        }
    }

    private static int getHeightOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeightOfBinaryTree(root.left), getHeightOfBinaryTree(root.right));
    }
}
