package arrays;

import java.util.Arrays;

// Problem Link: https://leetcode.com/problems/3sum-closest/
// Solution Link: https://leetcode.com/problems/3sum-closest/solutions/7883/c-solution-o-n-2-using-sort/

// Approach #1: Brute Force; Time Complexity: O(N^3)
// Approach #2: Sort & (N * Pair Sum); Time Complexity: O(NlogN + N^2) = O(N^2)

public class ClosestSumTriad {

    public int compute(int[] nums, int target) {

        int max = nums[0] + nums[1] + nums[2];

        int size = nums.length;

        Arrays.sort(nums);

        for (int index = 0; index < size - 2; index += 1) {

            int left = index + 1, right = size - 1;

            int num = nums[index];

            if (index > 0 && num == nums[index - 1]) continue;

            while (left < right) {

                int sum = num + nums[left] + nums[right];

                int closest = Math.abs(target - max);
                int current = Math.abs(target - sum);

                if (closest > current) max = sum;

                if (sum > target) right -= 1;
                else if (sum < target) left += 1;

                else return target;
            }
        }

        return max;
    }
}