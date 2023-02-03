package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Problem Link: https://leetcode.com/problems/merge-intervals/

// Approach: Sort, Check if Overlapping & Merge/Extend accordingly; Time Complexity: O(NlogN + N) = O(NlogN)

public class OverlapIntervals {

    public int[][] compute(int[][] intervals) {

        // Sort all the Intervals in Ascending Order w.r.t. their Start Positions
        Arrays.parallelSort(intervals, Comparator.comparingInt(interval -> interval[0]));

        List<int[]> results = new ArrayList<>();

        int[] merged = intervals[0];
        results.add(merged);

        for (int[] current : intervals) {

            if (merged[1] >= current[0])

                // If the Intervals are overlapping,
                // extend the current End Position
                merged[1] = Math.max(merged[1], current[1]);

            else {

                // If the Intervals are disjoint,
                // add the new Interval to the Results
                merged = current;
                results.add(merged);
            }
        }

        return results.toArray(new int[results.size()][2]);
    }
}