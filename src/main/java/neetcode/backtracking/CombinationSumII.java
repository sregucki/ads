package neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	/*
	Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations
	in candidates where the candidate numbers sum to target. Each number in candidates may only be used once in the
	combination. Note: The solution set must not contain duplicate combinations.

	Example 1:
	Input: candidates = [10,1,2,7,6,1,5], target = 8
	Output:
		[
		[1,1,6],
		[1,2,5],
		[1,7],
		[2,6]
		]

	Example 2:
	Input: candidates = [2,5,2,1,2], target = 5
	Output:
		[
		[1,2,2],
		[5]
		]

	Constraints:
	1 <= candidates.length <= 100
	1 <= candidates[i] <= 50
	1 <= target <= 30
	*/
	/*
	Time complexity: O(n*n^(T/M+1))
	Space complexity: O(T/M)
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		final List<List<Integer>> res = new ArrayList<>();
		backtrack(candidates, target, 0, new ArrayList<>(), res);
		return res;
	}

	private void backtrack(
		int[] candidates,
		int target,
		int index,
		List<Integer> cur,
		List<List<Integer>> res
	) {
		if (target == 0) {
			res.add(new ArrayList<>(cur));
		} else if (target < 0) {
			return;
		} else {
			for (int i = index; i < candidates.length; i++) {
				if (i > index && candidates[i] == candidates[i - 1]) {
					continue;
				}
				cur.add(candidates[i]);
				backtrack(candidates, target - candidates[i], i + 1, cur, res);
				cur.remove(cur.get(cur.size() - 1));
			}
		}
	}

	public static void main(String[] args) {
		final var obj = new CombinationSumII();
		System.out.println(
			obj.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8)
		);
	}
}
