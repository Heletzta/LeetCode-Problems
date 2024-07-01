// 1365. How Many Numbers Are Smaller Than the Current Number

// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

/*

Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.

 

Example 1:

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation: 
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1). 
For nums[3]=2 there exist one smaller number than it (1). 
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
Example 2:

Input: nums = [6,5,4,8]
Output: [2,1,0,3]
Example 3:

Input: nums = [7,7,7,7]
Output: [0,0,0,0]
 

Constraints:

2 <= nums.length <= 500
0 <= nums[i] <= 100

 */

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        //My faster solution
        int[] smaller = new int[nums.length];
        int[] counts = new int[101];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }

        for (int j = 0; j < nums.length; j++) {
            int num = nums[j];
            loop: for (int k = 0; k < counts.length; k++) {
                if (k >= num) {
                    break loop;
                } else {
                    smaller[j] += counts[k];
                }
            
            }
        }
        return smaller;
        

        
        
        //My even slower solution oof
        /*TreeMap<Integer, Integer> numberToCount = new TreeMap<>();
        int[] smaller = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (numberToCount.containsKey(nums[i])) {
                numberToCount.put(nums[i], numberToCount.get(nums[i]) + 1);
            } else {
                numberToCount.put(nums[i], 1);
            }
        }

        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];
            loop: for (int key : numberToCount.keySet()) {
                if (key >= num) {
                    break loop;
                } else {
                    smaller[index] += numberToCount.get(key);
                }
            }
        }

        return smaller;*/





        //My slow solution
        /*int[] smaller = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            smaller[i] = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[j] < nums[i]) {
                    smaller[i]++;
                }
            }
        }
        return smaller;*/

        //fastest solution (https://leetcode.com/u/YTchouar/ 's solution):
        /*int[] count = new int[101];
        for(int i = 0; i < nums.length; i++)
            count[nums[i]]++;

        int sum = 0;

        //makes the sums in place
        for(int i = 0; i < 101; i++) {
            sum += count[i];
            count[i] = sum;
        } 

        //gets the greatest sum that is less than the current nums[i]
        //also does it in place to use less memory
        for(int i = 0; i < nums.length; i++)
            if(nums[i] != 0)
                nums[i] = count[nums[i] - 1];

        return nums;*/

    }
}