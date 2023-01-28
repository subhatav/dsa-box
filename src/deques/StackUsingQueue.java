package deques;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    private final Queue<Integer> queue;

    public StackUsingQueue() { queue = new LinkedList<>(); }

    public void push(int number) {

        queue.offer(number);

        // Loops from 1 (to Size - 1) = Do NOT move "number"
        for (int index = 1; index < queue.size(); index++) {

            queue.add(queue.remove());
        }
    }

    public int pop() { return queue.poll(); }

    public int top() { return queue.peek(); }

    public boolean empty() { return queue.isEmpty(); }
}