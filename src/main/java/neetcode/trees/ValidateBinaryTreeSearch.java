package neetcode.trees;

import shared.TreeNode;

public class ValidateBinaryTreeSearch {

	/* Given the root of a binary tree, determine if it is a valid binary search tree (BST). A valid BST is defined as
	follows:
	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.

	Example 1:
	Input: root = [2,1,3]
	Output: true

	Example 2:
	Input: root = [5,1,4,null,null,3,6]
	Output: false
	Explanation: The root node's value is 5 but its right child's value is 4.

	Constraints:
	The number of nodes in the tree is in the range [1, 10^4].
	-2^31 <= Node.val <= 2^31 - 1*/
	/*
	Time complexity: O(n)
	Space complexity: O(h), where h is the height of the tree
	 */
	public boolean isValidBST(TreeNode root) {
		return helper(root, null, null);
	}

	private boolean helper(
		TreeNode root,
		Integer leftBound,
		Integer rightBound
	) {
		if (root == null) {
			return true;
		}

		if (
			(leftBound != null && root.val <= leftBound) ||
			(rightBound != null && root.val >= rightBound)
		) {
			return false;
		}

		boolean left = helper(root.left, leftBound, root.val);
		boolean right = helper(root.right, root.val, rightBound);

		return left && right;
	}

	public static void main(String[] args) {
		final var obj = new ValidateBinaryTreeSearch();
	}
}
