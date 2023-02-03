package arrays;

import java.util.Arrays;
import java.util.Comparator;

// Problem Link: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

// Approach: Sort, Check if Overlapping & Count when NOT so; Time Complexity: O(NlogN + N) = O(NlogN)

public class MinimumArrows {

    public int compute(int[][] points) {

        // Sort all the Balloons by their end positions
        Arrays.parallelSort(points, Comparator.comparingInt(pair -> pair[1]));

        int arrows = 1, last = points[0][1], size = points.length;

        for (int index = 1; index < size; index++) {

            // Check if the last Balloon is overlapping the current Balloon
            if (last >= points[index][0]) continue;

            // Increment the number of Arrows required when not overlapping
            arrows += 1;
            last = points[index][1];
        }

        return arrows;
    }
}