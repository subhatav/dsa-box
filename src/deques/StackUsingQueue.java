package deques;

import java.util.LinkedList;
import java.util.Queue;

// Problem Link: https://leetcode.com/problems/implement-stack-using-queues/
// Solution Link: https://takeuforward.org/data-structure/implement-stack-using-single-queue/

// Approach: Reverse Queue for each Push; Time Complexity: O(N), Space Complexity: O(N)

public class StackUsingQueue {

    private final Queue<Integer> queue;

    public StackUsingQueue() { queue = new LinkedList<>(); }

    public void push(final int number) {

        queue.offer(number);

        // Keep "number" fixed == Loops from 1 to (Size - 1)
        for (int index = 1; index < queue.size(); index++) {

            queue.add(queue.remove());
        }
    }

    public int pop() { return queue.poll(); }

    public int top() { return queue.peek(); }

    public boolean empty() { return queue.isEmpty(); }
}