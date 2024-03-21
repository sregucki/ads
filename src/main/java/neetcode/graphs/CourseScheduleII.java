package neetcode.graphs;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleII {

	/*
	Time complexity: O(n+p)
	Space complexity: O(n)
	 */
	private int[] findOrder(int numCourses, int[][] prerequisites) {
		final int[] visited = new int[numCourses];
		final List<Integer> res = new ArrayList<>();
		final List<List<Integer>> courses = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			courses.add(new ArrayList<>());
		}
		for (int i = 0; i < prerequisites.length; i++) {
			courses.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
		for (int i = 0; i < numCourses; i++) {
			if (visited[i] == 0) {
				if (!dfs(i, visited, courses, res)) {
					return new int[] {};
				}
			}
		}
		final int[] ans = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			ans[i] = res.get(i);
		}
		return ans;
	}

	private boolean dfs(
		int course,
		int[] visited,
		List<List<Integer>> courses,
		List<Integer> res
	) {
		visited[course] = 1;
		final List<Integer> eligibleCourses = courses.get(course);
		for (int i = 0; i < eligibleCourses.size(); i++) {
			int eligibleCourse = eligibleCourses.get(i);
			if (visited[eligibleCourse] == 1) {
				return false;
			}
			if (visited[eligibleCourse] == 0) {
				if (!dfs(eligibleCourse, visited, courses, res)) {
					return false;
				}
			}
		}
		visited[course] = 2;
		res.add(course);
		return true;
	}

	private static void main(String[] args) {
		final var obj = new CourseScheduleII();
	}
}
