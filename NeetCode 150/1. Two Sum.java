// 1. Two Sum

// https://leetcode.com/problems/two-sum/

/*

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?


 */

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // one pass hash table -- beats 97.83%
        int[] arr = new int[2];
        HashMap<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numToIndex.containsKey(complement)) {
                arr[0] = numToIndex.get(complement);
                arr[1] = i;
                return arr;
            }
            numToIndex.put(nums[i], i);
        }
        return null;

        //faster solution -- beats 62.69% of people
        /*int[] arr = new int[2];
        HashMap<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numToIndex.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numToIndex.containsKey(complement) && numToIndex.get(complement) != i) {
                arr[0] = i;
                arr[1] = numToIndex.get(complement);
                return arr;
            }
        }
        return null;*/
        
        //slow solution, brute force
        /*int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;*/
        
    }
}