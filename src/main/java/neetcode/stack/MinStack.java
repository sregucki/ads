package neetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

	/* Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
	Implement the MinStack class:

	MinStack() initializes the stack object.
	void push(int val) pushes the element val onto the stack.
	void pop() removes the element on the top of the stack.
	int top() gets the top element of the stack.
	int getMin() retrieves the minimum element in the stack.

	You must implement a solution with O(1) time complexity for each function.

	Example 1:
	Input
	["MinStack","push","push","push","getMin","pop","top","getMin"] [[],[-2],[0],[-3],[],[],[],[]]
	Output
	[null,null,null,null,-3,null,0,-2]

	Explanation
	MinStack minStack = new MinStack();
	minStack.push(-2);
	minStack.push(0);
	minStack.push(-3);
	minStack.getMin(); // return -3
	minStack.pop();
	minStack.top();    // return 0
	minStack.getMin(); // return -2


	Constraints:
	-2^31 <= val <= 2^31 - 1
	Methods pop, top and getMin operations will always be called on non-empty stacks.
	At most 3 * 10^4 calls will be made to push, pop, top, and getMin. */

	/*
	Time complexity: All operations: O(1)
	Space complexity: O(2n) = O(n)
	 */
	private final Deque<Integer> stack;
	private final Deque<Integer> minStack;

	MinStack() {
		stack = new ArrayDeque<>();
		minStack = new ArrayDeque<>();
	}

	public void push(int val) {
		stack.push(val);
		if (minStack.isEmpty() || val < minStack.peek()) {
			minStack.push(val);
		} else {
			minStack.push(minStack.peek());
		}
	}

	public void pop() {
		stack.pop();
		minStack.pop();
	}

	public int getMin() {
		return minStack.peek();
	}

	public int top() {
		return stack.peek();
	}

	public static void main(String[] args) {}
}
