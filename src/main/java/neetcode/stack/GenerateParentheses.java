package neetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	/* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

	Example 1:
	Input: n = 3
	Output: ["((()))","(()())","(())()","()(())","()()()"]

	Example 2:
	Input: n = 1
	Output: ["()"]

	Constraints:
	1 <= n <= 8 */
	/*
	Time complexity: O(N*2^N)
	Space complexity: O(n)
	 */
	public List<String> generateParenthesis(int n) {
		final List<String> res = new ArrayList<>();
		dfs(n, res, 0, 0, "");
		return res;
	}

	/*
	left = number of "("
	right = number of ")"
	 */
	private void dfs(int n, List<String> res, int left, int right, String s) {
		if (s.length() == 2 * n) {
			res.add(s);
			return;
		}
		if (left < n) {
			dfs(n, res, left + 1, right, s + "(");
		}
		if (left > right) {
			dfs(n, res, left, right + 1, s + ")");
		}
	}

	public static void main(String[] args) {
		final var obj = new GenerateParentheses();
		System.out.println(obj.generateParenthesis(3));
	}
}
