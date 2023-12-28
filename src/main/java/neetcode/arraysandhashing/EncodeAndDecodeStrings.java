package neetcode.arraysandhashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

	/* Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and
	is decoded back to the original list of strings. */

	/*
	 * @param strs: a list of strings
	 * @return: encodes a list of strings to a single string.
	 */

	/*
	 * Time complexity: O(n)
	 * Space complexity: O(n*m), m is the max length of str
	 */
	public String encode(List<String> strs) {
		final StringBuilder sb = new StringBuilder();
		for (String str : strs) {
			sb.append(str.length()).append(str);
		}
		return sb.toString();
	}

	/*
	 * @param str: A string
	 * @return: decodes a single string to a list of strings
	 */

	/*
	 * Time complexity: O(n/2)=O(n)
	 * Space complexity: O(n-1)=O(n)
	 */
	public List<String> decode(String str) {
		final List<String> result = new ArrayList<>();
		int i = 0;
		while (i < str.length()) {
			int strLength = Integer.parseInt(str.substring(i, i + 1));
			result.add(str.substring(i + 1, i + 1 + strLength));
			i += 1 + strLength;
		}
		return result;
	}

	public static void main(String[] args) {
		final var obj = new EncodeAndDecodeStrings();
		System.out.println(
			obj.decode(obj.encode(List.of("we", "say", ":", "yes")))
		);
	}
}
