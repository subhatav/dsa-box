package backtracking;

import java.util.ArrayList;
import java.util.List;

// Problem Link: https://leetcode.com/problems/palindrome-partitioning/
// Solution Link: https://takeuforward.org/data-structure/palindrome-partitioning/

// Approach: Use Backtracking Technique; Time Complexity: O((N / 2) * 2^N)

public class PalindromePartitions {

    public List<List<String>> compute(String str) {

        List<List<String>> partitions = new ArrayList<>();

        // Generate ALL the Palindrome Partitioned Sub-strings
        backtrack(partitions, new ArrayList<>(), str, 0);

        return partitions;
    }

    protected void backtrack(List<List<String>> partitions, List<String> partition, String str, int start) {

        // Add the Partitions to Results AFTER the Last Partition is grounded
        if (start == str.length()) partitions.add(new ArrayList<>(partition));

        else {

            for (int index = start; index < str.length(); index++)

                if (palindrome(str, start, index)) {

                    // Add the Palindrome Sub-string as Partition
                    partition.add(str.substring(start, index + 1));
                    backtrack(partitions, partition, str, index + 1);
                    partition.remove(partition.size() - 1);
                }
        }
    }

    // Checks if Sub-string of the "str" from the Index "low"
    // to the Index "high" (inclusive) is a PALINDROME or NOT
    private boolean palindrome(String str, int low, int high) {

        while (low < high) {

            char left = str.charAt(low++);
            char right = str.charAt(high--);

            if (left != right) return false;
        }

        return true;
    }
}