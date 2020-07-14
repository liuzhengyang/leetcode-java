package bfs.countgoodnodesinbinarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.datastructure.TreeNode;

/**
 * 从根节点开始，记录一个总数，bfs每次遍历到节点计数+1，如果子节点大于当前节点，则加入到下次遍历
 * 或者dfs遍历，每次向下递归时，带上当前的最大值
 * 标签BFS, DFS
 *
 * @author liuzhengyang
 */
public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> prev = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        Map<TreeNode, Integer> largestMap = new HashMap<>();
        prev.add(root);
        largestMap.put(root, root.val);
        int count = 0;
        while (!prev.isEmpty()) {
            for (TreeNode node : prev) {
                TreeNode left = node.left;
                int largest = largestMap.get(node);
                if (left != null) {
                    if (left.val >= largest) {
                        count++;
                    }
                    largestMap.put(left, Math.max(largest, left.val));
                    next.add(left);
                }
                TreeNode right = node.right;
                if (right != null) {
                    if (right.val >= largest) {
                        count++;
                    }
                    largestMap.put(right, Math.max(largest, right.val));
                    next.add(right);
                }
            }
            prev = next;
            next = new ArrayList<>();
        }
        return count;
    }

    /**
     * dfs版本，每次向下遍历的时候，传递上之前路径上的最大值
     * @return
     */
    private int dfsVersion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return doDfs(root, root.val);
    }

    private int doDfs(TreeNode node, int currentMax) {
        if (node == null) {
            return 0;
        }
        if (node.val >= currentMax) {
            return 1 + doDfs(node.left, node.val) + doDfs(node.right, node.val);
        } else {
            return doDfs(node.left, currentMax) + doDfs(node.right, currentMax);
        }
    }
}
