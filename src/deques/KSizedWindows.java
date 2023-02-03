package deques;

import java.util.ArrayDeque;
import java.util.Deque;

// Problem Link: https://leetcode.com/problems/sliding-window-maximum/
// Solution Link: https://www.youtube.com/watch?v=DfljaUwZsOk

// Approach #1: Brute Force; Time Complexity: O(N^2)
// Approach #2: Sliding Window with Deque; Time Complexity: O(N)

public class KSizedWindows {

    public int[] compute(int[] nums, int k) {

        Deque<Integer> deque = new ArrayDeque<>();

        int j = 0, size = nums.length;
        int[] maxes = new int[size - k + 1];

        for (int i = 0; i < size; i++) {

            // Remove left-most number which goes OUT of range
            if (!deque.isEmpty() && deque.peekFirst() == i - k)
                deque.pollFirst();

            // Remove left-most numbers which are SMALLER than "nums[i]"
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
                deque.pollLast();

            deque.offer(i); // Insert index of "nums[i]" at end

            // If range has "k" width, take the left-most number
            if (i >= k - 1) maxes[j++] = nums[deque.peekFirst()];
        }
        
        return maxes;
    }
}