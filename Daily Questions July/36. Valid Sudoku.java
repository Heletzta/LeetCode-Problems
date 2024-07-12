// 36. Valid Sudoku

// https://leetcode.com/problems/valid-sudoku/

/*

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.

*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        //optimized solution
        // do it all in one for loop with 3 int double arrays
        int row[][] = new int[9][9];
        int col[][] = new int[9][9];
        int square[][] = new int[9][9];

        //go through the board once
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    // position in the row / col matrix (depending on the row / col and the value of the number)
                    // if the position is already filled with 1, then we know it's not a valid sodoku
                    // if it's still 0, then we're good
                    // - 1 because the index starts at 0, but the numbers are 1 - 9
                    int pos = Character.getNumericValue(board[i][j]) - 1;
                    // position for the square matrix is different
                    // pos is the column number, 0 through 8
                    // pos_square is the row number
                    // we can say that the row is in row major order
                    // top left, then top middle, then top right, then next left, etc
                    int pos_square = (i / 3) + (j / 3) * 3;
                    row[i][pos]++;
                    col[pos][j]++;
                    square[pos_square][pos]++;
                    if (row[i][pos] > 1 || col[pos][j] > 1 || square[pos_square][pos] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;



        //brute force
        /*Set<Character> numbers = new HashSet<>();
        // rows
        for (char[] row : board) {
            for (int i = 0; i < row.length; i++) {
                if (numbers.contains(row[i])) {
                    System.out.println(numbers.toString());
                    //System.out.println(i + " " + j + " " + board[i][j]);
                    return false;
                }
                if (row[i] != '.') {
                    numbers.add(row[i]);
                }
            }
            numbers.clear();
        }

        
        //columns
        for (int i = 0; i < 9; i++) {
            for (char[] row : board) {
                if (numbers.contains(row[i])) {
                    System.out.println(numbers.toString());
                    //System.out.println(i + " " + j + " " + board[i][j]);
                    return false;
                }
                if (row[i] != '.') {
                    numbers.add(row[i]);
                }
                
            }
            numbers.clear();
        }
        
        //3 x 3 grids
        // first -- row = 0 to 2, col = 0 to 2
        // next -- row = 0 to 2, col = 3 to 5
        // next -- row = 0 to 2, col = 6 to 8

        // next ROW -- row = 3 - 5, col = 0 to 2

        //pattern -- row increases every 3 times to the next 3
        //col increases every time, but resets every 3 times

        // row should be on the outside, and += 3 each time
        // col should be on the inside += 3 each time, reset when row +=3

        
        //omggg the runtime is dying
        for (int row = 0; row < board.length; row += 3) {
            for (int col = 0; col < board[0].length; col+=3) {
                //for each square
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        if (numbers.contains(board[i][j])) {
                            //System.out.println(numbers.toString());
                            //System.out.println(i + " " + j + " " + board[i][j]);
                            return false;
                        }
                        if (board[i][j] != '.') {
                            numbers.add(board[i][j]);
                        }
                    }
                }
                numbers.clear();
            }
        }

        return true;*/


        
    }
}