package arrays;

import java.util.ArrayList;

// LeetCode Link: https://leetcode.com/problems/reverse-pairs/

// Approach #1: Brute Force; Time Complexity: O(N^2)
// Approach #2: Divide, Count & Merge; Time Complexity: O(NlogN + N + N) = O(NlogN)

// To-Do: Shift this Class to the "sorting" package

public class ReversePairs {

    public int compute(int[] nums) {

        return split(nums, 0, nums.length - 1);
    }

    protected int split(int[] nums, int low, int high) {

        int count = 0, middle = (low + high) / 2;

        if (low >= high) return count;

        count += split(nums, low, middle);
        count += split(nums, middle + 1, high);

        count += tally(nums, low, middle, high);

        return count;
    }

    private int tally(int[] nums, int low, int middle, int high) {

        int count = 0, right = middle + 1;

        for (int left = low; left <= middle; left++) {

            while (right <= high && (nums[left] / 2.0) > nums[right]) right++;

            count += right - (middle + 1);
        }

        sort(nums, low, middle, high);

        return count;
    }

    private void sort(int[] nums, int low, int middle, int high) {

        ArrayList<Integer> merged = new ArrayList<>();

        int left = low, right = middle + 1;

        while (left <= middle && right <= high) {

            if (nums[left] <= nums[right]) merged.add(nums[left++]);
            else merged.add(nums[right++]);
        }

        while (left <= middle) merged.add(nums[left++]);
        while (right <= high) merged.add(nums[right++]);

        for (int index = low; index <= high; index++) {

            nums[index] = merged.get(index - low);
        }
    }
}