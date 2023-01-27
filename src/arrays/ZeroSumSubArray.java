package arrays;

import java.util.HashMap;
import java.util.Map;

// GeeksForGeeks Link: https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
// Solution Link: https://takeuforward.org/data-structure/length-of-the-longest-subarray-with-zero-sum/

// Approach #1: Brute Force; Time Complexity: O(N^2), Space Complexity: O(1)
// Approach #2: Prefix Sum Technique; Time Complexity: O(N), Space Complexity: O(N)

public class ZeroSumSubArray {
    
    public int compute(int nums[], int length) {
        
        // Key == Prefix Sum; Value == Current Index
        Map<Integer, Integer> prefixes = new HashMap<>();

        int sum = 0, result = 0;

        for (int index = 0; index < length; index++) {

            int num = nums[index];

            if (num == 0 && result == 0) result = 1;
            else sum += num;
            
            if (sum == 0) result = index + 1;

            if (!prefixes.containsKey(sum)) prefixes.put(sum, index);
            else result = Math.max(result, index - prefixes.get(sum));
        }

        return result;
    }
}