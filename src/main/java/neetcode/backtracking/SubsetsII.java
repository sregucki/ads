package neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

	/* Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
	The solution set must not contain duplicate subsets. Return the solution in any order.

	Example 1:
	Input: nums = [1,2,2]
	Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

	Example 2:
	Input: nums = [0]
	Output: [[],[0]]

	Constraints:

	1 <= nums.length <= 10
	-10 <= nums[i] <= 10 */
	/*
	Time complexity: O(N*2^N)
	Space complexity: O(N*2^N)
	 */
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		final List<List<Integer>> res = new ArrayList<>();
		backtrack(nums, 0, new ArrayList<>(), res);
		return res;
	}

	private void backtrack(
		int[] nums,
		int index,
		List<Integer> cur,
		List<List<Integer>> res
	) {
		res.add(new ArrayList<>(cur));
		for (int i = index; i < nums.length; i++) {
			if (i > index && nums[i] == nums[i - 1]) {
				continue;
			}
			cur.add(nums[i]);
			backtrack(nums, i + 1, cur, res);
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String[] args) {
		final var obj = new SubsetsII();
		System.out.println(obj.subsetsWithDup(new int[] { 1, 2, 2, 3 }));
	}
}
