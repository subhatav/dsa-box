package linkedlists;

import linkedlists.CustomLinkedList.LinkedNode;

// Problem Link: https://leetcode.com/problems/middle-of-the-linked-list/
// Solution Link: https://takeuforward.org/data-structure/find-middle-element-in-a-linked-list/

// Approach #1: Brute Force; Time Complexity: O(N + (N/2))
// Approach #2: Tortoise-Hare Technique; Time Complexity: O(N)

public class FindMiddleNode {

    public LinkedNode compute(LinkedNode start) {

        // Tortoise == Node "slow" [normally];
        // Hare == Node "fast" [double speed]
        LinkedNode slow = start, fast = start;

        // First condition == Even-lengthed List;
        // Second condition == Odd-lengthed List
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // Node "slow" == Middle Node
    }
}