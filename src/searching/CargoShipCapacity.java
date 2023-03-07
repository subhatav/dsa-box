package searching;

// Problem Link: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
// Solution Link: https://leetcode.com/problems/magnetic-force-between-two-balls/solutions/794176/java-binary-search/

// Approach: Binary Search & Fitting Technique; Time Complexity: O(NlogN)

public class CargoShipCapacity {

    public int compute(int[] weights, int days) {

        int low = 0, high = 0, optimal = -1;

        // Search SPACE begins with
        // the MAXIMUM Weight; and,
        // ends with the SUM of ALL
        for (int weight : weights) {

            low = Math.max(low, weight);
            high += weight;
        }

        if (weights.length == days) return low;

        while (low <= high) {

            int mid = (low + high) >>> 1;

            // MINIMIZE the OPTIMAL Capacity
            if (fit(weights, mid) <= days) {

                optimal = mid;
                high = mid - 1;

            } else low = mid + 1;
        }

        return optimal;
    }

    private int fit(int[] weights, int mid) {

        // Set in the FIRST Day
        int count = 1, size = 0;

        for (int weight : weights) {

            // Check & Consume NEW Day
            if (size + weight > mid) {

                count += 1;
                size = 0;
            }

            // Load Weight
            size += weight;
        }

        return count; // Count of DAYS
    }
}