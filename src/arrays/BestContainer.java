package arrays;

// Problem Link: https://leetcode.com/problems/container-with-most-water/
// Solution Link: https://www.youtube.com/watch?v=UuiTKBwPgAo

// Approach #1: Brute Force; Time Complexity: O(N^2)
// Approach #2: Min-Max with 2-Pointers; Time Complexity: O(N)

public class BestContainer {

    public int compute(int[] heights) {

        int maxArea = 0, leftBar = 0, rightBar = heights.length - 1;

        while (leftBar < rightBar) {

            int currLeft = heights[leftBar], currRight = heights[rightBar];

            // Determine the Current Area from the Distance between the Bars,
            // multiplied with the Minimum Height of the Left and Right Bars
            int currArea = (rightBar - leftBar) * Math.min(currLeft, currRight);

            maxArea = Math.max(maxArea, currArea);

            if (currLeft < currRight) {

                // Move "leftBar" FORWARD, when Future Height is SMALLER
                while (leftBar < rightBar && currLeft >= heights[leftBar]) {

                    leftBar += 1;
                }

            } else {

                // Move "rightBar" BACKWARD, when Future Height is SMALLER
                while (leftBar < rightBar && currRight >= heights[rightBar]) {

                    rightBar -= 1;
                }
            }
        }

        return maxArea;
    }
}