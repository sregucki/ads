package neetcode.arraysandhashing;

import java.util.*;

public class TopKFrequentElements {

	/* Given an integer array nums and an integer k, return the k most frequent elements.
	You may return the answer in any order.

	Example 1:
	Input: nums = [1,1,1,2,2,3], k = 2
	Output: [1,2]

	Example 2:
	Input: nums = [1], k = 1
	Output: [1]

	Constraints:
	1 <= nums.length <= 105
	-104 <= nums[i] <= 104
	k is in the range [1, the number of unique elements in the array].
	It is guaranteed that the answer is unique.

	Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size. */

	/*
	Time complexity: O(n)
	Space complexity: O(n)
	*/
	public int[] topKFrequent(int[] nums, int k) {
		final int[] result = new int[k];
		final Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.replace(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}
		final Queue<List<Integer>> heap = new PriorityQueue<>((l1, l2) ->
			l2.get(1) - l1.get(1)
		);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			heap.add(List.of(entry.getKey(), entry.getValue()));
		}
		for (int i = 0; i < k; i++) {
			result[i] = heap.poll().get(0);
		}
		return result;
	}

	public static void main(String[] args) {
		final var obj = new TopKFrequentElements();
		System.out.println(
			Arrays.toString(obj.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2))
		);
	}
}
