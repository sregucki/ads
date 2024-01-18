package utils;

import shared.ListNode;

public class LinkedListUtils {

	public static ListNode arrayToLinkedList(int[] arr) {
		final ListNode head = new ListNode();
		ListNode tail = head;
		for (int num : arr) {
			tail.next = new ListNode(num);
			tail = tail.next;
		}
		return head.next;
	}
}
