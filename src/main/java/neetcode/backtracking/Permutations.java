package neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	/* Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any
	order.

	Example 1:
	Input: nums = [1,2,3]
	Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

	Example 2:
	Input: nums = [0,1]
	Output: [[0,1],[1,0]]

	Example 3:
	Input: nums = [1]
	Output: [[1]]

	Constraints:
	1 <= nums.length <= 6
	-10 <= nums[i] <= 10
	All the integers of nums are unique. */
	/*
	Time complexity: O(n*n!)
	Space complexity: O(n*n!)
	 */
	public List<List<Integer>> permute(int[] nums) {
		final List<List<Integer>> res = new ArrayList<>();
		backtrack(nums, new ArrayList<>(), res);
		return res;
	}

	private void backtrack(
		int[] nums,
		List<Integer> cur,
		List<List<Integer>> res
	) {
		if (cur.size() == nums.length) {
			res.add(new ArrayList<>(cur));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (cur.contains(nums[i])) {
					continue;
				}
				cur.add(nums[i]);
				backtrack(nums, cur, res);
				cur.remove(cur.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		final var obj = new Permutations();
		System.out.println(obj.permute(new int[] { 1, 2, 3 }));
	}
}
