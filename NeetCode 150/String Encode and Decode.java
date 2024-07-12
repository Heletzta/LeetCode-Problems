// String Encode and Decode

// https://neetcode.io/problems/string-encode-and-decode

/*

Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.

Please implement encode and decode

Example 1:

Input: ["neet","code","love","you"]

Output:["neet","code","love","you"]
Example 2:

Input: ["we","say",":","yes"]

Output: ["we","say",":","yes"]
Constraints:

0 <= strs.length < 100
0 <= strs[i].length < 200
strs[i] contains only UTF-8 characters.


 */

class Solution {

    public String encode(List<String> strs) {
        //how to know when one word ends and another word begins?
        //what if we use a special character to separate words for us?
        // pound sign 
        // works out in this case -- but assumption -- pound never shows
        // up in any words
        // delimiter could show up -- not good!
        // what if there was a way to know how many characters for in the first
        // word, second word, etc so then we know where to break them up?

        // maintain some kind of array -- for every word, have an integer
        // where can we store the list tho? Can't store a state variable
        // possible to store in the string itself????
        //why not put that number at the beginning??
        // what if the word itself has a number in it?
        //need a delimiter -- 4#neet for example
        // always expect only one delimiter, then take the right number of characters -- works no
        // matter what the word includes
        // overall time complexity -- O(n) where n is the number of characters

        // my code attempt after seeing explanation
        String encoded = "";
        for (String str : strs) {
            encoded += Integer.toString(str.length());
            encoded += "#";
            encoded += str;
        }
        System.out.println(encoded);
        return encoded;

    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            String lenStr = "";
            while(str.charAt(i) != '#') {
                lenStr += str.charAt(i);
                i++;
            }
            i++; // for the pound sign
            int len = Integer.parseInt(lenStr);
            String add = "";
            while (len != 0) {
                add += str.charAt(i);
                i++;
                len--;
            }
            decoded.add(add);
        }
        return decoded;
        

    }
}





