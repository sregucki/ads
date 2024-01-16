package neetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	/* Given a string s, find the length of the longest substring without repeating characters.
	Example 1:
	Input: s = "abcabcbb"
	Output: 3
	Explanation: The answer is "abc", with the length of 3.

	Example 2:
	Input: s = "bbbbb"
	Output: 1
	Explanation: The answer is "b", with the length of 1.

	Example 3:
	Input: s = "pwwkew"
	Output: 3
	Explanation: The answer is "wke", with the length of 3.
	Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

	Constraints:
	0 <= s.length <= 5 * 10^4
	s consists of English letters, digits, symbols and spaces. */
	/*
	Time complexity: O(n)
	Space complexity: O(n)
	 */
	public int lengthOfLongestSubstring(String s) {
		int res = 0, l = 0, r = 0;
		final Set<Character> window = new HashSet<>();
		while (r < s.length()) {
			if (!window.contains(s.charAt(r))) {
				window.add(s.charAt(r));
				res = Math.max(res, window.size());
				r++;
			} else {
				window.remove(s.charAt(l));
				l++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		final var obj = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
	}
}
