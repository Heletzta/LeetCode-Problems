// 1636. Sort Array by Increasing Frequency

// https://leetcode.com/problems/sort-array-by-increasing-frequency/

/*

Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.

 

Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]
 

Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100

*/

class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> numToFrequency = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numToFrequency.containsKey(nums[i])) {
                numToFrequency.put(nums[i], numToFrequency.get(nums[i]) + 1);
            } else {
                numToFrequency.put(nums[i], 1);
            }
        } 

        TreeMap<Integer, ArrayList<Integer>> frequencyToNums = new TreeMap<>();
        for (int k : numToFrequency.keySet()) {
            if (frequencyToNums.containsKey(numToFrequency.get(k))) {
                frequencyToNums.get(numToFrequency.get(k)).add(k);
            } else {
                ArrayList<Integer> numsForFreq = new ArrayList<>();
                numsForFreq.add(k);
                frequencyToNums.put(numToFrequency.get(k), numsForFreq);
            }
        }

        int[] numsSorted = new int[nums.length];
        int k = 0;
        for (int freq: frequencyToNums.keySet()) {
            Collections.sort(frequencyToNums.get(freq), Collections.reverseOrder());
            for (int i : frequencyToNums.get(freq)) {
                for (int j = 0; j < freq; j++) {
                    numsSorted[k] = i;
                    k++;
                }
            }
        }
        return numsSorted;
    }
}