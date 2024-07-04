// 2574. Left and Right Sum Differences

// https://leetcode.com/problems/left-and-right-sum-differences/

/*

Given a 0-indexed integer array nums, find a 0-indexed integer array answer where:

answer.length == nums.length.
answer[i] = |leftSum[i] - rightSum[i]|.
Where:

leftSum[i] is the sum of elements to the left of the index i in the array nums. If there is no such element, leftSum[i] = 0.
rightSum[i] is the sum of elements to the right of the index i in the array nums. If there is no such element, rightSum[i] = 0.
Return the array answer.

 

Example 1:

Input: nums = [10,4,8,3]
Output: [15,1,11,22]
Explanation: The array leftSum is [0,10,14,22] and the array rightSum is [15,11,3,0].
The array answer is [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22].
Example 2:

Input: nums = [1]
Output: [0]
Explanation: The array leftSum is [0] and the array rightSum is [0].
The array answer is [|0 - 0|] = [0].
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 105

*/

class Solution {
    public int[] leftRightDifference(int[] nums) {
        //even slower method, oofffff and uses more memory
        // beats 5.62% for runtime, and 6.99% for memory
        int[] answer = new int[nums.length];
        int[] leftSums = new int[nums.length];
        int[] rightSums = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            leftSums[i] = nums[i-1] + leftSums[i-1];
        }
        for (int j = nums.length-2; j >= 0; j--) {
            rightSums[j] = nums[j+1] + rightSums[j+1];
        }
        for (int k = 0; k < nums.length; k++) {
            answer[k] = Math.abs(leftSums[k] - rightSums[k]);
        }
        return answer;


        //brute force, beats 10.93% of people for runtime
        /*int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }
            for (int k=i+1; k < nums.length; k++) {
                rightSum += nums[k];
            }
            answer[i] = Math.abs(leftSum - rightSum);
        }

        return answer;*/
        
        
    }
}