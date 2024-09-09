// 1317. Convert Integer to the Sum of Two No-Zero Integers

// https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/

/*

No-Zero integer is a positive integer that does not contain any 0 in its decimal representation.

Given an integer n, return a list of two integers [a, b] where:

a and b are No-Zero integers.
a + b = n
The test cases are generated so that there is at least one valid solution. If there are many valid solutions, you can return any of them.

 

Example 1:

Input: n = 2
Output: [1,1]
Explanation: Let a = 1 and b = 1.
Both a and b are no-zero integers, and a + b = 2 = n.
Example 2:

Input: n = 11
Output: [2,9]
Explanation: Let a = 2 and b = 9.
Both a and b are no-zero integers, and a + b = 9 = n.
Note that there are other valid answers as [8, 3] that can be accepted.
 

Constraints:

2 <= n <= 104

 */

class Solution {
public:
    vector<int> getNoZeroIntegers(int n) {
        vector<int> arr;
        int one = 1;
        int two = n - one;
        string oneStr = to_string(one);
        string twoStr = to_string(two);
        while (true) {
            
            if (oneStr.find("0") == string::npos && twoStr.find("0") == string::npos) {
                arr.insert(arr.end(), one);
                arr.insert(arr.end(), two);
                return arr;
            } else {
                one++;
                two--;
                oneStr = to_string(one);
                twoStr = to_string(two);
            }
        }
        return arr;
        

    }
};