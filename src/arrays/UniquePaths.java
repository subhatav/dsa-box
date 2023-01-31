package arrays;

// LeetCode Link: https://leetcode.com/problems/unique-paths/

// Approach #1: Recursive Calls; Time Complexity: Exponential, Space Complexity: Exponential
// Approach #2: Dynamic Programming; Time Complexity: O(M * N), Space Complexity: O(M * N)
// Approach #3: Combinatorics; Time Complexity: O(M - 1) or O (N - 1), Space Complexity: O(1)

public class UniquePaths {

    public int compute(int m, int n) {

        /*
            int[][] dp = new int[m][n];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < n; j++) {

                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

            return dp[m - 1][n - 1];
        */

        return nCr(m + n - 2, n - 1);
    }
    
    private int nCr(int n, int r) {

        double res = 1;

        for (int i = 1; i <= r; i++) {

            res = res * (n - r + i) / i;
        }

        return (int) res;
    }
}