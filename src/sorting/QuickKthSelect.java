package sorting;

import java.util.Random;

// Problem Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
// Solution Link: https://leetcode.com/problems/kth-largest-element-in-an-array/solutions/60300/java-quick-select/

// Approach: Use Quick Sorting with the Binary Search Technique
// Average Time Complexity: O(N); Worst Time Complexity: O(N^2)

public class QuickKthSelect {

    private Random index;

    public int compute(int[] nums, int k) {

        index = new Random();

        int size = nums.length;
        int low = 0, high = size - 1;
        int index = size - k;

        while (low < high) {

            int pivot = select(nums, low, high);

            // Prune those BRANCHES of Recursion Tree, which
            // are NOT required for finding the K-th element

            if (pivot < index) low = pivot + 1;
            else if (pivot > index) high = pivot - 1;
            else return nums[pivot];
        }

        return nums[low];
    }

    protected int select(int[] nums, int low, int high) {

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