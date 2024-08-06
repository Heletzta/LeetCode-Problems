// 3016. Minimum Number of Pushes to Type Word II

// https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/

/*

You are given a string word containing lowercase English letters.

Telephone keypads have keys mapped with distinct collections of lowercase English letters, which can be used to form words by pushing them. For example, the key 2 is mapped with ["a","b","c"], we need to push the key one time to type "a", two times to type "b", and three times to type "c" .

It is allowed to remap the keys numbered 2 to 9 to distinct collections of letters. The keys can be remapped to any amount of letters, but each letter must be mapped to exactly one key. You need to find the minimum number of times the keys will be pushed to type the string word.

Return the minimum number of pushes needed to type word after remapping the keys.

An example mapping of letters to keys on a telephone keypad is given below. Note that 1, *, #, and 0 do not map to any letters.


 

Example 1:


Input: word = "abcde"
Output: 5
Explanation: The remapped keypad given in the image provides the minimum cost.
"a" -> one push on key 2
"b" -> one push on key 3
"c" -> one push on key 4
"d" -> one push on key 5
"e" -> one push on key 6
Total cost is 1 + 1 + 1 + 1 + 1 = 5.
It can be shown that no other mapping can provide a lower cost.
Example 2:


Input: word = "xyzxyzxyzxyz"
Output: 12
Explanation: The remapped keypad given in the image provides the minimum cost.
"x" -> one push on key 2
"y" -> one push on key 3
"z" -> one push on key 4
Total cost is 1 * 4 + 1 * 4 + 1 * 4 = 12
It can be shown that no other mapping can provide a lower cost.
Note that the key 9 is not mapped to any letter: it is not necessary to map letters to every key, but to map all the letters.
Example 3:


Input: word = "aabbccddeeffgghhiiiiii"
Output: 24
Explanation: The remapped keypad given in the image provides the minimum cost.
"a" -> one push on key 2
"b" -> one push on key 3
"c" -> one push on key 4
"d" -> one push on key 5
"e" -> one push on key 6
"f" -> one push on key 7
"g" -> one push on key 8
"h" -> two pushes on key 9
"i" -> one push on key 9
Total cost is 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 2 * 2 + 6 * 1 = 24.
It can be shown that no other mapping can provide a lower cost.
 

Constraints:

1 <= word.length <= 105
word consists of lowercase English letters.


 */

 class Solution {
    public int minimumPushes(String word) {
        // faster solution -- same algorithm, different data structures to make it simpler!!
        // use an array instead of a map to get the frequency of each letter!
        int[] freqToLetter = new int[26]; // we know it's 26 because lower case english letters only!
        for (int i = 0; i < word.length(); i++) {
            freqToLetter[word.charAt(i) - 'a']++;
        }

        //then you can sort by frequency!
        Integer[] sorted = new Integer[26];
        for (int i = 0; i < 26; i++) {
            sorted[i] = freqToLetter[i];
        }
        Arrays.sort(sorted, Collections.reverseOrder());
        
        int min = 0;
        for (int i = 0; i < 26; i++) {
            if (sorted[i] == 0) {
                break;
            }
            int keyPresses = (i / 8 + 1);
            min +=  keyPresses * sorted[i];
        }

        return min;

        //SLOW SOLUTION -- my original work
        //there are 9 - 2 + 1 = 8 different keys
        // know the frequency of each character

        /*Map<Character, Integer> letterToCount = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (letterToCount.containsKey(c)) {
                letterToCount.put(c, letterToCount.get(c) + 1);
            } else {
                letterToCount.put(c, 1);
            }
        }
        // sort by frequency, from greatest to smallest
        Map<Integer, ArrayList<Character>> countToLetters = new TreeMap<>(Collections.reverseOrder());
        for (char c : letterToCount.keySet()) {
            int count = letterToCount.get(c);
            if (countToLetters.containsKey(count)) {
                countToLetters.get(count).add(c);
            } else {
                ArrayList<Character> letters = new ArrayList<>();
                letters.add(c);
                countToLetters.put(letterToCount.get(c), letters);
            }
        }

        //now I have: a map of each frequency to the letters that have that frequency, from highest frequency to lowest
        // a hashset with the distinct characters in the word
        // a map of each character to its frequency

        // then there is a pattern for how many key presses you need to do to make the word
        // for the first 8, each letter counts as one press
        // for the next 8, each letter counts as 2,
        // then 3, and so on

        int num = 0;
        int min = 0;
        for (int freq : countToLetters.keySet()) {
            for (char c : countToLetters.get(freq)) {
                int keyPresses = 1 + (num / 8);
                min += keyPresses * freq;
                num++;
            }
        }

        return min;*/
        






    }
}