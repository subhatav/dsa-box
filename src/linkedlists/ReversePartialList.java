package linkedlists;

import linkedlists.CustomLinkedList.LinkedNode;

// LeetCode Link: https://leetcode.com/problems/reverse-linked-list-ii/
// Solution Link: https://leetcode.com/problems/reverse-linked-list-ii/solutions/30666/simple-java-solution-with-clear-explanation/

// Approach: Use 3-Pointers; Time Complexity: O(N)

public class ReversePartialList {

    public LinkedNode compute(LinkedNode head, int left, int right) {

        if (left == right || head.next == null) return head;

        // Node "dummy" POINTS to the Starting of the List
        LinkedNode back, result = new LinkedNode(0);

        result.next = head;
        back = result;

        // Node "back" HOLDS the Last Node before the Reverse List
        for (int index = 1; index < left; index++) back = back.next;

        // Node "node" == First Node of Reverse List
        // Node "then" == Second Node of Reverse List
        LinkedNode node = back.next, then = node.next;

        // Nodes "back" and "node" are FIXED; whereas
        // Node "then" keeps TRAVERSING over the List
        for (int index = left; index < right; index++) {

            // Connect to the Starting Node of rest of the List
            node.next = then.next;

            // Shift the "then" Node JUST after the "back" Node
            then.next = back.next;
            back.next = then;

            // Mark the Starting Node of rest
            // of the List as the "then" Node
            then = node.next;
        }

        return result.next;
    }
}