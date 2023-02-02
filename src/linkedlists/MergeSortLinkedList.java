package linkedlists;

import linkedlists.CustomLinkedList.LinkedNode;

// Problem Link: https://leetcode.com/problems/sort-list/
// Solution Link: https://leetcode.com/problems/sort-list/solutions/46714/java-merge-sort-solution/

// Approach #1: Top-Down Merge Sort == Recursive Technique; Time Complexity: O(NlogN), Space Complexity: O(logN)
// Approach #2: Bottom-Up Merge Sort == Iterative Technique; Time Complexity: O(NlogN), Space Complexity: O(1)

public class MergeSortLinkedList {

    public LinkedNode compute(LinkedNode head) {

        return split(head); // Divide & Merge LL
    }
    
    protected LinkedNode split(LinkedNode start) {

        if (start == null) return start;
        if (start.next == null) return start;

        // Node "back" == Last Node of First Half of List
        // Node "middle" == First Node of Second Half of List
        // Node "then" == Last Node of Second Half of List
        LinkedNode back = null, middle = start, then = start;

        while (then != null && then.next != null) {

            back = middle;
            middle = middle.next;
            then = then.next.next;
        }

        back.next = null; // Separate two Halves

        return sort(split(start), split(middle));
    }

    private LinkedNode sort(LinkedNode list1, LinkedNode list2) {

        LinkedNode dummy = new LinkedNode(0);
        LinkedNode merged = dummy;

        while (list1 != null && list2 != null) {

            if (list1.value <= list2.value) {

                merged.next = list1;
                list1 = list1.next;

            } else {

                merged.next = list2;
                list2 = list2.next;
            }

            merged = merged.next;
        }

        if (list1 != null) merged.next = list1;
        if (list2 != null) merged.next = list2;

        return dummy.next;
    }
}