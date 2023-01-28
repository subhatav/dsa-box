package stacks;

import java.util.Stack;

// LeetCode Link: https://leetcode.com/problems/valid-parentheses/
// Solution Link: https://www.youtube.com/watch?v=3gqYc56p9qU&t=309s

// Approach: Odd Length Check + Stack LIFO Technique; Time Complexity: O(N)

public class ValidParentheses {

    public boolean compute(String expression) {

        Stack<Character> parentheses = new Stack<>();

        if (expression.length() % 2 == 1) return false;

        for (char parenthesis : expression.toCharArray()) {

            if (parenthesis == '(') parentheses.push(')');
            else if (parenthesis == '{') parentheses.push('}');
            else if (parenthesis == '[') parentheses.push(']');
            
            else if (parentheses.empty()) return false;
            else if (parentheses.pop() != parenthesis) return false;
        }
        
        return parentheses.empty();
    }
}