package arrays;

// LeetCode Link: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

// Approach #1: Brute Force; Time Complexity: O(N^3) or O(N^2)
// Approach #2: Sort & Compare with 2-Pointers; Time Complexity: O(NlogN + N) = O(NlogN)
// Approach #3: Find the Smallest & Largest numbers of the Unsorted sub-array &
//              find their proper Indices in the Sorted whole-array; Time Complexity: O(N)

public class ShortestSubArray {
    
    public int compute(int[] nums) {

        int len = nums.length - 1;

        // Default values should be such that
        // length of the sub-array should be 0
        int left = -1, right = -2;

        int max = nums[0], min = nums[len];

        for (int ind = 1; ind <= len; ind++) {

            // The maximum value of the sub-array needs to be smaller
            // than the minimum of the rightmost sorted sub-array = 
            // the maximum value of the sub-array is counted from left
            max = Math.max(max, nums[ind]);
            // The minimum value of the sub-array needs to be larger
            // than the maximum of the leftmost sorted sub-array = 
            // the minimum value of the sub-array is counted from right
            min = Math.min(min, nums[len - ind]);

            // When "nums[ind]" is smaller than the current maximum
            // = the unsorted sub-array AT LEAST needs to end here
            if (nums[ind] < max) right = ind;
            // When "nums[len - ind]" is larger than the current minimum
            // = the unsorted sub-array AT LEAST needs to begin here
            if (nums[len - ind] > min) left = len - ind;
        }
        
        return right - left + 1;
    }
}