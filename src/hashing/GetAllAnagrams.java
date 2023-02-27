package hashing;

import java.util.LinkedList;
import java.util.List;

// Problem Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/
// Solution Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/solutions/639309/java-python-sliding-window-detail-explanation-clean-concise/

// Approach: Maintain HASHED, Sliding Window for PATTERN
// Time Complexity: O(|S| + |P|), Space Complexity: O(1)

public class GetAllAnagrams {

    private List<Integer> anagrams;

    public List<Integer> compute(String str, String pat) {

        anagrams = new LinkedList<>();

        int[] count = new int[26];

        int low = 0, high = 0;

        for (char ch : pat.toCharArray()) {

            count[ch - 'a'] += 1;
        }

        while (high < str.length()) {

            char added = str.charAt(high++);

            count[added - 'a'] -= 1;

            while (count[added - 'a'] < 0) {

                char deleted = str.charAt(low++);

                count[deleted - 'a'] += 1;
            }

            if (high - low == pat.length()) {

                anagrams.add(low);
            }
        }

        return anagrams;
    }
}