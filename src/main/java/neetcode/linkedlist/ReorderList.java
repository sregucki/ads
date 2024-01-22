package neetcode.linkedlist;

import static utils.LinkedListUtils.arrayToLinkedList;

import shared.ListNode;

public class ReorderList {

	/* You are given the head of a singly linked-list. The list can be represented as: L0 → L1 → … → Ln - 1 → Ln
	Reorder the list to be on the following form: L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
	You may not modify the values in the list's nodes. Only nodes themselves may be changed.

	Example 1:
	Input: head = [1,2,3,4]
	Output: [1,4,2,3]

	Example 2:
	Input: head = [1,2,3,4,5]
	Output: [1,5,2,4,3]

	Constraints:
	The number of nodes in the list is in the range [1, 5 * 10^4].
	1 <= Node.val <= 1000 */

	/*
	Time complexity: O(n)
	Space complexity: O(1)
	 */
	public void reorderList(ListNode head) {
		// split array into equal parts using slow, fast pointer pattern
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// reverse second half
		ListNode prev = null;
		while (slow != null) {
			ListNode next = slow.next;
			slow.next = prev;
			prev = slow;
			slow = next;
		}

		// merge two parts
		ListNode p1 = head;
		ListNode p2 = prev;

		while (p1 != null) {
			ListNode p1Next = p1.next;
			ListNode p2Next = p2.next;
			p1.next = p2;
			p2.next = p1Next;
			p1 = p1Next;
			p2 = p2Next;
		}
	}

	public static void main(String[] args) {
		final var obj = new ReorderList();
		obj.reorderList(arrayToLinkedList(new int[] { 1, 2, 3, 4, 5 }));
	}
}
