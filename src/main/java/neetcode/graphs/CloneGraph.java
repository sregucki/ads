package neetcode.graphs;

import java.util.HashMap;
import java.util.Map;
import shared.Node;

public class CloneGraph {

	/*
	Time complexity: O(k+v)=O(n)
	Space complexity: O(n)
	 */
	public Node cloneGraph(Node node) {
		final Map<Node, Node> oldToNew = new HashMap<>();
		return node == null ? null : dfs(node, oldToNew);
	}

	private Node dfs(Node node, Map<Node, Node> oldToNew) {
		if (oldToNew.containsKey(node)) {
			return oldToNew.get(node);
		}
		Node copy = new Node(node.val);
		oldToNew.put(node, copy);
		for (Node neighbour : node.neighbors) {
			copy.neighbors.add(dfs(neighbour, oldToNew));
		}
		return copy;
	}

	public static void main(String[] args) {
		final var obj = new CloneGraph();
	}
}
