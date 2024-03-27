package neetcode.slidingwindow;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {

	/*
	Time complexity: O(n*log(n))
	Space complexity: O(1)
	 */
	public int maxFrequency(int[] nums, int k) {
		if (nums == null || nums.length < 2) {
			return 1;
		}
		Arrays.sort(nums);
		int max = 0, sum = 0, l = 0;
		for (int r = 0; r < nums.length; r++) {
			sum += nums[r];
			while (((r - l + 1) * nums[r]) - sum > k) {
				sum -= nums[l];
				l++;
			}
			max = Math.max(max, r - l + 1);
		}

		return max;
	}

	public static void main(String[] args) {
		final var obj = new FrequencyOfTheMostFrequentElement();
		System.out.println(obj.maxFrequency(new int[] { 3, 9, 7 }, 2));
	}
}
