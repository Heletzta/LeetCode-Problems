// 347. Top K Frequent Elements

// https://leetcode.com/problems/top-k-frequent-elements/

/*

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.


 */

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        //my original attempt -- beats 13.83%
        HashMap<Integer, Integer> numToFreq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numToFreq.containsKey(nums[i])) {
                numToFreq.put(nums[i], numToFreq.get(nums[i]) + 1);
            } else {
                numToFreq.put(nums[i], 1);
            }
        }

        ArrayList<ArrayList<Integer>> sorted = new ArrayList<>();
        for (int key: numToFreq.keySet()) {
            //int[] tuple = new int[]{key, numToFreq.get(key)};
            ArrayList<Integer> tuple = new ArrayList<>();
            tuple.add(key);
            tuple.add(numToFreq.get(key));
            sorted.add(tuple);
        }

        Collections.sort(sorted, new Comparator<List<Integer>>() {
    public int compare(List<Integer> o1, List<Integer> o2) {
        return o1.get(1).compareTo(o2.get(1));}});
    
    Collections.reverse(sorted);
        

        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = sorted.get(i).get(0);
        }
        return topK;

        // heap solution???
        /*if (k == nums.length) {
            return nums;
        }

        HashMap<Integer, Integer> numToFreq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numToFreq.containsKey(nums[i])) {
                numToFreq.put(nums[i], numToFreq.get(nums[i]) + 1);
            } else {
                numToFreq.put(nums[i], 1);
            }
        }*/

        //build heap of size k using N elements!
        

        
        


        
    }
}