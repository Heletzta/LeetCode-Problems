// 242. Valid Anagram

// https://leetcode.com/problems/valid-anagram/

/*

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

 */


class Solution {
    public boolean isAnagram(String s, String t) {
        //faster method
        if (s.length() != t.length()) {
            return false;
        }
        /*char[] arrS = new char[s.length()];
        char[] arrT = new char[t.length()];


        for (int i = 0; i < s.length(); i++) {
            arrS[i] = s.charAt(i);
            arrT[i] = t.charAt(i);
        }*/
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();

        Arrays.sort(arrS);
        Arrays.sort(arrT);

        
        if (Arrays.equals(arrT, arrS)) {
            return true;
        } else {
            return false;
        }



        //slow solution
        /*HashMap<Character, Integer> charToCountS = new HashMap<>();
        HashMap<Character, Integer> charToCountT = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (charToCountS.containsKey(s.charAt(i))) {
                charToCountS.put(s.charAt(i), charToCountS.get(s.charAt(i)) + 1);
            } else {
                charToCountS.put(s.charAt(i), 1);
            }
            if (charToCountT.containsKey(t.charAt(i))) {
                charToCountT.put(t.charAt(i), charToCountT.get(t.charAt(i)) + 1);
            } else {
                charToCountT.put(t.charAt(i), 1);
            }
        }

        if (charToCountT.equals(charToCountS)) {
            return true;
        } else {
            return false;
        }*/
        
    }
}