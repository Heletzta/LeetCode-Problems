// 350. Intersection of Two Arrays II

// https://leetcode.com/problems/intersection-of-two-arrays-ii/

/* 

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 

Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?


*/


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> nums1List = new ArrayList<>();
        List<Integer> nums2List = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            nums1List.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2List.add(nums2[i]);
        }

        List<Integer> intersection = new ArrayList<>();
        while (nums1List.size() != 0 && nums2List.size() != 0) {
            if (nums1List.contains(nums2List.get(0))) {
                intersection.add(nums2List.get(0));
                nums1List.remove(nums1List.indexOf(nums2List.get(0)));
                nums2List.remove(0);
            } else {
                nums2List.remove(0);
            }
        }
        
        int[] answerArr = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            answerArr[i] = intersection.get(i);
        }
        return answerArr;
    }
        
}