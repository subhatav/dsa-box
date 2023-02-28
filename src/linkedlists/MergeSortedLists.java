package linkedlists;

import linkedlists.CustomLinkedList.LinkedNode;

// Problem Link: https://leetcode.com/problems/merge-two-sorted-lists/
// Solution Link: https://takeuforward.org/data-structure/merge-two-sorted-linked-lists/

// Approach #1: Store in new Linked List; Time Complexity: O(N1 + N2), Space Complexity: O(N1 + N2)
// Approach #2: Store in-place w/o extra space; Time Complexity: O(N1 + N2), Space Complexity: O(1)

public class MergeSortedLists {

    public LinkedNode compute(LinkedNode list1, LinkedNode list2) {

        // When null, return opposite LL
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        LinkedNode backup, result;

        // LL "list1" should have the SMALLER starting number
        if (list1.value > list2.value) {

            // Swap the "list1" and "list2" LLs
            backup = list1;
            list1 = list2;
            list2 = backup;
        }

        // Backup the starting Node in the "result" LL
        result = list1;

        while (list1 != null && list2 != null) {

            LinkedNode last = null;

            // Run the "list1" LL until it becomes EMPTY, or if
            // its number is LARGER than that of the "list2" LL
            while (list1 != null && list1.value <= list2.value) {

                last = list1;
                list1 = list1.next;
            }

            // Connect the "last" Node to the "list2" LL
            last.next = list2;

            // Swap the "list1" and "list2" LLs
            backup = list1;
            list1 = list2;
            list2 = backup;
        }

        return result;
    }
}