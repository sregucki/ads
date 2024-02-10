package neetcode.trees;

import shared.TreeNode;

public class BalancedBinaryTree {

	/* Given a binary tree, determine if it is height-balanced.

	Example 1:
	Input: root = [3,9,20,null,null,15,7]
	Output: true

	Example 2:
	Input: root = [1,2,2,3,3,null,null,4,4]
	Output: false

	Example 3:
	Input: root = []
	Output: true

	Constraints:
	The number of nodes in the tree is in the range [0, 5000].
	-10^4 <= Node.val <= 10^4 */

	/*
	Time complexity: O(n)
	Space complexity: O(n)
	 */
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		return (
			Math.abs(leftHeight - rightHeight) <= 1 &&
			isBalanced(root.left) &&
			isBalanced(root.right)
		);
	}

	private int height(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = height(root.left);
		int right = height(root.right);

		return 1 + Math.max(left, right);
	}

	public static void main(String[] args) {
		final var obj = new BalancedBinaryTree();
		System.out.println(
			obj.isBalanced(
				new TreeNode(
					3,
					new TreeNode(9, null, null),
					new TreeNode(
						20,
						new TreeNode(15, null, null),
						new TreeNode(7, null, null)
					)
				)
			)
		);
	}
}
