package neetcode.twopointers;

public class TrappingRainWater {

	/* Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much
	water it can trap after raining.

	Example 1:
	Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
	Output: 6
	Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this
	case, 6 units of rain water (blue section) are being trapped.

	Example 2:
	Input: height = [4,2,0,3,2,5]
	Output: 9

	Constraints:
	n == height.length
	1 <= n <= 2 * 104
	0 <= height[i] <= 105 */

	/*
	Time complexity: O(n)
	Space complexity: O(1)
	 */
	public int trap(int[] height) {
		int l = 0, r = height.length - 1, res = 0, lMax = 0, rMax = 0;
		while (l < r) {
			lMax = Math.max(lMax, height[l]);
			rMax = Math.max(rMax, height[r]);
			if (lMax < rMax) {
				if (lMax - height[l] > 0) {
					res += lMax - height[l];
				}
				l++;
			} else {
				if (rMax - height[r] > 0) {
					res += rMax - height[r];
				}
				r--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		final var obj = new TrappingRainWater();
		System.out.println(
			obj.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 })
		);
	}
}
