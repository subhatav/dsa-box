package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Problem Link: https://leetcode.com/problems/group-anagrams/
// Solution Link: https://leetcode.com/problems/group-anagrams/solutions/19176/share-my-short-java-solution/

// Approach #1: For EACH String, SORT & Save in MAP; Time Complexity: O(N * KlogK)
// Approach #2: For EACH String, ENCODE & Append in MAP; Time Complexity: O(N * K)

// Note: "K" == MEAN Number of CHARACTERS in EACH String, from the LIST of Strings

public class GroupAnagrams {

    // Map "map" == Keys -> BASIC Strings;
    // Values -> Group of MATCHED Anagrams
    private Map<String, List<String>> map;

    public List<List<String>> compute(String[] strs) {

        map = new HashMap<>(); // INITIATE the Groups

        for (String str : strs) {

            // ENCODE == Convert the "str" into BASIC
            String sorted = encode(str.toCharArray());

            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(str); // PUSH in GROUP
        }

        // Return ALL the GROUPS of Strings
        return new ArrayList<>(map.values());
    }

    private String encode(char[] chars) {

        // Records ALL the CHARACTERS
        char[] counter = new char[26];

        // COUNT all the Chars from the "str" String
        for (char ch : chars) counter[ch - 'a'] += 1;

        // GET the BASIC Form of "str"
        return String.valueOf(counter);
    }
}