// 15. 3Sum

// https://leetcode.com/problems/3sum/

/*

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105


 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // beats 86.05% of people!!
        // fix one number
        // call two-sum on all of the other numbers except for that one and call it on the new target. See if two-sum outputs true or false; 
        // if true, add to list as a combination
        // how to deal with repeats: sort the arrays in the total arraylist and then check before putting in the next one 
        // same index issue won't happen because fixed number will be excluded somehow..... (by index or smth) -- done
        List<List<Integer>> triples = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            ArrayList<ArrayList<Integer>> twos = twoSum(i, nums, -nums[i]);
            triples.addAll(twos);
            //System.out.println(twos);
            //triples.addAll(twos);
        }
        return triples;



        //first wrong attempt -- problem:
        // many repeat versions, and also sometimes uses the same index in the array twice, once in the pair and once for the 3rd value
        //when I fixed that, the algorithm was too slow LMAO
        //technically it works though!!!
        // brute force idea:
        // find every pair of numbers -- nums choose 2 -- (nums.length)(nums.length - 1) / 2 pairs
        // do hash table from pair to complement
        /*List<List<Integer>> total = new ArrayList<>();
        HashMap<ArrayList<Integer>, Integer> pairsToComplement = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(nums[i]);
                pair.add(nums[j]);
                pair.add(i);
                pair.add(j);
                pairsToComplement.put(pair, -nums[i]-nums[j]);
            }
        }

        System.out.println(pairsToComplement.keySet());
        
        // if the complement exists in the array, then add the pair and the complement in a 3 elem arraylist to the total arraylist
        for (ArrayList<Integer> pair : pairsToComplement.keySet()) {
            int value = pairsToComplement.get(pair);
            if (contains(nums, value, pair)) {
                ArrayList<Integer> triple = new ArrayList<>();
                triple.add(pair.get(0));
                triple.add(pair.get(1));
                triple.add(value);
                Collections.sort(triple);
                if (!total.contains(triple)) {
                    total.add(triple);
                }
            }
        }


        // return total arraylist
        return total;*/

    }

    //helper function -- sees if array contains a number
    /*public boolean contains(int[] nums, int x, ArrayList<Integer> pair) {
        for (int i = 0; i < nums.length; i++) {
            if (x == nums[i] && pair.get(2) != i && pair.get(3) != i) {
                return true;
            }
        }
        return false;
    }*/

    public ArrayList<ArrayList<Integer>> twoSum(int fixedIndex, int[] nums, int newTarget) {
        int start = fixedIndex + 1;
        int end = nums.length - 1;
        ArrayList<ArrayList<Integer>> triples = new ArrayList<>();
        while (start < end) {
            if (nums[start] + nums[end] > newTarget) {
                end--;
            } else if (nums[start] + nums[end] < newTarget) {
                start++;
            } else if (end < nums.length - 1 && start > 0 && nums[end] == nums[end + 1] && nums[start] == nums[start - 1]){
                end--;
                start++;
            } else {
                ArrayList<Integer> triple = new ArrayList<>();
                triple.add(nums[start]);
                triple.add(nums[end]);
                triple.add(nums[fixedIndex]);
                triples.add(triple);
                start++;
                end--;
            }
        }
        return triples;
        
        /*HashMap<Integer, Integer> numToIndex = new HashMap<>();
        ArrayList<ArrayList<Integer>> twos = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != fixedIndex) {
                if (numToIndex.containsKey(newTarget - nums[i])) {
                    ArrayList<Integer> two = new ArrayList<>();
                    two.add(nums[i]);
                    two.add(newTarget - nums[i]);
                    two.add(nums[fixedIndex]);
                    Collections.sort(two);
                    twos.add(two);
                }
                numToIndex.put(nums[i], i);
            }
        }
        return twos;*/
    }
}