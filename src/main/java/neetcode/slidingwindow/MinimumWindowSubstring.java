package neetcode.slidingwindow;

public class MinimumWindowSubstring {

	/* Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that
	every character in t (including duplicates) is included in the window. If there is no such substring, return the
	empty string "". The testcases will be generated such that the answer is unique.

	Example 1:
	Input: s = "ADOBECODEBANC", t = "ABC"
	Output: "BANC"
	Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

	Example 2:
	Input: s = "a", t = "a"
	Output: "a"
	Explanation: The entire string s is the minimum window.

	Example 3:
	Input: s = "a", t = "aa"
	Output: ""
	Explanation: Both 'a's from t must be included in the window.
	Since the largest window of s only has one 'a', return empty string.

	Constraints:
	m == s.length
	n == t.length
	1 <= m, n <= 105
	s and t consist of uppercase and lowercase English letters.


	Follow up: Could you find an algorithm that runs in O(m + n) time? */
	/*
	Time complexity: O(m + n)
	Space complexity: O(1)
	 */
	public String minWindow(String s, String t) {
		if (
			s == null ||
			t == null ||
			s.isEmpty() ||
			t.isEmpty() ||
			s.length() < t.length()
		) {
			return "";
		}
		final int[] map = new int[128];
		int l = 0, r = 0, minLen = Integer.MAX_VALUE, startIndex = 0, count =
			t.length();
		for (char c : t.toCharArray()) {
			map[c]++;
		}
		final char[] chS = s.toCharArray();
		while (r < chS.length) {
			if (map[chS[r++]]-- > 0) {
				count--;
			}
			while (count == 0) {
				if (r - l < minLen) {
					startIndex = l;
					minLen = r - l;
				}
				if (map[chS[l++]]++ == 0) {
					count++;
				}
			}
		}
		return minLen == Integer.MAX_VALUE
			? ""
			: new String(chS, startIndex, minLen);
	}

	public static void main(String[] args) {
		final var obj = new MinimumWindowSubstring();
		System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
	}
}
