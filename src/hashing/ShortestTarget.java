package hashing;

// Problem Link: https://leetcode.com/problems/minimum-window-substring/
// Solution Link: https://leetcode.com/problems/minimum-window-substring/solutions/26808/here-is-a-10-line-template-that-can-solve-most-substring-problems/comments/25816

// Approach: Retain HASHED and Sliding Window for TARGET
// Time Complexity: O(|S| + |T|), Space Complexity: O(1)

public class ShortestTarget {

    public String compute(String str, String tar) {

        int size = str.length(), shortest = size + 1;
        int left = 0, right = 0, start = -1;

        int[] counter = new int[128];

        int matched = 0; // Unique Chars in the Target

        for (char ch : tar.toCharArray()) {

            if (++counter[ch] == 1) matched += 1;
        }

        while (right < size) {

            // ADD Character from the RIGHT
            char added = str.charAt(right++);

            // If "matched" becomes NEGATIVE, then Substring
            // has MORE Characters than the MINIMUM required
            if (--counter[added] == 0) matched -= 1;

            // If "matched" becomes ZERO, then Substring
            // contains ALL the Characters in the Target
            while (matched == 0) {

                int window = right - left;

                if (window < shortest) {

                    shortest = window;
                    start = left;
                }

                // DELETE Character from the LEFT
                char deleted = str.charAt(left++);

                // If "matched" becomes POSITIVE, then Substring
                // has LESS Characters than the MINIMUM required
                if (++counter[deleted] > 0) matched += 1;
            }
        }

        if (start == -1) return "";

        return str.substring(start, start + shortest);
    }
}