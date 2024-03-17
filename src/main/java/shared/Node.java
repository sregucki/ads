package shared;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {

	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<>();
	}

	public Node(int val) {
		this.val = val;
		neighbors = new ArrayList<>();
	}

	public Node(int val, List<Node> neighbors) {
		this.val = val;
		this.neighbors = new ArrayList<>();
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Node node = (Node) o;
		return val == node.val && Objects.equals(neighbors, node.neighbors);
	}

	@Override
	public int hashCode() {
		return Objects.hash(val, neighbors);
	}

	public static Node findNodeByVal(int val, List<Node> nodes) {
		return nodes
			.stream()
			.filter(node -> node.val == val)
			.findFirst()
			.orElseThrow(() ->
				new IllegalArgumentException(
					"No nodes found in list for given value!"
				)
			);
	}
}
