// 84. Largest Rectangle in Histogram

// https://leetcode.com/problems/largest-rectangle-in-histogram/

/*

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104

 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        // keep track of the left and right boundaries for each bar
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Stack<Integer> nums = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!nums.isEmpty() && heights[nums.peek()] >= heights[i]) {
                nums.pop();
            }
            if (nums.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = nums.peek();
            }
            nums.push(i);
        }
        nums.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!nums.isEmpty() && heights[nums.peek()] >= heights[i]) {
                nums.pop();
            }
            if (nums.isEmpty()) {
                right[i] = heights.length;
            } else {
                right[i] = nums.peek();
            }
            nums.push(i);
        }

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = right[i] - left[i] - 1; // right and left are not inclusive!
            max = Math.max(width * heights[i], max);
        }
        return max;
        
        // too slow solution :'(
        //sliding window, but window can be any size from 1 to n
        /*int max = 0;
        for (int windowSize = 1; windowSize <= heights.length; windowSize++) {
            for (int start = 0; start < heights.length - windowSize + 1; start++) {
                int min = Integer.MAX_VALUE;
                int j = start;
                //System.out.println("windowSize: " + windowSize);
                int together = j + windowSize;
                //System.out.println("j + windowSize: " + together);
                while (j < (start + windowSize)) {
                    //System.out.println(j);
                    if (heights[j] < min) {
                        min = heights[j];
                    }
                    j++;
                    //System.out.println("j + 1: " + j);
                }
                //System.out.println("nextRound");
                max = Math.max(max, min * windowSize);
            }
        }
        return max;*/
    }
}