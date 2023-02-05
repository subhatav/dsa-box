package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Problem Link: https://leetcode.com/problems/permutations-ii/
// Solution Link: https://leetcode.com/problems/permutations/solutions/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning/
// Complexity Link: https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071

// Approach: Use Backtracking Technique; Time Complexity: O(NlogN + N! * N)

public class UniquePermutations {

    public List<List<Integer>> compute(int[] nums) {

        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] frequencies = new boolean[nums.length];

        Arrays.sort(nums); // Sort all the Numbers in Ascending Order
        backtrack(permutations, new ArrayList<>(), nums, frequencies);

        return permutations;
    }

    private void backtrack(List<List<Integer>> permutations, List<Integer> subset, int[] nums, boolean[] used) {

        // ALL the Indices are being USED
        if (subset.size() == nums.length) {

            // Include a deep Copy of the Permutation
            permutations.add(new ArrayList<>(subset));

        } else {

            for (int index = 0; index < nums.length; index++) {

                int number = nums[index];

                boolean isConsecutiveDuplicate = (index > 0) && (number == nums[index - 1]);
                boolean isLastDuplicateNotUsed = isConsecutiveDuplicate && !used[index - 1];

                if (!used[index] && !isLastDuplicateNotUsed) {

                    used[index] = true;
                    subset.add(number);

                    backtrack(permutations, subset, nums, used);

                    used[index] = false;
                    subset.remove(subset.size() - 1);
                }
            }
        }
    }
}
