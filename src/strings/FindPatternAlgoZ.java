package strings;

// Problem Link: https://www.codingninjas.com/codestudio/problems/1112619
// Solution Link: https://www.codingninjas.com/codestudio/library/z-algorithm

// Approach: Use Z-Algorithm for Pattern Finding
// Algorithm Link: https://iq.opengenus.org/z-algorithm-function/

// Time Complexity: O(M + N); Space Complexity: O(log(M + N))

public class FindPatternAlgoZ {

    private int[] z; // Array "z[]" == Function of "Z"

    public int compute(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        // BUILD the "Z" Function, from the PATTERN
        // and SOURCE Strings CONCATENATED together
        function(needle + "$" + haystack, m + n + 1);

        for (int index = 0; index < z.length; index += 1) {

            // Compensate for LENGTH of the Pattern
            if (z[index] == m) return index - m - 1;
        }

        return -1; // Return N/A for the ABSENT Case
    }

    private void function(String concats, int size) {

        z = new int[size];

        int left = 0, right = 0;

        for (int index = 1; index < size; index += 1) {

            z[index] = 0;

            if (right > index) { // If "index" is INSIDE the Z-Box

                z[index] = Math.min(right - index, z[index - left]);
            }

            while (index + z[index] < size &&
                   concats.charAt(z[index]) ==
                   concats.charAt(index + z[index])) z[index] += 1;

            if (right < index + z[index]) {

                left = index;
                right = index + z[index];
            }
        }

        z[0] = size;
    }
}