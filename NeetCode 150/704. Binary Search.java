// 704. Binary Search

// https://leetcode.com/problems/binary-search/

/*

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 

Constraints:

1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.

 */

class Solution {
    public int search(int[] nums, int target) {
        // implement a binary search
        // binary search: if the target is less than the middle, you go to the left half, and if it's more, you go to the right half, until you find the target
        // I'm going to implement using recursion
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int middle = nums[nums.length / 2];
        if (target == middle) {
            return nums.length / 2;
        }
        if (target < middle) {
            int[] left = new int[nums.length / 2];
            System.arraycopy(nums, 0, left, 0, nums.length / 2);
            int srch = search(left, target);
            if (srch == -1) {
                return -1;
            }
            return srch;
        } else {
            int[] right = new int[nums.length - nums.length / 2];
            System.arraycopy(nums, nums.length / 2, right, 0, nums.length - nums.length / 2);
            int srch = search(right, target);
            if (srch == -1) {
                return -1;
            }
            return (nums.length / 2) + srch;
        }
        
    }
}