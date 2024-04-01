package neetcode.dynamicprogramming;

public class LongestPalindromicSubstring {

	/*
	Time complexity: O(n^2)
	Space complexity: O(n)
	 */
	public String longestPalindrome(String s) {
		if (s.length() < 2) {
			return s;
		}
		String max = "";
		for (int i = 0; i < s.length(); i++) {
			int l = i, r = i;
			// odd
			while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
				max = compareAndSet(max, s.substring(l, r + 1));
				l--;
				r++;
			}
			l = i;
			r = i + 1;
			// even
			while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
				max = compareAndSet(max, s.substring(l, r + 1));
				l--;
				r++;
			}
		}
		return max;
	}

	private static String compareAndSet(String max, String s) {
		return s.length() > max.length() ? s : max;
	}

	public static void main(String[] args) {
		final var obj = new LongestPalindromicSubstring();
		System.out.println(obj.longestPalindrome("aba"));
	}
}
