package greedy;

import java.util.Arrays;

// Problem Link: https://leetcode.com/problems/maximum-units-on-a-truck/
// Solution Link: https://leetcode.com/problems/maximum-units-on-a-truck/solutions/1271374/js-python-java-c-simple-sort-solution-w-explanation/

// Approach: Sort according to Units & Use Greedy Knapsack Technique
// Time Complexity: O(NlogN), Space Complexity: O(1) or O(N) depending on Sorting Algorithm

public class MostProfitBoxes {
    
    public int compute(int[][] boxTypes, int truckSize) {

        // Sort ALL the Box types in Non-increasing Order w.r.t. their Units
        Arrays.sort(boxTypes, (now, then) -> Integer.compare(then[1], now[1]));

        int totalUnits = 0;

        // Run loop for EACH Box type
        for (int[] boxType : boxTypes) {

            if (boxType[0] <= truckSize) {

                // Consider ALL the Boxes available
                totalUnits += boxType[0] * boxType[1];
                truckSize -= boxType[0];

            } else {

                // Take Fraction of Boxes available
                totalUnits += truckSize * boxType[1];

                break; // Stop looping next Box types
            }
        }

        return totalUnits;
    }
}