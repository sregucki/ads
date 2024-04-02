package neetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

	/*
	Time complexity: O(n)
	Space complexity: O(n)
	 */
	public int numDecodings(String s) {
		return dfs(0, s, new HashMap<>());
	}

	private int dfs(int i, String s, Map<Integer, Integer> dp) {
		if (i == s.length()) {
			return 1;
		}
		if (dp.containsKey(i)) {
			return dp.get(i);
		}
		if (s.charAt(i) == '0') {
			return 0;
		}
		int res = 0;
		res += dfs(i + 1, s, dp);
		if (
			i < s.length() - 1 &&
			(s.charAt(i) == '1' ||
				(s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
		) {
			{
				res += dfs(i + 2, s, dp);
			}
		}
		dp.put(i, res);
		return dp.get(i);
	}

	public static void main(String[] args) {
		System.out.println(new DecodeWays().numDecodings("226"));
	}
}
