package neetcode.arraysandhashing;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {

	/*	Given an integer array nums, return true if any value appears at least twice in the array,
	and return false if every element is distinct.

	Example 1:

	Input: nums = [1,2,3,1]
	Output: true
	Example 2:

	Input: nums = [1,2,3,4]
	Output: false
	Example 3:

	Input: nums = [1,1,1,3,3,4,3,2,4,2]
	Output: true
	*/

	/*
	Time complexity: O(n)
	Space complexity: O(n)
	*/
	public boolean containsDuplicate(int[] nums) {
		final var set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}

	/*
	Time complexity: O(n*log(n))
	Space complexity: O(1)
	*/
	public boolean containsDuplicateSW(int[] nums) {
		int k = 2, i = 0;
		Arrays.sort(nums);
		while (i + k <= nums.length) {
			final var arr = Arrays.copyOfRange(nums, i, i + k);
			if (arr[0] == arr[1]) {
				return true;
			}
			i++;
		}
		return false;
	}

	public static void main(String[] args) {
		final var obj = new ContainsDuplicate();
		System.out.println(
			obj.containsDuplicateSW(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 })
		);
	}
}
