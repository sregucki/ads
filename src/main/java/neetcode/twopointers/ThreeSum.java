package neetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	/* Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and
	j != k, and nums[i] + nums[j] + nums[k] == 0.
	Notice that the solution set must not contain duplicate triplets.

	Example 1:
	Input: nums = [-1,0,1,2,-1,-4]
	Output: [[-1,-1,2],[-1,0,1]]
	Explanation:
	nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
	nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
	nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
	The distinct triplets are [-1,0,1] and [-1,-1,2].
	Notice that the order of the output and the order of the triplets does not matter.

	Example 2:
	Input: nums = [0,1,1]
	Output: []
	Explanation: The only possible triplet does not sum up to 0.

	Example 3:
	Input: nums = [0,0,0]
	Output: [[0,0,0]]
	Explanation: The only possible triplet sums up to 0.

	Constraints:

	3 <= nums.length <= 3000
	-10^5 <= nums[i] <= 10^5 */

	/*
	Time complexity: O(n^2)
	Space complexity: O(n)
	*/
	public List<List<Integer>> threeSum(int[] nums) {
		final List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int l = i + 1, r = nums.length - 1;
			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r];
				if (sum == 0) {
					result.add(List.of(nums[i], nums[l], nums[r]));
					while (l < r && nums[l] == nums[l + 1]) {
						l++;
					}
					while (l < r && nums[r] == nums[r - 1]) {
						r--;
					}
					l++;
					r--;
				} else if (sum > 0) {
					r--;
				} else {
					l++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		final var obj = new ThreeSum();
		System.out.println(obj.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
	}
}
