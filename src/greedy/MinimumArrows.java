package greedy;

import java.util.Arrays;
import java.util.Comparator;

// Problem Link: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

// Approach: Sort, Check if Overlapping & Count when NOT so; Time Complexity: O(NlogN + N) = O(NlogN)

public class MinimumArrows {

    public int compute(int[][] points) {

        // Sort all the Balloons in Ascending Order w.r.t. their End Positions
        Arrays.parallelSort(points, Comparator.comparingInt(pair -> pair[1]));

        int arrows = 1, previous = 0, size = points.length;

        for (int current = 1; current < size; current += 1) {

            // Verify if the current Balloon is NOT
            // overlapping with the current Balloon
            if (points[previous][1] < points[current][0]) {

                arrows += 1;
                previous = current;
            }
        }

        return arrows;
    }
}