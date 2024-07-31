// 912. Sort an Array

// https://leetcode.com/problems/sort-an-array/

/*Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

 

Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessairly unique.
 

Constraints:

1 <= nums.length <= 5 * 104
-5 * 104 <= nums[i] <= 5 * 104

*/


class Solution {
    public int[] sortArray(int[] nums) {
        // merge sort O(nlogn) runtime!
        // break up the array into two equal halves 
        // when you get the sorted lists back, you go through them and make a new sorted list to return
        if (nums.length == 1) {
            return nums;
        }
        //right and left arrays for sorting
        int[] left = new int[nums.length / 2];
        int[] right = new int[nums.length - nums.length / 2];
        System.arraycopy(nums, 0, left, 0, nums.length / 2);
        System.arraycopy(nums, nums.length / 2, right, 0, nums.length - nums.length / 2);
        int[] sortedLeft = sortArray(left);
        int[] sortedRight = sortArray(right);

        
        int[] sortedNums = new int[nums.length];
        //merge!
        // make a pointer for each of the arrays to follow 
        int leftP = 0;
        int rightP = 0;
        
        for (int i = 0; i < sortedNums.length; i++) {
            if (leftP >= sortedLeft.length) {
                sortedNums[i] = sortedRight[rightP];
                rightP++;
                continue;
            }
            if (rightP >= sortedRight.length) {
                sortedNums[i] = sortedLeft[leftP];
                leftP++;
                continue;
            }
            if(sortedLeft[leftP] < sortedRight[rightP]) {
                sortedNums[i] = sortedLeft[leftP];
                leftP++;
            } else {
                sortedNums[i] = sortedRight[rightP];
                rightP++;
            }
        } 
        return sortedNums;
        

    }
}