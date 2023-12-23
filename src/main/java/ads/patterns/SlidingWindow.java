package ads.patterns;

import java.util.Arrays;

public class SlidingWindow {

	public static int[][] fixedSize(int k, int[] array) {
		int windowSize = 0, i = 0;
		int[][] result = new int[array.length - 1][k];
		while (i + k < array.length + 1) {
			if (windowSize < k) {
				windowSize++;
				continue;
			}
			result[i] = Arrays.copyOfRange(array, i, i + k);
			i++;
		}
		return result;
	}

	public static String[] fixedSize(int k, String str) {
		int windowSize = 0, i = 0;
		String[] result = new String[str.length() - 1];
		while (i + k < str.length() + 1) {
			if (windowSize < k) {
				windowSize++;
				continue;
			}
			result[i] = str.substring(i, i + k);
			i++;
		}
		return result;
	}
}
