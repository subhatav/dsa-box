package greedy;

// Problem Link: https://leetcode.com/problems/maximum-swap/
// Solution Link: https://leetcode.com/problems/maximum-swap/solutions/107068/java-simple-solution-o-n-time/

// Approach: Use BUCKETS to Store INDICES of All DIGITS; Time Complexity: O(N)

public class SwapForLargest {

    public int compute(int num) {

        String number = String.valueOf(num);
        char[] digits = number.toCharArray();

        int digit, top = 9, bucket;
        int size = digits.length;

        int[] buckets = new int[10];

        // Save the LAST Indices of EACH Number [0-9]
        for (int index = 0; index < size; index += 1) {

            digit = digits[index] - '0';

            buckets[digit] = index;
        }

        // Kick off CHECKING from the M.S.B. of "num"
        for (int index = 0; index < size; index += 1) {

            digit = digits[index] - '0'; // CURRENT Digit

            // LOOP for Digits GREATER than CURRENT Digit
            for (int mark = top; mark > digit; mark -= 1) {

                bucket = buckets[mark]; // Get LAST Index

                if (bucket > index) {

                    // Do SWAP the Digits ONCE
                    char backup = digits[index];
                    digits[index] = digits[bucket];
                    digits[bucket] = backup;

                    String largest = new String(digits);

                    return Integer.valueOf(largest);
                }
            }

            // If the SWAP is NOT done, it MEANS there is
            // NO Digit GREATER than the [CURRENT] Digit;
            // hence, record the MAXIMUM Digit into "top"
            top = digit;
        }

        return num; // Return "num" when there is NO Swap
    }
}