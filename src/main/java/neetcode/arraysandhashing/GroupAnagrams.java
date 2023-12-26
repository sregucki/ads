package neetcode.arraysandhashing;

import java.util.*;
import utils.StringUtils;

public class GroupAnagrams {

	/* Given an array of strings strs, group the anagrams together. You can return the answer in any order.
	An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all
	the original letters exactly once.

	Example 1:
	Input: strs = ["eat","tea","tan","ate","nat","bat"]
	Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

	Example 2:
	Input: strs = [""]
	Output: [[""]]

	Example 3:
	Input: strs = ["a"]
	Output: [["a"]]

	Constraints:
	1 <= strs.length <= 104
	0 <= strs[i].length <= 100
	strs[i] consists of lowercase English letters. */

	/*
	Time complexity: O(n*m*log(m)), where m is the max length of str
	Space complexity: O(n*m)
	*/
	List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char[] currCharArr = strs[i].toCharArray();
			Arrays.sort(currCharArr);
			final String currStr = StringUtils.charArrayToString(currCharArr);
			if (map.containsKey(currStr)) {
				final List<String> tmp = map.get(currStr);
				tmp.add(strs[i]);
				map.replace(currStr, tmp);
			} else {
				map.put(currStr, new ArrayList<>(List.of(strs[i])));
			}
		}
		return map.values().stream().toList();
	}

	public static void main(String[] args) {
		final var obj = new GroupAnagrams();
		System.out.println(
			obj.groupAnagrams(
				new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }
			)
		);
	}
}
