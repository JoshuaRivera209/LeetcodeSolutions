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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class validSudoku_36 {
    // Method to check the validity of the 9x9 sudoku board
    public static boolean isValidSudoku(char[][] board) {
        /*
            Since we know each row and column must contain 1 instance of 1-9, we can
            parse through each sub box and check count the frequency of every digit.
            We can use 1 hashmap for rows, and 1 for columns. We can check if the current
            value is inside the set at the current row/col. If it is, then we know that
            the sudoku is invalid and will return false.

            We know that a partially filled board might not be solvable but can be valid.
            We also know that only the *filled* cells need to be validated which seems to make the
            problem easier.

            Note: How to keep track of 3x3 sub boxes?
                - We will keep track of the 3x3 sub boxes by essentially creating a large 3x3 grid
                  out of the 9x9 matrix. Since the matrix is divisible by 3, we can use integer division
                  on the row and column to find which sub box the current cell belongs to. We will have a
                  3rd map to keep track of the sub boxes (we will call them squares for the variable).
                  We will find the row using r/3 * 3, and column using c/3. We multiply by 3 because when going
                  down, the integer is incremented by 3. So, we multiply by 3 to move down to the next box when the
                  integer division eventually increments up from 0. c/3 will add the digit to shift us to the right.
                  See visual:
                    -- 0, 1, 2
                    -- 3, 4, 5
                    -- 6, 7, 8

         */

        // Note for self:
            // i == rows
            // j == cols

        HashMap<Integer, Set<Character>> rows = new HashMap<>();
        HashMap<Integer, Set<Character>> cols = new HashMap<>();
        HashMap<Integer, Set<Character>> squares = new HashMap<>();

        // Parsing rows
        for (int r=0; r<9; r++) {
            // Parsing cols
            for (int c=0; c<9; c++) {
                char currCell = board[r][c];
                if (board[r][c] == '.') {
                    continue;
                }
                // Check if current value is valid
                /*
                    We will do this by checking each hashmap for the current cell
                    in the matrix. Rows, cols, then squares.
                 */
                if (rows.getOrDefault(r, new HashSet<>()).contains(currCell) ||
                        cols.getOrDefault(c, new HashSet<>()).contains(currCell) ||
                        squares.getOrDefault((r/3) * 3 + (c/3), new HashSet<>()).contains(currCell)) {
                    return false;
                }
                // If we get to here then we know the values are valid and will add them to their sets.
                cols.computeIfAbsent(c, e -> new HashSet<>()).add(currCell);
                rows.computeIfAbsent(r, e -> new HashSet<>()).add(currCell);
                squares.computeIfAbsent((r/3) * 3 + (c/3), e -> new HashSet<>()).add(currCell);
            }
        }
        // If we have checked the entire matrix and exited then we know the sudoku is valid.
        return true;
    }

    // Main method to run program
    public static void main(String[] args) {
        char[][] test = new char[][] {
                {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                , {'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
        };

        char[][] test2 = new char[][] {
                        {'.','8','7','6','5','4','3','2','1'},
                        {'2','.','.','.','.','.','.','.','.'},
                        {'3','.','.','.','.','.','.','.','.'},
                        {'4','.','.','.','.','.','.','.','.'},
                        {'5','.','.','.','.','.','.','.','.'},
                        {'6','.','.','.','.','.','.','.','.'},
                        {'7','.','.','.','.','.','.','.','.'},
                        {'8','.','.','.','.','.','.','.','.'},
                        {'9','.','.','.','.','.','.','.','.'}
        };
        System.out.println(isValidSudoku(test2));
    }
}
