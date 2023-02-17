package searching;

// Problem Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
// Solution Link: https://leetcode.com/problems/search-in-rotated-sorted-array/solutions/14436/revised-binary-search/comments/191339

// Approach #1: Brute Force; Time Complexity: O(N)
// Approach #2: Modified Binary Searching; Time Complexity: O(logN)

public class SearchCircularArray {

    public int compute(int[] nums, int target) {

        int low = 0, high = nums.length - 1;

        while (low <= high) {

            // Get the "middle" Element Index
            int mid = low + (high - low) / 2;

            if (target == nums[mid]) return mid;

            // Verify when LEFT Part is
            // MONOTONICALLY Increasing
            if (nums[low] <= nums[mid]) {

                // The "target" is located IN the LEFT Portion
                if (nums[low] <= target && nums[mid] > target) {

                    high = mid - 1; // Focus on the LEFT Portion

                } else low = mid + 1; // Go to the CIRCULAR Part

            } else { // Or RIGHT Part is MONOTONICALLY Decreasing

                // The "target" is located IN the RIGHT Portion
                if (nums[mid] < target && nums[high] >= target) {

                    low = mid + 1; // Focus on that RIGHT Portion

                } else high = mid - 1; // Go to the CIRCULAR Part
            }
        }

        return -1; // The "target" is NOT inside the ENTIRE Array
    }
}