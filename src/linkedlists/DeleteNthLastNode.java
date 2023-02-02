package linkedlists;

import linkedlists.CustomLinkedList.LinkedNode;

// Problem Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// Solution Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/solutions/1164537/short-simple-one-pass-solution-w-explanation-beats-100-no-dummy-node-required/

// Approach #1: 2 Passes; Time Complexity: O(N + N)
// Approach #2: 1 Pass with Tortoise-Hare Technique; Time Complexity: O(N)

public class DeleteNthLastNode {

    public LinkedNode compute(LinkedNode start, int n) {

        // Tortoise == Node "slow" [normally];
        // Hare == Node "fast" [double speed]
        LinkedNode slow = start, fast = start;

        // Create a gap of "n" Nodes b/w
        // the "slow" & the "fast" Nodes
        while (n-- > 0) fast = fast.next;

        // Remove the "start" Node itself
        if (fast == null) return start.next;

        // Run the Loop till the "fast" Node
        // reaches the last Node of the List
        while (fast.next != null) {

            slow = slow.next;
            fast = fast.next;
        }

        // Remove the Node JUST after
        // the "slow" Node in the List
        slow.next = slow.next.next;

        return start;
    }
}