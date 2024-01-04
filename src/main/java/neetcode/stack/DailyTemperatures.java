package neetcode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {

	/* Given an array of integers temperatures represents the daily temperatures, return an array answer such that
	answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no
	future day for which this is possible, keep answer[i] == 0 instead.

	Example 1:
	Input: temperatures = [73,74,75,71,69,72,76,73]
	Output: [1,1,4,2,1,1,0,0]

	Example 2:
	Input: temperatures = [30,40,50,60]
	Output: [1,1,1,0]

	Example 3:
	Input: temperatures = [30,60,90]
	Output: [1,1,0]

	Constraints:
	1 <= temperatures.length <= 10^5
	30 <= temperatures[i] <= 100 */
	/*
	Time complexity: O(n)
	Space complexity: O(n)
	 */
	public int[] dailyTemperatures(int[] temperatures) {
		final Deque<int[]> stack = new ArrayDeque<>();
		final int[] res = new int[temperatures.length];
		for (int i = 0; i < temperatures.length; i++) {
			if (stack.isEmpty() || stack.peek()[0] >= temperatures[i]) {
				stack.push(new int[] { temperatures[i], i });
			} else {
				while (!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
					res[stack.peek()[1]] = i - stack.peek()[1];
					stack.pop();
				}
				stack.push(new int[] { temperatures[i], i });
			}
		}
		return res;
	}

	public static void main(String[] args) {
		final var obj = new DailyTemperatures();
		System.out.println(
			Arrays.toString(
				obj.dailyTemperatures(
					new int[] { 73, 74, 75, 71, 69, 72, 76, 73 }
				)
			)
		);
	}
}
