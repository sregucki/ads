package neetcode.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import shared.TreeNode;

public class BinaryTreeRightSideView {

	/* Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the
	nodes you can see ordered from top to bottom.

	Example 1:
	Input: root = [1,2,3,null,5,null,4]
	Output: [1,3,4]

	Example 2:
	Input: root = [1,null,3]
	Output: [1,3]

	Example 3:
	Input: root = []
	Output: []

	Constraints:
	The number of nodes in the tree is in the range [0, 100].
	-100 <= Node.val <= 100 */

	/*
	Time complexity: O(n), where n is the number of nodes
	Space complexity: O(w), where w is max level width (2^k, where k is number of levels)
	 */
	public List<Integer> rightSideView(TreeNode root) {
		final List<Integer> res = new ArrayList<>();
		final Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			final int levelWidth = queue.size();
			for (int i = 0; i < levelWidth; i++) {
				final TreeNode curr = queue.poll();
				if (i == 0) {
					res.add(curr.val);
				}
				if (curr.right != null) {
					queue.add(curr.right);
				}
				if (curr.left != null) {
					queue.add(curr.left);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		final var obj = new BinaryTreeRightSideView();
		System.out.println(
			obj.rightSideView(
				new TreeNode(1, null, new TreeNode(3, null, null))
			)
		);
	}
}
