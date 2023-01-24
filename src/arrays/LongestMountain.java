package arrays;

// LeetCode Link: https://leetcode.com/problems/longest-mountain-in-array/

// Approach: Traverse & Check Validity & Record Distance; Time Complexity: O(N)

public class LongestMountain {
    
    public int compute(int[] nums) {
        
        int index = 0, result = 0, distance = nums.length;

        while (distance >= 3 && index < distance) {

            int base = index;

            // Climb up the Mountain side
            while (index + 1 < distance && nums[index] < nums[index + 1]) {

                index += 1;
            }

            // Check validity of the Base point
            if (index == base) {

                index += 1;
                continue;
            }

            int peak = index;

            // Roll down the Mountain side
            while (index + 1 < distance && nums[index] > nums[index + 1]) {

                index += 1;
            }

            // Check validity of the Peak point
            if (index == peak) {

                index += 1;
                continue;
            }

            // Update the maximum Distance
            result = Math.max(result, index - base + 1);
        }

        return result;
    }
}