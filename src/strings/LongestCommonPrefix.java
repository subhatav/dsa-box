package strings;

// Problem Link: https://leetcode.com/problems/longest-common-prefix/
// Solution Link: https://leetcode.com/problems/longest-common-prefix/solutions/1405155/java-detailed-solution-0-ms-faster-than-100/

// Approach: Horizontal SCANNING; Time Complexity: O(S), Space Complexity: O(1)

// Note: "S" == TOTAL Number of ALL the Characters in ALL the "N" Strings GIVEN

public class LongestCommonPrefix {

    public String compute(String[] strings) {

        String prefix = strings[0];

        for (String string : strings) {

            while (!string.startsWith(prefix)) {

                int size = prefix.length(); // CURRENT Prefix Size

                prefix = prefix.substring(0, size - 1);
            }
        }

        return prefix;
    }
}