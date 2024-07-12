// 1190. Reverse Substrings Between Each Pair of Parentheses

// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/

/*

You are given a string s that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.

 

Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
 

Constraints:

1 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It is guaranteed that all parentheses are balanced.

*/

class Solution {
    public String reverseParentheses(String s) {
        //using a StringBuilder for optimization (reverse function at the bottom)
        StringBuilder result = new StringBuilder();
        // stack keeps track of opening parentheses
        Stack<Integer> openIndex = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // keep track of the start of the parentheses in the result string
                openIndex.push(result.length());
            } else if (s.charAt(i) == ')') {
                int start = openIndex.pop();
                String reverse = "";
                //create reverse string
                reverse(result, start, result.length() - 1);
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
        
        /*// solution using a stack
        String result = "";
        // stack keeps track of opening parentheses
        Stack<Integer> openIndex = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // keep track of the start of the parentheses in the result string
                openIndex.push(result.length());
            } else if (s.charAt(i) == ')') {
                int start = openIndex.pop();
                String reverse = "";
                //create reverse string
                for (int j = start; j < result.length(); j++) {
                    reverse = result.charAt(j) + reverse;
                }
                //switch out the old string with the reversed version
                result = result.substring(0, start) + reverse;
            } else {
                result += s.charAt(i);
            }
        }
        return result;*/



        // FAILED ATTEMPTS
        //second failed attempt
        /*
        // using hints: order of reversal does not matter!!
        ArrayList<Integer> open = new ArrayList<>();
        ArrayList<Integer> close = new ArrayList<>();
        
        String str = new String();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                str += s.charAt(i);
            } else if (s.charAt(i) == '('){
                open.add(i - open.size());
            } else {
                close.add(i - close.size() - open.size());
            }
        }

        //Collections.reverse(open);
        System.out.println("Begin: " + str);
        //System.out.println(open.toString());
        //System.out.println(close.toString());
        

        for (int i = 0; i < open.size(); i++) {
            String reverse = "";
            System.out.println(open.get(i));
            System.out.println(close.get(i));
            for (int j = open.get(i); j < close.get(i); j++) {
                reverse = str.charAt(j) + reverse;
            }
            System.out.println("Reverse: " + reverse);
            str = str.substring(0, open.get(i)) + reverse + str.substring(close.get(i), str.length());
            System.out.println("Str: " + str);
        }

        return str;*/
        

        //go from the outside in, since order doesn't matter.
        /*for (int i = 0; i < open.size(); i++) {
            int start = open.get(i);
            int startkeep = start;
            StringBuilder str = new StringBuilder();
            while (start != close.get(close.size() - i - 1)) {
                str.append(s.charAt(start));
                start++;
            }
            str = str.reverse();
            if (i == 0) {
                s = str.toString();
            } else {
                s = s.substring(0, startkeep) + str + s.substring(close.get(close.size() - i - 1), s.length());
            }
            System.out.println(s);
        }*/

        // return s;
        

        
        
        
        // first failed attempt
        /*Stack<Integer> brackets = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                brackets.push(i);
                System.out.println(brackets.toString());
            } else if (s.charAt(i) == ')') {
                int index = brackets.pop() + 1;
                int start = index - 1;
                System.out.println("Start: " + s.charAt(start));
                String curr = "";
                while (s.charAt(index) != ')') {
                    curr = s.charAt(index) + curr;
                    index++;
                }
                System.out.println("End: " + s.charAt(index));
                System.out.println("Curr: " + curr);
                s = s.substring(0, start) + curr + s.substring(index + 1, s.length());
                System.out.println(s);
            }
            i++;
        }
        return s;*/
        
    }

    public void reverse(StringBuilder str, int start, int end) {
            while (start < end) {
                char temp = str.charAt(start);
                str.setCharAt(start, str.charAt(end));
                str.setCharAt(end, temp);
                start++;
                end--;
            }
        }
}