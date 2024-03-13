package neetcode.backtracking;

public class WordSearch {

	/*
	Time complexity: O(m*n*4^L)
	Space complexity: O(L)
	 */
	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (
					board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)
				) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, int r, int c, int start, String word) {
		if (word.length() <= start) {
			return true;
		}

		if (
			r < 0 ||
			c < 0 ||
			r >= board.length ||
			c >= board[0].length ||
			board[r][c] == '#' ||
			board[r][c] != word.charAt(start)
		) {
			return false;
		}

		char ch = board[r][c];
		board[r][c] = '#';

		if (
			dfs(board, r - 1, c, start + 1, word) ||
			dfs(board, r + 1, c, start + 1, word) ||
			dfs(board, r, c - 1, start + 1, word) ||
			dfs(board, r, c + 1, start + 1, word)
		) {
			return true;
		}

		board[r][c] = ch;

		return false;
	}

	public static void main(String[] args) {
		final var obj = new WordSearch();
		System.out.println(
			obj.exist(
				new char[][] {
					{ 'A', 'B', 'C', 'E' },
					{ 'S', 'F', 'C', 'S' },
					{ 'A', 'D', 'E', 'E' },
				},
				"ABCCED"
			)
		);
	}
}
