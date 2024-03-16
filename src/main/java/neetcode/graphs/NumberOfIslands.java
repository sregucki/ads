package neetcode.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

	/*
	Time complexity: O(nm)
	Space complexity: O(nm)
	 */
	public int numIslands(char[][] grid) {
		int res = 0;
		final int ROWS = grid.length;
		final int COLS = grid[0].length;
		final boolean[][] visit = new boolean[ROWS][COLS];
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				if (grid[r][c] == '1' && !visit[r][c]) {
					bfs(r, c, grid, ROWS, COLS, visit);
					res++;
				}
			}
		}
		return res;
	}

	private void bfs(
		int r,
		int c,
		char[][] grid,
		int ROWS,
		int COLS,
		boolean[][] visit
	) {
		final Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });
		visit[r][c] = true;
		int[][] directions = new int[][] {
			{ 1, 0 },
			{ -1, 0 },
			{ 0, 1 },
			{ 0, -1 },
		};
		while (!q.isEmpty()) {
			final int[] cur = q.poll();
			for (int[] dir : directions) {
				final int x = cur[0] + dir[0];
				final int y = cur[1] + dir[1];
				if (
					x >= 0 &&
					x < ROWS &&
					y >= 0 &&
					y < COLS &&
					grid[x][y] == '1' &&
					!visit[x][y]
				) {
					q.offer(new int[] { x, y });
					visit[x][y] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		final var obj = new NumberOfIslands();
		System.out.println(
			obj.numIslands(
				new char[][] {
					{ '1', '1', '1', '1', '0' },
					{ '0', '0', '0', '0', '0' },
				}
			)
		);
	}
}
