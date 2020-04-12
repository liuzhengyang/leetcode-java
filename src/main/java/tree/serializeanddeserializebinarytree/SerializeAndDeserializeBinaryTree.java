package tree.serializeanddeserializebinarytree;

import common.datastructure.TreeNode;
import tree.utils.TreeUtils;

/**
 * @author liuzhengyang
 * Make something people want.
 * 2020/4/13
 */
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       return TreeUtils.buildTreeToArray(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return TreeUtils.buildTreeFromArray(data);
    }

}
