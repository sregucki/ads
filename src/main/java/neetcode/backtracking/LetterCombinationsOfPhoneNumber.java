package neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

	final Map<Character, String> map = Map.ofEntries(
		Map.entry('2', "abc"),
		Map.entry('3', "def"),
		Map.entry('4', "ghi"),
		Map.entry('5', "jkl"),
		Map.entry('6', "mno"),
		Map.entry('7', "pqrs"),
		Map.entry('8', "tuv"),
		Map.entry('9', "wxyz")
	);

	/*
	Time complexity: O(4^N)
	Space complexity: O(N)
	 */
	public List<String> letterCombinations(String digits) {
		if (digits.isEmpty()) {
			return new ArrayList<>();
		}
		final List<String> res = new ArrayList<>();
		backtrack(digits, 0, res, "");
		return res;
	}

	private void backtrack(
		String digits,
		int index,
		List<String> res,
		String curr
	) {
		if (curr.length() == digits.length()) {
			res.add(curr);
		} else if (index >= digits.length()) {
			return;
		} else {
			String letters = map.get(digits.charAt(index));
			for (char c : letters.toCharArray()) {
				backtrack(digits, index + 1, res, curr + c);
			}
		}
	}

	public static void main(String[] args) {
		final var obj = new LetterCombinationsOfPhoneNumber();
		System.out.println(obj.letterCombinations("23"));
	}
}
