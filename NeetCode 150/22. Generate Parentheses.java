// 22. Generate Parentheses

// https://leetcode.com/problems/generate-parentheses/

/*

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
 */

class Solution {
    public List<String> generateParenthesis(int n) {
        // you either open more parentheses, or close the current one until you use all the parentheses
        //two cases each time, unless stack is empty or used up the number of brackets
        Stack<Integer> brackets = new Stack<>();
        
        StringBuilder start = new StringBuilder();
        return helper(n, start, brackets);
        
    }

    List<String> helper(int n, StringBuilder curr, Stack<Integer> brackets) {
        List<String> cases = new ArrayList<>();
        if (brackets.isEmpty() && n == 0) {
            return cases;
        } else if (!brackets.isEmpty() && n != 0) {
            Stack<Integer> second = (Stack<Integer>) brackets.clone();
            //first case
            StringBuilder add = new StringBuilder(curr);
            add.append("(");
            brackets.push(1);
            cases.addAll(helper(n-1, add, brackets));
            
            //second case
            add = new StringBuilder(curr);;
            add.append(")");
            second.pop(); // pop to get rid of the opened brackets
            cases.addAll(helper(n, add, second));
        } else if (!brackets.isEmpty() && n == 0) {
            while (!brackets.isEmpty()) {
                curr.append(")");
                brackets.pop();
            }
            cases.add(curr.toString());
        } else if (n != 0) {
            curr.append("(");
            brackets.push(1);
            cases.addAll(helper(n-1, curr, brackets));
        }
        return cases;
    }
}