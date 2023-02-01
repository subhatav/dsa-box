package linkedlists;

import linkedlists.CustomLinkedList.LinkedNode;

// LeetCode Link: https://leetcode.com/problems/palindrome-linked-list/
// Solution Link: https://leetcode.com/problems/palindrome-linked-list/solutions/433547/palindrome-linked-list/

// Approach #1: Use extra Data Structure; Time Complexity: O(N), Space Complexity: O(N)
// Approach #2: Reverse Back-Half in-place, Traverse & Check; Time Complexity: O(N), Space Complexity: O(1)

public class CheckPalindromeList {

    public boolean compute(LinkedNode head) {

        if (head.next == null) return true;

        LinkedNode half = reverse(middle(head).next);

        while (half != null) {

            if (head.value != half.value) return false;

            head = head.next;
            half = half.next;
        }

        return true;
    }

    private LinkedNode middle(LinkedNode start) {

        // Node "fast" starts from the Second Node
        // of List, because for Even-lengthed List,
        // the first Middle Node would be returned
        LinkedNode slow = start, fast = start.next;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private LinkedNode reverse(LinkedNode start) {

        LinkedNode backup, reverse = null;

        while (start != null) {

            backup = start.next;
            start.next = reverse;

            reverse = start;
            start = backup;
        }

        return reverse;
    }
}