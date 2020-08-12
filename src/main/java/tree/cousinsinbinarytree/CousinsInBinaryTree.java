package tree.cousinsinbinarytree;

import java.util.HashMap;
import java.util.Map;

import common.datastructure.TreeNode;

/**
 * @author liuzhengyang
 * 2020/8/12
 */
public class CousinsInBinaryTree {
    public static void main(String[] args) {

    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, Integer> levelMap = new HashMap<>();
        Map<Integer, Integer> parentMap = new HashMap<>();
        computeLevelAndParent(root, 0, 0, levelMap, parentMap);
        int levelX = levelMap.getOrDefault(x, -1);
        int levelY = levelMap.getOrDefault(y, -1);
        int parentX = parentMap.getOrDefault(x, -1);
        int parentY = parentMap.getOrDefault(y, -1);
        return levelX >= 0 && levelY >= 0 && (levelX == levelY) && parentX >= 0 && parentY >= 0 && (parentX != parentY);
    }

    private void computeLevelAndParent(TreeNode root, int level, int parent,
           Map<Integer, Integer> levelMap, Map<Integer, Integer> parentMap) {
        int val = root.val;
        parentMap.put(val, parent);
        levelMap.put(val, level);
        TreeNode left = root.left;
        if (left != null) {
            computeLevelAndParent(left, level + 1, val, levelMap, parentMap);
        }
        TreeNode right = root.right;
        if (right != null) {
            computeLevelAndParent(right, level + 1, val, levelMap, parentMap);
        }
    }
}
