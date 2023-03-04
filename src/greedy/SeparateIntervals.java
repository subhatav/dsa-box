package greedy;

import java.util.Arrays;
import java.util.Comparator;

// Problem Link: https://leetcode.com/problems/non-overlapping-intervals/

// Approach: Sort, Check if Overlapping & Count when NOT so; Time Complexity: O(NlogN + N) = O(NlogN)

public class SeparateIntervals {

    public int compute(int[][] intervals) {

        // Sort all the Balloons in Ascending Order w.r.t. their End Positions
        Arrays.parallelSort(intervals, Comparator.comparingInt(pair -> pair[1]));

        int overlapped = 1, previous = 0, size = intervals.length;

        for (int current = 1; current < size; current += 1) {

            // Verify if the current Interval is NOT
            // overlapping with the current Interval
            if (intervals[previous][1] <= intervals[current][0]) {

                overlapped += 1;
                previous = current;
            }
        }

        return size - overlapped;
    }
}