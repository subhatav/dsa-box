package deques;

// Problem Link: https://leetcode.com/problems/min-stack/

// Approach: Pairs of Value & Minimum linked in LIFO; Time Complexity: O(1), Space Complexity: O(N * 2)

public class MinimumStackList {

    static class Pair {

        int number, minimum;
        Pair link;

        Pair(int number, int minimum, Pair link) {

            this.number = number;
            this.minimum = minimum;
            this.link = link;
        }
    }

    private Pair head;
    
    public MinimumStackList() { this.head = null; }

    public void push(int number) {

        if (head == null) head = new Pair(number, number, null);
        else head = new Pair(number, Math.min(number, head.minimum), head);
    }

    public void pop() { head = head.link; }

    public int top() { return head.number; }

    public int minimum() { return head.minimum; }
}
