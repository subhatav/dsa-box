package arrays;

import java.util.HashMap;
import java.util.Map;

// Problem Link: https://leetcode.com/problems/two-sum/

// Approach #1: Brute Force; Time Complexity: O(N^2)
// Approach #2: Sort & Binary Search; Time Complexity: O(NlogN + NlogN) = O(NlogN)
// Approach #3: Set; Time Complexity: O(N)

public class ZeroSumDuplet {

    public int[] compute(int[] nums, int target) {

        Map<Integer, Integer> counter = new HashMap<>();

        for (int index = 0; index < nums.length; index += 1) {

            int diff = target - nums[index];

            if (counter.containsKey(diff)) {

                return new int[] { counter.get(diff), index };
            }

            counter.put(nums[index], index);
        }

        return null;
    }
}