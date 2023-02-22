package heaps;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// Problem Link: https://leetcode.com/problems/find-median-from-data-stream/
// Solution Link: https://leetcode.com/problems/find-median-from-data-stream/solutions/1330646/c-java-python-minheap-maxheap-solution-picture-explain-clean-concise/

// Approach: Balance 2-Heaps == Min-and-Max; Space Complexity: O(N)
// Time Complexities: "addNumber" == O(NlogN), "findMedian" == O(1)

public class RunningMedian {

    // P. Queue "Left" == Ordered as Max-Heap;
    // P. Queue "Right" == Ordered as Min-Heap
    private Queue<Integer> leftHeap, rightHeap;

    public RunningMedian() {

        leftHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightHeap = new PriorityQueue<>();
    }

    public void addNumber(int number) {

        leftHeap.offer(number);
        rightHeap.offer(leftHeap.poll());

        if (rightHeap.size() > leftHeap.size()) {

            // Size (Right Heap <= Left Heap)
            leftHeap.offer(rightHeap.poll());
        }
    }

    public double findMedian() {

        // Do IF the TOTAL Length is ODD Number
        if (leftHeap.size() > rightHeap.size()) {

            // Peek/find the EXCESS
            // Number, which is the
            // SINGLE Middle Number
            return leftHeap.peek();
        }

        // Return the MEAN of the TWO Middle Numbers
        return (leftHeap.peek() + rightHeap.peek()) / 2.0;
    }
}