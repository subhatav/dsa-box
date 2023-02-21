package sorting;

// Problem Link: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

// Approach #1: Brute Force; Time Complexity: O(N^3) or O(N^2)
// Approach #2: Sort & Compare with 2-Pointers; Time Complexity: O(NlogN + N) = O(NlogN)
// Approach #3: Find the Smallest & Largest numbers of the Unsorted sub-array &
//              find their proper Indices in the Sorted whole-array; Time Complexity: O(N)

public class UnsortedSubArray {

    public int compute(int[] nums) {

        int last = nums.length - 1;

        // Default values should be such that
        // length of the sub-array should be 0
        int left = -1, right = -2;

        int high = nums[0], low = nums[last];

        for (int index = 1; index <= last; index++) {

            // The maximum value of the sub-array needs to be smaller
            // than the minimum of the rightmost sorted sub-array =
            // the maximum value of the sub-array is counted from left
            high = Math.max(high, nums[index]);
            // The minimum value of the sub-array needs to be larger
            // than the maximum of the leftmost sorted sub-array =
            // the minimum value of the sub-array is counted from right
            low = Math.min(low, nums[last - index]);

            // When "nums[index]" is smaller than the current "high"
            // = the unsorted sub-array AT LEAST needs to end here
            if (nums[index] < high) right = index;
            // When "nums[last - index]" is larger than the current "low"
            // = the unsorted sub-array AT LEAST needs to begin here
            if (nums[last - index] > low) left = last - index;
        }

        return right - left + 1;
    }
}