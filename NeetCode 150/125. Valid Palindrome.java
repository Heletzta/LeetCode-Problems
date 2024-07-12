// 125. Valid Palindrome

// https://leetcode.com/problems/valid-palindrome/

/*

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.


 */

class Solution {
    public boolean isPalindrome(String s) {
        //optimization -- one while loop! -- beats 99.07%
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            int ascii = (int) s.charAt(start);
            while (start < end && (ascii > 122 || (57 < ascii && 97 > ascii) || ascii < 48))        {
                start++;
                ascii = (int) s.charAt(start);
            }
            
            ascii = (int) s.charAt(end);
            while (start < end && (ascii > 122 || (57 < ascii && 97 > ascii) || ascii < 48))        {
                end--;
                ascii = (int) s.charAt(end);
            }

            if (!(s.charAt(start) == s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
        
        
        //optimization using a stringbuilder
        /*StringBuilder newS = new StringBuilder();
        
        // cleaning the word
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            int ascii = (int) s.charAt(i);
            if (!(ascii > 122 || (57 < ascii && 97 > ascii) || ascii < 48)) {
                newS.append(s.charAt(i));
            }
        }
        // use pointer from start and end and see if they are the same until the middle
        int start = 0;
        int end = newS.length() - 1;
        while (start < end) {
            if (!(newS.charAt(start) == newS.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;*/




        
    }
}