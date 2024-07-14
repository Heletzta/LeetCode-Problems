// 42. Trapping Rain Water

// https://leetcode.com/problems/trapping-rain-water/

/*

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105


 */

class Solution {
    public int trap(int[] height) {
        // using two pointer and making it in one loop!
        int left = 0;
        int leftMax = height[0];
        int right = height.length - 1;
        int rightMax = height[right];
        int count = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                count += leftMax - height[left];
                left++;
                leftMax = Math.max(leftMax, height[left]);
            } else {
                count += rightMax - height[right];
                right--;
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return count;
        
        // original solution
        /*int leftMax = 0;
        int rightMax = 0;
        HashMap<Integer, Integer> leftMaxes = new HashMap<>();
        HashMap<Integer, Integer> rightMaxes = new HashMap<>();
        for (int i = 1; i < height.length; i++) {
            leftMax = Math.max(leftMax, height[i-1]);
            leftMaxes.put(i-1, leftMax);
            rightMax = Math.max(rightMax, height[height.length - i]);
            rightMaxes.put(height.length - i - 1, rightMax);
        }
        //System.out.println(leftMaxes);
        //System.out.println(rightMaxes);

        int count = 0;
        for (int i = 0; i < height.length - 1; i++) {
            int currH = Math.min(leftMaxes.get(i), rightMaxes.get(i));
            if (currH - height[i] > 0) {
                count += (currH - height[i]);
            }
            
        }
        return count;*/
     }
}