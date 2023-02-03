package linkedlists;

import linkedlists.CustomLinkedList.LinkedNode;

// Problem Link: https://leetcode.com/problems/rotate-list/
// Solution Link: https://takeuforward.org/data-structure/rotate-a-linked-list/

// Approach #1: Brute Force; Time Complexity: O(N * K)
// Approach #2: Get Length, Make Cycle & Disconnect; Time Complexity: O(N + Times)

public class RotateLinkedList {

    public LinkedNode compute(LinkedNode start, int k) {

        // Handle the Edge Cases
        if (k == 0) return start;
        if (start == null) return start;
        if (start.next == null) return start;

        LinkedNode dummy = start;
        int length = 1, times;

        // Get the Size of the LL
        while (dummy.next != null) {

            length += 1;
            dummy = dummy.next;
        }

        // Connect a Cycle
        dummy.next = start;

        // Calculate the position of
        // the new Last Node in List
        times = length - (k % length);

        // Reach to the new Last Node of the LL
        while (times-- >= 1) dummy = dummy.next;

        // Point the Head
        start = dummy.next;
        // Ground the End
        dummy.next = null;

        return start;
    }
}