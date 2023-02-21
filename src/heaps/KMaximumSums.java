package heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// Problem Link: https://www.codingninjas.com/codestudio/problems/k-max-sum-combinations_975322
// Solution Link: https://www.geeksforgeeks.org/k-maximum-sum-combinations-two-arrays/

// Approach #1: Priority Queue Technique; Time Complexity: O(N^2), Space Complexity: O(N^2)
// Approach #2: Optimized Priority Handling; Time Complexity: O(NlogN), Space Complexity: O(N)

public class KMaximumSums {

    public List<Integer> compute(List<Integer> nums1, List<Integer> nums2, int k) {

        Queue<Integer> queue = new PriorityQueue<>(k);
        List<Integer> sums = new ArrayList<>(k);

        while (k-- > 0) { queue.add(Integer.MIN_VALUE); }

        // LOOP through "nums1"
        for (int num1 : nums1) {

            // LOOP through "nums2"
            for (int num2 : nums2) {

                // CALCULATE this SUM
                int sum = num1 + num2;

                if (sum > queue.peek()) { // See if the CURRENT Sum is LARGER

                    queue.poll(); // REMOVE the SMALLER Sum from the Min-Heap
                    queue.offer(sum); // ADD the CURRENT Sum to this Min-Heap
                }
            }
        }

        while (!queue.isEmpty()) { sums.add(queue.poll()); }

        Collections.reverse(sums); // REVERSE the K-Top Sums

        return sums;
    }
}