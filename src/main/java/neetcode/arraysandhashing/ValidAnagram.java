package neetcode.arraysandhashing;

import java.util.Arrays;

public class ValidAnagram {

	/* Given two strings s and t, return true if t is an anagram of s, and false otherwise.

	An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
	typically using all the original letters exactly once.

	Example 1:
	Input: s = "anagram", t = "nagaram"
	Output: true

	Example 2:
	Input: s = "rat", t = "car"
	Output: false

	Constraints:
	1 <= s.length, t.length <= 5 * 104
	s and t consist of lowercase English letters.*/

	public boolean isAnagram(String s, String t) {
		char[] arrS = new char[26], arrT = new char[26];
		if (s.length() != t.length()) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			arrS[s.charAt(i) - 'a']++;
			arrT[t.charAt(i) - 'a']++;
		}
		return Arrays.equals(arrS, arrT);
	}

	public static void main(String[] args) {
		final var obj = new ValidAnagram();
		System.out.println(obj.isAnagram("anagram", "nagaram"));
	}
}
