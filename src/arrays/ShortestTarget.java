package arrays;

// Problem Link: https://leetcode.com/problems/minimum-window-substring/

// Approach: Sliding Window Technique; Time Complexity: O(|S| + |T|), Space Complexity: O(|S| + |T|)

public class ShortestTarget {

    public String compute(String str, String tar) {

        int[] counter = new int[128];

        int matched = 0; // Number of Unique Characters forming the Target
        int left = 0, right = 0, start = -1;
        int size = str.length(), shortest = size + 1;

        if (size == 1 && tar.length() == 1 && str.equals(tar)) return tar;

        for (char ch : tar.toCharArray()) if (++counter[ch] == 1) matched++;

        while (right < size) {

            // Add character from the RIGHT
            char added = str.charAt(right++);

            // If "matched" becomes NEGATIVE, then substring
            // has MORE characters than the minimum required
            if (--counter[added] == 0) matched--;

            // If "matched" becomes ZERO, then substring
            // contains ALL the characters in the target
            while (matched == 0) {

                int window = right - left;

                if (window < shortest) {

                    shortest = window;
                    start = left;
                }

                // Delete character from the LEFT
                char deleted = str.charAt(left++);

                // If "matched" becomes POSITIVE, then substring
                // has LESS characters than the minimum required
                if (++counter[deleted] > 0) matched++;
            }
        }

        return (start == -1) ? "" : str.substring(start, start + shortest);
    }
}