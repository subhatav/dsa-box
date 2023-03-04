package maths;

// Approach Link: https://www.geeksforgeeks.org/subtract-two-numbers-without-using-arithmetic-operators/

// Time & Auxiliary Space Complexity: O(logY), when doing [X - Y]

public class RecursiveSubtract {

    public long compute(long minuend, long subtrahend) {

        if (subtrahend == 0) return minuend;

        long carry = ~minuend & subtrahend;

        return compute(minuend ^ subtrahend, carry << 1);
    }
}