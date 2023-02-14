package sorting;

import java.util.Random;

// Problem Link: https://leetcode.com/problems/sort-an-array/
// Solution Link: https://leetcode.com/problems/sort-an-array/solutions/492042/7-sorting-algorithms-quick-sort-top-down-bottom-up-merge-sort-heap-sort-etc/

// Average Time Complexity: O(NlogN); Worst Time Complexity: O(N^2); Worst Space Complexity: O(logN)

public class QuickSortArray {

    private Random index;

    public int[] compute(int[] nums) {

        index = new Random();

        sort(nums, 0, nums.length - 1);

        return nums;
    }

    protected void sort(int[] nums, int low, int high) {

        if (low < high) {

            int pivot = partition(nums, low, high);

            sort(nums, low, pivot - 1);
            sort(nums, pivot + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {

        swap(nums, low, low + index.nextInt(high - low));

        int pivot = nums[low];

        while (low < high) {

            while (low < high && nums[high] >= pivot) {

                high -= 1;
            }

            nums[low] = nums[high];

            while (low < high && nums[low] <= pivot) {

                low += 1;
            }

            nums[high] = nums[low];
        }

        nums[low] = pivot;

        return low;
    }

    private void swap(int[] array, int left, int right) {

        int backup = array[left];
        array[left] = array[right];
        array[right] = backup;
    }
}