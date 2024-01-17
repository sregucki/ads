package neetcode.slidingwindow;

import java.util.Arrays;

public class PermutationInString {

	/* Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise. In other words,
	return true if one of s1's permutations is the substring of s2.

	Example 1:
	Input: s1 = "ab", s2 = "eidbaooo"
	Output: true
	Explanation: s2 contains one permutation of s1 ("ba").

	Example 2:
	Input: s1 = "ab", s2 = "eidboaoo"
	Output: false

	Constraints:
	1 <= s1.length, s2.length <= 10^4
	s1 and s2 consist of lowercase English letters. */
	/*
	Time complexity: O(n)
	Space complexity: O(52)=O(1)
	 */
	public boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return false;
		}
		final int[] s1Arr = new int[26], window = new int[26];
		int l = 0, r = s1.length();
		for (int i = 0; i < s1.length(); i++) {
			s1Arr[s1.charAt(i) - 'a']++;
			window[s2.charAt(i) - 'a']++;
		}
		if (Arrays.equals(s1Arr, window)) {
			return true;
		}
		while (r < s2.length()) {
			window[s2.charAt(l++) - 'a']--;
			window[s2.charAt(r++) - 'a']++;
			if (Arrays.equals(s1Arr, window)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		final var obj = new PermutationInString();
		System.out.println(obj.checkInclusion("adc", "dcda"));
	}
}
