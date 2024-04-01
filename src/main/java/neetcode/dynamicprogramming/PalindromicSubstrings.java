package neetcode.dynamicprogramming;

public class PalindromicSubstrings {

	/*
	Time complexity: O(n^2)
	Space complexity: O(1)
	 */
	public int countSubstrings(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			int l = i, r = i;
			while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
				count++;
				l--;
				r++;
			}
			l = i;
			r = i + 1;
			while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
				count++;
				l--;
				r++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		final var obj = new PalindromicSubstrings();
		System.out.println(obj.countSubstrings("aaa"));
	}
}
