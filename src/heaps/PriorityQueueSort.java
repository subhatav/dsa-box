package heaps;

import java.util.PriorityQueue;
import java.util.Queue;

// Problem Link: https://leetcode.com/problems/sort-an-array/
// Solution Link: https://www.geeksforgeeks.org/priorityqueue-comparator-method-in-java/

// Average Time Complexity: O(NlogN); Worst Time Complexity: O(NlogN); Worst Space Complexity: O(1)

public class PriorityQueueSort {

    Queue<Integer> priority;

    public int[] compute(int[] nums) {

        // Initiate the Priority Queue order as a Max-Heap
        priority = new PriorityQueue<>((n1, n2) -> n2 - n1);

        sort(nums, nums.length);

        return nums;
    }

    private void sort(int[] nums, int size) {

        // Build a Max-Heap from the "nums[]" array
        for (int num : nums) { priority.offer(num); }

        // Store the LARGEST Numbers at the END of "nums[]"
        while (--size >= 0) { nums[size] = priority.poll(); }
    }
}