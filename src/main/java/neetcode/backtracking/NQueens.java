package neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {

	/*
	Time complexity: O(N*N!)
	Space complexity: O(n)
	 */
	public List<List<String>> solveNQueens(int n) {
		final Set<Integer> col = new HashSet<>();
		final Set<Integer> posDiag = new HashSet<>(); // (r+c)
		final Set<Integer> negDiag = new HashSet<>(); // (r-c)
		final List<List<String>> res = new ArrayList<>();
		final char[][] board = new char[n][n];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				board[r][c] = '.';
			}
		}
		backtrack(0, n, board, col, posDiag, negDiag, res);
		return res;
	}

	private void backtrack(
		int r,
		int n,
		char[][] board,
		Set<Integer> col,
		Set<Integer> posDiag,
		Set<Integer> negDiag,
		List<List<String>> res
	) {
		if (r == n) {
			res.add(
				new ArrayList<>(
					Arrays.stream(board).map(String::valueOf).toList()
				)
			);
			return;
		}
		for (int c = 0; c < n; c++) {
			if (
				col.contains(c) ||
				posDiag.contains(r + c) ||
				negDiag.contains(r - c)
			) {
				continue;
			}

			col.add(c);
			posDiag.add(r + c);
			negDiag.add(r - c);
			board[r][c] = 'Q';

			backtrack(r + 1, n, board, col, posDiag, negDiag, res);

			col.remove(c);
			posDiag.remove(r + c);
			negDiag.remove(r - c);
			board[r][c] = '.';
		}
	}

	public static void main(String[] args) {
		final var obj = new NQueens();
		System.out.println(obj.solveNQueens(4));
	}
}
