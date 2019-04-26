package dfs.binarytreepaths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    private List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        dfs(root, null);
        return result;
    }

    private void dfs(TreeNode treeNode, String prev) {
        if (prev == null) {
            prev = String.valueOf(treeNode.val);
        } else {
            prev += "->" + treeNode.val;
        }
        if (treeNode.left == null && treeNode.right == null) {
            result.add(prev);
            return;
        }
        if (treeNode.left != null) {
            dfs(treeNode.left, prev);
        }
        if (treeNode.right != null) {
            dfs(treeNode.right, prev);
        }
    }
}
