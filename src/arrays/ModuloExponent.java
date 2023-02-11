package arrays;

// Problem Link: https://www.codingninjas.com/codestudio/problems/modular-exponentiation_1082146
// Solution Link: https://www.geeksforgeeks.org/modular-exponentiation-power-in-modular-arithmetic/

// Approach #1: Brute Force; Time Complexity: O(N)
// Approach #2: Modular Exponentiation; Time Complexity: O(logN)

public class ModuloExponent {

    public long compute(long x, long n, long m) {

        if (n == 0) return 1; // Base Condition

        if (n % 2 == 0) return compute((x % m) * (x % m), n / 2, m);
        else return ((x % m) * compute(x % m, n - 1, m)) % m;
    }
}