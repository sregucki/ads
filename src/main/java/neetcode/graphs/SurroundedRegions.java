package neetcode.graphs;

public class SurroundedRegions {

	static final int[][] dirs = new int[][] {
		{ 1, 0 },
		{ -1, 0 },
		{ 0, 1 },
		{ 0, -1 },
	};

	/*
	Time complexity: O(n*m)
	Space complexity: O(n*m)
	 */
	public void solve(char[][] board) {
		for (int r = 0; r < board.length; r++) {
			dfs(r, 0, board);
			dfs(r, board[0].length - 1, board);
		}
		for (int c = 0; c < board[0].length; c++) {
			dfs(0, c, board);
			dfs(board.length - 1, c, board);
		}
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[r][c] == 'O') {
					board[r][c] = 'X';
				}
			}
		}
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[r][c] == 'T') {
					board[r][c] = 'O';
				}
			}
		}
	}

	private void dfs(int r, int c, char[][] board) {
		if (
			r < 0 ||
			c < 0 ||
			r >= board.length ||
			c >= board[0].length ||
			board[r][c] != 'O'
		) {
			return;
		}

		board[r][c] = 'T';

		for (int[] dir : dirs) {
			dfs(r + dir[0], c + dir[1], board);
		}
	}

	public static void main(String[] args) {
		final var obj = new SurroundedRegions();
		obj.solve(new char[][] { { 'O', 'O' }, { 'O', 'O' } });
	}
}
