package arrays;

// LeetCode Link: https://leetcode.com/problems/rotate-image/

// Approach #1: Brute Force; Time Complexity: O(N^2), Space Complexity: O(N^2)
// Approach #2: Transpose + Reflect; Time Complexity: O(N^2), Space Complexity: O(1)
// Approach #3: Rotate 4-Cell Groups; Time Complexity: O(N^2), Space Complexity: O(1)

public class RotateMatrix {

    public void compute(int[][] matrix) {

        int length = matrix.length;

        for (int layer = 0; layer < length / 2; layer++) {

            int first = layer;
            int last = length - layer - 1;

            for (int index = first; index < last; index++) {

                int offset = index - first;

                // Save the number at Top
                int backup = matrix[first][index];

                // Shift the Left to the Top
                matrix[first][index] = matrix[last - offset][first];

                // Shift the Bottom to the Left
                matrix[last - offset][first] = matrix[last][last - offset];

                // Shift the Right to the Bottom
                matrix[last][last - offset] = matrix[index][last];

                // Shift the Top to the Right
                matrix[index][last] = backup;
            }
        }
    }
}
