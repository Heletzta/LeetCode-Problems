// 1720. Decode XORed Array

// https://leetcode.com/problems/decode-xored-array/

/*

There is a hidden integer array arr that consists of n non-negative integers.

It was encoded into another integer array encoded of length n - 1, such that encoded[i] = arr[i] XOR arr[i + 1]. For example, if arr = [1,0,2,1], then encoded = [1,2,3].

You are given the encoded array. You are also given an integer first, that is the first element of arr, i.e. arr[0].

Return the original array arr. It can be proved that the answer exists and is unique.

 

Example 1:

Input: encoded = [1,2,3], first = 1
Output: [1,0,2,1]
Explanation: If arr = [1,0,2,1], then first = 1 and encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
Example 2:

Input: encoded = [6,2,7,3], first = 4
Output: [4,2,0,7,4]
 

Constraints:

2 <= n <= 104
encoded.length == n - 1
0 <= encoded[i] <= 105
0 <= first <= 105

 */

class Solution {
    public int[] decode(int[] encoded, int first) {
        // solution beats 86.52% of people for runtime, and 6.19% for memory
        int[] arr = new int[encoded.length+1];
        arr[0] = first;
        for (int i = 1; i < arr.length; i++) {
            String bitsCurr = Integer.toString(encoded[i-1], 2);
            String bitsPrev = Integer.toString(arr[i-1], 2);
            while (bitsPrev.length() < bitsCurr.length()) {
                bitsPrev = "0" + bitsPrev;
            }
            while (bitsCurr.length() < bitsPrev.length()) {
                bitsCurr = "0" + bitsCurr;
            }
            System.out.println("First input: "  + bitsPrev);
            System.out.println("Result: " + bitsCurr);
            String newNum = "";
            for (int j =0; j < bitsCurr.length(); j++) {
                if (bitsCurr.charAt(j) == '0') {
                    newNum += bitsPrev.charAt(j);
                } else if (bitsPrev.charAt(j) == '1'){
                    newNum += "0";
                } else {
                    newNum += "1";
                }
            }
            System.out.println(newNum);
            arr[i] = Integer.parseInt(Integer.toString(Integer.parseInt(newNum, 2), 10));
        }

        return arr;
        
    }
}