package ads.algorithms;

import java.util.List;
import shared.ListNode;
import shared.TreeNode;

public interface AlgosAndPatterns {
	List<List<Integer>> slidingWindow(int[] arr);
	int binarySearchRecursive(int[] arr, int target);
	int binarySearchIterative(int[] arr, int target);
	ListNode reverseLinkedList(ListNode head);
	List<Integer> dfsTree(TreeNode root);
	List<Integer> bfsTree(TreeNode root);
	List<Integer> dfsGraph(int[][] grid);
	List<Integer> bfsGraph(int[][] grid);
}
