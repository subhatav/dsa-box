package backtracking;

// Problem Link: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
// Solution Link: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/solutions/78308/15ms-concise-java-solution/

// Approach: Depth-First-Searching with Dynamic Programming Technique
// Time Complexity: O((M * N) * log(M * N)), Space Complexity: O(M * N)

// To-Do: Shift this Class to the "graphs" package

public class LongestIncreasingPath {

    private int horizontal[] = { 0, 0, 1, -1 };
    private int vertical[] = { 1, -1, 0, 0 };

    private int rows, columns, sides = 4;

    private int[][] cache;

    public int compute(int[][] matrix) {

        rows = matrix.length;
        columns = matrix[0].length;

        cache = new int[rows][columns];

        int answer = 1; // Count in the INITIAL Cell

        for (int row = 0; row < rows; row++) {

            for (int column = 0; column < columns; column++) {

                // Find the LIP for the CURRENT Cell
                int path = find(matrix, row, column);

                // Update the Max. LIP till now
                answer = Math.max(answer, path);
            }
        }

        return answer;
    }

    private int find(int[][] matrix, int row, int column) {

        // If the LONGEST Increasing Path for the CURRENT Cell
        // is ALREADY calculated, then USE the CACHED Distance
        if (cache[row][column] != 0) return cache[row][column];

        int path = 1, current = matrix[row][column];

        // Move in ALL the POSSIBLE 4-Directions
        for (int side = 0; side < sides; side++) {

            int x = row + horizontal[side];
            int y = column + vertical[side];

            if (x < 0 || y < 0) continue;
            if (x >= rows || y >= columns) continue;

            // Skip on to the NEXT Move, WHEN the
            // PATH will grow into NOT Increasing
            if (matrix[x][y] <= current) continue;

            path = Math.max(path, 1 + find(matrix, x, y));
        }

        cache[row][column] = path; // Cache this DISTANCE

        return path;
    }
}