package sorting;

// Problem Link: https://leetcode.com/problems/sort-an-array/
// Solution Link: https://www.programiz.com/dsa/heap-sort

// Average Time Complexity: O(NlogN); Worst Time Complexity: O(NlogN); Worst Space Complexity: O(1)

public class HeapSortArray {

    public int[] compute(int[] nums) {

        sort(nums, nums.length);

        return nums;
    }

    protected void sort(int[] nums, int size) {

        // Node "internal" ==== Index
        // of the First Non-Leaf Node
        int internal = (size / 2) - 1;

        // Build a Max-Heap from the provided "nums[]" array
        while (internal >= 0) heapify(nums, size, internal--);

        for (int last = size - 1; last >= 0; last--) {

            // Swap the Current Root
            // to the Ending of Heap
            swap(nums, 0, last);

            // Maximize the Reduced Heap
            // i.e., maintain a Max-Heap
            heapify(nums, last, 0);
        }
    }

    private void heapify(int[] nums, int size, int root) {

        int largest = root;

        int left = (2 * root) + 1;
        int right = (2 * root) + 2;

        if (left < size && nums[left] > nums[largest]) {

            // If the Left Child is LARGER than
            // the "largest" Node, POINT it to
            // the Index of Left Child Node
            largest = left;
        }

        if (right < size && nums[right] > nums[largest]) {

            // If the Right Child is LARGER than
            // the "largest" Node, POINT it to
            // the Index of Right Child Node
            largest = right;
        }

        if (largest != root) {

            // Swap-in the Root Node
            // with the largest Node
            swap(nums, root, largest);

            // After this swap, the Node
            // at the "largest" Index is
            // OLD "root" Node; thereby,
            // recursively, HEAPIFY that
            // IMPACTED Sub-Tree of Heap
            heapify(nums, size, largest);
        }
    }

    private void swap(int[] array, int left, int right) {

        int backup = array[left];
        array[left] = array[right];
        array[right] = backup;
    }
}