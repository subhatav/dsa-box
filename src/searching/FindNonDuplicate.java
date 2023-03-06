package searching;

// Problem Link: https://leetcode.com/problems/single-element-in-a-sorted-array/
// Solution Link: https://leetcode.com/problems/single-element-in-a-sorted-array/solutions/627921/java-c-python3-easy-explanation-o-logn-o-1/

// Approach #1: Brute Force; Time Complexity: O(N)
// Approach #2: Binary Search; Time Complexity: O(logN)

/*
    <Target> First Index whose "Partner Index" [= Index XOR 1] holds a DIFFERENT Number.
    <Couples> First Number occurs at EVEN Index; Second Number occurs at ODD Index.
    <Disturbance> This PATTERN will be MISSED when a SINGLE Number appears in the Array.
    <Intuition> Focus AWAY from that HALF of the Array which has the Pattern MAINTAINED.
    <Method> Number XOR 1 == Flips the Least Significant Bit of the operand Number.
    <Inference> LSB becomes 0 from 1 == Subtracted 1; LSB becomes 1 from 0 == Added 1.
    <Application> Odd Number XOR 1 = Odd Number - 1; Even Number XOR 1 = Even Number + 1.
*/

public class FindNonDuplicate {

    public int compute(int[] nums) {

        int low = 0, high = nums.length - 1;

        while (low <= high) {

            int mid = (low + high) >>> 1;

            // Check if the Number at "mid"
            // is a DUPLICATE in the "nums"
            // i.e., Condition for PATTERN
            if (nums[mid] == nums[mid ^ 1]) {

                low = mid + 1;

            } else high = mid - 1;
        }

        return nums[low]; // SAME as "nums[high]", since the Indices are EQUAL
    }
}