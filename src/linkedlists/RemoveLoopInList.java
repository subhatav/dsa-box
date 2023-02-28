package linkedlists;

import linkedlists.CustomLinkedList.LinkedNode;

// Problem Link: https://www.codingninjas.com/codestudio/problems/interview-shuriken-42-detect-and-remove-loop_241049
// Solution Link: https://www.scaler.com/topics/remove-loop-in-linked-list/

// Approach #1: Hashing Technique; Time Complexity: O(N), Space Complexity: O(N)
// Approach #2: Tortoise-Hare Technique; Time Complexity: O(N), Space Complexity: O(1)

public class RemoveLoopInList {

    public LinkedNode compute(LinkedNode head) {

        LinkedNode slow = head, fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            // SNAP if LOOP is SEEN
            if (slow == fast) break;
        }

        if (slow == fast) {

            // If LOOP is FOUND
            // at the BEGINNING
            if (slow == head) {

                fast = starter(head, fast);

            // Differently, LOOP is ELSEWHERE
            } else fast = betwixt(head, fast);

            fast.next = null; // NULLIFY Link
        }

        return head;
    }

    private LinkedNode starter(LinkedNode head,
                               LinkedNode fast) {

        // Find the PREDECESSOR of the "head" Node
        while (fast.next != head) fast = fast.next;

        return fast;
    }

    private LinkedNode betwixt(LinkedNode slow,
                               LinkedNode fast) {

        while (slow.next != fast.next) {

            slow = slow.next;
            fast = fast.next;
        }

        return fast; // Return END Node of LIST
    }
}