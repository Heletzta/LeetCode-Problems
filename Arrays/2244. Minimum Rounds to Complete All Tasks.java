// 2244. Minimum Rounds to Complete All Tasks

// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/

/*

You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task. In each round, you can complete either 2 or 3 tasks of the same difficulty level.

Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.

 

Example 1:

Input: tasks = [2,2,3,3,2,4,4,4,4,4]
Output: 4
Explanation: To complete all the tasks, a possible plan is:
- In the first round, you complete 3 tasks of difficulty level 2. 
- In the second round, you complete 2 tasks of difficulty level 3. 
- In the third round, you complete 3 tasks of difficulty level 4. 
- In the fourth round, you complete 2 tasks of difficulty level 4.  
It can be shown that all the tasks cannot be completed in fewer than 4 rounds, so the answer is 4.
Example 2:

Input: tasks = [2,3,3]
Output: -1
Explanation: There is only 1 task of difficulty level 2, but in each round, you can only complete either 2 or 3 tasks of the same difficulty level. Hence, you cannot complete all the tasks, and the answer is -1.
 

Constraints:

1 <= tasks.length <= 105
1 <= tasks[i] <= 109
 

Note: This question is the same as 2870: Minimum Number of Operations to Make Array Empty.


 */

class Solution {
    public int minimumRounds(int[] tasks) {
        // make a map of the number to the count
        HashMap<Integer, Integer> numberToCount = new HashMap<>();
        for (int i : tasks) {
            if (numberToCount.containsKey(i)) {
                numberToCount.put(i, numberToCount.get(i) + 1);
            } else {
                numberToCount.put(i, 1);
            }
        }

        int count = 0;
        // make sure that they are all greater than one
        for (int k : numberToCount.values()) {
            if (k < 2) {
                return -1;
            }

            int rem = k % 3;
            if (rem == 0) {
                count += k / 3;
            } else {
                count += k / 3 + 1;
            }
        }

        //then divide by 3, and take the remainer to see if its one or 2, or 0.
            // if 1, then add 1 to the count (add 2 twos, take out a 3)
            // if 2,  also add 1 to the count (add a two)
            // if 0, then just add the number divided by 3
        
        return count;

    }
}