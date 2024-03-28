package neetcode.dynamicprogramming;

public class ClimbingStars {

	/*
	Time complexity: O(n)
	Space complexity: O(n)
	 */
	public int climbStairs(int n) {
		// bottom-up approach
		final int[] arr = new int[n + 1];
		arr[0] = 1;
		arr[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[n];
	}

	public static void main(String[] args) {
		final var obj = new ClimbingStars();
		System.out.println(obj.climbStairs(5));
	}
}
