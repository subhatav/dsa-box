package stacks;

import java.util.Arrays;
import java.util.Stack;

// LeetCode Link: https://leetcode.com/problems/next-greater-element-ii/
// Solution Link: https://takeuforward.org/data-structure/next-greater-element-using-stack/

// Approach: Monotonic Stack LIFO Technique * 2; Time Complexity: O(N * 2); Space Complexity: O(N)

public class NextCircularNumber {

    public int[] compute(int[] nums) {

        // Monotonic increasing sub-sequence
        Stack<Integer> stack = new Stack<>();

        int size = nums.length;
        int ngns[] = new int[size];

        // Fill default values
        Arrays.fill(ngns, -1);

        // Double the Array to tackle Circular Problems
        for (int index = 0; index < (size * 2); index++) {

            int current = index % size;
            int number = nums[current];

            // Remove right-most numbers, SMALLER than current one
            while (!stack.empty() && number > nums[stack.peek()]) {

                // Store CURRENT number as
                // NGN for smaller numbers
                ngns[stack.pop()] = number;
            }

            if (index < size) stack.push(current);
        }

        return ngns;
    }
}