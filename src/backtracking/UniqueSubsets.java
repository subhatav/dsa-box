package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Problem Link: https://leetcode.com/problems/subsets-ii/
// Solution Link: https://leetcode.com/problems/subsets/solutions/27281/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/?orderBy=most_votes
// Complexity Link: https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071

// Approach: Use Backtracking Technique; Time Complexity: O(2^N)

public class UniqueSubsets {

    public List<List<Integer>> compute(int[] nums) {

        List<List<Integer>> subsets = new ArrayList<>();

        Arrays.sort(nums); // Sort all the Numbers first

        // Start generating the Subsets from the First Index
        backtrack(subsets, new ArrayList<>(), nums, 0);

        return subsets;
    }

    private void backtrack(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int start) {

        // Include a deep Copy of the Subset
        subsets.add(new ArrayList<>(subset));

        for (int index = start; index < nums.length; index++) {

            int number = nums[index]; // Get the Current Number

            // Condition == Skip the Consecutive Duplicates
            if (index <= start || number != nums[index - 1]) {

                subset.add(number); // Add the Current Number

                // Make a Recursive Call to the Parent Stack
                backtrack(subsets, subset, nums, index + 1);

                // Delete the Last Number while Backtracking
                subset.remove(subset.size() - 1);
            }
        }
    }
}