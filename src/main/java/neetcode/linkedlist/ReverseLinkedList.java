package neetcode.linkedlist;

import shared.ListNode;
import utils.LinkedListUtils;

public class ReverseLinkedList {

	/* Given the head of a singly linked list, reverse the list, and return the reversed list.
	Example 1:
	Input: head = [1,2,3,4,5]
	Output: [5,4,3,2,1]

	Example 2:
	Input: head = [1,2]
	Output: [2,1]

	Example 3:
	Input: head = []
	Output: []

	Constraints:
	The number of nodes in the list is the range [0, 5000].
	-5000 <= Node.val <= 5000

	Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both? */
	/*
	Time complexity: O(n)
	Space complexity: O(1)
	 */
	public ListNode reverseListIterative(ListNode head) {
		ListNode newHead = null;
		ListNode tail = head;
		while (tail != null) {
			ListNode next = tail.next;
			tail.next = newHead;
			newHead = tail;
			tail = next;
		}
		return newHead;
	}

	/*
	Time complexity: O(n)
	Space complexity: O(n)
	 */
	public ListNode reverseListRecursive(ListNode head) {
		return reverseListHelper(head, null);
	}

	private ListNode reverseListHelper(ListNode head, ListNode newHead) {
		if (head == null) {
			return newHead;
		}
		ListNode next = head.next;
		head.next = newHead;
		return reverseListHelper(next, head);
	}

	public static void main(String[] args) {
		final var obj = new ReverseLinkedList();
		System.out.println(
			obj.reverseListIterative(
				LinkedListUtils.arrayToLinkedList(new int[] { 1, 2, 3, 4, 5 })
			)
		);
	}
}
