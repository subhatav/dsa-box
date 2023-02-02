package arrays;

// Problem Link: https://leetcode.com/problems/trapping-rain-water/

// Approach #1: Brute Force; Time Complexity: O(N^2)
// Approach #2: Maxes by DP & (Min-of-Maxes minus Current); Time Complexity: O(N)
// Approach #3: Min-Max with 2-Pointers; Time Complexity: O(N)

public class TrapRainWater {

    public int compute(int[] heights) {

        int water = 0, distance = heights.length;
        int leftBar = 0, rightBar = distance - 1;

        int leftMax = heights[leftBar];
        int rightMax = heights[rightBar];

        if (distance <= 2) return water;

        while (leftBar < rightBar) {

            if (leftMax < rightMax) {

                water += leftMax - heights[leftBar++];

                leftMax = Math.max(leftMax, heights[leftBar]);

            } else {

                water += rightMax - heights[rightBar--];

                rightMax = Math.max(rightMax, heights[rightBar]);
            }
        }

        return water;
    }
}