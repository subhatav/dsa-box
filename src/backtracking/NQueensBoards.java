package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Problem Link: https://leetcode.com/problems/n-queens/
// Solution Link: https://www.youtube.com/watch?v=i05Ju7AftcM

// Approach #1: Use Backtracking with DFS Technique
// Approach #2: Optimize the SAFE Checks for Queens

// Time Complexity: O(N! * N); Space Complexity: O(N^2)

public class NQueensBoards {

    List<List<String>> boards;

    boolean[] visited, dia1, dia2;

    public List<List<String>> compute(int size) {

        boards = new ArrayList<>();

        visited = new boolean[size];

        // Both the Diagonals are HASHMAPS
        dia1 = new boolean[(2 * size) - 1];
        dia2 = new boolean[(2 * size) - 1];

        // Place the "N" Queens from the First Row
        configure(new ArrayList<>(), size, 0);

        return boards;
    }

    protected void configure(List<String> board, int size, int row) {

        // When ALL the "N" Queens are PLACED in the Board,
        // include a deep Copy of the Board to the Results
        if (row == size) boards.add(new ArrayList<>(board));

        else {

            // Loop through ALL Columns in Board
            for (int col = 0; col < size; col++) {

                // Check the CURRENT Slot
                if (safe(size, row, col)) {

                    // Place the Queen in Board
                    board.add(place(size, col));
                    set(size, row, col, true);

                    // Generate Boards with next Row
                    configure(board, size, row + 1);

                    // Remove the Queen from Board
                    board.remove(board.size() - 1);
                    set(size, row, col, false);
                }
            }
        }
    }

    private boolean safe(int size, int row, int col) {

        // Verify if Diagonals are TAKEN
        boolean inDia1 = dia1[row + col];
        boolean inDia2 = dia2[row - col + size - 1];

        // Queen has NOT visited the Current Index;
        // AND, are not placed in EITHER Diagonals
        return !visited[col] && !(inDia1 || inDia2);
    }

    private String place(int size, int queen) {

        char[] positions = new char[size];
        Arrays.fill(positions, '.');

        positions[queen] = 'Q';

        // Set the Queen [Q] in this Row
        return String.valueOf(positions);
    }

    private void set(int size, int row, int col, boolean done) {

        // Occupy the Column
        visited[col] = done;

        // Occupy the Diagonals
        dia1[row + col] = done;
        dia2[row - col + size - 1] = done;
    }
}