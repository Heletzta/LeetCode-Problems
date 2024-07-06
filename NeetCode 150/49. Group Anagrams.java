// 49. Group Anagrams

// https://leetcode.com/problems/group-anagrams/

/*Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> lettersToStrings = new HashMap<>();
        List<List<String>> anagrams = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char[] toList = strs[i].toCharArray();
            Arrays.sort(toList);
            String str = Arrays.toString(toList);

            if (lettersToStrings.containsKey(str)) {
                lettersToStrings.get(str).add(strs[i]);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                lettersToStrings.put(str, list);
            }
        }

        anagrams.addAll(lettersToStrings.values());
        return anagrams;




        //first unsuccessful attempt
        /*List<List<String>> anagrams = new ArrayList<>();        
        List<char[]> types = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char[] toList = strs[i].toCharArray();
            Arrays.sort(toList);
            System.out.println(Arrays.toString(toList));
            if (types.contains(toList)) {
                System.out.println("I'm here!");
                int index = types.indexOf(toList);
                anagrams.get(index).add(strs[i]);
            } else {
                types.add(toList);
                List<String> gram = new ArrayList<>();
                gram.add(strs[i]);
                anagrams.add(gram);
            }
        }

        return anagrams;*/
    }
}