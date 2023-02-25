package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Problem Link: https://leetcode.com/problems/largest-number/
// Solution Link: https://leetcode.com/problems/largest-number/solutions/53158/my-java-solution-to-share/

// Approach: LEXICOGRAPHICAL Sorting Technique
// Time Complexity: O(NKlogN + N), Space Complexity: O(N)

public class FormLargestNumber {

    private Comparator<String> comparer = (str1, str2) -> {

        char char1 = str1.charAt(0);
        char char2 = str2.charAt(0);

        if (char1 != char2) return str2.compareTo(str1);

        int size1 = str1.length();
        int size2 = str2.length();

        if (size1 == size2) return str2.compareTo(str1);

        // SORT the Numbers in LEXICOGRAPHICAL Order
        return (str2 + str1).compareTo(str1 + str2);
    };

    public String compute(int[] nums) {

        List<String> strs = new ArrayList<>();

        for (int num : nums) strs.add(String.valueOf(num));

        Collections.sort(strs, comparer); // SORT the Strings

        if (strs.get(0).equals("0")) return "0";

        StringBuilder largest = new StringBuilder(nums.length);

        for (String str : strs) largest.append(str);

        return largest.toString();
    }
}