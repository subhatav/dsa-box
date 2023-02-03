package deques;

import java.util.Stack;

// Problem Link: https://leetcode.com/problems/implement-queue-using-stacks/
// Solution Link: https://takeuforward.org/data-structure/implement-queue-using-stack/

// Approach: Amortized usage of two Stacks; Time Complexity: O(1), Space Complexity: O(2 * N)

public class QueueUsingStack {

    private final Stack<Integer> input, output;

    public QueueUsingStack() {

        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(final int number) { input.push(number); }

    public int pop() { peek(); return output.pop(); }

    public int peek() {
    
        if (output.empty()) while (!input.empty()) output.push(input.pop());

        return output.peek();
    }

    public boolean empty() { return input.empty() && output.empty(); }
}