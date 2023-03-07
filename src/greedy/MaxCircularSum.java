package greedy;

// Problem Link: https://leetcode.com/problems/maximum-sum-circular-subarray/
// Solution Link: https://leetcode.com/problems/maximum-sum-circular-subarray/solutions/178422/one-pass/

// Approach: Modified Kadane's Algorithm; Time Complexity: O(N)

public class MaxCircularSum {

    public int compute(int[] nums) {

        int subMax = 0, maxSum = nums[0];
        int subMin = 0, minSum = nums[0];

        int totalSum = 0;

        for (int num : nums) {

            totalSum += num;

            subMax = Math.max(subMax + num, num);
            subMin = Math.min(subMin + num, num);

            maxSum = Math.max(maxSum, subMax);
            minSum = Math.min(minSum, subMin);
        }

        // If all Numbers are NEGATIVE
        if (maxSum <= 0) return maxSum;

        return Math.max(maxSum, totalSum - minSum);
    }
}