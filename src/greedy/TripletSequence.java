package greedy;

// Problem Link: https://leetcode.com/problems/increasing-triplet-subsequence/
// Solution Link: https://leetcode.com/problems/increasing-triplet-subsequence/solutions/79004/concise-java-solution-with-comments/

// Approach: MAINTAIN "i" and "j", BREAK when "k" is FOUND; Time Complexity: O(N)

public class TripletSequence {

    public boolean compute(int[] numbers) {

        int first = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;

        for (int number : numbers) {

            if (number <= first) first = number;
            else if (number <= middle) middle = number;
            else return true; // Return if "k" is FOUND
        }

        return false; // Return when "k" is NOT Present
    }
}
