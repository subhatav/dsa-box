package arrays;

// LeetCode Link: https://leetcode.com/problems/powx-n/
// Solution Link: https://takeuforward.org/data-structure/implement-powxn-x-raised-to-the-power-n/

// Approach #1: Brute Force; Time Complexity: O(N)
// Approach #2: Binary Exponentiation; Time Complexity: O(logN)

public class PowerOfN {

    public double compute(double x, int n) {

        long nm = n;

        if (n < 0) {

            nm = -nm;
            x = 1 / x;
        }

        return power(x, nm);
    }

    private double power(double x, long n) {

        if (n == 0) return 1;

        if (n % 2 == 0) return power(x * x, n / 2);
        else return x * power(x, n - 1);
    }
}