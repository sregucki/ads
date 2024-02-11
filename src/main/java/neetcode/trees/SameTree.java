package neetcode.trees;

import shared.TreeNode;

public class SameTree {

	/* Given the roots of two binary trees p and q, write a function to check if they are the same or not. Two binary
	trees are considered the same if they are structurally identical, and the nodes have the same value.

	Example 1:
	Input: p = [1,2,3], q = [1,2,3]
	Output: true

	Example 2:
	Input: p = [1,2], q = [1,null,2]
	Output: false

	Example 3:
	Input: p = [1,2,1], q = [1,1,2]
	Output: false

	Constraints:
	The number of nodes in both trees is in the range [0, 100].
	-10^4 <= Node.val <= 10^4 */
	/*
	Time complexity: O(n)
	Space complexity: O(n)
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val != q.val) {
			return false;
		}

		boolean left = isSameTree(p.left, q.left);
		boolean right = isSameTree(p.right, q.right);

		return left & right;
	}

	public static void main(String[] args) {
		final var obj = new SameTree();
		System.out.println(
			obj.isSameTree(
				new TreeNode(
					1,
					new TreeNode(2, null, null),
					new TreeNode(3, null, null)
				),
				new TreeNode(
					1,
					new TreeNode(2, null, null),
					new TreeNode(3, null, null)
				)
			)
		);
	}
}
