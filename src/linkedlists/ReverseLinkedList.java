package linkedlists;

import linkedlists.CustomLinkedList.LinkedNode;

// LeetCode Link: https://leetcode.com/problems/reverse-linked-list/

// Approach #1: Recursive Technique; Time Complexity: O(N)
// Approach #2: Iterative Technique; Time Complexity: O(N)

public class ReverseLinkedList {

    public LinkedNode compute(LinkedNode head) {

        /*
            if (head == null) return head;
            if (head.next == null) return head;

            LinkedNode reverse = compute(head.next);

            head.next.next = head;
            head.next = null;

            return reverse;
        */

        // Node "reverse" == Reversed LL
        LinkedNode backup, reverse = null;

        while (head != null) {

            // Backup the link to the next Node
            backup = head.next;
            // Point to the Reverse as the next Node
            head.next = reverse;

            // Copy the Head to the Reverse Node
            reverse = head;
            // Point the Head to the next Node
            head = backup;
        }

        return reverse;
    }
}
