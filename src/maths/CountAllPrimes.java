package maths;

// Problem Link: https://leetcode.com/problems/count-primes/
// Solution Link: https://leetcode.com/problems/count-primes/solutions/57593/12-ms-java-solution-modified-from-the-hint-method-beats-99-95/comments/277117
// Complexity Link: https://leetcode.com/problems/count-primes/solutions/473021/Time-Complexity-O(log(log(n))-Explained/

// Approach: Use slightly-modified Sieve of Eratosthenes Algorithm
// Time Complexity: O(sqrt(N) * log(logN)); Space Complexity: O(N)

public class CountAllPrimes {

    public int compute(int limit) {

        // Record "true" == For ODD Composites;
        // Record "false" == For OTHER Variants
        boolean[] composites = new boolean[limit];

        // ASSUME that ALL the ODD Numbers
        // BELOW "limit" are PRIME Numbers
        int number = 3, primes = limit / 2;

        if (limit < number) return 0;

        // Do LOOP till the SQUARE Root
        while (number * number < limit) {

            // Number is NOT Visited
            if (!composites[number]) {

                // Initiate the FIRST Multiple
                int multiple = number * number;

                // LOOP by the Multiples
                // whence the ODD Number
                while (multiple < limit) {

                    // Multiple is NOT Visited
                    if (!composites[multiple]) {

                        // REMEMBER it as Composite
                        composites[multiple] = true;
                        // DECREASE Count when the
                        // ODD Number is NOT Prime
                        primes -= 1;
                    }

                    // Get NEXT Odd Multiple
                    multiple += (number * 2);
                }
            }

            number += 2; // LOOP through ODD Numbers
        }

        return primes; // Return COUNT of ALL Primes
    }
}