package linkedlists;

import linkedlists.CustomLinkedList.LinkedNode;

// Problem Link: https://leetcode.com/problems/intersection-of-two-linked-lists/
// Solution Link: https://leetcode.com/problems/intersection-of-two-linked-lists/solutions/49785/java-solution-without-knowing-the-difference-in-len/

// Approach #1: Brute Force; Time Complexity: O(N1 * N2), Space Complexity: O(1)
// Approach #2: Hashing Technique; Time Complexity: O(N1 + N2), Space Complexity: O(N1)
// Approach #3: Optimized Technique; Time Complexity: O(2 * max(N1, N2)), Space Complexity: O(1)

public class GetIntersectionNode {

    public LinkedNode compute(LinkedNode headA, LinkedNode headB) {

        LinkedNode dummy1 = headA, dummy2 = headB;

        // Iteration #1: Compensate for the Difference in the Loop Lengths
        // Iteration #2: Pointers arrive at the Intersection Node together

        while (dummy1 != dummy2) {

            dummy1 = (dummy1 == null) ? headB : dummy1.next;
            dummy2 = (dummy2 == null) ? headA : dummy2.next;
        }

        return dummy1;
    }
}