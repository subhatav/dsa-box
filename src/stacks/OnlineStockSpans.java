package stacks;

import java.util.ArrayList;
import java.util.Stack;

// LeetCode Link: https://www.codingninjas.com/codestudio/problems/span-of-ninja-coin_1475049
// Solution Link: https://www.youtube.com/watch?v=29Jn5xPGJHg

// Approach #1: Brute Force; Time Complexity: O(N^2)
// Approach #2: Stack LIFO Technique; Time Complexity: O(N)

public class OnlineStockSpans {

    public static ArrayList<Integer> compute(ArrayList<Integer> prices) {

        ArrayList<Integer> spans = new ArrayList<>();
        Stack<Integer> range = new Stack<>();

        for (int index = 0; index < prices.size(); index++) {

            int current = prices.get(index);

            // Remove right-most prices which are SMALLER than "price[i]"
            while (!range.empty() && current >= prices.get(range.peek()))
                range.pop();

            if (range.empty()) spans.add(index + 1);
            else spans.add(index - range.peek());

            range.push(index);
        }

        return spans;
    }
}