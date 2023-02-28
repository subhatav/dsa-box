package hashing;

import java.util.HashMap;
import java.util.Map;

// Problem Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Solution Link: https://takeuforward.org/data-structure/length-of-longest-substring-without-any-repeating-character/

// Approach #1: Brute Force; Time Complexity: O(N^2)
// Approach #2: Sliding Window with Set; Time Complexity: O(2 * N)
// Approach #3: Sliding Window with Map; Time Complexity: O(N)

public class LongestWindow {

    private Map<Character, Integer> window;

    public int compute(String str) {

        window = new HashMap<>();

        int size = str.length();
        int low = 0, high = 0;

        int answer = 0;

        if (size <= 1) return size;

        while (high < size) {

            char ch = str.charAt(high);
            int last = window.getOrDefault(ch, -1);

            if (last >= low) low = last + 1;

            window.put(ch, high += 1);

            answer = Math.max(answer, high - low);
        }

        return answer;
    }
}