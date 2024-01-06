package neetcode.binarysearch;

public class SearchA2DMatrix {

	/*	You are given an m x n integer matrix with the following two properties: Each row is sorted in non-decreasing
	order. The first integer of each row is greater than the last integer of the previous row. Given an integer target,
	return true if target is in matrix or false otherwise. You must write a solution in O(log(m * n)) time complexity.

	Example 1:
	Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
	Output: true

	Example 2:
	Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
	Output: false

	Constraints:
	m == matrix.length
	n == matrix[i].length
	1 <= m, n <= 100
	-10^4 <= matrix[i][j], target <= 10^4 */

	/*
	Time complexity: O(log(n*m))
	Space complexity: O(1)
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int t = 0, b = matrix.length - 1;
		while (t <= b) {
			int mid = t + (b - t) / 2;
			if (
				matrix[mid][0] <= target &&
				(mid + 1 > matrix.length - 1 || matrix[mid + 1][0] > target)
			) {
				return binarySearch(matrix[mid], target) != -1;
			} else if (matrix[mid][0] > target) {
				b = mid - 1;
			} else {
				t = mid + 1;
			}
		}
		return false;
	}

	private int binarySearch(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		final var obj = new SearchA2DMatrix();
		System.out.println(obj.searchMatrix(new int[][] { { 1 } }, 1));
	}
}
