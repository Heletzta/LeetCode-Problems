// 128. Longest Consecutive Sequence

// https://leetcode.com/problems/longest-consecutive-sequence/

/*

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109

 */

class Solution {
    public int longestConsecutive(int[] nums) {
        
        //------------my original solution-------------
        
        // has O(nlog(n)) time complexity, where n is the number of unique numbers in the array nums
        // bottlenecked by sorting the arraylist -- not exactly O(n)!
        if (nums.length == 0) {
            return 0;
        }
    
        //remove duplicates -- make new set
        HashSet<Integer> unique = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            unique.add(nums[i]);
        }

        // put vals in arrayList
        ArrayList<Integer> vals = new ArrayList<>();
        for (int val : unique) {
            vals.add(val);
        }

        //sort the arraylist
        Collections.sort(vals);
        
        //find the longest consecutive sequence in the sorted arraylist
        int max = 0;
        int count = 0;
        for (int i = 1; i < vals.size(); i++) {
            if (vals.get(i) == vals.get(i - 1) + 1) {
                count++;
                if (count > max) {
                    max = count;
                }
            } 
            else {
                count = 0;
            }
        }

        return max + 1;

        // since I already have a hashset, I can do the same thing without making a new sorted array
        // ------------ Dixon_N's (https://leetcode.com/u/Dixon_N/) solution using hashset only ------------
        
        /*HashSet<Integer> unique = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            unique.add(nums[i]);
        }

        int count = 0;
        for (int k : unique) {
            if (!unique.contains(k-1)) {
                int j = k + 1;
                while (unique.contains(j)) {
                    j++;
                }
                count = Math.max(count, j-k);
            }
        }
        return count;*/

        //-------------------failed attempt -------------------
        /*if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 1;
        int maxCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1] + 1) {
                System.out.println(nums[i-1]);
                count++;
                System.out.println("Count: " + count);
                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 1;
            }
            
            
            
        }
        return maxCount;*/
        
    }
}