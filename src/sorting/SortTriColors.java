package sorting;

// Problem Link: https://leetcode.com/problems/sort-colors/
// Solution Link: https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/

// Approach #1: Sorting; Time Complexity: O(NlogN)
// Approach #2: Counting; Time Complexity: O(N + N) = O(N)
// Approach #3: 3-Pointers; Time Complexity: O(N)

// Dutch-National-Flag [DNF] Colors: Red == 0, White == 1, Blue == 2

public class SortTriColors {

    public void compute(int[] nums) {

        // The 2-Pointers "low" and "high"
        // MARK the Start and End of WHITE
        int low = 0, high = nums.length - 1;

        for (int index = low; index <= high; index++) {

            if (nums[index] == 0) swap(nums, low++, index);
            else if (nums[index] == 2) swap(nums, index--, high--);
        }
    }

    private void swap(int[] array, int left, int right) {

        int backup = array[left];
        array[left] = array[right];
        array[right] = backup;
    }
}