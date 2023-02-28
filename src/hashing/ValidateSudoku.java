package hashing;

import java.util.HashSet;
import java.util.Set;

// Problem Link: https://leetcode.com/problems/valid-sudoku/
// Solution Link: https://leetcode.com/problems/valid-sudoku/solutions/15450/shared-my-concise-java-code/

// Approach: Validate EACH Row + Column + Sub-box; Time Complexity: O(N^2) == O(9^2) = Constant Time

public class ValidateSudoku {

    public boolean compute(char[][] board) {

        for (int i = 0; i < 9; i++) {

            Set<Character> sqrs = new HashSet<>();

            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();

            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if (board[j][i] != '.' && !cols.add(board[j][i])) return false;

                int srow = 3 * (i / 3) + (j / 3);
                int scol = 3 * (i % 3) + (j % 3);

                if (board[srow][scol] != '.' && !sqrs.add(board[srow][scol])) return false;
            }
        }

        return true;
    }
}