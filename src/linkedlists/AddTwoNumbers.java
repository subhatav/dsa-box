package linkedlists;

import linkedlists.CustomLinkedList.LinkedNode;

// Problem Link: https://leetcode.com/problems/add-two-numbers/
// Solution Link: https://leetcode.com/problems/add-two-numbers/solutions/127833/add-two-numbers/

// Approach: Elementary Mathematics; Time Complexity: O(max(N1, N2))

public class AddTwoNumbers {

    public LinkedNode addTwoNumbers(LinkedNode list1, LinkedNode list2) {

        LinkedNode dummy = new LinkedNode(-1), node = dummy;

        int sum, digit, carry = 0;

        while (list1 != null || list2 != null || carry != 0) {

            int digit1 = (list1 != null) ? list1.value : 0;
            int digit2 = (list2 != null) ? list2.value : 0;

            sum = (digit1 + digit2) + carry;

            digit = sum % 10;
            carry = sum / 10;

            node.next = new LinkedNode(digit);
            node = node.next;

            if (list1 != null) list1 = list1.next;
            if (list2 != null) list2 = list2.next;
        }

        return dummy.next;
    }
}