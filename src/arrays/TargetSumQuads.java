package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Problem Link: https://leetcode.com/problems/4sum/
// Solution Link: https://takeuforward.org/data-structure/4-sum-find-quads-that-add-up-to-a-target-value/

// Approach #1: Sort & (N^3) * Binary Search; Time Complexity: O(NlogN + (N^3) * logN)
// Approach #2: Sort & (N^2) * 2-Sum Approach; Time Complexity: O(NlogN + (N^2) * N) = O(N^3)

public class TargetSumQuads {

    // Iteratively convert K-Sum Problem into (K - 1) Sum Problem,
    // until a Pair-Sum (Two-Sum) Problem is found for approaching

    public List<List<Integer>> compute(int[] nums, int target) {

        List<List<Integer>> quads = new ArrayList<>();

        int size = nums.length;

        Arrays.sort(nums);

        for (int first = 0; first < size - 3; first++) {

            long primary = target - nums[first];

            for (int second = first + 1; second < size - 2; second++) {

                long secondary = primary - nums[second];

                int third = second + 1, fourth = size - 1;

                while (third < fourth) {

                    long tertiary = nums[third] + nums[fourth];

                    if (tertiary > secondary) fourth -= 1;
                    else if (tertiary < secondary) third += 1;

                    else {

                        List<Integer> quad = new ArrayList<>();

                        quad.add(nums[first]);
                        quad.add(nums[second]);
                        quad.add(nums[third]);
                        quad.add(nums[fourth]);

                        quads.add(quad);

                        // Skip the Consecutive Duplicates of the fourth Number
                        while (third < fourth && quad.get(3) == nums[fourth]) fourth -= 1;

                        // Skip the Consecutive Duplicates of the third Number
                        while (third < fourth && quad.get(2) == nums[third]) third += 1;
                    }
                }

                // Skip the Consecutive Duplicates of the second Number
                while (second + 1 < size && nums[second + 1] == nums[second]) second += 1;
            }

            // Skip the Consecutive Duplicates of the first Number
            while (first + 1 < size && nums[first + 1] == nums[first]) first += 1;
        }

        return quads;
    }
}