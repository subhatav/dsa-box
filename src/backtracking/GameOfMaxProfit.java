package backtracking;

// Problem Link: https://leetcode.com/problems/predict-the-winner/
// Solution Link: https://leetcode.com/problems/predict-the-winner/solutions/96838/java-1-line-recursive-solution-o-n-2-time-and-o-n-space/

// Approach #1: W/o Cache Technique; Time Complexity: O(2^N), Space Complexity: O(N)
// Reason #1: EACH Node can have 2 Children, therefore Time Complexity becomes O(2^N)

// Approach #2: With Cache Technique; Time Complexity: O(N^2), Space Complexity: O(N)
// Reason #2: All (index * index) Combos are COMPUTED, while OTHERs are CACHED in DP

public class GameOfMaxProfit {

    public boolean compute(int[] nums) {

        int purse, size = nums.length;

        // Pointer "beg" == Marks the START of the remaining Coins;
        // Pointer "end" == Marks the FINISH of the remaining Coins
        purse = play(new Integer[size][size], nums, 0, size - 1);

        return purse >= 0; // Return WHETHER First Player WILL Profit
    }

    private int play(Integer[][] status, int[] nums, int beg, int end) {

        // Check IF Chance NOT Cached
        if (status[beg][end] == null) {

            // Verify IF there is NO Choice to PICK Coin
            if (beg == end) status[beg][end] = nums[beg];

            else {

                // Change in Profit when the LEFT-MOST Coin is CHOSEN
                int left = nums[beg] - play(status, nums, beg + 1, end);
                // Change in Profit when the RIGHT-MOST Coin is CHOSEN
                int right = nums[end] - play(status, nums, beg, end - 1);

                // PICK the BEST of the 2-Possible COINS
                status[beg][end] = Math.max(left, right);
            }
        }

        // Return CACHED Profit
        return status[beg][end];
    }
}