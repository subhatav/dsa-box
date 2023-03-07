package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Problem Link: https://leetcode.com/problems/pascals-triangle/

// Approach: Add Elements of last Row as Required; Time Complexity: O(N * N/2) = O(N^2)

public class PascalTriangle {

    public List<List<Integer>> compute(int numRows) {

        List<List<Integer>> rows = new ArrayList<List<Integer>>();
        List<Integer> last = new ArrayList<Integer>();

        // Add the first Row (= 1)
        last.add(1);
        rows.add(new ArrayList<Integer>(last));

        for (int row = 1; row < numRows; row += 1) {

            List<Integer> curr = new ArrayList<Integer>();
            List<Integer> half = new ArrayList<Integer>();

            int mid = row / 2, rem = row % 2;

            // Add the first Element (= 1)
            curr.add(1);

            // Run the Loop for half-length of the Row
            for (int col = 1; col < mid + rem; col += 1) {

                curr.add(last.get(col - 1) + last.get(col));
            }

            // Copy the current half Row and inverse it
            half.addAll(curr);
            Collections.reverse(half);

            // Set the Middle Element for the even-indexed Rows
            if (rem == 0) curr.add(last.get(mid - 1) + last.get(mid));

            // Add the inversed Row to the current Row
            curr.addAll(half);
            rows.add(new ArrayList<Integer>(curr));

            // Update the last Row with the current Row
            last = curr;
        }

        return rows;
    }
}