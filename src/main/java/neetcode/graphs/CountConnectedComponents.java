package neetcode.graphs;

import java.util.ArrayList;
import java.util.List;

public class CountConnectedComponents {

	/*
	Time complexity: O(v+e)
	Space complexity: O(v)
	 */
	public int countComponents(int n, int[][] edges) {
		int res = 0;
		final int[] visited = new int[n];
		final List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 0; i < edges.length; i++) {
			adjList.get(edges[i][0]).add(edges[i][1]);
		}
		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				dfs(i, visited, adjList);
				res++;
			}
		}
		return res;
	}

	private void dfs(int node, int[] visited, List<List<Integer>> adjList) {
		visited[node] = 1;
		final List<Integer> nodes = adjList.get(node);
		for (int i = 0; i < nodes.size(); i++) {
			int nextNode = nodes.get(i);
			if (visited[nextNode] == 1) {
				return;
			}
			if (visited[nextNode] == 0) {
				dfs(nextNode, visited, adjList);
			}
		}
		visited[node] = 2;
	}

	public static void main(String[] args) {
		final var obj = new CountConnectedComponents();
		System.out.println(
			obj.countComponents(
				6,
				new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 4, 5 } }
			)
		);
	}
}
