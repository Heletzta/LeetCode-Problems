// 14. Longest Common Prefix

// https://leetcode.com/problems/longest-common-prefix/

/*

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.

 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder str = new StringBuilder();
        
        
        // get min length
        int l = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < l) {
                l = strs[i].length();
            }
        }

        //Arrays.sort(strs, (a, b)->Integer.compare(a.length(), b.length()));

        //solve problem
        for (int j = 0; j < l; j++) {
            char c = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(j) != c) {
                    return str.toString();
                }
            }
            str.append(c); 
        }
        return str.toString();
    }
}