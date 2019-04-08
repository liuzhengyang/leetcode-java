package sumofroottoleafbinarynumbers;

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

    public int sumRootToLeaf(TreeNode root) {
        List<List<Integer>> allPaths = getAllPaths(root);
        System.out.println(allPaths);
        int sum = 0;
        for (List<Integer> path : allPaths) {
            int result = 0;
            int multiple = 1;
            for (Integer val : path) {
                result += val * multiple;
                multiple *= 2;
            }
            sum += result;
        }
        return sum;
    }

    private List<List<Integer>> getAllPaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            List<Integer> result = new ArrayList<>();
            result.add(root.val);
            return new ArrayList<>(Collections.singletonList(result));
        }
        List<List<Integer>> leftPaths = getAllPaths(root.left);
        List<List<Integer>> rightPaths = getAllPaths(root.right);
        leftPaths.addAll(rightPaths);
        for (List<Integer> path : leftPaths) {
            path.add(root.val);
        }
        return leftPaths;
    }
}
