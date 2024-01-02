package neetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ValidParentheses {

	/* Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is
	valid.
	An input string is valid if:
	Open brackets must be closed by the same type of brackets.
	Open brackets must be closed in the correct order.
	Every close bracket has a corresponding open bracket of the same type.

	Example 1:
	Input: s = "()"
	Output: true

	Example 2:
	Input: s = "()[]{}"
	Output: true

	Example 3:
	Input: s = "(]"
	Output: false

	Constraints:
	1 <= s.length <= 104
	s consists of parentheses only '()[]{}'. */
	/*
	Time complexity: O(n)
	Space complexity: O(n)
	 */
	public boolean isValid(String s) {
		final Deque<Character> stack = new ArrayDeque<>();
		final Map<Character, Character> map = Map.ofEntries(
			Map.entry('(', ')'),
			Map.entry('{', '}'),
			Map.entry('[', ']')
		);
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				stack.push(s.charAt(i));
			} else {
				if (stack.isEmpty() || map.get(stack.pop()) != s.charAt(i)) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		final var obj = new ValidParentheses();
		System.out.println(obj.isValid("]"));
	}
}
