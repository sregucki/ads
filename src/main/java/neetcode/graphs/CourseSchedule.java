package neetcode.graphs;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

	/*
	Time complexity: O(n+p)
	Space complexity: O(n)
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> courses = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			courses.add(new ArrayList<>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}

		int[] visited = new int[numCourses];

		for (int i = 0; i < numCourses; i++) {
			if (!dfs(i, visited, courses)) {
				return false;
			}
		}

		return true;
	}

	private boolean dfs(
		int course,
		int[] visited,
		List<List<Integer>> courses
	) {
		visited[course] = 1;
		final List<Integer> eligibleCourses = courses.get(course);
		for (int i = 0; i < eligibleCourses.size(); i++) {
			int eligibleCourse = eligibleCourses.get(i);
			if (visited[eligibleCourse] == 1) {
				return false;
			}
			if (visited[eligibleCourse] == 0) {
				if (!dfs(eligibleCourse, visited, courses)) {
					return false;
				}
			}
		}
		visited[course] = 2;
		return true;
	}

	public static void main(String[] args) {
		final var obj = new CourseSchedule();
		obj.canFinish(
			5,
			new int[][] { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 3, 4 } }
		);
	}
}
