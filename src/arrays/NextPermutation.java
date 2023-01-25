package arrays;

// LeetCode Link: https://leetcode.com/problems/next-permutation/
// Solution Link: https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/

// Approach #1: Brute Force; Time Complexity: O(N! * N)
// Approach #2: Follow Solution Link; Time Complexity: O(N + N + N) = O(N)

public class NextPermutation {

    public void compute(int[] nums) {

        int last = nums.length - 1, left = last - 1;

        // Determine the index of the Longest non-increasing Suffix
        while (left >= 0 && nums[left] >= nums[left + 1]) left -= 1;

        if (left >= 0) {

            int right = last;

            // Find index of the Element JUST bigger
            // than the Element at the index "left"
            while (nums[right] <= nums[left]) right -= 1;

            swap(nums, left, right);
        }
        
        reverse(nums, left + 1, last);
    }

    protected void reverse(int[] array, int left, int right) {

        while (left < right) swap(array, left++, right--);
    }

    private void swap(int[] array, int left, int right) {

        int backup = array[left];
        array[left] = array[right];
        array[right] = backup;
    }
}