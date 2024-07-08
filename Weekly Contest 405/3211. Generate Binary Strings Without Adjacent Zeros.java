// 3211. Generate Binary Strings Without Adjacent Zeros

// https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros/

/*

You are given a positive integer n.

A binary string x is valid if all 
substrings
 of x of length 2 contain at least one "1".

Return all valid strings with length n, in any order.

 

Example 1:

Input: n = 3

Output: ["010","011","101","110","111"]

Explanation:

The valid strings of length 3 are: "010", "011", "101", "110", and "111".

Example 2:

Input: n = 1

Output: ["0","1"]

Explanation:

The valid strings of length 1 are: "0" and "1".

 

Constraints:

1 <= n <= 18

 */

class Solution {
    public List<String> validStrings(int n) {
        List<String> input = new ArrayList<>();
        List<String> validStrings = helper("1", n);
        validStrings.addAll(helper("0", n));
        if (n == 1) {
            validStrings.add("1");
            validStrings.add("0");
        }
        return validStrings;
        
    }

    public List<String> helper(String curr, int n) {
        List<String> newStrings = new ArrayList<>();
        if (curr.length() == n) {
            return newStrings;
        }
        if (curr.charAt(curr.length() - 1) == '1') {
            String add = curr + "1";
            String add2 = curr + "0";
            newStrings.addAll(helper(add, n));
            newStrings.addAll(helper(add2, n));
            if (add.length() == n) {
                newStrings.add(add);
                newStrings.add(add2);
            }
        } else {
            String add = curr + "1";
            newStrings.addAll(helper(add, n));
            if (add.length() == n) {
                newStrings.add(add);
            }
        }
        return newStrings;
    }
}