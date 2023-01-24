package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// GeeksForGeeks Link: https://practice.geeksforgeeks.org/problems/minimum-swaps/1

// Approach: Sort & Compare Both Arrays; Time Complexity: O(N + NlogN + N) = O(NlogN)

public class MinimumSwaps {

    public int minSwaps(int[] nums) {

        int swaps = 0;
        int size = nums.length;
        int[] cloned = nums.clone();

        Arrays.sort(cloned);

        // Store the sorted elements and their indices
        Map<Integer, Integer> sorted = new HashMap<>();

        for (int index = 0; index < size; index++) {

            sorted.put(cloned[index], index);
        }

        for (int index = 0; index < size; index++) {

            // Detect the cycle formed between elements to be swapped;
            // Traverse the cycle until the starting index is reached
            while (sorted.get(nums[index]) != index) {

                swaps++;

                // Swap the two elements
                int temp = nums[index];
                nums[index] = nums[sorted.get(temp)];
                nums[sorted.get(temp)] = temp;
            }
        }

        return swaps;
    }
}