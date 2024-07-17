// 150. Evaluate Reverse Polish Notation

// https://leetcode.com/problems/evaluate-reverse-polish-notation/

/*

You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.
 

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
tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].


 */

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> values = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int second = values.pop();
                int first = values.pop();
                int sum = second + first;
                values.push(sum);
            } else if (tokens[i].equals("-")) {
                int second = values.pop();
                int first = values.pop();
                int result = first - second;
                values.push(result);
            } else if (tokens[i].equals("*")) {
                int second = values.pop();
                int first = values.pop();
                int product = second * first;
                values.push(product);
            } else if (tokens[i].equals("/")) {
                int second = values.pop();
                int first = values.pop();
                int quotient = first / second;
                values.push(quotient);
            } else {
                values.push(Integer.parseInt(tokens[i]));
            }
        }
        int finish = values.pop();
        return finish;

    }
    
}