package arrays;

// Problem Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
// Solution Link: https://leetcode.com/problems/largest-rectangle-in-histogram/solutions/28902/5ms-O(n)-Java-solution-explained-(beats-96)/

// Approach #1: Brute Force; Time Complexity: O(N^2), Space Complexity: O(1)
// Approach #2: Prefix Sums Technique; Time Complexity: O(N * 3), Space Complexity: O(N * 2)

public class LargestRectangle {

    public int compute(int[] heights) {

        int answer = 0, distance = heights.length;

        // Array "lefts[]" == First-Indices for h[left] < h[index];
        // Array "rights[]" == First-Indices for h[right] < h[index]
        int[] lefts = new int[distance], rights = new int[distance];

        lefts[0] = -1;

        for (int index = 1; index < distance; index += 1) {

            int last = index - 1, height = heights[index];

            // Array "lefts[]" has Indices of the Previous Smaller Numbers
            while (last >= 0 && height <= heights[last]) last = lefts[last];

            lefts[index] = last;
        }

        rights[distance - 1] = distance;

        for (int index = distance - 2; index >= 0; index -= 1) {

            int last = index + 1, height = heights[index];

            // Array "rights[]" contains the Indices of the Next Smaller Numbers
            while (last < distance && height <= heights[last]) last = rights[last];

            rights[index] = last;
        }

        for (int index = 0; index < heights.length; index += 1) {

            int height = heights[index], width = rights[index] - lefts[index] - 1;

            answer = Math.max(answer, height * width);
        }

        return answer;
    }
}