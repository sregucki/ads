package neetcode.trees;

import shared.TreeNode;

public class SubtreeOfAnotherTree {

	/* Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same
	structure and node values of subRoot and false otherwise. A subtree of a binary tree is a tree that consists of a
	node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

	Example 1:
	Input: root = [3,4,5,1,2], subRoot = [4,1,2]
	Output: true

	Example 2:
	Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
	Output: false

	Constraints:
	The number of nodes in the root tree is in the range [1, 2000].
	The number of nodes in the subRoot tree is in the range [1, 1000].
	-10^4 <= root.val <= 10^4
	-10^4 <= subRoot.val <= 10^4 */
	/*
	Time complexity: O(n)
	Space complexity: O(n)
	 */
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (subRoot == null || isEqual(root, subRoot)) {
			return true;
		}
		if (root == null) {
			return false;
		}
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	private boolean isEqual(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null || p.val != q.val) {
			return false;
		}

		boolean left = isEqual(p.left, q.left);
		boolean right = isEqual(p.right, q.right);

		return left && right;
	}

	public static void main(String[] args) {
		final var obj = new SubtreeOfAnotherTree();
	}
}
