package greedy;

// Problem Link: https://leetcode.com/problems/maximum-subarray/
// Solution Link: https://www.youtube.com/watch?v=5WZl3MMT0Eg

// Approach #1: Brute Force; Time Complexity: O(N^3) or O(N^2)
// Approach #2: Kadane's Algorithm; Time Complexity: O(N)

public class MaximumSubArray {

    public int compute(int[] nums) {

        int sum = 0, max = Integer.MIN_VALUE;

        for (int num : nums) {

            sum += num;

            if (sum > max) max = sum;
            // Reset the current "sum" = ZERO,
            // when it becomes LESS than ZERO
            if (sum < 0) sum = 0;
        }

        return max;
    }
}