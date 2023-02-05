package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Problem Link: https://leetcode.com/problems/combination-sum-ii/
// Solution Link: https://leetcode.com/problems/combination-sum/solutions/16502/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/

// Time Complexity: O(2^N * K), Space Complexity: O(K * X)
// where N == Number of Elements, K == Average Length of every Combinations, X == Number of Possible Combinations

public class SumCombinations {

    public List<List<Integer>> compute(int[] nums, int target) {

        List<List<Integer>> combos = new ArrayList<>();

        Arrays.sort(nums); // Sort all the Numbers first

        // Create the Permissible Combinations from the First Index
        backtrack(combos, new ArrayList<>(), nums, target, 0);

        return combos;
    }

    private void backtrack(List<List<Integer>> combos, List<Integer> combo, int[] nums, int target, int start) {

        // Add copy of the Combo when the Target is reached
        if (target == 0) combos.add(new ArrayList<>(combo));

        else if (target > 0) {

            for (int index = start; index < nums.length; index++) {

                int number = nums[index]; // Get the Current Number

                if (number > target) break; // Handle the Edge Case

                // Condition == Skip the Consecutive Duplicates
                if (index <= start || number != nums[index - 1]) {

                    combo.add(number); // Add the Current Number

                    // Do a Combo with the Target reduced by the Current Number
                    backtrack(combos, combo, nums, target - number, index + 1);
                    // If the Current Number is permitted to be re-usable, then
                    // make the Call with the Start as "index", NOT "index + 1"

                    // Delete the Last Number while Backtracking
                    combo.remove(combo.size() - 1);
                }
            }
        }
    }
}