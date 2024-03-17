package neetcode.graphs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

	/*
	Time complexity: O(n*m)
	Space complexity: O(n*m)
	 */
	int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		final List<List<Integer>> res = new ArrayList<>();
		boolean[][] pacific =
			new boolean[heights.length][heights[0].length], atlantic =
			new boolean[heights.length][heights[0].length];

		for (int c = 0; c < heights[0].length; c++) {
			dfs(heights, 0, c, Integer.MIN_VALUE, pacific);
			dfs(heights, heights.length - 1, c, Integer.MIN_VALUE, atlantic);
		}

		for (int r = 0; r < heights.length; r++) {
			dfs(heights, r, 0, Integer.MIN_VALUE, pacific);
			dfs(heights, r, heights[0].length - 1, Integer.MIN_VALUE, atlantic);
		}

		for (int r = 0; r < heights.length; r++) {
			for (int c = 0; c < heights[0].length; c++) {
				if (atlantic[r][c] && pacific[r][c]) {
					res.add(List.of(r, c));
				}
			}
		}
		return res;
	}

	private void dfs(
		int[][] heights,
		int r,
		int c,
		int prev,
		boolean[][] ocean
	) {
		if (
			r < 0 ||
			c < 0 ||
			r >= heights.length ||
			c >= heights[0].length ||
			ocean[r][c] ||
			heights[r][c] < prev
		) {
			return;
		}

		ocean[r][c] = true;

		for (int[] dir : dirs) {
			dfs(heights, r + dir[0], c + dir[1], heights[r][c], ocean);
		}
	}

	public static void main(String[] args) {
		final var obj = new PacificAtlanticWaterFlow();
		System.out.println(
			obj.pacificAtlantic(
				new int[][] {
					{ 1, 2, 2, 3, 5 },
					{ 3, 2, 3, 4, 4 },
					{ 2, 4, 5, 3, 1 },
					{ 6, 7, 1, 4, 5 },
					{ 5, 1, 1, 2, 4 },
				}
			)
		);
	}
}
