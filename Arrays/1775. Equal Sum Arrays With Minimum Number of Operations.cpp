// 1775. Equal Sum Arrays With Minimum Number of Operations

// https://leetcode.com/problems/equal-sum-arrays-with-minimum-number-of-operations/

/*

You are given two arrays of integers nums1 and nums2, possibly of different lengths. The values in the arrays are between 1 and 6, inclusive.

In one operation, you can change any integer's value in any of the arrays to any value between 1 and 6, inclusive.

Return the minimum number of operations required to make the sum of values in nums1 equal to the sum of values in nums2. Return -1​​​​​ if it is not possible to make the sum of the two arrays equal.

 

Example 1:

Input: nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
Output: 3
Explanation: You can make the sums of nums1 and nums2 equal with 3 operations. All indices are 0-indexed.
- Change nums2[0] to 6. nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2].
- Change nums1[5] to 1. nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2].
- Change nums1[2] to 2. nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2].
Example 2:

Input: nums1 = [1,1,1,1,1,1,1], nums2 = [6]
Output: -1
Explanation: There is no way to decrease the sum of nums1 or to increase the sum of nums2 to make them equal.
Example 3:

Input: nums1 = [6,6], nums2 = [1]
Output: 3
Explanation: You can make the sums of nums1 and nums2 equal with 3 operations. All indices are 0-indexed. 
- Change nums1[0] to 2. nums1 = [2,6], nums2 = [1].
- Change nums1[1] to 2. nums1 = [2,2], nums2 = [1].
- Change nums2[0] to 4. nums1 = [2,2], nums2 = [4].
 

Constraints:

1 <= nums1.length, nums2.length <= 105
1 <= nums1[i], nums2[i] <= 6

*/

class Solution {
public:
    int minOperations(vector<int>& nums1, vector<int>& nums2) {
        // the case where it is not possible
        if (6 * nums1.size() < nums2.size() || 6 * nums2.size() < nums1.size()) {
            return -1;
        }
        
        /*std::map<int, int> numToCount1;
        for (int i = 0; i < nums1.size(); i++) {
            if (numToCount1.count(nums1[i]) == 0) {
                numToCount1[nums1[i]] = 1;
            } else {
                numToCount1[nums1[i]] += 1;
            }
        }

        std::map<int, int> numToCount2;
        for (int i = 0; i < nums2.size(); i++) {
            if (numToCount2.count(nums2[i]) == 0) {
                numToCount2[nums2[i]] = 1;
            } else {
                numToCount2[nums2[i]] += 1;
            }
        }*/

        // the minimum count of each
        // the maximum count of each

        // find the sums of both
        
        int sum1 = reduce(nums1.begin(), nums1.end());
        int sum2 = reduce(nums2.begin(), nums2.end());

        if (sum1 == sum2) {
            return 0;
        }

        int operations = 0;

        /*if(sum1 > sum2) {
            return minOperations(nums2, nums1);
        }*/

        if (sum1 > sum2) {
            int temp = sum1;
            sum1 = sum2;
            sum2 = temp;

            vector<int> tempArr = nums1;
            nums1 = nums2;
            nums2 = tempArr;
            //nums1.swap(nums2);
        }

        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end(), greater<int>());

        /*for (auto i : nums1) {
            cout << i;
        }
        cout << endl;
        for (auto i : nums2) {
            cout << i;
        }*/
        
        
        
        
        //int maxUp = 0;
        //int maxDown = 0;

        int diff = sum2 - sum1;
        int ptr1 = 0;
        int ptr2 = 0;
        //cout << "sums: " << sum1 << " " << sum2 << endl;
        while (diff > 0) {
            if (ptr2 == nums2.size() || ptr1 < nums1.size() && (6 - nums1[ptr1]) >= (nums2[ptr2] - 1)) {
                diff -= (6 - nums1[ptr1]);
                operations++;
                ptr1++;
            } else {
                diff -= (nums2[ptr2] - 1);
                operations++;
                ptr2++;
            }            
        }

        
        return operations;


        //solution with priority queue
        /*int sum1 = reduce(nums1.begin(), nums1.end());
        int sum2 = reduce(nums2.begin(), nums2.end());

        priority_queue<int> differences;

        if (sum1 > sum2) {
            for (int i = 0; i < nums1.size(); i++) {
                differences.push(nums1[i] - 1);
            }

            for (int i = 0; i < nums2.size(); i++) {
                differences.push(6 - nums2[i]);
            }
        } else {
            for (int i = 0; i < nums2.size(); i++) {
                differences.push(nums2[i] - 1);
            }

            for (int i = 0; i < nums1.size(); i++) {
                differences.push(6 - nums1[i]);
            }
        }

        int diff = abs(sum1 - sum2);

        int operations = 0;

        while (diff > 0 && differences.size() != 0) {
            int top = differences.top();
            differences.pop();
            diff -= min(diff, top);
            operations++;
        }

        
        return operations;*/
        

        // solution 2
        //count the frequency of each element from 1 to 6 in both vectors
        
        /*std::map<int, int> numToCount1;
        for (int i = 0; i < nums1.size(); i++) {
            if (numToCount1.count(nums1[i]) == 0) {
                numToCount1[nums1[i]] = 1;
            } else {
                numToCount1[nums1[i]] += 1;
            }
        }

        std::map<int, int> numToCount2;
        for (int i = 0; i < nums2.size(); i++) {
            if (numToCount2.count(nums2[i]) == 0) {
                numToCount2[nums2[i]] = 1;
            } else {
                numToCount2[nums2[i]] += 1;
            }
        }*/

        // the one with the smaller sum will be increased and the other will be decreased

        





        
    }
};