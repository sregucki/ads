package neetcode.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import shared.TreeNode;

public class KthSmallestElementInABST {

	/* Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the
	values of the nodes in the tree.

	Example 1:
	Input: root = [3,1,4,null,2], k = 1
	Output: 1

	Example 2:
	Input: root = [5,3,6,2,4,null,null,1], k = 3
	Output: 3

	Constraints:
	The number of nodes in the tree is n.
	1 <= k <= n <= 10^4
	0 <= Node.val <= 10^4

	Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth
	smallest frequently, how would you optimize? */
	/*
	Time complexity: O(h + k), where h is height of the three and k is arg
	Space complexity: O(h)
	 */
	public int kthSmallest(TreeNode root, int k) {
		int currK = 0;
		TreeNode curr = root;
		final Deque<TreeNode> stack = new ArrayDeque<>();
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			if (++currK == k) {
				return curr.val;
			}
			curr = curr.right;
		}
		return currK;
	}

	public static void main(String[] args) {
		final var obj = new KthSmallestElementInABST();
		System.out.println(
			obj.kthSmallest(
				new TreeNode(
					3,
					new TreeNode(1, null, new TreeNode(2, null, null)),
					new TreeNode(4, null, null)
				),
				4
			)
		);
	}
}
