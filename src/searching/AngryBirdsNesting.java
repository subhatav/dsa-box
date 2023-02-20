package searching;

import java.util.Arrays;

// Problem Link: https://leetcode.com/problems/magnetic-force-between-two-balls/
// Solution Link: https://leetcode.com/problems/magnetic-force-between-two-balls/solutions/794176/java-binary-search/

// Approach: Binary Search & Placing Technique; Time Complexity: O(NlogN)

public class AngryBirdsNesting {

    public int compute(int[] nests, int birds) {

        Arrays.sort(nests);

        int space = nests[nests.length - 1] - nests[0];
        int low = 0, high = space / (birds - 1);

        int optimal = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // MAXIMIZE the OPTIMAL Space
            if (place(nests, birds, mid)) {

                optimal = mid;
                low = mid + 1;

            } else high = mid - 1;
        }

        return optimal;
    }

    private boolean place(int[] nests, int birds, int gap) {

        // Nest the FIRST Bird at START
        int count = 1, last = nests[0];

        for (int current : nests) {

            // Place the Bird, when the
            // MINIMAL Gap is satisfied
            if (current - last >= gap) {

                count += 1;

                // Return if ALL Birds are DONE
                if (count == birds) return true;

                last = current;
            }
        }

        return false;
    }
}