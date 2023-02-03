package stacks;

import java.util.Stack;

// Problem Link: https://leetcode.com/problems/valid-parenthesis-string/
// Solution Link: https://leetcode.com/problems/valid-parenthesis-string/solutions/107572/java-using-2-stacks-o-n-space-and-time-complexity/

// Approach: Run two Stacks in LIFO Technique; Time Complexity: O(N)

public class ValidStringBraces {

    public boolean compute(String str) {

        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();

        int size = str.length();

        for (int index = 0; index < size; index++) {

            char ch = str.charAt(index);

            if (ch == '(') left.push(index);
            else if (ch == '*') star.push(index);

            else {

                if (!left.empty()) left.pop();
                else if (!star.empty()) star.pop();
                else return false;
            }
        }

        while (left.size() > 0 && star.size() > 0) {

            // For the negative possibility, when the
            // Left Brace arrives AFTER the Star Sign
            if (left.pop() > star.pop()) return false;
        }

        return left.empty();
    }
}