package greedy;

import java.util.Arrays;

// Problem Link: https://www.codingninjas.com/codestudio/problems/job-sequencing-problem_1169460
// Solution Link: https://takeuforward.org/data-structure/job-sequencing-problem/

// Time Complexity: O(Nlog N + (N * M)); Space Complexity: O(N)

public class JobSequencing {

    public int compute(int[][] jobs) {

        // Sort ALL the Jobs in Non-increasing Order w.r.t. their Profits
        Arrays.sort(jobs, (now, then) -> Integer.compare(then[1], now[1]));

        int profit = 0, size = jobs.length;
        boolean[] days = new boolean[size];

        for (int job = 0; job < size; job += 1) {

            int deadline = Math.min(size, jobs[job][0]);

            // Try to do Jobs on their Last Day of Deadline
            for (int day = deadline - 1; day >= 0; day -= 1) {

                // Check if Day is Free
                if (days[day] == false) {

                    // Occupy the Day
                    days[day] = true;
                    profit += jobs[job][1];

                    break;
                }
            }
        }

        return profit;
    }
}