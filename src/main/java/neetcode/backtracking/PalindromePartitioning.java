package neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	/*
	Time complexity: O(n*2^n)
	Space complexity: O(n)
	 */
	public List<List<String>> partition(String s) {
		final List<List<String>> res = new ArrayList<>();
		backtrack(0, s, new ArrayList<>(), res);
		return res;
	}

	private void backtrack(
		int index,
		String word,
		List<String> path,
		List<List<String>> res
	) {
		if (index == word.length()) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = index; i < word.length(); i++) {
			if (isPalindromeSimplified(word.substring(index, i + 1))) {
				path.add(word.substring(index, i + 1));
				backtrack(i + 1, word, path, res);
				path.remove(path.size() - 1);
			}
		}
	}

	private boolean isPalindromeSimplified(String word) {
		int l = 0, r = word.length() - 1;
		while (l < r) {
			if (word.charAt(r) != word.charAt(l)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}

	public static void main(String[] args) {
		final var obj = new PalindromePartitioning();
	}
}
