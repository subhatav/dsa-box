package searching;

import java.util.Arrays;

// Problem Link: https://leetcode.com/problems/search-a-2d-matrix/

// Approach #1: Brute Force; Time Complexity: O(M * N)
// Approach #2: Binary Search for entire Matrix; Time Complexity: O(log(M * N))
// Approach #3: Binary Search for a single Row; Time Complexity: O(M + logN)

public class SearchMatrix {

    public boolean compute(int[][] matrix, int target) {

        int capacity = matrix[0].length;

        for (int[] row : matrix) {

            if (target <= row[capacity - 1]) {

                return Arrays.binarySearch(row, target) >= 0;
            }
        }

        return false;
    }
}