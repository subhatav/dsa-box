package stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Problem Link: https://leetcode.com/problems/next-greater-element-i/
// Solution Link: https://leetcode.com/problems/next-greater-element-i/solutions/97595/java-10-lines-linear-time-complexity-o-n-with-explanation/

// Approach: Monotonic Stack LIFO Technique; Time Complexity: O(N1 + N2); Space Complexity: O(N1 * 2)

public class NextGreaterNumber {

    public int[] compute(int[] nums1, int[] nums2) {

        // Key == nums1[..]; Value == NGN if exists
        Map<Integer, Integer> map = new HashMap<>();
        // Monotonic decreasing sub-sequence
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {

            // Remove right-most numbers, SMALLER than "num"
            while (!stack.isEmpty() && num > stack.peek()) {

                // Map the SMALLER numbers
                // with their NGN [="num"]
                map.put(stack.pop(), num);
            }

            stack.push(num);
        }

        for (int index = 0; index < nums1.length; index++) {

            nums1[index] = map.getOrDefault(nums1[index], -1);
        }

        return nums1;
    }
}