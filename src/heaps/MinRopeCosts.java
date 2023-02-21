package heaps;

import java.util.PriorityQueue;
import java.util.Queue;

// Problem Link: https://www.codingninjas.com/codestudio/problems/connect-n-ropes-with-minimum-cost_630476
// Solution Link: https://www.codingninjas.com/codestudio/library/connect-n-ropes-with-minimum-cost

// Approach: Optimized Priority Queue; Time Complexity: O(NlogN), Space Complexity: O(N)

public class MinRopeCosts {

    public long compute(int[] nums) {

        // Initiate the Priority Queue as a Min-Heap
        Queue<Integer> queue = new PriorityQueue<>();

        // Build the Heap from the given "nums[]"
        for (int num : nums) { queue.offer(num); }

        long costs = 0; // Store the FINAL Costs

        while (queue.size() >= 2) {

            int first = queue.poll();
            int second = queue.poll();

            // ADD the TWO Smallest
            // Ropes, from the HEAP
            costs += first + second;

            // ADD the NEW Rope in HEAP
            queue.offer(first + second);
        }

        return costs;
    }
}