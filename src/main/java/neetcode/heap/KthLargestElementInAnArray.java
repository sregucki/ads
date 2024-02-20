package neetcode.heap;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

	/* Given an integer array nums and an integer k, return the kth largest element in the array. Note that it is the
	kth largest element in the sorted order, not the kth distinct element. Can you solve it without sorting?

	Example 1:
	Input: nums = [3,2,1,5,6,4], k = 2
	Output: 5

	Example 2:
	Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
	Output: 4   //6 5 4 2

	Constraints:
	1 <= k <= nums.length <= 10^5
	-10^4 <= nums[i] <= 10^4 */
	/*
	Time complexity: O(n)
	Space complexity: O(k)
	 */
	public int findKthLargest(int[] nums, int k) {
		final PriorityQueue<Integer> heap = new PriorityQueue<>();
		for (int num : nums) {
			heap.offer(num);
			if (heap.size() > k) {
				heap.poll();
			}
		}
		return heap.poll();
	}

	public static void main(String[] args) {
		final var obj = new KthLargestElementInAnArray();
	}
}
