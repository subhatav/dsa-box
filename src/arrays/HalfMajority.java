package arrays;

// Problem Link: https://leetcode.com/problems/majority-element/
// Solution Link: https://takeuforward.org/data-structure/find-the-majority-element-that-occurs-more-than-n-2-times/

// Approach #1: Brute Force; Time Complexity: O(N^2)
// Approach #2: Sorting & Finding Middle Element; Time Complexity: O(NlogN)
// Approach #3: Insert in HashMap & Check; Time Complexity: O(N)
// Approach #4: Boyer-Moore Majority Voting Algorithm; Time Complexity: O(N)

public class HalfMajority {

    public int compute(int[] nums) {

        int count = 0, major = 0;

        for (int num : nums) {

            // Since the Majority Element WILL occur more than (N / 2) times,
            // there is guaranteed chance that the Majority Element will occur
            // in AT LEAST two Consecutive Indices in the Array provided; so
            // the value of the Frequency Variable will become more than one

            if (count == 0) major = num;

            if (num == major) count += 1;
            else count -= 1;
        }
        
        count = 0; // Reset the Frequency Variable to zero

        for (int num : nums) if (num == major) count += 1;

        return (count > (nums.length / 2)) ? major : -1;
    }
}