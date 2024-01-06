package neetcode.binarysearch;

import java.util.Arrays;

public class KokoEatingBananas {

	/* Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone
	and will come back in h hours. Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some
	pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead
	and will not eat any more bananas during this hour. Koko likes to eat slowly but still wants to finish eating all
	the bananas before the guards return. Return the minimum integer k such that she can eat all the bananas within h
	hours.

	Example 1:
	Input: piles = [3,6,7,11], h = 8
	Output: 4

	Example 2:
	Input: piles = [30,11,23,4,20], h = 5
	Output: 30

	Example 3:
	Input: piles = [30,11,23,4,20], h = 6
	Output: 23

	Constraints:
	1 <= piles.length <= 10^4
	piles.length <= h <= 10^9
	1 <= piles[i] <= 10^9 */

	/*
	Time complexity: O(n)
	Space complexity: O(1)
	 */
	public int minEatingSpeed(int[] piles, int h) {
		final int maxPile = Arrays
			.stream(piles)
			.boxed()
			.max(Integer::compareTo)
			.orElse(0);
		int l = 1, r = maxPile;
		while (l < r) {
			int mid = l + (r - l) / 2;
			int currentH = consumeAll(piles, mid);
			if (currentH <= h) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

	private int consumeAll(int[] piles, int k) {
		int res = 0;
		for (int i = 0; i < piles.length; i++) {
			double currRes = (double) piles[i] / k;
			if (piles[i] % k == 0) {
				res += (int) currRes;
			} else {
				res += (int) currRes + 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		final var obj = new KokoEatingBananas();
		System.out.println(
			obj.minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 6)
		);
	}
}
