package shared;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public TreeNode(int val) {
		this(val, null, null);
	}

	public static TreeNode arrayToTree(int[] array) {
		return arrayToTree(array, 0);
	}

	public static TreeNode arrayToTree(int[] array, int index) {
		if (index >= array.length) return null;
		return new TreeNode(
			array[index],
			arrayToTree(array, index * 2 + 1),
			arrayToTree(array, index * 2 + 2)
		);
	}

	@Override
	public String toString() {
		if (left != null) {
			return val + " " + left;
		}
		if (right != null) {
			return val + " " + right;
		}
		return Integer.toString(val);
	}
}
