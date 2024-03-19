package neetcode.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IslandsAndTreasure {

	private static final int[][] dirs = new int[][] {
		{ 1, 0 },
		{ -1, 0 },
		{ 0, 1 },
		{ 0, -1 },
	};

	/*
	Time complexity: O(n*m)
	Space complexity: O(n*m)
	 */
	public void islandsAndTreasure(int[][] grid) {
		int distance = 0;
		final Queue<int[]> q = new LinkedList<>();
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				grid[r][c] = grid[r][c];
				if (grid[r][c] == 0) {
					q.offer(new int[] { r, c });
				}
			}
		}
		while (!q.isEmpty()) {
			final int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				final int[] cur = q.poll();
				grid[cur[0]][cur[1]] = distance;
				for (int[] dir : dirs) {
					final int x = cur[0] + dir[0];
					final int y = cur[1] + dir[1];
					if (
						x >= 0 &&
						y >= 0 &&
						x < grid.length &&
						y < grid[0].length &&
						grid[x][y] == Integer.MAX_VALUE
					) {
						q.add(new int[] { x, y });
						grid[x][y] = -1;
					}
				}
			}
			distance++;
		}
		System.out.println(Arrays.deepToString(grid));
	}

	public static void main(String[] args) {
		final var obj = new IslandsAndTreasure();
		obj.islandsAndTreasure(
			new int[][] {
				{ 2147483647, -1, 0, 2147483647 },
				{ 2147483647, 2147483647, 2147483647, -1 },
				{ 2147483647, -1, 2147483647, -1 },
				{ 0, -1, 2147483647, 2147483647 },
			}
		);
	}
}
