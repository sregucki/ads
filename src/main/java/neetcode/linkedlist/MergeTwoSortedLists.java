package neetcode.linkedlist;

import shared.ListNode;
import utils.LinkedListUtils;

public class MergeTwoSortedLists {

	/* You are given the heads of two sorted linked lists list1 and list2. Merge the two lists into one sorted list. The
	list should be made by splicing together the nodes of the first two lists. Return the head of the merged linked
	list.

	Example 1:
	Input: list1 = [1,2,4], list2 = [1,3,4]
	Output: [1,1,2,3,4,4]

	Example 2:
	Input: list1 = [], list2 = []
	Output: []

	Example 3:
	Input: list1 = [], list2 = [0]
	Output: [0]

	Constraints:
	The number of nodes in both lists is in the range [0, 50].
	-100 <= Node.val <= 100
	Both list1 and list2 are sorted in non-decreasing order. */

	/*
	Time complexity: O(min(n, m))
	Space complexity: O(n + m)
	 */
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode head = new ListNode();
		ListNode tail = head;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				tail.next = list1;
				list1 = list1.next;
			} else {
				tail.next = list2;
				list2 = list2.next;
			}
			tail = tail.next;
		}
		if (list1 != null) {
			tail.next = list1;
		} else if (list2 != null) {
			tail.next = list2;
		}
		return head.next;
	}

	public static void main(String[] args) {
		final var obj = new MergeTwoSortedLists();
		System.out.println(
			obj.mergeTwoLists(
				LinkedListUtils.arrayToLinkedList(new int[] { 1, 2, 4 }),
				LinkedListUtils.arrayToLinkedList(new int[] { 1, 3, 4 })
			)
		);
	}
}
