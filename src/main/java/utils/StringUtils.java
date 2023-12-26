package utils;

import java.util.Arrays;

public class StringUtils {

	public static String charArrayToString(char[] arr) {
		final StringBuilder sb = new StringBuilder();
		for (char c : arr) {
			sb.append(c);
		}
		return sb.toString();
	}

	public static String sortString(String str) {
		final char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return charArrayToString(arr);
	}
}
