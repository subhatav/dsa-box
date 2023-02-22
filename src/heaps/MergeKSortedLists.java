package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// LeetCode Link: https://leetcode.com/problems/merge-k-sorted-lists/
// Solution Link: https://leetcode.com/problems/merge-k-sorted-lists/solutions/10528/a-java-solution-based-on-priority-queue/comments/1542198

// Approach #1: Iterative Merge Sort Technique; Time Complexity: O(NlogK), Space Complexity: O(1)
// Approach #2: Optimized Heap Sort Technique; Time Complexity: O(NlogK), Space Complexity: O(K)

// Note: "N" == TOTAL Number of NODES in the FINAL List, NOT the LENGTH(s) of the SPECIFIC List(s)

public class MergeKSortedLists {

    static class ListNode {

        int value = 0;
        ListNode next = null;

        ListNode(int value) { this.value = value; }
    }

    private Comparator<ListNode> comparer;
    private Queue<ListNode> queue;

    public ListNode compute(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;

        // DEFINE the Comparator for a MIN-HEAP of Nodes
        comparer = (now, next) -> now.value - next.value;
        queue = new PriorityQueue<>(lists.length, comparer);

        ListNode head = new ListNode(0), tail = head;

        for (ListNode node : lists) {

            // ADD the FIRST Nodes of ALL Lists
            if (node != null) queue.offer(node);
        }

        while (!queue.isEmpty()) {

            // BUILD the MERGED List
            tail.next = queue.poll();

            tail = tail.next;

            // APPEND the SUCCESSOR Node IF it is PRESENT
            if (tail.next != null) queue.offer(tail.next);
        }

        return head.next;
    }
}