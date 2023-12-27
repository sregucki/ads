package neetcode.arraysandhashing;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

	/* Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the
	elements of nums except nums[i].
	The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
	You must write an algorithm that runs in O(n) time and without using the division operation.

	Example 1:
	Input: nums = [1,2,3,4]
	Output: [24,12,8,6]

	Example 2:
	Input: nums = [-1,1,0,-3,3]
	Output: [0,0,9,0,0]

	Constraints:
	2 <= nums.length <= 105
	-30 <= nums[i] <= 30
	The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer. */

	/*
	Time complexity: O(n)
	Space complexity: O(2n)
	*/
	public int[] productExceptSelf(int[] nums) {
		int[] lArr = new int[nums.length], rArr = new int[nums.length], result =
			new int[nums.length];
		int l = 0, r = nums.length - 1;
		while (l < nums.length && r >= 0) {
			if (l == 0) {
				lArr[l] = 1;
			} else {
				lArr[l] = nums[l - 1] * lArr[l - 1];
			}
			if (r == nums.length - 1) {
				rArr[r] = 1;
			} else {
				rArr[r] = nums[r + 1] * rArr[r + 1];
			}
			l++;
			r--;
		}
		for (int i = 0; i < nums.length; i++) {
			result[i] = lArr[i] * rArr[i];
		}
		return result;
	}

	public static void main(String[] args) {
		final var obj = new ProductOfArrayExceptSelf();
		System.out.println(
			Arrays.toString(obj.productExceptSelf(new int[] { 1, 2, 3, 4 }))
		);
	}
}
