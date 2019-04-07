package binarytreeinordertraversal;

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

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        if (root.left != null) {
            result.addAll(inorderTraversal(root.left));
        }
        result.add(root.val);
        if (root.right != null) {
            result.addAll(inorderTraversal(root.right));
        }
        return result;
    }
}
