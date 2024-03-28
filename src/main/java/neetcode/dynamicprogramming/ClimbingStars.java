package neetcode.dynamicprogramming;

public class ClimbingStars {

	/*
	Time complexity: O(n)
	Space complexity: O(1)
	 */
	public int climbStairs(int n) {
		// bottom-up approach
		final int[] dp = new int[n + 1];
		dp[n] = 1;
		dp[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			dp[i] = dp[i + 1] + dp[i + 2];
		}
		return dp[0];
	}

	public static void main(String[] args) {
		final var obj = new ClimbingStars();
		System.out.println(obj.climbStairs(5));
	}
}
