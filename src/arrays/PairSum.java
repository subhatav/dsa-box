package arrays;

import java.util.HashMap;
import java.util.Map;

// LeetCode Link : https://leetcode.com/problems/two-sum/

public class PairSum {

    public int[] compute(int[] nums, int target) {

        Map<Integer, Integer> counter = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {

            int diff = target - nums[index];

            if (counter.containsKey(diff)) {

                return new int[] { counter.get(diff), index };
            }

            counter.put(nums[index], index);
        }

        return null;
    }
}