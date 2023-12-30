package neetcode.twopointers;

public class ValidPalindrome {

	/* A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
	non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and
	numbers.

	Given a string s, return true if it is a palindrome, or false otherwise.

	Example 1:
	Input: s = "A man, a plan, a canal: Panama"
	Output: true
	Explanation: "amanaplanacanalpanama" is a palindrome.

	Example 2:
	Input: s = "race a car"
	Output: false
	Explanation: "raceacar" is not a palindrome.

	Example 3:
	Input: s = " "
	Output: true
	Explanation: s is an empty string "" after removing non-alphanumeric characters.
	Since an empty string reads the same forward and backward, it is a palindrome.

	Constraints:
	1 <= s.length <= 2 * 105
	s consists only of printable ASCII characters. */

	/*
	Time complexity: O(n)
	Space complexity: O(1)
	*/
	public boolean isPalindrome(String s) {
		int l = 0, r = s.length() - 1;
		while (l < r) {
			if (!Character.isLetterOrDigit(s.charAt(l))) {
				l++;
			} else if (!Character.isLetterOrDigit(s.charAt(r))) {
				r--;
			} else {
				if (
					Character.toLowerCase(s.charAt(l)) !=
					Character.toLowerCase(s.charAt(r))
				) {
					return false;
				}
				l++;
				r--;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		final var obj = new ValidPalindrome();
		System.out.println(obj.isPalindrome("A man, a plan, a canal: Panama"));
	}
}
