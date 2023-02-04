package greedy;

import java.util.Arrays;

// Problem Link: https://www.codingninjas.com/codestudio/problems/975286
// Solution Link: https://takeuforward.org/data-structure/fractional-knapsack-problem-greedy-approach/

// Approach: Sort according Value per Weight ratio & Use Fractional Knapsack Technique
// Time Complexity: O(NlogN), Space Complexity: O(1) or O(N) depending on Sorting Algorithm

public class FractionalKnapsack {

    static class Pair {

        int weight, value;

        Pair(int weight, int value) {

            this.weight = weight;
            this.value = value;
        }
    }

    public double compute(Pair[] items, int units, int capacity) {

        Arrays.parallelSort(items, (now, then) -> {

            return (then.value * now.weight) - (now.value * then.weight);
        });

        double profit = 0;

        for (Pair item : items) {

            int weight = item.weight;
            int value = item.value;

            if (capacity >= weight) {

                profit += value;
                capacity -= weight;

            } else {

                double ratio = (double) value / (double) weight;

                return profit + (capacity * ratio);
            }
        }

        return profit;
    }
}