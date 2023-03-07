package maths;

// Problem Link: https://www.codingninjas.com/codestudio/problems/1082146
// Solution Link: https://www.geeksforgeeks.org/modular-exponentiation-power-in-modular-arithmetic/

// Approach #1: Brute Force; Time Complexity: O(N)
// Approach #2: Modular Exponentiation; Time Complexity: O(logN)

public class ModuloExponent {

    public long compute(long num, long pow, long mod) {

        if (pow == 0) return 1;

        num = num % mod;

        if (pow % 2 == 0) return compute(num * num, pow / 2, mod);
        else return (num * compute(num, pow - 1, mod)) % mod;
    }
}