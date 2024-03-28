package neetcode.dynamicprogramming;

public class MinCostClimbingStairs {

	/*
	Time complexity: O(n)
	Space complexity: O(n), possibility of O(1)
	 */
	public int minCostClimbingStairs(int[] cost) {
		final int n = cost.length;
		final int[] arr = new int[n];
		arr[0] = cost[n - 1];
		arr[1] = cost[n - 2];
		for (int i = 2; i < n; i++) {
			arr[i] = Math.min(arr[i - 1], arr[i - 2]) + cost[n - i - 1];
		}
		return Math.min(arr[n - 1], arr[n - 2]);
	}

	public static void main(String[] args) {
		final var obj = new MinCostClimbingStairs();
		System.out.println(
			obj.minCostClimbingStairs(new int[] { 9, 15, 20, 13, 17, 11 })
		);
	}
}
