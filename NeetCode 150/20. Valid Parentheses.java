// 20. Valid Parentheses

// https://leetcode.com/problems/valid-parentheses/

/* 

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> open = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char elem = s.charAt(i);
            if (elem == '(' || elem == '[' || elem == '{') {
                open.add(elem);
            } else if (open.isEmpty()) {
                return false;
            } else if (elem == ')') {
                if (open.peek() == '(') {
                    open.pop();
                } else {
                    return false;
                }
            } else if (elem == ']') {
                if (open.peek() == '[') {
                    open.pop();
                } else {
                    return false;
                }
            } else if (elem == '}') {
                if (open.peek() == '{') {
                    open.pop();
                } else {
                    return false;
                }
            }
        }
        if (open.isEmpty()) {
            return true;
        } else {
            return false;
        }
        

    }
}

