package strings;

// Problem Link: https://leetcode.com/problems/longest-palindromic-substring/
// Solution Link: https://leetcode.com/problems/longest-palindromic-substring/solutions/2928/very-simple-clean-java-solution/comments/255896

// Approach: EXPAND around CENTER; Time Complexity: O(N^2), Space Complexity: O(1)

public class LongestPalindrome {

    public String compute(String str) {

        int size = str.length(), start = 0, finish = 0;

        // EXPAND around at EACH Index of the String
        for (int index = 0; index < size; index++) {

            // Get the CURRENT Character
            char ch = str.charAt(index);
            int left = index, right = index;

            // Do EXPAND on BOTH the Sides for SAME Characters
            while (left >= 0 && str.charAt(left) == ch) left -= 1;
            while (right < size && str.charAt(right) == ch) right += 1;

            while (left >= 0 && right < size) {

                if (str.charAt(left) != str.charAt(right)) break;

                left -= 1; // Keep EXPANDING on the LEFT Side
                right += 1; // Do EXPANDING on the RIGHT Side
            }

            left += 1; // SHRINK as Palindrome STARTS at [left + 1]
            right -= 1; // SHRINK as Palindrome ENDS at [right - 1]

            if (right - left > finish - start) {

                start = left; // UPDATE as the MAXIMUM Left
                finish = right; // STORE the FURTHEST Right
            }
        }

        // Return the LONGEST Palindrome String
        return str.substring(start, finish + 1);
    }
}