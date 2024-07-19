// 739. Daily Temperatures

// https://leetcode.com/problems/daily-temperatures/

/*

Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

 

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]
 

Constraints:

1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100

 */

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // optimized attempt -- stack
        Stack<Integer> indices = new Stack<>();
        int[] days = new int[temperatures.length];
        indices.push(0);
        int i = 1;
        while (i < temperatures.length && !indices.isEmpty()) {
            while (!indices.isEmpty() && temperatures[i] > temperatures[indices.peek()]) {
                int rem = indices.pop();
                days[rem] = i  - rem;
            }
            indices.push(i); 
            i++;
            
        }
        return days;

        


        // brute force: works but is too slow
        // brute force:
        // go through each temperature and add the number of days for the normal one 
        
        /*for (int i = 0; i < temperatures.length - 1; i++) {
            int j = i + 1;
            loop: while (j < temperatures.length) {
                if (temperatures[j] > temperatures[i]) {
                    days[i] = j - i;
                    break loop;
                }
                j++;
            }
        }*/
        //return days;
    }
}