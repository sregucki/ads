package neetcode.tries;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

	private static class Node {

		Node[] children = new Node[26];
		String word = null;
	}

	Node root;

	private Node buildPrefixTree(String[] words) {
		Node root = new Node();
		for (String word : words) {
			Node curr = root;
			for (char c : word.toCharArray()) {
				if (curr.children[c - 'a'] == null) {
					curr.children[c - 'a'] = new Node();
				}
				curr = curr.children[c - 'a'];
			}
			curr.word = word;
		}
		return root;
	}

	private void dfs(char[][] board, Node curr, Set<String> res, int r, int c) {
		if (
			r < 0 ||
			c < 0 ||
			r >= board.length ||
			c >= board[0].length ||
			board[r][c] == '#' ||
			curr.children[board[r][c] - 'a'] == null
		) {
			return;
		}

		if (curr.children[board[r][c] - 'a'].word != null) {
			res.add(curr.children[board[r][c] - 'a'].word);
		}

		curr = curr.children[board[r][c] - 'a'];
		char ch = board[r][c];
		board[r][c] = '#';

		dfs(board, curr, res, r - 1, c);
		dfs(board, curr, res, r + 1, c);
		dfs(board, curr, res, r, c - 1);
		dfs(board, curr, res, r, c + 1);
		board[r][c] = ch;
	}

	/*
	Time complexity: O(max(l*wl), m*n*l*wl), wl-number of words, l-max length of word, m,n-board lengths
	Space complexity: O(l*wl)
	 */
	public List<String> findWords(char[][] board, String[] words) {
		Node root = buildPrefixTree(words);
		Set<String> res = new HashSet<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, root, res, i, j);
			}
		}
		return new ArrayList<>(res);
	}

	public static void main(String[] args) {
		final var obj = new WordSearchII();
		final char[][] board = new char[][] {
			{ 'o', 'a', 'a', 'n' },
			{ 'e', 't', 'a', 'e' },
			{ 'i', 'h', 'k', 'r' },
			{ 'i', 'f', 'l', 'v' },
		};
		System.out.println(
			obj.findWords(board, new String[] { "oath", "pea", "eat", "rain" })
		);
	}
}
