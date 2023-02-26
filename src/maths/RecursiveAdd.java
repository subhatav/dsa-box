package maths;

// Approach Link: https://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-operators/

// Time & Auxiliary Space Complexity: O(logK), where K = (X & Y)

public class RecursiveAdd {

    public long add(long augend, long addend) {

        if (addend == 0) return augend;

        long carry = augend & addend;

        return add(augend ^ addend, carry << 1);
    }
}