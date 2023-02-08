package hashing;

// Problem Link: https://leetcode.com/problems/happy-number/
// Solution Link: https://leetcode.com/problems/happy-number/solutions/421162/happy-number/

// Approach #1: Hashing Technique; Time Complexity: O(logN), Space Complexity: O(N)
// Approach #2: Tortoise-Hare Technique; Time Complexity: O(logN), Space Complexity: O(1)

public class CheckHappyNumber {

    public boolean compute(int number) {

        int slow = number;
        int fast = next(number);

        // When "slow" meets "fast", then
        // a CYCLE is FOUND among the SSs
        while (fast != 1 && slow != fast) {

            slow = next(slow);
            fast = next(next(fast));
        }

        return (fast == 1);
    }

    // Method to get Square Sum
    private int next(int number) {

        int squares = 0;

        do {

            int digit = number % 10;
            squares += digit * digit;

        } while ((number /= 10) > 0);

        return squares;
    }
}