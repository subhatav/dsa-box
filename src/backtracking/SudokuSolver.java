package backtracking;

// Problem Link: https://leetcode.com/problems/sudoku-solver/
// Solution Link: https://takeuforward.org/data-structure/sudoku-solver/

// Approach: Use Backtracking Technique; Time Complexity: O(9^(N^2))
// Reason: Nine POSSIBLE Numbers for EACH Slot in the (N * N) Board

public class SudokuSolver {

    public boolean compute(char[][] board) {

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                // Check for the EMPTY Slots
                if (board[row][col] == '.') {

                    for (char ch = '1'; ch <= '9'; ch++) {

                        // Check if a Number is SAFE to PUT
                        if (validate(board, row, col, ch)) {

                            // Put IN the NUMBER
                            board[row][col] = ch;

                            // Do a RECURSION Call with the
                            // Number put in, to EXTEND the
                            // CURRENT Config. of the Board
                            if (compute(board)) return true;
                            // When the Future Config.
                            // is NOT valid, PUT back
                            // the CURRENT Slot to "."
                            else board[row][col] = '.';
                        }
                    }

                    return false; // BACKTRACK for NO Config.
                }
            }
        }

        return true;
    }

    private boolean validate(char[][] board, int row, int col, char ch) {

        for (int index = 0; index < 9; index++) {

            // Traverse the WHOLE Row for this NUMBER
            if (board[index][col] == ch) return false;
            // Check the WHOLE Column for this NUMBER
            if (board[row][index] == ch) return false;

            int srow = 3 * (row / 3) + (index / 3);
            int scol = 3 * (col / 3) + (index % 3);

            // Check the LOCAL SUB-BOX for the NUMBER
            if (board[srow][scol] == ch) return false;
        }

        return true; // Return WHEN this Slot is VALID
    }
}