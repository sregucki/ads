package neetcode.dynamicprogramming;

import java.util.Arrays;

public class HouseRobber {

	/*
	Time complexity: O(n)
	Space complexity: O(n)
	 */
	public int rob(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		final int[] arr = new int[nums.length];
		arr[0] = nums[nums.length - 1];
		arr[1] = nums[nums.length - 2];
		for (int i = 2; i < nums.length; i++) {
			int j = i - 2;
			while (j >= 0) {
				arr[i] = Math.max(arr[i], nums[nums.length - i - 1] + arr[j]);
				j--;
			}
		}
		return Arrays.stream(arr).max().orElse(0);
	}

	public static void main(String[] args) {
		final var obj = new HouseRobber();
		System.out.println(obj.rob(new int[] { 2, 1, 1, 2 }));
	}
}
