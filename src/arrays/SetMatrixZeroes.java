package arrays;

// LeetCode Link: https://leetcode.com/problems/set-matrix-zeroes/

// All Approaches: Time Complexity: O(M * N)

// Approach #1: Brute Force; Space Complexity: O(M * N)
// Approach #2: Store the Row & Column No.(s) in 2 Sets; Space Complexity: O(M + N)
// Approach #3: Indicate the Row & Column No.(s) with the 1st Row & Column; Space Complexity: O(1)

public class SetMatrixZeroes {

    public void compute(int[][] matrix) {

        int nbRows = matrix.length, nbColumns = matrix[0].length;

        boolean firstRow = false, firstColumn = false;

        for (int row = 0; row < nbRows; row++) {

            for (int column = 0; column < nbColumns; column++) {

                if (matrix[row][column] == 0) {

                    // Indicate if the first Row and/or Column need
                    // to be set Zeroes, in two separate boolean Flags
                    if (row == 0) firstRow = true;
                    if (column == 0) firstColumn = true;

                    // Indicate which Row and Column to be set Zeroes
                    // in the first Row and first Column of the Matrix
                    matrix[row][0] = 0;
                    matrix[0][column] = 0;
                }
            }
        }

        for (int row = 1; row < nbRows; row++) {

            for (int column = 1; column < nbColumns; column++) {

                if (matrix[row][0] == 0 || matrix[0][column] == 0) {

                    // Set all the Cells as zeroes which need to be
                    // set Zeroes and are not in the first Row/Column
                    matrix[row][column] = 0;
                }
            }
        }

        if (firstRow) {
            
            for (int column = 0; column < nbColumns; column++) {

                // Set the entire first Row as Zeroes, if required so
                matrix[0][column] = 0;
            }
        }

        if (firstColumn) {

            for (int row = 0; row < nbRows; row++) {

                // Set the entire first Column as Zeroes, if required so
                matrix[row][0] = 0;
            }
        }
    }
}