package arrays;

// LeetCode Link: https://leetcode.com/problems/longest-consecutive-sequence/
// Solution Link: https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/

// Approach #1: Sorting; Time Complexity: O(NlogN)
// Approach #2: Counting; Time Complexity: O(N + N) = O(N)
// Approach #3: 3-Pointers; Time Complexity: O(N)

// Dutch-National-Flag [DNF] Colors: Red == 0, White == 1, Blue == 2

public class SortTriColors {

    public void compute(int[] nums) {

        int red = 0, white = 0, blue = nums.length - 1;
        
        while (white <= blue) {

            if (nums[white] == 0) swap(nums, red++, white++);
            else if (nums[white] == 2) swap(nums, white, blue--);
            else white++;
        }
    }

    private void swap(int[] array, int left, int right) {

        int backup = array[left];
        array[left] = array[right];
        array[right] = backup;
    }
}