// 2006. Count Number of Pairs With Absolute Difference K

// https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/

/*

Given an integer array nums and an integer k, return the number of pairs (i, j) where i < j such that |nums[i] - nums[j]| == k.

The value of |x| is defined as:

x if x >= 0.
-x if x < 0.
 

Example 1:

Input: nums = [1,2,2,1], k = 1
Output: 4
Explanation: The pairs with an absolute difference of 1 are:
- [1,2,2,1]
- [1,2,2,1]
- [1,2,2,1]
- [1,2,2,1]
Example 2:

Input: nums = [1,3], k = 3
Output: 0
Explanation: There are no pairs with an absolute difference of 3.
Example 3:

Input: nums = [3,2,1,5,4], k = 2
Output: 3
Explanation: The pairs with an absolute difference of 2 are:
- [3,2,1,5,4]
- [3,2,1,5,4]
- [3,2,1,5,4]
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
1 <= k <= 99

 */

class Solution {
    public int countKDifference(int[] nums, int k) {
        //fast solution -- beats 100% -- from acuon account
        //usesthe fact that nums[i] < 100
        int[] arr = new int[101]; // maps number to its count
        int count = 0;
        for (int i : nums) {
            arr[i]++;
        } // ^ above is the mapping to the count
        for (int i = 0; i + k < 101; i++) {
            count += arr[i] * arr[i + k];
        } // ^ then go through all the numbers in the array and add to count the number of times that there exists a match at the number + the number it needs (because subtraction)
        return count;
        
        //fast solution with map -- 94% runtime -- from potato account
        /*HashMap<Integer,Integer> map = new HashMap<>();
        int count=0;
        for(int n: nums){
            count += map.getOrDefault(n-k, 0) + map.getOrDefault(n+k, 0);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return count;*/



        //Really slow solution with map
        /*HashMap<Integer, Integer> numToCount = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (numToCount.containsKey(nums[i])) {
                numToCount.put(nums[i], numToCount.get(nums[i]) + 1);
            } else {
                numToCount.put(nums[i], 1);
            }
        }

        ArrayList<HashSet<Integer>> done = new ArrayList<>();
        for (int num : numToCount.keySet()) {
            if (numToCount.containsKey(num + k)) {
                HashSet<Integer> tuple = new HashSet<>();
                tuple.add(num);
                tuple.add(num + k);       
                if (!done.contains(tuple)) {
                    count += numToCount.get(num) * numToCount.get(num + k);
                    done.add(tuple);
                }
            } 
            if (numToCount.containsKey(num - k)) {
                HashSet<Integer> tuple = new HashSet<>();
                tuple.clear();
                tuple.add(num);
                tuple.add(num - k);
                if (!done.contains(tuple)) {
                    count += numToCount.get(num) * numToCount.get(num - k);
                    done.add(tuple);
                }
            }
        }
        return count;*/


        //brute force solution
        /*int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && Math.abs(nums[i] - nums[j]) == k) {
                    count++;
                }
            }
        }
        return count/2;*/
        
    }
}