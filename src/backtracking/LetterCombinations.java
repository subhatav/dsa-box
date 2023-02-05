package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Problem Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// Solution Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/solutions/8109/my-recursive-solution-using-java/comments/9318

// Approach: Use Backtracking Technique; Time Complexity: O(N * 3^N)

public class LetterCombinations {

    private static final String[] KEYS = { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> compute(String digits) {

        if (digits.isEmpty()) return Arrays.asList();

        // Generate ALL the Permissible Letters Combinations from an Empty String
        return backtrack(new ArrayList<>(), new StringBuilder(), digits, 0);
    }

    private List<String> backtrack(List<String> combos, StringBuilder combo, String digits, int index) {

        // Add the String to Results if ALL the Digits are Checked
        if (index == digits.length()) combos.add(combo.toString());

        else {

            // Extract ALL the LETTERS for a Particular DIGIT
            String letters = KEYS[digits.charAt(index) - '0'];

            for (char letter : letters.toCharArray()) {

                combo.append(letter);
                backtrack(combos, combo, digits, index + 1);
                combo.deleteCharAt(combo.length() - 1);
            }
        }

        return combos; // Return the final List of all Strings
    }
}