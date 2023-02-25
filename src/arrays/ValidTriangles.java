package arrays;

import java.util.Arrays;

// Problem Link: https://leetcode.com/problems/valid-triangle-number/
// Solution Link: https://leetcode.com/problems/valid-triangle-number/solutions/104169/java-solution-3-pointers/

// Approach: Traverse & Compare with 2-Pointers; Time Complexity: O(N^2)

public class ValidTriangles {

    public int compute(int[] nums) {

        int index = 1, count = 0;

        int size = nums.length;

        if (size < 3) return count;

        // SORT the SIDES
        Arrays.sort(nums);

        while ((index += 1) < size) {

            // Initiate the TWO Extremities
            int left = 0, right = index - 1;

            while (left < right) {

                int sum = nums[left] + nums[right];

                if (sum > nums[index]) {

                    count += (right - left);

                    right -= 1; // NEXT Side

                } else left += 1; // RECITFY
            }
        }

        return count;
    }
}