package p101;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-16
 */
public class Solution {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 * int val;
	 * TreeNode left;
	 * TreeNode right;
	 * TreeNode(int x) { val = x; }
	 * }
	 */
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		void printSelf() {
			System.out.println("Val " + val );
			if (left != null) {
				left.printSelf();
			}
			if (right != null) {
				right.printSelf();
			}
		}
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return equals(root, reverse(root));
	}

	public TreeNode reverse(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode treeNode = new TreeNode(root.val);
		treeNode.right = reverse(root.left);
		treeNode.left = reverse(root.right);
		return treeNode;
	}

	public boolean equals(TreeNode first, TreeNode second) {
		if (first != null && second != null) {
			if (first.val != second.val) {
				return false;
			}
			return equals(first.left, second.left) && equals(first.right, second.right);
		}
		if (first != null) {
			return false;
		}
		if (second != null) {
			return false;
		}
		return true;
	}
}