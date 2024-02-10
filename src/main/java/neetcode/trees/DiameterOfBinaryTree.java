package neetcode.trees;

import shared.TreeNode;

public class DiameterOfBinaryTree {

	/* Given the root of a binary tree, return the length of the diameter of the tree. The diameter of a binary tree is
	the length of the longest path between any two nodes in a tree. This path may or may not pass through the root. The
	length of a path between two nodes is represented by the number of edges between them.

	Example 1:
	Input: root = [1,2,3,4,5]
	Output: 3
	Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

	Example 2:
	Input: root = [1,2]
	Output: 1
	Constraints:

	The number of nodes in the tree is in the range [1, 104].
	-100 <= Node.val <= 100 */
	/*
	Time complexity: O(n)
	Space complexity: O(n)
	 */
	private int maxDiameter = -1;

	public int diameterOfBinaryTree(TreeNode root) {
		return dfs(root);
	}

	private int dfs(TreeNode root) {
		if (root == null) {
			return -1;
		}
		int left = dfs(root.left); // diameter of the left subtree
		int right = dfs(root.right); // diameter of the right subtree
		maxDiameter = Math.max(maxDiameter, left + right + 2);

		return 1 + Math.max(left, right);
	}

	public static void main(String[] args) {
		final var obj = new DiameterOfBinaryTree();
		System.out.println(
			obj.diameterOfBinaryTree(
				TreeNode.arrayToTree(new int[] { 1, 2, 3, 4, 5 })
			)
		);
	}
}
