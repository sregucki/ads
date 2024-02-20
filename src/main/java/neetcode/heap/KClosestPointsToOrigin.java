package neetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

	/* Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return
	the k closest points to the origin (0, 0). The distance between two points on the X-Y plane is the Euclidean
	distance (i.e., √(x1 - x2)2 + (y1 - y2)2). You may return the answer in any order. The answer is guaranteed to be
	unique (except for the order that it is in).

	Example 1:
	Input: points = [[1,3],[-2,2]], k = 1
	Output: [[-2,2]]
	Explanation:
	The distance between (1, 3) and the origin is sqrt(10).
	The distance between (-2, 2) and the origin is sqrt(8).
	Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
	We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

	Example 2:
	Input: points = [[3,3],[5,-1],[-2,4]], k = 2
	Output: [[3,3],[-2,4]]
	Explanation: The answer [[-2,4],[3,3]] would also be accepted.

	Constraints:
	1 <= k <= points.length <= 104
	-10^4 <= xi, yi <= 10^4 */

	/*
	time complexity: O(n)
	Space complexity: O(k)
	 */
	public int[][] kClosest(int[][] points, int k) {
		final PriorityQueue<double[]> heap = new PriorityQueue<>(
			k,
			Comparator.comparingDouble(x -> -x[0])
		);
		final int[][] res = new int[k][2];
		for (int i = 0; i < points.length; i++) {
			final double currDis = eucDis(points[i][0], points[i][1]);
			if (heap.size() < k) {
				heap.offer(new double[] { currDis, i });
			} else if (heap.peek()[0] > currDis) {
				heap.poll();
				heap.offer(new double[] { currDis, i });
			}
		}
		for (int i = 0; i < k; i++) {
			res[i] = points[(int) heap.poll()[1]];
		}
		return res;
	}

	private double eucDis(int x1, int x2) {
		return Math.sqrt(Math.pow(x1, 2) + Math.pow(x2, 2));
	}

	public static void main(String[] args) {
		final var obj = new KClosestPointsToOrigin();
		System.out.println(
			Arrays.deepToString(
				obj.kClosest(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2)
			)
		);
	}
}
