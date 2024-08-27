// 840. Magic Squares In Grid

// https://leetcode.com/problems/magic-squares-in-grid/

/*

A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.

Given a row x col grid of integers, how many 3 x 3 contiguous magic square subgrids are there?

Note: while a magic square can only contain numbers from 1 to 9, grid may contain numbers up to 15.

 

Example 1:


Input: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]]
Output: 1
Explanation: 
The following subgrid is a 3 x 3 magic square:

while this one is not:

In total, there is only one magic square inside the given grid.
Example 2:

Input: grid = [[8]]
Output: 0
 

Constraints:

row == grid.length
col == grid[i].length
1 <= row, col <= 10
0 <= grid[i][j] <= 15

*/


class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        // brute force solution
        // go through all of the possible 3x3 subgrids
        // check each row, col, and diagonal to see if a particular grid holds the same sum
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                count += check(i, j, grid);
            }
        }
        return count;
    }

    public int check(int i, int j, int[][]grid) {
        int[] visited = new int[10];
        
        // check the rows
        HashSet<Integer> sums = new HashSet<>();
        int row = i;
        int col = j;
        int sum;
        while (row < i + 3) {
            sum = 0;
            col = j;
            while (col < j + 3) {
                sum += grid[row][col];
                if (grid[row][col] > 9 || grid[row][col] < 1) {
                    return 0;
                }
                if (visited[grid[row][col]] != 0) {
                    return 0;
                } else {
                    visited[grid[row][col]] = grid[row][col];
                }
                col++;
            }
            sums.add(sum);
            row++;
        }
        if (sums.size() > 1) {
            return 0;
        }

        // check the columns
        row = i;
        col = j;
        while (col < j + 3) {
            sum = 0;
            row = i;
            while (row < i + 3) {
                sum += grid[row][col];
                row++;
            }
            sums.add(sum);
            col++;
        }
        if (sums.size() > 1) {
            return 0;
        }
        // check the diagonals -- diagonal 1
        col = j;
        row = i;
        sum = 0;
        while (col < j + 3 && row < i + 3) {
            sum += grid[row][col];
            row++;
            col++;
        }
        sums.add(sum);
        if (sums.size() > 1) {
            return 0;
        }
        // diagonal 2;
        col = j + 2;
        row = i;
        sum = 0;
        while (col >= j && row < i + 3) {
            sum += grid[row][col];
            row++;
            col--;
        }
        sums.add(sum);
        if (sums.size() > 1) {
            return 0;
        }
        int[] check = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        if (Arrays.equals(check, visited)) {
            return 1;
        }
        return 0;

    }
}