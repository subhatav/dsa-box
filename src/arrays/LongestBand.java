package arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

// Problem Link: https://leetcode.com/problems/longest-consecutive-sequence/

// Approach #1: Brute Force; Time Complexity: O(N^3)
// Approach #2: Sort + Traverse; Time Complexity: O(NlogN + N) = O(NlogN)
// Approach #3: Traverse with Set; Time Complexity: O(N + N), not O(N * N)

public class LongestBand {

    public int compute(int[] nums) {

        Set<Integer> register = Arrays.stream(nums).boxed()
                                      .collect(Collectors.toSet());

        int result = 0;

        for (int number : register) {

            // Determine the Start of the Chain
            if (!register.contains(number - 1)) {

                int streak = 1;
                int current = number;

                // Determine the End of the Chain
                while (register.contains(current + 1)) {

                    streak += 1;
                    current += 1;
                }

                // Update the longest Streak
                result = Math.max(result, streak);
            }
        }

        return result;
    }
}