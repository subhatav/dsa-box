package greedy;

import java.util.ArrayList;
import java.util.List;

// Problem Link: https://leetcode.com/problems/insert-interval/
// Solution Link: https://www.youtube.com/watch?v=A8NUOmlwOlM

// Approach: Follow Solution Link; Time Complexity: O(N)

public class InsertInterval {
    
    public int[][] insert(int[][] intervals, int[] injected) {

        List<int[]> results = new ArrayList<>();

        for (int[] interval : intervals) {

            // Check if the Injected Interval starts
            // AFTER the End of the Current Interval
            if (injected == null || interval[1] < injected[0]) {

                results.add(interval);

            // Check when the Current Interval starts
            // AFTER the End of the Injected Interval
            } else if (interval[0] > injected[1]) {

                results.add(injected);
                results.add(interval);

                injected = null;

            } else { // Merge/Extend with the Injected Interval

                injected[0] = Math.min(injected[0], interval[0]);
                injected[1] = Math.max(injected[1], interval[1]);
            }
        }

        if (injected != null) results.add(injected);

        return results.toArray(new int[results.size()][2]);
    }
}