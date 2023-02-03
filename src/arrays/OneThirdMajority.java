package arrays;

import java.util.ArrayList;
import java.util.List;

// Problem Link: https://leetcode.com/problems/majority-element-ii/
// Solution Link: https://takeuforward.org/data-structure/majority-elementsn-3-times-find-the-elements-that-appears-more-than-n-3-times-in-the-array/

// Approach #1: Brute Force; Time Complexity: O(N^2)
// Approach #2: Insert in HashMap & Check; Time Complexity: O(N)
// Approach #3: Extended Boyer-Moore Majority Voting Algorithm; Time Complexity: O(N)

public class OneThirdMajority {

    public List<Integer> compute(int[] nums) {

        List<Integer> result = new ArrayList<>();

        // If N numbers and K counters are given,
        // (maximum) number of Pairs <= N/(K + 1)

        int count1 = 0, major1 = 0;
        int count2 = 0, major2 = 0;

        for (int num : nums) {

            if (num == major1) count1 += 1;
            else if (num == major2) count2 += 1;

            else if (count1 == 0) {

                major1 = num;
                count1 = 1;
            }
            
            else if (count2 == 0) {

                major2 = num;
                count2 = 1;
            }

            else { count1 -= 1; count2 -= 1; }
        }

        count1 = count2 = 0;

        for (int num : nums) {

            if (num == major1) count1 += 1;
            else if (num == major2) count2 += 1;
        }

        if (count1 > (nums.length / 3)) result.add(major1);
        if (count2 > (nums.length / 3)) result.add(major2);

        return result;
    }
}