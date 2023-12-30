package neetcode.arraysandhashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

	/*	Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
	You must write an algorithm that runs in O(n) time.

	Example 1:
	Input: nums = [100,4,200,1,3,2]
	Output: 4
	Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

	Example 2:
	Input: nums = [0,3,7,2,5,8,4,6,0,1]
	Output: 9

	Constraints:
	0 <= nums.length <= 10^5
	-10^9 <= nums[i] <= 10^9 */

	/*
	Time complexity: O(n)
	Space complexity: O(n)
	*/
	public int longestConsecutive(int[] nums) {
		final Map<Integer, Integer> map = new HashMap<>();
		final Set<Integer> set = Arrays
			.stream(nums)
			.boxed()
			.collect(Collectors.toSet());
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				continue;
			}
			if (!set.contains(nums[i] - 1)) {
				map.put(nums[i], 1);
				int seq = nums[i];
				while (set.contains(seq + 1)) {
					map.replace(nums[i], map.get(nums[i]) + 1);
					seq++;
				}
			}
		}
		return map.values().stream().max(Integer::compareTo).orElse(0);
	}

	public static void main(String[] args) {
		final var obj = new LongestConsecutiveSequence();
		System.out.println(
			obj.longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 })
		);
	}
}
