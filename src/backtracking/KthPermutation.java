package backtracking;

import java.util.ArrayList;
import java.util.List;

// Problem Link: https://leetcode.com/problems/permutation-sequence/
// Solution Link: https://www.youtube.com/watch?v=wT7gcXLYoao&t=2s

// Approach #1: Use Backtracking Technique; Time Complexity: O(N! * N + NlogN)
// Approach #2: Follow Solution Link; Time Complexity: O(N^2), Space Complexity: O(N)

public class KthPermutation {

    public String compute(int n, int k) {

        StringBuilder ans = new StringBuilder();
        List<Integer> nums = new ArrayList<>();

        int fact = 1;

        for (int num = 1; num <= n; num++) {

            fact *= num;
            nums.add(num);
        }

        k -= 1; // Convert to 0-based Index

        while (!nums.isEmpty()) {

            fact /= nums.size();

            // Index == "k" / Fact. [n - 1]
            ans.append(nums.remove(k / fact));

            // Find the NEXT "k", i.e. K-th
            // Permutation Sequence for the
            // rest of the Numbers from "n"
            k %= fact;
        }

        return ans.toString();
    }
}