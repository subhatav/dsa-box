package strings;

// Problem Link: https://www.codingninjas.com/codestudio/problems/893000

// Approach: SHRINK for LARGEST Palindrome Sub-String; Time Complexity: O((N / 2) * N)

public class MinCharsPalindromic {

    public int compute(String str) {

        int last = str.length() - 1;

        if (last <= 0) return 0;

        int left = 0, right = excess(str, left, last);

        while (left != right) {

            if (palindrome(str, left, right)) {

                return last - right;

            } else right -= 1;

            right = excess(str, left, right);
        }

        return last - right;
    }

    protected int excess(String str, int low, int high) {

        while (str.charAt(low) != str.charAt(high)) {

            high -= 1; // SHRINK until SAME Char seen
        }

        return high;
    }

    // Checks if Sub-string of the "str" from the Index "low"
    // to the Index "high" (inclusive) is a PALINDROME or NOT
    private boolean palindrome(String str, int low, int high) {

        while (low < high) {

            char left = str.charAt(low++);
            char right = str.charAt(high--);

            if (left != right) return false;
        }

        return true;
    }
}