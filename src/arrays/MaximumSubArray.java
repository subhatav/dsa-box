package arrays;

// LeetCode Link: https://leetcode.com/problems/maximum-subarray/

// Approach #1: Brute Force; Time Complexity: O(N^3) or O(N^2)
// Approach #2: Kadane's Algorithm; Time Complexity: O(N)

public class MaximumSubArray {

    public int compute(int[] nums) {

        int sum = 0, max = Integer.MIN_VALUE;

        for (int num : nums) {

            sum += num;

            if (sum > max) max = sum;
            // Reset current "sum" to ZERO, when it goes negative
            if (sum < 0) sum = 0;
        }

        return max;
    }
}