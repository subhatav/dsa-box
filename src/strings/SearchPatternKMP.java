package strings;

// Problem Link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
// Solution Link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/solutions/535326/java-kmp-solution-o-m-n-clean-code/

// Approach: Use Knuth-Morris-Pratt Algorithm for Pattern Searching
// Algorithm Link: https://www.scaler.com/topics/data-structures/kmp-algorithm/

// Time Complexity: O(M + N); Space Complexity: O(M)

public class SearchPatternKMP {

    private int[] lps; // Array "lps[]" == LPS Table

    public int compute(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        // BUILD the LPS
        table(needle, m);

        int j = 0, i = 0;

        while (i < n) {

            if (needle.charAt(j) == haystack.charAt(i)) {

                j += 1; // Loop the Pattern
                i += 1; // Move in the Text

                // Return when ALL Chars
                // are FOUND in the Text
                if (j == m) return i - m;

            } else {

                // REWIND back to the LAST
                // Matched Char in Pattern
                if (j > 0) j = lps[j - 1];
                else i += 1; // Shift Loop
            }
        }

        return -1; // For the MISSING Case
    }

    private void table(String pattern, int size) {

        lps = new int[size];

        int j = 0, k = 1;

        while (k < size) {

            if (pattern.charAt(j) == pattern.charAt(k)) {

                j += 1; // Increase Matcher
                lps[k] = j; // Record index
                k += 1; // Loop the Pattern

            } else {

                // REWIND back to the LAST
                // Matched Char in Pattern
                if (j > 0) j = lps[j - 1];
                else k += 1; // Shift Loop
            }
        }
    }
}