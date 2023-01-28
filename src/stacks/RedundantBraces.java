package stacks;

import java.util.Stack;

// LeetCode Link: https://www.interviewbit.com/problems/redundant-braces/

// Approach: Stack LIFO Technique & Operator Check; Time Complexity: O(N)

public class RedundantBraces {
    
    public boolean compute(String expression) {

        Stack<Character> braces = new Stack<>();
        
        for (char operand : expression.toCharArray()) {

            if (operand != ')') braces.push(operand);
            
            else {
                
                boolean found = false;

                while (!braces.empty() && braces.peek() != '(') {

                    char operator = braces.pop();

                    if (operator == '+' || operator == '-' ||
                        operator == '*' || operator == '/') found = true;
                }

                braces.pop();

                // If none of the [+,-,*,/] operators are found,
                // then it implies a redundant brace is present
                if (!found) return true;
            }
        }

        return false;
    }
}