package neetcode.arraysandhashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	/* Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following
	rules:

	Each row must contain the digits 1-9 without repetition.
	Each column must contain the digits 1-9 without repetition.
	Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
	Note:

	A Sudoku board (partially filled) could be valid but is not necessarily solvable.
	Only the filled cells need to be validated according to the mentioned rules. */

	/*
	Time complexity: O(9^2 = 81) = O(1)
	Space complexity: O(9) = O(1)
	*/
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			if (checkLine(board[i])) {
				return false;
			}
		}

		for (int i = 0; i < board.length; i++) {
			char[] col = new char[board.length];
			for (int j = 0; j < board.length; j++) {
				col[j] = board[j][i];
			}
			if (checkLine(col)) {
				return false;
			}
		}

		int r = 0;
		while (r < board.length) {
			int c = 0;
			char[][] box = new char[3][3];
			while (c < board.length) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						box[i][j] = board[r + i][c + j];
					}
				}
				if (!checkBox(box)) {
					return false;
				}
				c += 3;
			}
			r += 3;
		}
		return true;
	}

	private boolean checkBox(char[][] board) {
		final Set<Character> set = new HashSet<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] != '.') {
					if (set.contains(board[i][j])) {
						return false;
					}
					set.add(board[i][j]);
				}
			}
		}
		return true;
	}

	private boolean checkLine(char[] line) {
		final Set<Character> set = new HashSet<>();
		for (int i = 0; i < line.length; i++) {
			if (line[i] != '.') {
				if (set.contains(line[i])) {
					return true;
				}
				set.add(line[i]);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		final var obj = new ValidSudoku();
		System.out.println(
			obj.isValidSudoku(
				new char[][] {
					{ '8', '3', '.', '.', '7', '.', '.', '.', '.' },
					{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
					{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
					{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
					{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
					{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
					{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
					{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
					{ '.', '.', '.', '.', '8', '.', '.', '7', '9' },
				}
			)
		);
	}
}
