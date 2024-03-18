package neetcode.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

	private static final int[][] dirs = new int[][] {
		{ 1, 0 },
		{ -1, 0 },
		{ 0, 1 },
		{ 0, -1 },
	};

	/*
	Time complexity: O(n*m)
	Space complexity:O(n*m)
	 */
	public int orangesRotting(int[][] grid) {
		int time = 0, fresh = 0;
		final Queue<int[]> q = new LinkedList<>();

		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] == 2) {
					q.offer(new int[] { r, c });
				}
				if (grid[r][c] == 1) {
					fresh++;
				}
			}
		}

		while (!q.isEmpty() && fresh > 0) {
			final int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				final int[] cur = q.poll();
				for (int[] dir : dirs) {
					final int x = cur[0] + dir[0];
					final int y = cur[1] + dir[1];
					if (
						x >= 0 &&
						y >= 0 &&
						x < grid.length &&
						y < grid[0].length &&
						grid[x][y] == 1
					) {
						q.offer(new int[] { x, y });
						grid[x][y] = 2;
						fresh--;
					}
				}
			}
			time++;
		}
		return fresh == 0 ? time : -1;
	}

	public static void main(String[] args) {
		final var obj = new RottingOranges();
		System.out.println(
			obj.orangesRotting(
				new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }
			)
		);
	}
}
