// 2134. Minimum Swaps to Group All 1's Together II

// https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/

/*
 
A swap is defined as taking two distinct positions in an array and swapping the values in them.

A circular array is defined as an array where we consider the first element and the last element to be adjacent.

Given a binary circular array nums, return the minimum number of swaps required to group all 1's present in the array together at any location.

 

Example 1:

Input: nums = [0,1,0,1,1,0,0]
Output: 1
Explanation: Here are a few of the ways to group all the 1's together:
[0,0,1,1,1,0,0] using 1 swap.
[0,1,1,1,0,0,0] using 1 swap.
[1,1,0,0,0,0,1] using 2 swaps (using the circular property of the array).
There is no way to group all 1's together with 0 swaps.
Thus, the minimum number of swaps required is 1.
Example 2:

Input: nums = [0,1,1,1,0,0,1,1,0]
Output: 2
Explanation: Here are a few of the ways to group all the 1's together:
[1,1,1,0,0,0,0,1,1] using 2 swaps (using the circular property of the array).
[1,1,1,1,1,0,0,0,0] using 2 swaps.
There is no way to group all 1's together with 0 or 1 swaps.
Thus, the minimum number of swaps required is 2.
Example 3:

Input: nums = [1,1,0,0,1]
Output: 0
Explanation: All the 1's are already grouped together due to the circular property of the array.
Thus, the minimum number of swaps required is 0.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.

 */

class Solution {
    public int minSwaps(int[] nums) {
        int numOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                numOnes++;
            }
        }

        // my faster solution

        // start with beginning window:
        int count = 0;
        for (int j = 0; j < numOnes; j++) {
            if (nums[j % nums.length] == 1) {
                count++;
            }
        }
        // then change the window by one each time and check to see if the minimum changes
        int min = numOnes - count;
        for (int i = 1; i < nums.length; i++) {
            count = count - nums[(i - 1) % nums.length] + nums[(numOnes + i - 1) % nums.length];
            min = Math.min(numOnes - count, min);
        }
        return min;


        //too slow solution
        /*int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < i + numOnes; j++) {
                if (nums[j % nums.length] == 0) {
                    count++;
                }
            }
            if (count < min) {
                min = count;
            }
        }
        return min;*/
        
        //fastest solution, works! -- from editorial
        /*int min = Integer.MAX_VALUE;
        int onesCount = nums[0];
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                onesCount -= nums[i - 1];
            }
            while (end - i + 1 < numOnes) {
                end++;
                onesCount += nums[end % nums.length];
            }
            min = Math.min(min, numOnes - onesCount);
            
        }
        return min;*/
         
    }
}