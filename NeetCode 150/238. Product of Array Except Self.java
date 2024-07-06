// 238. Product of Array Except Self

// https://leetcode.com/problems/product-of-array-except-self/

/*

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)


 */


class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        // beats 8.38% of people for runtime
        // try to build prefix and suffix for each index
        int[] prefixes = new int[nums.length];
        int[] suffixes = new int[nums.length];
        int[] prodExcept = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            if(i == 1) {
                prefixes[i] = nums[0];
                suffixes[nums.length - 2] = nums[nums.length - 1];
            } else {
                prefixes[i] = prefixes[i-1] * nums[i - 1];
                suffixes[nums.length - 1 - i] = suffixes[nums.length - i] * nums[nums.length - i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prodExcept[i] = suffixes[i];
            } else if (i == nums.length - 1) {
                prodExcept[i] = prefixes[i];
            } else {
                prodExcept[i] = prefixes[i] * suffixes[i];
            }
        }
        return prodExcept;

        
        /*int totalProduct = 1;
        for (int i : nums) {
            totalProduct *= i;
        }

        int[] productExceptCurr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            productExceptCurr[i] = (int) (totalProduct *  Math.pow(nums[i], -1));
        }
        return productExceptCurr;*/
        
    }
}