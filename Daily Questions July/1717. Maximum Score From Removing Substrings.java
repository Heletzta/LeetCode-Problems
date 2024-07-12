// 1717. Maximum Score From Removing Substrings

// https://leetcode.com/problems/maximum-score-from-removing-substrings/

/*

You are given a string s and two integers x and y. You can perform two types of operations any number of times.

Remove substring "ab" and gain x points.
For example, when removing "ab" from "cabxbae" it becomes "cxbae".
Remove substring "ba" and gain y points.
For example, when removing "ba" from "cabxbae" it becomes "cabxe".
Return the maximum points you can gain after applying the above operations on s.

 

Example 1:

Input: s = "cdbcbbaaabab", x = 4, y = 5
Output: 19
Explanation:
- Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
- Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
- Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
- Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
Total score = 5 + 4 + 5 + 5 = 19.
Example 2:

Input: s = "aabbaaxybbaabb", x = 5, y = 4
Output: 20
 

Constraints:

1 <= s.length <= 105
1 <= x, y <= 104
s consists of lowercase English letters.

 */

class Solution {
    //unoptimized
    int count = 0;
    public int maximumGain(String s, int x, int y) {
        
        if (x > y) {
           String n = removeABwithX(s, x);
           String next = countEasierY(n, y);
        } else {
            String next = removeBAwithY(s, y);
            String n = countEasierX(next, x);
        }
        return count;
    }


    public String removeABwithX(String s, int x) {
        Stack<Character> chars = new Stack<>();
        String removed = "";
        for (int i = 0; i < s.length(); i++) {
                if (chars.size() == 0) {
                    chars.push(s.charAt(i));
                } else if (!(chars.peek() == 'a' && s.charAt(i) == 'b')) {
                    chars.push(s.charAt(i));
                } else {
                    chars.pop();
                    count += x;
                }
        }
        while (chars.size() > 0) {
            removed = chars.pop() + removed;
        }
        System.out.println("Here: " + removed);
        return removed;
    }

    public String removeBAwithY(String s, int y) {
        Stack<Character> chars = new Stack<>();
        String removed = "";
        for (int i = 0; i < s.length(); i++) {
                if (chars.size() == 0) {
                    chars.push(s.charAt(i));
                } else if (!(chars.peek() == 'b' && s.charAt(i) == 'a')) {
                    chars.push(s.charAt(i));
                } else {
                    chars.pop();
                    count += y;
                }
        }
        while (chars.size() > 0) {
            removed = chars.pop() + removed;
        }
        System.out.println("Here: " + removed);
        return removed;
    }

    public String countEasierX(String s, int x) {
        Stack<Character> chars = new Stack<>();
        String removed = "";
        for (int i = 0; i < s.length(); i++) {
                if (chars.size() == 0) {
                    chars.push(s.charAt(i));
                } else if (!(chars.peek() == 'a' && s.charAt(i) == 'b')) {
                    chars.push(s.charAt(i));
                } else {
                    chars.pop();
                    count += x;
                }
        }
        return removed;
    }

    public String countEasierY(String s, int y) {
        Stack<Character> chars = new Stack<>();
        String removed = "";
        for (int i = 0; i < s.length(); i++) {
                if (chars.size() == 0) {
                    chars.push(s.charAt(i));
                } else if (!(chars.peek() == 'b' && s.charAt(i) == 'a')) {
                    chars.push(s.charAt(i));
                } else {
                    chars.pop();
                    count += y;
                }
        }
        return removed;
    }

}