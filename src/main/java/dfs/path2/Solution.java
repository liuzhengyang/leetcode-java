package dfs.path2;

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

    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        search(root, new ArrayList<>(), sum);
        return result;
    }

    private void search(TreeNode root,
            List<Integer> path, int sum) {
        if (root == null) {
            return;
        }
        List<Integer> thisPath = new ArrayList<>(path);
        thisPath.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                result.add(thisPath);
            }
        }
        search(root.left, thisPath, sum - root.val);
        search(root.right, thisPath, sum - root.val);
    }
}
