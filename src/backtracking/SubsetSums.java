package backtracking;

import java.util.ArrayList;
import java.util.Collections;

// Problem Link: https://www.codingninjas.com/codestudio/problems/subset-sum_3843086
// Solution Link: https://takeuforward.org/data-structure/subset-sum-sum-of-all-subsets/

// Approach: Use Backtracking Technique; Time Complexity: O(NlogN + 2^N)

public class SubsetSums {
    
    public ArrayList<Integer> compute(int nums[]) {

        ArrayList<Integer> sums = new ArrayList<>();

        // Sum the Subsets from the First Index
        backtrack(sums, 0, nums, 0);

        Collections.sort(sums); // Arrange Sums

        return sums;
    }

    private void backtrack(ArrayList<Integer> sums, int sum, int[] nums, int index) {

        if (index == nums.length) sums.add(sum); // Include the Sum of the Current Subset

        else {

            // Do a Recursive Call with the Current Number added
            backtrack(sums, sum + nums[index], nums, index + 1);
            // Do backtrack w/o the Current Number
            backtrack(sums, sum, nums, index + 1);
        }
    }
}