package neetcode.graphs;

public class MaxAreaOfIsland {

	/*
	Time complexity: O(n*m)
	Space complexity: O(n*m)
	 */
	public int maxAreaOfIsland(int[][] grid) {
		int maxArea = 0;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				maxArea = Math.max(maxArea, dfs(r, c, grid));
			}
		}
		return maxArea;
	}

	private int dfs(int r, int c, int[][] grid) {
		if (
			r < 0 ||
			c < 0 ||
			r >= grid.length ||
			c >= grid[0].length ||
			grid[r][c] == 0
		) {
			return 0;
		}

		grid[r][c] = 0;

		return (
			1 +
			dfs(r + 1, c, grid) +
			dfs(r - 1, c, grid) +
			dfs(r, c - 1, grid) +
			dfs(r, c + 1, grid)
		);
	}

	public static void main(String[] args) {
		final var obj = new MaxAreaOfIsland();
		System.out.println(
			obj.maxAreaOfIsland(
				new int[][] {
					{ 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
					{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
					{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
				}
			)
		);
	}
}
