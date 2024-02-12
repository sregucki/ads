package neetcode.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import shared.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	/* Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to
	right, level by level).

	Example 1:
	Input: root = [3,9,20,null,null,15,7]
	Output: [[3],[9,20],[15,7]]

	Example 2:
	Input: root = [1]
	Output: [[1]]

	Example 3:
	Input: root = []
	Output: []

	Constraints:
	The number of nodes in the tree is in the range [0, 2000].
	-1000 <= Node.val <= 1000 */
	/*
	Time complexity: O(n)
	Space complexity: O(w), where w is max width of level (2^h where h is tree height)
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		final List<List<Integer>> res = new ArrayList<>();
		final Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			final int levelSize = queue.size();
			final List<Integer> level = new ArrayList<>();
			for (int i = 0; i < levelSize; i++) {
				TreeNode curr = queue.poll();
				level.add(curr.val);
				if (curr.left != null) {
					queue.add(curr.left);
				}
				if (curr.right != null) {
					queue.add(curr.right);
				}
			}
			res.add(level);
		}
		return res;
	}

	public static void main(String[] args) {
		final var obj = new BinaryTreeLevelOrderTraversal();
		System.out.println(
			obj.levelOrder(
				new TreeNode(
					1,
					new TreeNode(2, null, null),
					new TreeNode(3, null, null)
				)
			)
		);
	}
}
