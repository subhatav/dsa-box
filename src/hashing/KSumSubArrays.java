package hashing;

import java.util.HashMap;
import java.util.Map;

// Problem Link: https://leetcode.com/problems/subarray-sum-equals-k/
// Solution Link: https://leetcode.com/problems/subarray-sum-equals-k/solutions/102106/java-solution-presum-hashmap/

// Approach #1: Brute Force; Time Complexity: O(N^2), Space Complexity: O(1)
// Approach #2: Prefix Sum Technique; Time Complexity: O(N), Space Complexity: O(N)

public class KSumSubArrays {

    public int compute(int[] nums, int k) {

        // Key == Prefix Sum; Value == Times Encountered
        Map<Integer, Integer> prefixes = new HashMap<>();

        int sum = 0, count = 0;

        // Default count for Zero Sum
        prefixes.put(0, 1);

        for (int num : nums) {

            sum += num;

            count += prefixes.getOrDefault(sum - k, 0);

            prefixes.merge(sum, 1, (old, value) -> old + value);
        }

        return count;
    }
}