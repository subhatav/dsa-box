package backtracking;

import java.util.ArrayList;
import java.util.List;

// Problem Link: https://leetcode.com/problems/subsets/
// Solution Link: https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/

// Approach: Use Binary Bits Technique; Time Complexity: O(2^N)

public class IterativeSubsets {
    
    public List<List<Integer>> compute(int[] nums) {

        List<List<Integer>> subsets = new ArrayList<>();

        // No. of Subsets == (1 << N) == (1 * 2^N)
        int size = nums.length, count = 1 << size;

        // Number "pattern" == Bits are SET to 1 as needed
        for (int pattern = 0; pattern < count; pattern++) {

            List<Integer> subset = new ArrayList<>();

            // Run the Loop while checking ALL the Bits
            for (int index = 0; index < size; index++) {

                // Set the CURRENT Index
                int current = 1 << index;

                // Check if the Current BIT is
                // SET in the Number "pattern"
                if ((pattern & current) > 0) {

                    subset.add(nums[index]);
                }
            }

            subsets.add(subset);
        }

        return subsets;
    }
}