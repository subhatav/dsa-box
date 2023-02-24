package strings;

// Problem Link: https://leetcode.com/problems/break-a-palindrome/
// Solution Link: https://leetcode.com/problems/break-a-palindrome/solutions/939823/java-0-ms-intuitive-code-w-explanation/

// Approach: REPLACE with 'a' from FIRST Index; Time & Space Complexity: O(N)

public class BreakPalindromeString {

    public String compute(String palindrome) {

        char[] chars = palindrome.toCharArray();

        int index = 0, size = chars.length;

        if (size <= 1) return "";

        // Loop till HALF of Array
        // since the LATER Half is
        // SAME as the FORMER Half
        while (index < (size / 2)) {

            if (chars[index] != 'a') {

                chars[index] = 'a'; // Break

                return String.valueOf(chars);
            }

            index += 1;
        }

        // When ALL Characters
        // are 'a', then place
        // the 'b' at last 'a'
        chars[size - 1] = 'b';

        return String.valueOf(chars);
    }
}