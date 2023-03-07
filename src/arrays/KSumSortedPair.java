package arrays;

// Problem Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

// Approach: Shrink SEARCH Space with 2-Pointers; Time Complexity: O(N)

public class KSumSortedPair {

    public int[] compute(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left < right) {

            int sum = nums[left] + nums[right];

            if (sum == target) break;
            else if (sum < target) left += 1;
            else if (sum > target) right -= 1;
        }

        return new int[] { left + 1, right + 1 };
    }
}