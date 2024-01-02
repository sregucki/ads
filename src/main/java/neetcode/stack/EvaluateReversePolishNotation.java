package neetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public class EvaluateReversePolishNotation {

	/* You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
	Evaluate the expression. Return an integer that represents the value of the expression. Note that: The valid
	operators are '+', '-', '*', and '/'. Each operand may be an integer or another expression. The division between
	two integers always truncates toward zero. There will not be any division by zero. The input represents a valid
	arithmetic expression in a reverse polish notation. The answer and all the intermediate calculations can be
	represented in a 32-bit integer.

	Example 1:
	Input: tokens = ["2","1","+","3","*"]
	Output: 9
	Explanation: ((2 + 1) * 3) = 9

	Example 2:
	Input: tokens = ["4","13","5","/","+"]
	Output: 6
	Explanation: (4 + (13 / 5)) = 6

	Example 3:
	Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
	Output: 22
	Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
		= ((10 * (6 / (12 * -11))) + 17) + 5
		= ((10 * (6 / -132)) + 17) + 5
		= ((10 * 0) + 17) + 5
		= (0 + 17) + 5
		= 17 + 5
		= 22

	Constraints:
	1 <= tokens.length <= 104
	tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200]. */
	/*
	Time complexity: O(n)
	Space complexity: O(n)
	 */
	public int evalRPN(String[] tokens) {
		final Deque<Integer> stack = new ArrayDeque<>();
		final Set<String> op = Set.of("+", "-", "/", "*");
		for (int i = 0; i < tokens.length; i++) {
			if (op.contains(tokens[i])) {
				final int a = stack.poll();
				final int b = stack.poll();
				int opRes =
					switch (tokens[i]) {
						case "+" -> a + b;
						case "-" -> b - a;
						case "*" -> a * b;
						case "/" -> b / a;
						default -> 0;
					};
				stack.push(opRes);
			} else {
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
		return stack.poll();
	}

	public static void main(String[] args) {
		final var obj = new EvaluateReversePolishNotation();
		System.out.println(
			obj.evalRPN(new String[] { "2", "1", "+", "3", "*" })
		);
		System.out.println(
			obj.evalRPN(new String[] { "4", "13", "5", "/", "+" })
		);
		System.out.println(
			obj.evalRPN(
				new String[] {
					"10",
					"6",
					"9",
					"3",
					"+",
					"-11",
					"*",
					"/",
					"*",
					"17",
					"+",
					"5",
					"+",
				}
			)
		);
	}
}
