package stacks;

import java.util.Stack;

// Problem Link: https://leetcode.com/problems/simplify-path/

// Approach: Stack LIFO Technique; Time Complexity: O(N)

public class SimplifyUnixPath {

    public String compute(String path) {

        String[] segments = path.split("/");
        Stack<String> elements = new Stack<>();

        for (String segment : segments) {

            if (segment.isEmpty()) continue;
            if (segment.equals(".")) continue;
            
            if (segment.equals("..")) {

                if (!elements.isEmpty()) elements.pop();

            } else elements.push(segment);
        }

        return "/".concat(String.join("/", elements));
    }
}