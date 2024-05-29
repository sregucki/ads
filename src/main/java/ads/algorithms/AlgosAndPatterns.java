package ads.algorithms;

import shared.ListNode;
import shared.TreeNode;

public interface AlgosAndPatterns {
	int[][] slidingWindow(int[] arr);
	int binarySearchRecursive(int[] arr);
	int binarySearchIterative(int[] arr);
	void reverseLinkedList(ListNode head);
	void dfsTree(TreeNode root);
	void bfsTree(TreeNode root);
	void dfsGraph(char[][] grid);
	void bfsGraph(char[][] grid);
}
