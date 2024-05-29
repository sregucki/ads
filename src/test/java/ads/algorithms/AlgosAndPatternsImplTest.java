package ads.algorithms;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shared.ListNode;
import shared.TreeNode;

class AlgosAndPatternsImplTest {

	private final AlgosAndPatterns obj = new AlgosAndPatternsImpl();

	@Test
	void slidingWindow() {
		Assertions.assertEquals(
			List.of(List.of(1, 2), List.of(2, 3), List.of(3, 4), List.of(4, 5)),
			obj.slidingWindow(new int[] { 1, 2, 3, 4, 5 })
		);
	}

	@Test
	void binarySearchRecursive() {
		int target = 7;
		int index = 6;
		Assertions.assertEquals(
			index,
			obj.binarySearchRecursive(
				new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 },
				target
			)
		);
	}

	@Test
	void binarySearchIterative() {
		int target = 7;
		int index = 6;
		Assertions.assertEquals(
			index,
			obj.binarySearchIterative(
				new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 },
				target
			)
		);
	}

	@Test
	void reverseLinkedList() {
		ListNode head = new ListNode(
			1,
			new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))
		);
		List<Integer> expected = List.of(5, 4, 3, 2, 1);
		List<Integer> actual = new ArrayList<>();
		ListNode tail = obj.reverseLinkedList(head);
		while (tail != null) {
			actual.add(tail.val);
			tail = tail.next;
		}
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void dfsTree() {
		Assertions.assertEquals(
			List.of(1, 2, 4, 5, 3, 6, 7),
			obj.dfsTree(
				new TreeNode(
					1,
					new TreeNode(2, new TreeNode(4), new TreeNode(5)),
					new TreeNode(3, new TreeNode(6), new TreeNode(7))
				)
			)
		);
	}

	@Test
	void bfsTree() {
		Assertions.assertEquals(
			List.of(1, 2, 3, 4, 5, 6, 7),
			obj.bfsTree(
				new TreeNode(
					1,
					new TreeNode(2, new TreeNode(4), new TreeNode(5)),
					new TreeNode(3, new TreeNode(6), new TreeNode(7))
				)
			)
		);
	}

	@Test
	void dfsGraph() {
		Assertions.assertEquals(
			List.of(1, 5, 9, 13, 14, 10, 6, 2, 3, 7, 11, 15, 16, 12, 8, 4),
			obj.dfsGraph(
				new int[][] {
					{ 1, 2, 3, 4 },
					{ 5, 6, 7, 8 },
					{ 9, 10, 11, 12 },
					{ 13, 14, 15, 16 },
				}
			)
		);
	}

	@Test
	void bfsGraph() {
		Assertions.assertEquals(
			List.of(1, 2, 5, 3, 6, 9, 4, 7, 10, 13, 8, 11, 14, 12, 15, 16),
			obj.bfsGraph(
				new int[][] {
					{ 1, 2, 3, 4 },
					{ 5, 6, 7, 8 },
					{ 9, 10, 11, 12 },
					{ 13, 14, 15, 16 },
				}
			)
		);
	}
}
