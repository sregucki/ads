package neetcode.tries;

public class ImplementTriePrefixTree {

	/*
	A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys
	in a dataset of strings. There are various applications of this data structure, such as autocomplete and
	spellchecker. Implement the Trie class:

	Trie() Initializes the trie object.
	void insert(String word) Inserts the string word into the trie.
	boolean search(String word) Returns rue if the string word is in the trie (i.e., was inserted before), and false
	otherwise.
	boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix,
	and false otherwise.

	Example 1:
	Input
	["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
	[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
	Output
	[null, null, true, false, true, null, true]

	Explanation
	Trie trie = new Trie();
	trie.insert("apple");
	trie.search("apple");   // return True
	trie.search("app");     // return False
	trie.startsWith("app"); // return True
	trie.insert("app");
	trie.search("app");     // return True

	Constraints:
	1 <= word.length, prefix.length <= 2000
	word and prefix consist only of lowercase English letters.
	At most 3 * 104 calls in total will be made to insert, search, and startsWith.
	*/
	/*
	Time complexity: O(m), where m is max length string
	Space complexity: O(m)
	 */
	static class Node {

		char val;
		boolean isWord;
		Node[] children;

		Node(char val) {
			this.val = val;
			isWord = false;
			children = new Node[26];
		}
	}

	Node root;

	public ImplementTriePrefixTree() {
		root = new Node('0');
	}

	public void insert(String word) {
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
		final Node res = getLast(word);
		return res != null && res.isWord;
	}

	private Node getLast(String word) {
		Node curr = root;
		for (char c : word.toCharArray()) {
			if (curr.children[c - 'a'] == null) {
				return null;
			}
			curr = curr.children[c - 'a'];
		}
		return curr;
	}

	public boolean startsWith(String prefix) {
		return getLast(prefix) != null;
	}

	public static void main(String[] args) {
		final var obj = new ImplementTriePrefixTree();
		obj.insert("apple");
		obj.insert("ape");
		System.out.println(obj.search("appl"));
	}
}
