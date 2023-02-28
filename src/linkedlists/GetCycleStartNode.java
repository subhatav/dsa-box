package linkedlists;

import linkedlists.CustomLinkedList.LinkedNode;

// Problem Link: https://leetcode.com/problems/linked-list-cycle-ii/
// Solution Link: https://takeuforward.org/data-structure/starting-point-of-loop-in-a-linked-list/

// Approach #1: Hashing Technique; Time Complexity: O(N), Space Complexity: O(N)
// Approach #2: Tortoise-Hare Technique; Time Complexity: O(N), Space Complexity: O(1)

public class GetCycleStartNode {

    public LinkedNode compute(LinkedNode head) {

        LinkedNode slow = head, fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            // If a Cycle is present, then
            // the "slow" and "fast" Nodes
            // will MEET at the SAME index
            if (slow == fast) break;
        }

        if (fast == null) return null;
        if (fast.next == null) return null;

        // Bring the Node "head"
        // to the Starting Node
        // of the Cycle present
        while (head != slow) {

            head = head.next;
            slow = slow.next;
        }

        return head;
    }
}