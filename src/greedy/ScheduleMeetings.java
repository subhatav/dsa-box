package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Problem Link: https://www.codingninjas.com/codestudio/problems/1062658
// Solution Link: https://takeuforward.org/data-structure/n-meetings-in-one-room/

// Approach: Sort, Check if Overlapping & Add when NOT so; Time Complexity: O(N + NlogN + N) = O(NlogN)

public class ScheduleMeetings {
    
    public static List<Integer> maximumMeetings(int[] start, int[] finish) {

        List<Integer> result = new ArrayList<>();

        int previous = -1, size = finish.length;
        int[][] meets = new int[size][3];

        for (int time = 0; time < size; time++) {

            meets[time][0] = time + 1;
            meets[time][1] = start[time];
            meets[time][2] = finish[time];
        }

        Arrays.sort(meets, Comparator.comparingInt(meet -> meet[2]));

        for (int index = 0; index < size; index++) {

            if (previous < meets[index][1]) {

                result.add(meets[index][0]);
                previous = meets[index][2];
            }
        }

        return result;
    }
}