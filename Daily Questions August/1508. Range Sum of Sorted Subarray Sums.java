// 1508. Range Sum of Sorted Subarray Sums

// https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/

/*

You are given the array nums consisting of n positive integers. You computed the sum of all non-empty continuous subarrays from the array and then sorted them in non-decreasing order, creating a new array of n * (n + 1) / 2 numbers.

Return the sum of the numbers from index left to index right (indexed from 1), inclusive, in the new array. Since the answer can be a huge number return it modulo 109 + 7.

 

Example 1:

Input: nums = [1,2,3,4], n = 4, left = 1, right = 5
Output: 13 
Explanation: All subarray sums are 1, 3, 6, 10, 2, 5, 9, 3, 7, 4. After sorting them in non-decreasing order we have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10]. The sum of the numbers from index le = 1 to ri = 5 is 1 + 2 + 3 + 3 + 4 = 13. 
Example 2:

Input: nums = [1,2,3,4], n = 4, left = 3, right = 4
Output: 6
Explanation: The given array is the same as example 1. We have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10]. The sum of the numbers from index le = 3 to ri = 4 is 3 + 3 = 6.
Example 3:

Input: nums = [1,2,3,4], n = 4, left = 1, right = 10
Output: 50
 

Constraints:

n == nums.length
1 <= nums.length <= 1000
1 <= nums[i] <= 100
1 <= left <= right <= n * (n + 1) / 2

 */

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        // get all non-empty continuous subarrays
        // subarrays can be of length 1 to length n
        // sliding window -- for 1

        // then just add the next number until you get to the length of that subarray, and the length + the beginning index is less than n
        
        // then get sum of numbers from left to right, inclusive, indexed from 1, and return

        // REMEMBER TO USE LONGS SO THAT DATA IS STORED CORRECTLY

        // faster if you do it with an array instead of an arraylist
        int[] sums = new int[n*(n+1)/2];
        int k = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                sums[k] = sum;
                k++;
            }
        }
        //System.out.println(Arrays.toString(sums));
        Arrays.sort(sums);

        long sumFinal = 0;
        for (int i = left - 1; i < right; i++) {
            sumFinal += sums[i];
        }

        return (int) (sumFinal % (1e9 + 7));
        
        
        //ArrayList<Integer> sums = new ArrayList<>();
        // original slow way to get subarrays
        /*for (int windowSize = 1; windowSize <= n; windowSize++) {
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j < i + windowSize; j++) {
                    sum += nums[j % nums.length];
                }
                if (i + windowSize - 1 < nums.length) {
                    sums.add(sum);
                }
            }
        }*/

        //faster way to get subarrays!!
        /*for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                sums.add(sum);
            }
        }*/

        //Collections.sort(sums);
            
        /*long sumFinal = 0;
        for (int i = left - 1; i < right; i++) {
            sumFinal += sums.get(i);
        }

        return (int) (sumFinal % (Math.pow(10, 9) + 7));*/
        
        
    }
}