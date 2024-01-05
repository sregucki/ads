package neetcode.binarysearch;

public class BinarySearch {

	/* Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to
	search target in nums. If target exists, then return its index. Otherwise, return -1.
	You must write an algorithm with O(log n) runtime complexity.

	Example 1:
	Input: nums = [-1,0,3,5,9,12], target = 9
	Output: 4
	Explanation: 9 exists in nums and its index is 4

	Example 2:
	Input: nums = [-1,0,3,5,9,12], target = 2
	Output: -1
	Explanation: 2 does not exist in nums so return -1

	Constraints:
	1 <= nums.length <= 10^4
	-10^4 < nums[i], target < 10^4
	All the integers in nums are unique. nums is sorted in ascending order. */

	/*
	Time complexity: O(log(n))
	Space complexity: O(1)
	 */
	public int searchIterative(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (target < nums[mid]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

	/*
	Time complexity: O(log(n))
	Space complexity: O(log(n))
	 */
	public int searchRecursive(int[] nums, int target, int l, int r) {
		int mid = l + (r - l) / 2;
		if (nums[mid] == target) {
			return mid;
		} else if (target < nums[mid]) {
			return searchRecursive(nums, target, l, mid - 1);
		} else {
			return searchRecursive(nums, target, mid + 1, r);
		}
	}

	public static void main(String[] args) {
		final var obj = new BinarySearch();
		System.out.println(
			obj.searchIterative(new int[] { -1, 0, 3, 5, 9, 12 }, 9)
		);
		System.out.println(
			obj.searchRecursive(new int[] { -1, 0, 3, 5, 9, 12 }, 9, 0, 5)
		);
	}
}
