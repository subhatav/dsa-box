package searching;

// Problem Link: https://leetcode.com/problems/sqrtx/
// Solution Link: https://leetcode.com/problems/sqrtx/solutions/25198/3-java-solutions-with-explanation/

// Approach: Find CRITICAL Point for SQUARE Root; Time Complexity: O(N)
// Checks for Critical Point: [ (i * i) <= x && (i + 1) * (i + 1) > x ]

public class SearchSquareRoot {

    public int compute(int num) {

        if (num == 0) return num;

        int low = 1, high = num;

        while (low < high) {

            int mid = low + (high - low) / 2;

            // Do the FIRST Condition Check
            if (mid > num / mid) high = mid;

            else {

                low = mid + 1;

                // Do the LAST Check
                if (low > num / low) {

                    return mid;
                }
            }
        }

        return high; // NEAREST Root
    }
}
