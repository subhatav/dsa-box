package backtracking;

import java.util.ArrayList;
import java.util.List;

// Problem Link: https://leetcode.com/problems/generate-parentheses/
// Solution Link: https://leetcode.com/problems/generate-parentheses/solutions/10100/easy-to-understand-java-backtracking-solution/

public class BraceCombinations {

    public List<String> compute(int pairs) {

        List<String> combinations = new ArrayList<>();

        // Generate ALL the Permissible Combinations from an Empty Expression
        backtrack(combinations, "", pairs, 0, 0);

        return combinations;
    }

    public void backtrack(List<String> combinations, String expression, int pairs, int opening, int closing) {

        // Include the Expression to Results when ALL Brace Pairs are consumed
        if ((expression.length() / 2.0) == pairs) combinations.add(expression);

        else {

            // Include an Opening Brace ONLY if the Count of the Same is less than FREE Opening Braces
            if (opening < pairs) backtrack(combinations, expression + "(", pairs, opening + 1, closing);
            // Include a Closing Brace ONLY if the Count of the Same is less than DEPLOYED Opening Braces
            if (closing < opening) backtrack(combinations, expression + ")", pairs, opening, closing + 1);
        }
    }
}