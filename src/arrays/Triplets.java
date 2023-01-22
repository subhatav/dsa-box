package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LeetCode Link : https://leetcode.com/problems/3sum/

// Approach #1 : Brute Force; Time Complexity : O(N^3)
// Approach #2 : Sort + N * Pair Sum; Time Complexity : O(NlogN + N^2) = O(N^2)

public class Triplets {

    public List<List<Integer>> compute(int[] nums) {

        Arrays.sort(nums);

        int capacity = nums.length;

        List<List<Integer>> triplets = new ArrayList<>();

        for (int index = 0; index < capacity - 2; index++) {

            int num = nums[index];

            if (index > 0 && num == nums[index - 1]) continue;

            int left = index + 1, right = capacity - 1;

            while (left < right) {

                int sum = num + nums[left] + nums[right];

                if (sum > 0) right--;
                else if (sum < 0) left++;

                else if (sum == 0) {

                    triplets.add(Arrays.asList(num, nums[left++], nums[right--]));

                    while (nums[left] == nums[left - 1] && left < right) left++;
                }
            }
        }

        return triplets;
    }
}