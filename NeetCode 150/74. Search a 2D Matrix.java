// 74. Search a 2D Matrix

// https://leetcode.com/problems/search-a-2d-matrix/

/*

You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104

 */


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] rows = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            rows[i] = matrix[i][0];
        }
        int index = findRow(rows, target);
        //System.out.println("index: " + index);
        if (index == -1) {
            return false;
        }
        if (bs(matrix[index], target) == -1) {
            return false;
        }

        return true;
    }

    public int findRow(int[] rows, int target) {
        return rowBinarySearch(rows, target);
    }

    public int bs(int[] arr, int target) {
        if (arr.length == 1) {
            if (arr[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int middle = arr[arr.length / 2];
        if (middle == target) {
            return arr.length / 2;
        }
        if (middle > target) {
            int[] left = new int[arr.length / 2];
            System.arraycopy(arr, 0, left, 0, arr.length / 2);
            int index = bs(left, target);
            if (index == -1) {
                return -1;
            } 
            return index;
        } else {
            int[] right = new int[arr.length - (arr.length / 2)];
            System.arraycopy(arr, arr.length / 2, right, 0, arr.length - (arr.length / 2));
            int index = bs(right, target);
            if (index == -1) {
                return -1;
            } 
            return arr.length / 2 + index;

        }
    }

    public int rowBinarySearch(int[] arr, int target) {
        //System.out.println("arr: " + Arrays.toString(arr));
        if (arr.length == 2) {
            if (target == arr[0]) {
                return 0;
            } else if (target == arr[1]) {
                return 1;
            } else if (arr[0] < target && target < arr[1]) {
                return 0;
            } else if (target > arr[1]) {
                return 1;
            } else {
                return -1;
            }
        }
        
        if (arr.length == 1) {
            if (target >= arr[0]) {
                return 0;
            } else {
                return -1;
            }
        }
        int middle = arr[arr.length / 2];
        if (middle == target) {
            return arr.length / 2;
        }
        if (middle > target) {
            int[] left = new int[arr.length / 2];
            System.arraycopy(arr, 0, left, 0, arr.length / 2);
            int index = rowBinarySearch(left, target);
            if (index == -1) {
                return -1;
            } 
            return index;
        } else {
            int[] right = new int[arr.length - (arr.length / 2)];
            System.arraycopy(arr, arr.length / 2, right, 0, arr.length - (arr.length / 2));
            int index = rowBinarySearch(right, target);
            if (index == -1) {
                return -1;
            } 
            return arr.length / 2 + index;

        }
    }
}