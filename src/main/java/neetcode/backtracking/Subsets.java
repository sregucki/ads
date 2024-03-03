package neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	/* Given an integer array nums of unique elements, return all possible subsets (the power set). The solution set
	must not contain duplicate subsets. Return the solution in any order.

	Example 1:
	Input: nums = [1,2,3]
	Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

	Example 2:
	Input: nums = [0]
	Output: [[],[0]]

	Constraints:
	1 <= nums.length <= 10
	-10 <= nums[i] <= 10
	All the numbers of nums are unique. */

	/*
	Time complexity: O(n*2^n)
	Space complexity: O(n)
	 */
	public List<List<Integer>> subsets(int[] nums) {
		final List<List<Integer>> res = new ArrayList<>();
		final List<Integer> list = new ArrayList<>();
		helper(0, nums, list, res);
		return res;
	}

	private void helper(
		int curr,
		int[] nums,
		List<Integer> list,
		List<List<Integer>> res
	) {
		if (curr >= nums.length) {
			res.add(new ArrayList<>(list));
		} else {
			list.add(nums[curr]);
			helper(curr + 1, nums, list, res);
			list.remove(list.size() - 1); // choice for not adding the element
			helper(curr + 1, nums, list, res);
		}
	}

	public static void main(String[] args) {
		final var obj = new Subsets();
		System.out.println(obj.subsets(new int[] { 1, 2, 3 }));
	}
}
