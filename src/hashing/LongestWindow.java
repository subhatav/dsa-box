package hashing;

import java.util.HashMap;
import java.util.Map;

// Problem Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Solution Link: https://takeuforward.org/data-structure/length-of-longest-substring-without-any-repeating-character/

// Approach #1: Brute Force; Time Complexity: O(N^2)
// Approach #2: Sliding Window with Set; Time Complexity: O(2 * N)
// Approach #3: Sliding Window with Map; Time Complexity: O(N)

public class LongestWindow {

    public int compute(String str) {

        Map<Character, Integer> window = new HashMap<>();

        int size = str.length();
        int left = 0, right = 0;

        int ans = 0;

        if (size <= 1) return size;

        while (right < size) {

            char ch = str.charAt(right);
            int temp = window.getOrDefault(ch, -1);

            if (temp >= left) left = temp + 1;

            window.put(ch, right += 1);

            ans = Math.max(ans, right - left);
        }

        return ans;
    }
}