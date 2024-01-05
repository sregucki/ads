package neetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {

	/* Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
	return the area of the largest rectangle in the histogram.

	Example 1:
	Input: heights = [2,1,5,6,2,3]
	Output: 10
	Explanation: The above is a histogram where width of each bar is 1.
	The largest rectangle is shown in the red area, which has an area = 10 units.

	Example 2:
	Input: heights = [2,4]
	Output: 4

	Constraints:
	1 <= heights.length <= 10^5
	0 <= heights[i] <= 10^4 */

	/*
	Time complexity: O(n^2)
	Space complexity: O(1)
	 */
	public int largestRectangleAreaBruteForce(int[] heights) {
		int maxArea = 0;
		for (int i = 0; i < heights.length; i++) {
			int minHeight = heights[i];
			for (int j = i; j < heights.length; j++) {
				minHeight = Math.min(minHeight, heights[j]);
				int currArea = (j - i + 1) * minHeight;
				System.out.printf(
					"i: %d, j: %d, currArea: %d%n",
					i,
					j,
					currArea
				);
				maxArea = Math.max(currArea, maxArea);
			}
		}
		return maxArea;
	}

	/*
	Time complexity: O(n)
	Space complexity: O(n)
	 */
	public int largestRectangleArea(int[] heights) {
		final Deque<Integer> stack = new ArrayDeque<>();
		int maxArea = 0, i = 0;
		while (i < heights.length) {
			if (stack.isEmpty() || heights[i] > heights[stack.peek()]) {
				stack.push(i++);
			} else {
				int h = heights[stack.pop()];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				maxArea = Math.max(maxArea, h * w);
			}
		}
		while (!stack.isEmpty()) {
			int h = heights[stack.pop()];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			maxArea = Math.max(maxArea, h * w);
		}
		return maxArea;
	}

	public static void main(String[] args) {
		final var obj = new LargestRectangleInHistogram();
		System.out.println(
			obj.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 })
		);
	}
}
