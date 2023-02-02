package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Problem Link: https://leetcode.com/problems/3sum/

// Approach #1: Brute Force; Time Complexity: O(N^3)
// Approach #2: Sort & (N * Pair Sum); Time Complexity: O(NlogN + N^2) = O(N^2)

public class Triplets {

    public List<List<Integer>> compute(int[] nums) {

        List<List<Integer>> triplets = new ArrayList<>();

        int size = nums.length;

        Arrays.sort(nums);

        for (int index = 0; index < size - 2; index++) {

            int left = index + 1, right = size - 1;

            int num = nums[index];

            if (index > 0 && num == nums[index - 1]) continue;

            while (left < right) {

                int sum = num + nums[left] + nums[right];

                if (sum < 0) left += 1;
                else if (sum > 0) right -= 1;

                else {

                    triplets.add(Arrays.asList(num, nums[left++], nums[right--]));

                    while (left < right && nums[left - 1] == nums[left]) left += 1;
                }
            }
        }

        return triplets;
    }
}