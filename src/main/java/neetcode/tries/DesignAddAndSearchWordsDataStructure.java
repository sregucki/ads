package neetcode.tries;

public class DesignAddAndSearchWordsDataStructure {

	static class Node {

		final char val;

		final Node[] children;
		boolean isWord;

		Node(char val) {
			this.val = val;
			children = new Node[26];
			isWord = false;
		}
	}

	Node root;

	/*
	Time complexity: O(m^2), where m is the max length string
	Space complexity: O(m)
	 */
	public DesignAddAndSearchWordsDataStructure() {
		root = new Node('\0');
	}

	public void addWord(String word) {
		Node curr = root;
		for (char c : word.toCharArray()) {
			if (curr.children[c - 'a'] == null) {
				curr.children[c - 'a'] = new Node(c);
			}
			curr = curr.children[c - 'a'];
		}
		curr.isWord = true;
	}

	public boolean search(String word) {
		return helper(word, root, 0);
	}

	private boolean helper(String word, Node curr, int index) {
		for (int i = index; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c == '.') {
				for (Node child : curr.children) {
					if (child != null && helper(word, child, i + 1)) {
						return true;
					}
				}
				return false;
			}
			if (curr.children[c - 'a'] == null) {
				return false;
			}
			curr = curr.children[c - 'a'];
		}
		return curr.isWord;
	}

	public static void main(String[] args) {
		final var obj = new DesignAddAndSearchWordsDataStructure();
		obj.addWord("add");
		System.out.println(obj.search("a.."));
	}
}
